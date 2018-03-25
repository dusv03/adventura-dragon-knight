/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv17s._4_1100.dusv03_dusek.game;

import eu.pedu.adv17s_fw.game_txt.IBag;

import static eu.pedu.adv17s._4_1100.dusv03_dusek.game.Texts.*;
import static eu.pedu.adv17s._4_1100.dusv03_dusek.game.G_Item.*;



/*******************************************************************************
 * Instance of the {@code EmptyBag} class represents the repository,
 * to which the players store the items picked up in individual places,
 * so that they could be moved to other places and/or used.
 * The disposal site has a final capacity defining the maximal permitted
 * sum of weights of items occuring in the repository.
 * <p>
 * In this game the bag is ...
 * with capacity ....
 * The item weight represents
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2017-Summer
 */
public   class Bag
        extends AItemContainer
    implements IBag
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** The only instance of the bag in the bag. */
    private static final Bag SINGLETON = new Bag();


    static final int CAPACITY = 4;
        
//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** Volná kapacit batohu. */
    private int remains;

//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================

    /***************************************************************************
     * Factory method returning the only existing instance of the bag.
     *
     * @return The only instance of the bag
     */
    static Bag getInstance()
    {
        return SINGLETON;
    }



//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================

//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============

//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     */
    public Bag()
    {
        super ("bag",STANDARD + MEČ,STANDARD + PRSTEN);
    }

//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Returns the bag capacity, i.e. the maximal permitted sum
     * of weights of items, that can be put into the bag at the same time.
     *
     * @return Capacity of the bag
     */
    @Override
    public int getCapacity()
    {
        return CAPACITY;
    }

    void initialize()
    {
        initializeItems();
        remains = CAPACITY - 2;
    }
        
    /***************************************************************************
    * Vejde-li se zadaný h-objekt do batohu, přidá jej;
    * poté vrátí zprávu o výsledku.
    *
    * @param item H-objekt, který se má přidat do batohu
    * @return Zpráva o výsledku: {@code true} = byl přidán,
    * {@code false} = nebyl přidán
    */
    boolean tryAddItem(G_Item item)
    {
        if (item.getWeight() > remains) 
        {
            return false;
        }
        
        addItem(item);
        remains -= item.getWeight();
        return true;
    }
    
    @Override
    void removeItem(G_Item item)
    {
        super.removeItem(item);
        remains += item.getWeight();
    }

//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================

//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
