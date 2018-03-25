/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv17s._4_1100.dusv03_dusek;

import eu.pedu.adv17s._4_1100.dusv03_dusek.game.DK_ScenarioManager;
import eu.pedu.adv17s._4_1100.dusv03_dusek.game.DK_Game;
import eu.pedu.adv17s._4_1100.dusv03_dusek.game.IAuthor_VD;
import eu.pedu.adv17s_fw.game_txt.IGSMFactory;
import eu.pedu.adv17s_fw.scenario.AScenarioManager;



/*******************************************************************************
 * Instances of the {@code EmptyGSMFactory } class represent
 * the factory objects which are able to deliver the game instance,
 * an instance of scenario manager of this game
 * and an instance of the text user interface.
 * As long as some of these objects are not yet fully defined,
 * the methods throw the
 * {@link eu.pedu.adv17s_fw.utilities.UncompletedMethodException}.
 * <p>
 * In the first stage of the whole application development only the method
 * {@link #getScenarioManager()} allowing to obtain
 * the scenario manager instance is active.
 * Bodies of remaining methods are commented.
 * In the next development stages also these methods are uncommented.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2017-Summer
 */
public   class DK_GSMFactory
    implements IGSMFactory, IAuthor_VD
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
     * Creates the factory object providing the key application objects.
     */
    public DK_GSMFactory()
    {
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Returns the instance of the scenario manager.
     *
     * @return Required scenario manager
     */
    @Override
    public AScenarioManager getScenarioManager()
    {
        return DK_ScenarioManager.getInstance();
    }


    /***************************************************************************
     * Returns the instance of text version of the game.
     *
     * @return Required game
     */
    @Override
    public DK_Game getGame()
    {
        return DK_Game.getInstance();
    }


    /***************************************************************************
     * Returns the object executing the user interface.
     *
     * @return Required user interface
     */
//    @Override
//    public IUI getUI()
//    {
//        return TextUI_Instance;
//    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
