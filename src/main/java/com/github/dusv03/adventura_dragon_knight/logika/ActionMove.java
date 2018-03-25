/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.dusv03.adventura_dragon_knight.logika;

import eu.pedu.adv17s_fw.game_txt.INamed;
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
public class ActionMove
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
    public ActionMove()
    {
        super (Texts.pJDI_DO,
               "Přesune hrdinu do lokace zadané parametrem.");
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
    @Override
    public String execute(String... arguments)
    {
        if (arguments.length == 1)
        {
            return Texts.zŽÁDNÝ_PARAMETR + Texts.zCHYBA_PŘESUN_A;
        }
        else
        {
            String destinationName;
            destinationName = arguments[1];
            Place currentPlace = World.getInstance().getCurrentPlace();
            Optional<Place> oDestination 
                                = INamed.getO(destinationName, 
                                              currentPlace.getNeighbors());
            if ( ! oDestination.isPresent())
            {
                return Texts.zCHYBNÝ_PARAMETR + Texts.zCHYBA_PŘESUN_A;
            }
            else
            {
                Place destinationPlace = oDestination.get();
                if (destinationPlace.getName().equals(Texts.JESKYNĚ))
                {
                    Bag bag = Bag.getInstance();
                    Optional<G_Item> oItem = bag.getOItem(Texts.AMULET);
                    if ( ! oItem.isPresent())
                    {
                        World.getInstance().setCurrentPlace(destinationPlace);
                        AAction.stopGame();
                        return Texts.zPŘESUN + " " + destinationPlace.getName()
                                + ". " + Texts.zJESKYNĚ_SMRT;
                    }
                    else
                    {   
                        World.getInstance().setCurrentPlace(destinationPlace);
                        return Texts.zPŘESUN + " " + destinationPlace.getName()
                                + ". " + Texts.zAMULETA;
                    }
                }
                if (destinationPlace.getName().equals(Texts.SLŮJ))
                {
                    World.getInstance().setCurrentPlace(destinationPlace);
                        return Texts.zPŘESUN + " " + destinationPlace.getName()
                                + ". " + Texts.zSLŮJ;
                }
                World.getInstance().setCurrentPlace(destinationPlace);
                return Texts.zPŘESUN + " " + destinationPlace.getName();
            }
        }
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
