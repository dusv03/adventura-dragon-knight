/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.dusv03.adventura_dragon_knight.logika;

import java.util.Optional;

/*******************************************************************************
 * @author  dusv03
 * 
 */
public class ActionMine
     extends APrikaz
{
	private final HerniPlan herniPlan;
    private final Batoh batoh;
    
    public ActionMine(HerniPlan herniPlan, Batoh batoh)
    {
        super (Texts.pNATĚŽIT,
               "Pomocí krumpáče v inventáři natěží objekt \n"
          + "zadaný parametrem.\n");
        this.herniPlan = herniPlan;
        this.batoh = batoh;
    }

    @Override
    public String proved(String... arguments)
    {
        if (arguments.length == 0)
        {
            return Texts.zŽÁDNÝ_PARAMETR;
        }
        String itemName;
        itemName = arguments[0];
        String pickaxe = Texts.KRUMPÁČ;
        Optional<Vec> oPickaxe = batoh.vratOVec(pickaxe);
        if ( ! oPickaxe.isPresent())
        {
            return Texts.zCHYBÍ_KRUMPÁČ;
        }
        Prostor currentPlace = herniPlan.getAktualniProstor();
        Optional<Vec> oItem = currentPlace.vratOVec(itemName);
        if ( ! oItem.isPresent())
        {
            return Texts.zŠPATNÝ_PŘEDMĚT;
        }
        if ( ! itemName.equals(Texts.METEORITSKÁ_RUDA))
        {
            return Texts.zNELZE_TĚŽIT;
        }
        Vec W_Item = oItem.get();
        W_Item.setWeight(1);
        return Texts.zNATĚŽENÍ + " " + W_Item.getJmeno();
    }

}
