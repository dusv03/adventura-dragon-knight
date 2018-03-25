/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.dusv03.adventura_dragon_knight.logika;


import java.util.Collection;
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
    public ActionKill()
    {
        super (Texts.pZABÍT,
               "Zabije nepřítele určeného parametrem.");
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
            return Texts.zŽÁDNÝ_PARAMETR + Texts.zCHYBA_ZABÍT;
        }

        String itemName;
        itemName = arguments[1];
        Place currentPlace = World.getInstance().getCurrentPlace();
        Optional<G_Item> oItem = currentPlace.getOItem(itemName);
        if ( ! oItem.isPresent())
        {
            return Texts.zCHYBA_ZABÍT;
        }
        G_Item W_Item = oItem.get();
        if (! W_Item.getSmrtelnost())
        {
            return Texts.zCHYBA_ZABÍT2 + Texts.zCHYBA_ZABÍT;
        }
        if (itemName.equals(Texts.PŘÍZRAK))
        {
            if (State.isGhostKillable())
            {
                currentPlace.removeItem(W_Item);
                Place place = currentPlace;
                Collection<Place> places = World.getInstance().getAllPlaces();
                for (Place s: places)
                {
                    if(s.getName().equals(Texts.ŠTOLA))
                        place = s;
                }
                currentPlace.addNeighbor(place);
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
            Bag bag = Bag.getInstance();
            Optional<G_Item> oSword = bag.getOItem(Sword);
            if ( ! oItem.isPresent())
            {
                AAction.stopGame();
                return Texts.zSMRT_DRAK + Texts.zUKONČENÍ;
            }
            else
            {
                currentPlace.removeItem(W_Item);
                AAction.stopGame();
                return Texts.zZABITÍDRAKA + Texts.zUKONČENÍ;
            }
        }
        return Texts.zCHYBA_ZABÍT2 + Texts.zCHYBA_ZABÍT;
       
    }

//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
