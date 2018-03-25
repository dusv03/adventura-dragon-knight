/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.dusv03.adventura_dragon_knight.logika;

import java.util.Optional;

import static eu.pedu.adv17s._4_1100.dusv03_dusek.game.Texts.*;
import static eu.pedu.adv17s._4_1100.dusv03_dusek.game.G_Item.*;



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
public class ActionTalk
     extends AAction
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============
//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================

//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================




//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Creates the action instance for ...
     */
    public ActionTalk()
    {
        super (Texts.pMLUVIT_S,
               "Hráč promluví s postavou určenou parametrem.\n");
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
     * Processes the command composed from the given words
     * and returns the game answer to the user.
     * Number of word depends on particular action, however it must be
     * at least one, because the zeroth element contains the action name.
     * The remaining words are arguments of this action and they may differ:
     * the actions of <i>end</i> and <i>help</i> type do not have any,
     * the actions of <i>go</i> and <i>take</i> type have one,
     * the actions of <i>apply</i> type ) can have two (e.g. apply key lock)
     * or three (e.g. apply key to lock) etc.
     *
     * @param arguments Action arguments –
     *                  their number can be different for each action,
     *                  but for all execution of the same action is the same
     * @return The answer of the game after processing the command
     */

    /***************************************************************************
    * Předčasně ukončí hru.
    *
    * @param arguments Parametry příkazu - zde se nepoužívají
    * @return Text zprávy vypsané po provedeni příkazu
    */

    @Override
    public String execute(String... arguments)
    {
       if (arguments.length == 1)
        {
            return Texts.zŽÁDNÝ_PARAMETR + Texts.zCHYBA_MLUVIT;
        }
        String itemName;
        itemName = arguments[1];
        Place currentPlace = World.getInstance().getCurrentPlace();
        Optional<G_Item> oItem = currentPlace.getOItem(itemName);
        if ( ! oItem.isPresent())
        {
            return Texts.zŠPATNÝ_PŘEDMĚT;
        }
        
        G_Item W_Item = oItem.get();
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
                            G_Item ttalisman = new G_Item(STANDARD + TALISMAN);
                            currentPlace.addItem(ttalisman);
                            State.setmageS(2);
                            break;
                    
                    case 2: Bag bag = Bag.getInstance();
                    Optional<G_Item> oByliny = bag.getOItem(Texts.BYLINY);
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

//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
