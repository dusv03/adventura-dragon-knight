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
public class ActionActivate
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
    public ActionActivate()
    {
        super (Texts.pAKTIVOVAT,
               "Aktivuje věc zadanou parametrem.\n");
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
            return Texts.zŽÁDNÝ_PARAMETR +"\n" + Texts.zCHYBA_AKTIVOVAT;
        }
        String itemName = arguments[1];
        Bag bag = Bag.getInstance();
        Optional<G_Item> oItem = bag.getOItem(itemName);
        if ( ! oItem.isPresent())
        {
            return Texts.zNENÍ_V_BATOHU;
        }
        G_Item W_Item = oItem.get();
        if ( ! itemName.equals(Texts.TALISMAN))
        {
            return Texts.zCHYBA_AKTIVOVAT;
        }
        Place currentPlace = World.getInstance().getCurrentPlace();
        if (currentPlace.getName().equals(Texts.DŮL))
        {
            State.setKillableGhost(true);
            return Texts.zTALISMAN + " " + Texts.zPŘÍZRAK;
        }
        return Texts.zTALISMAN;
    }

//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
