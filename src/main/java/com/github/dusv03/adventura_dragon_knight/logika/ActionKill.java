/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.dusv03.adventura_dragon_knight.logika;


import java.util.Optional;

/*******************************************************************************
 * Instances of the {@code EmptyAction} class process the commands, which
 * ???.
 * <p>
 * Instances of the action classes are effectively singletons,
 * however we do not need to ensure it explicitely, because for their creation
 * and further management the specified action manager takes care
 * which ensures the only instance of each such class.
 * </p>
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2017-Summer
 */
public class ActionKill
     extends APrikaz
{
	private final HerniPlan herniPlan;
    private final Batoh batoh;
    private final Hra hra;

    public ActionKill(HerniPlan herniPlan, Batoh batoh, Hra hra)
    {
        super (Texts.pZABÍT,
               "Zabije nepřítele určeného parametrem.");
        this.herniPlan = herniPlan;
        this.batoh = batoh;
        this.hra = hra;
    }

    @Override
    public String proved(String... arguments)
    {
        if (arguments.length == 1)
        {
            return Texts.zŽÁDNÝ_PARAMETR + Texts.zCHYBA_ZABÍT;
        }

        String itemName;
        itemName = arguments[1];
        Prostor currentPlace = herniPlan.getAktualniProstor();
        Optional<Vec> oItem = currentPlace.vratOVec(itemName);
        if ( ! oItem.isPresent())
        {
            return Texts.zCHYBA_ZABÍT;
        }
        Vec W_Item = oItem.get();
        if (! W_Item.getSmrtelnost())
        {
            return Texts.zCHYBA_ZABÍT2 + Texts.zCHYBA_ZABÍT;
        }
        if (itemName.equals(Texts.PŘÍZRAK))
        {
            if (State.isGhostKillable())
            {
                currentPlace.vyberOVec(W_Item.getJmeno());
                return Texts.zZABITÍ + " " + Texts.PŘÍZRAK;
            }
            else
            {
                return Texts.zCHYBA_ZABÍT3;
            }
        }
        if (itemName.equals(Texts.DRAK))
        {
            String Sword = Texts.METEORITSKÝ_MEČ;
            Optional<Vec> oSword = batoh.vratOVec(Sword);
            if ( ! oSword.isPresent())
            {
                hra.setKonecHry(true);
                return Texts.zSMRT_DRAK + Texts.zUKONČENÍ;
            }
            else
            {
            	currentPlace.vyberOVec(W_Item.getJmeno());
            	hra.setKonecHry(true);
                return Texts.zZABITÍDRAKA + Texts.zUKONČENÍ;
            }
        }
        return Texts.zCHYBA_ZABÍT2 + Texts.zCHYBA_ZABÍT;
       
    }
}
