/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.dusv03.adventura_dragon_knight.logika;

import java.util.Optional;

import com.github.dusv03.adventura_dragon_knight.logika.Batoh;
import com.github.dusv03.adventura_dragon_knight.logika.HerniPlan;





public class ActionPickUp
     extends APrikaz
{
	private final HerniPlan herniPlan;
    private final Batoh batoh;
    
    public ActionPickUp(HerniPlan herniPlan, Batoh batoh)
    {
        super (Texts.pSEBRAT,
               "Sebere z prostředí předmět určený parametrem.");
        this.herniPlan = herniPlan;
        this.batoh = batoh;
    }

    @Override
    public String proved(String... arguments)
    {
        if (arguments.length == 0)
        {
            return Texts.zŽÁDNÝ_PARAMETR + Texts.zCHYBA_SEBRAT;
        }
        
        String itemName;
        itemName = arguments[0];
        Prostor currentPlace = herniPlan.getAktualniProstor();
        Optional<Vec> oItem = currentPlace.vratOVec(itemName);
        if ( ! oItem.isPresent())
        {
            return Texts.zŠPATNÝ_PŘEDMĚT;
        }
        
        Vec W_Item = oItem.get();
         
        if (W_Item.getWeight() > batoh.getCapacity())
        {
            return Texts.zNEPOHYBLIVÝ;
        }
        
        boolean added = batoh.tryAddItem(W_Item);
        if (added)
        {
            currentPlace.vyberOVec(W_Item.getJmeno());
            return Texts.zSEBRÁNÍ + " " + W_Item.getJmeno();
        }
        else
        {
           return Texts.zPLNÝ_BATOH;
        }
                
            
    }

}
