/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.dusv03.adventura_dragon_knight.logika;

import java.util.Optional;

import com.github.dusv03.adventura_dragon_knight.logika.APrikaz;
import com.github.dusv03.adventura_dragon_knight.logika.HerniPlan;
import com.github.dusv03.adventura_dragon_knight.logika.Prostor;
import static com.github.dusv03.adventura_dragon_knight.logika.Texts.*;
import com.github.dusv03.adventura_dragon_knight.logika.Vec;


/*******************************************************************************
 *
 * @author  dusv03
 */
public class ActionMove extends APrikaz{
    private final HerniPlan herniPlan;
    private final Batoh batoh;
    private final Hra hra;
    private static final String NAZEV = pJDI_DO;
    
    public ActionMove(HerniPlan herniPlan, Batoh batoh, Hra hra){
        super (pJDI_DO,
        		"Přesune hrdinu do lokace zadané parametrem.");
        this.herniPlan = herniPlan;
        this.batoh = batoh;
        this.hra = hra;
    }
    

	@Override
    public String proved(String... arguments)
    {
    	 if (arguments.length == 0)
         {
             return Texts.zŽÁDNÝ_PARAMETR + Texts.zCHYBA_PŘESUN_A;
         }
         else
         {
             String destinationName;
             destinationName = arguments[0];
             Optional<Prostor> oDestination = herniPlan.
                     getAktualniProstor().
                     vratSousedniProstor(destinationName);
             
             if ( ! oDestination.isPresent())
             {
                 return Texts.zCHYBNÝ_PARAMETR + Texts.zCHYBA_PŘESUN_A;
             }
             else
             {
                 Prostor destinationPlace = oDestination.get();
                 if (destinationPlace.getNazev().equals(Texts.JESKYNĚ))
                 {
                     Optional<Vec> oItem = batoh.vratOVec(Texts.AMULET);
                     if ( ! oItem.isPresent())
                     {
                         herniPlan.setAktualniProstor(destinationPlace);
                         hra.setKonecHry(true);
                         return Texts.zPŘESUN + " " + destinationPlace.getNazev()
                                 + ". " + Texts.zJESKYNĚ_SMRT;
                     }
                     else
                     {   
                    	 herniPlan.setAktualniProstor(destinationPlace);
                         return Texts.zPŘESUN + " " + destinationPlace.getNazev()
                                 + ". " + Texts.zAMULETA;
                     }
                 }
                 if (destinationPlace.getNazev().equals(Texts.SLŮJ))
                 {
                	 herniPlan.setAktualniProstor(destinationPlace);
                         return Texts.zPŘESUN + " " + destinationPlace.getNazev()
                                 + ". " + Texts.zSLŮJ;
                 }
                 if (destinationPlace.getNazev().equals(Texts.ŠTOLA))
                 {
                	 Prostor currentPlace = herniPlan.getAktualniProstor();
                	 Optional<Vec> oItem = currentPlace.vratOVec(PŘÍZRAK);
                     if ( oItem.isPresent())
                     {
                         return zPŘÍZRAKB;
                     }
                 }
                 herniPlan.setAktualniProstor(destinationPlace);
                 return Texts.zPŘESUN + " " + destinationPlace.getNazev();
                 


             }
         }
    }
}



   