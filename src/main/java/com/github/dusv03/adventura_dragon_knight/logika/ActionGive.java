/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv17s._4_1100.dusv03_dusek.game;

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
public class ActionGive
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
    public ActionGive()
    {
        super (Texts.pPŘEDAT,
               "Předá věc určenou parametrem osobě \n"
          + "v současné lokaci.\n");
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
            return Texts.zŽÁDNÝ_PARAMETR + Texts.zCHYBA_POLOŽIT;
        }
        
        String itemName = arguments[1];
        Bag bag = Bag.getInstance();
        Optional<G_Item> oItem = bag.getOItem(itemName);
        if ( ! oItem.isPresent())
        {
            return Texts.zNENÍ_V_BATOHU;
        }
        G_Item W_Item = oItem.get();
        bag.removeItem(W_Item);
        Place currentPlace = World.getInstance().getCurrentPlace();
        String place = currentPlace.getName();
        String answer;
        switch (place){
            case Texts.ČARODĚJOVA_VĚŽ:
                if (itemName.equals(Texts.BYLINY))
                {
                    answer = Texts.zPŘEDÁNÍ + " " + Texts.BYLINY;
                    State.setmageS(3);
                    G_Item ttalisman = new G_Item(STANDARD + AMULET);
                    currentPlace.addItem(ttalisman);
                }
                else
                {
                    answer = Texts.zCHYBA_PŘEDÁNÍ;
                }
                break;
                
            case Texts.LESNÍ_MÝTINA:
                if (itemName.equals(Texts.PRSTEN))
                {
                    State.setspriteS(3);
                    G_Item ttalisman = new G_Item(STANDARD + BYLINY);
                    currentPlace.addItem(ttalisman);
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
                    answer = Texts.zPŘEDÁNÍ + " " + Texts.MEČ;
                    if (State.getblacksmithS() == 2)
                    {
                        State.setblacksmithS(4);
                        G_Item ttalisman = new G_Item(STANDARD + 
                                                      METEORITSKÝ_MEČ);
                        currentPlace.addItem(ttalisman);
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
                        answer = Texts.zPŘEDÁNÍ + " " + Texts.METEORITSKÁ_RUDA;
                        if (State.getblacksmithS() == 3)
                        {
                            State.setblacksmithS(4);
                            G_Item ttalisman = new G_Item(STANDARD + 
                                                      METEORITSKÝ_MEČ);
                            currentPlace.addItem(ttalisman);
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

//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
