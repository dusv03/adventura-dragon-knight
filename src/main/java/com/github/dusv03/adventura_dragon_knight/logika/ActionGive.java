/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.dusv03.adventura_dragon_knight.logika;

import java.util.Optional;

import static com.github.dusv03.adventura_dragon_knight.logika.Texts.*;
import static com.github.dusv03.adventura_dragon_knight.logika.Vec.*;

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
public class ActionGive
     extends APrikaz
{
	private final HerniPlan herniPlan;
    private final Batoh batoh;
	
    public ActionGive(HerniPlan herniPlan, Batoh batoh)
    {
        super (pPŘEDAT,
               "Předá věc určenou parametrem osobě \n"
          + "v současné lokaci.\n");
        this.herniPlan = herniPlan;
        this.batoh = batoh;
    }

    @Override
    public String proved(String... arguments)
    {
       if (arguments.length == 0)
        {
            return zŽÁDNÝ_PARAMETR + zCHYBA_POLOŽIT;
        }
        
        String itemName = arguments[0];
        Optional<Vec> oItem = batoh.vratOVec(itemName);
        if ( ! oItem.isPresent())
        {
            return Texts.zNENÍ_V_BATOHU;
        }
        Prostor currentPlace = herniPlan.getAktualniProstor();
        String place = currentPlace.getNazev();
        String answer;
        switch (place){
            case Texts.ČARODĚJOVA_VĚŽ:
                if (itemName.equals(Texts.BYLINY))
                {
                	batoh.vyberOVec(itemName);
                    int x = batoh.get_remains();
                    batoh.set_remains(x+1);
                    answer = Texts.zPŘEDÁNÍ + " " + Texts.BYLINY;
                    State.setmageS(3);
                    Vec ttalisman = new Vec(STANDARD + AMULET, "/com/github/dusv03/adventura_dragon_knight/ui/amulet.PNG");
                    currentPlace.vlozVec(ttalisman);
                }
                else
                {
                    answer = Texts.zCHYBA_PŘEDÁNÍ;
                }
                break;
                
            case Texts.LESNÍ_MÝTINA:
                if (itemName.equals(Texts.PRSTEN))
                {
                	batoh.vyberOVec(itemName);
                    int x = batoh.get_remains();
                    batoh.set_remains(x+1);
                    State.setspriteS(3);
                    Vec ttalisman = new Vec(STANDARD + BYLINY, "/com/github/dusv03/adventura_dragon_knight/ui/flowers.PNG");
                    currentPlace.vlozVec(ttalisman);
                    answer = Texts.zLESNÍVÍLA2;
                }
                else
                {
                    answer = Texts.zCHYBA_PŘEDÁNÍ;
                }
                break;
                
            case Texts.KOVÁRNA:
                if (itemName.equals(Texts.MEČ))
                {
                	batoh.vyberOVec(itemName);
                    int x = batoh.get_remains();
                    batoh.set_remains(x+1);
                    answer = Texts.zPŘEDÁNÍ + " " + Texts.MEČ;
                    if (State.getblacksmithS() == 2)
                    {
                        State.setblacksmithS(4);
                        Vec ttalisman = new Vec(STANDARD + 
                                                      METEORITSKÝ_MEČ, "/com/github/dusv03/adventura_dragon_knight/ui/sword.PNG");
                        currentPlace.vlozVec(ttalisman);
                    }
                    else
                    {
                        State.setblacksmithS(3);
                    }
                    
                }
                else
                {
                    if(itemName.equals(Texts.METEORITSKÁ_RUDA))
                    {
                    	batoh.vyberOVec(itemName);
                        int x = batoh.get_remains();
                        batoh.set_remains(x+1);
                        answer = Texts.zPŘEDÁNÍ + " " + Texts.METEORITSKÁ_RUDA;
                        if (State.getblacksmithS() == 3)
                        {
                            State.setblacksmithS(4);
                            Vec ttalisman = new Vec(STANDARD + 
                                                      METEORITSKÝ_MEČ, "/com/github/dusv03/adventura_dragon_knight/ui/sword.PNG");
                            currentPlace.vlozVec(ttalisman);
                        }
                        else
                        {
                            State.setblacksmithS(2);
                        }
                    }
                    else
                    {
                        answer = Texts.zCHYBA_PŘEDÁNÍ;
                    }
                }
                break;
                    
            default: answer = Texts.zCHYBA_PŘEDÁNÍ;
                     break;
        }
        
        return answer;
    }
}
