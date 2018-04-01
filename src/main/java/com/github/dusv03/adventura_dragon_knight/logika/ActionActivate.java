/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.dusv03.adventura_dragon_knight.logika;

import java.util.Optional;


/*******************************************************************************
 *
 * @author dusv03
 * @version 2017-Summer
 */
public class ActionActivate
     extends APrikaz
{
	private final HerniPlan herniPlan;
    private final Batoh batoh;

    public ActionActivate(HerniPlan herniPlan, Batoh batoh)
    {
        super (Texts.pAKTIVOVAT,
               "Aktivuje věc zadanou parametrem.\n");
        this.herniPlan = herniPlan;
        this.batoh = batoh;
    }

    @Override
    public String proved(String... arguments)
    {
        if (arguments.length == 0)
        {
            return Texts.zŽÁDNÝ_PARAMETR +"\n" + Texts.zCHYBA_AKTIVOVAT;
        }
        String itemName = arguments[0];
        Optional<Vec> oItem = batoh.vratOVec(itemName);
        if ( ! oItem.isPresent())
        {
            return Texts.zNENÍ_V_BATOHU;
        }
        Vec W_Item = oItem.get();
        if ( ! W_Item.getJmeno().equals(Texts.TALISMAN))
        {
            return Texts.zCHYBA_AKTIVOVAT;
        }
        Prostor currentPlace = herniPlan.getAktualniProstor();
        if (currentPlace.getNazev().equals(Texts.DŮL))
        {
            State.setKillableGhost(true);
            return Texts.zTALISMAN + " " + Texts.zPŘÍZRAK;
        }
        return Texts.zTALISMAN + "\nAle aby byl efektivní, měl by být aktivovaný poblíž ducha";
    }

}
