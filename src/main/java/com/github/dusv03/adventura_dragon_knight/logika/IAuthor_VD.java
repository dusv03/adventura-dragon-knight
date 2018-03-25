/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv17s._4_1100.dusv03_dusek.game;

import eu.pedu.adv17s._4_1100.dusv03_dusek.DK_GSMFactory;
import eu.pedu.adv17s_fw.game_txt.IGSMFactory;
import eu.pedu.adv17s_fw.game_txt.IGSMFactoryProduct;



/*******************************************************************************
 * {@code IAuthorPrototype} instances know to return on request
 * the name and identification string of the author of its class;
 * these values are saved in their static constants
 * {@link #AUTHOR_NAME} a {@link #AUTHOR_ID}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2017-Summer
 */
public interface IAuthor_VD
         extends IGSMFactoryProduct
{
//\CC== CLASS (STATIC) CONSTANTS ===============================================

    /** The name of the author in format <b>SURNAME First-name</b>,
     * i.e. firstly the surname in capital letters followed by first name,
     * with only the first capital letter, other letters will be small.
     * If the program author has more first names, he can quote all of them. */
    String AUTHOR_NAME = "DUŠEK Vladimír";

    /** Author's identification string written in CAPITAL LETTERS.
     *  It is mostly the login into the school information system. */
    String AUTHOR_ID = "DUSV03";

    /** Factory class the instances of which are factory objects providing
     *  the instance of the game, its associated scenario manager
     *  and the textual user interface created by this author. */
    Class<? extends IGSMFactory> FACTORY_CLASS = DK_GSMFactory.class;



//\CM== CLASS (STATIC) METHODS =================================================



//##############################################################################
//\AG== ABSTRACT GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Returns the program author name in format <b>SURNAME First-name</b>,
     * i.e. firstly the surname in capital letters followed by first name,
     * with only the first capital letter, other letters will be small.
     * If the program author has more first names, he can quote all of them.
     *
     * @return Program author name in format SURNAME First-name
     */
    @Override
    default public String getAuthorName()
    {
        return AUTHOR_NAME;
    }


    /***************************************************************************
     * Returns the program author identification string
     * written in CAPITAL LETTERS.
     * It is mostly the login into the school information system.
     *
     * @return Identification string (login) of the program author
     */
    @Override
    default public String getAuthorID()
    {
        return AUTHOR_ID;
    }


    /***************************************************************************
     * Returns the class-object of the factory class, the instances of which
     * can mediate receiving of all key objects of the application,
     * the part of which also the mother class of this instance is.
     *
     * @return The class-object of the factory class
     */
    @Override
    default public Class<? extends IGSMFactory> getFactoryClass()
    {
        return FACTORY_CLASS;
    }



//\AM== REMAINING ABSTRACT METHODS =============================================
//\DG== DEFAULT GETTERS AND SETTERS ============================================
//\DM== REMAINING DEFAULT METHODS ==============================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
