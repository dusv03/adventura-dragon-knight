/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.dusv03.adventura_dragon_knight.logika;

import java.util.Optional;

import static com.github.dusv03.adventura_dragon_knight.logika.Texts.*;
import static com.github.dusv03.adventura_dragon_knight.logika.Vec.*;



/*******************************************************************************
 *
 * @author  dusv03
 * 
 */
public class ActionTalk
     extends APrikaz
{
	private final HerniPlan herniPlan;
    private final Batoh batoh;

    public ActionTalk(HerniPlan herniPlan, Batoh batoh)
    {
        super (Texts.pMLUVIT_S,
               "Hráč promluví s postavou určenou parametrem.\n");
        this.herniPlan = herniPlan;
        this.batoh = batoh;
    }

    @Override
    public String proved(String... arguments)
    {
       if (arguments.length == 0)
        {
            return Texts.zŽÁDNÝ_PARAMETR + Texts.zCHYBA_MLUVIT;
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
        if (! W_Item.getKOMUNIKATIVITA())
        {
            return Texts.zCHYBNÝ_PARAMETR + Texts.zCHYBA_MLUVIT;
        }
        int state;
        String answer;
        switch(itemName){
            case Texts.ČARODĚJ:
                state = State.getmageS();
                switch(state){
                    case 1: answer = Texts.zČARODĚJ1;
                            Vec ttalisman = new Vec(STANDARD + TALISMAN, "/ui/talisman.PNG");
                            currentPlace.vlozVec(ttalisman);
                            State.setmageS(2);
                            break;
                    
                    case 2: 
                    Optional<Vec> oByliny = batoh.vratOVec(Texts.BYLINY);
                            if ( ! oByliny.isPresent())
                            {
                                answer = Texts.zČARODĚJ3;
                                break;
                            }
                            answer = Texts.zČARODĚJ2;
                            break;
                   
                    default:answer = Texts.zČARODĚJ4;
                            break;
                }
                break;
                
            case Texts.LESNÍ_VÍLA:
                state = State.getspriteS();
                switch(state){
                    case 1: answer = Texts.zLESNÍVÍLA1;
                            State.setspriteS(2);
                            break;
                    
                    case 2: answer = Texts.zLESNÍVÍLA3;
                            break;
                    
                    default:answer = Texts.zLESNÍVÍLA4;
                            break;
                }
                break;
                
            case Texts.KOVÁŘ:
                state = State.getblacksmithS();
                switch(state){
                    case 1: answer = Texts.zKOVÁŘ1;
                            break;
                    
                    case 2: answer = Texts.zKOVÁŘ2;
                            break;
                    
                    case 3: answer = Texts.zKOVÁŘ3;
                            break;
                    
                    default:answer = Texts.zKOVÁŘ4;
                            break;
                }
                break;
            default: answer= "";
                     break;
        }
        return answer;
    }

}
