/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.dusv03.adventura_dragon_knight.logika;

import java.util.Optional;


/*******************************************************************************
 *
 * @author  dusv03
 * @version 2017-Summer
 */
public class ActionPutDown
     extends APrikaz
{
	private final HerniPlan herniPlan;
    private final Batoh batoh;
    

    public ActionPutDown(HerniPlan herniPlan, Batoh batoh)
    {
        super (Texts.pPOLOŽIT,
               "Přesune věc určenou parametrem z batohu \n"
          + "do aktuálního prostoru.");
        this.herniPlan = herniPlan;
        this.batoh = batoh;
    }


    @Override
    public String proved(String... arguments)
    {
        if (arguments.length == 0)
        {
            return Texts.zŽÁDNÝ_PARAMETR + Texts.zCHYBA_POLOŽIT;
        }
        
        String itemName = arguments[0];
        Prostor currentPlace = herniPlan.getAktualniProstor();
        Optional<Vec> oItem = batoh.vratOVec(itemName);
        if ( ! oItem.isPresent())
        {
            return Texts.zNENÍ_V_BATOHU;
        }
        
        Vec W_Item = oItem.get();
        batoh.vyberOVec(W_Item.getJmeno());
        int x = batoh.get_remains();
        batoh.set_remains(x+1);
        currentPlace.vlozVec(W_Item);
        return Texts.zPOLOŽENÍ + " " + W_Item.getJmeno();
    }
}
