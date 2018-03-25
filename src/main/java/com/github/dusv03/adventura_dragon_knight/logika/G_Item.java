/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv17s._4_1100.dusv03_dusek.game;

import eu.pedu.adv17s_fw.game_txt.IItem;

/*******************************************************************************
 * Instances of the {@code EmptyItem} class represent the items in places.
 * These items can be things as well as persons or other entities
 * (flowers, light, charm etc.)
 * <p>
 * Some of these items can qualify certain game or place properties
 * (the light is on), others may be determined for taken and so gain a property
 * (e.g. ability to go through a strange place), or capability
 * (e.g. key for unlocking the door, sward for killing the monster,
 * money for bribing the guard etc.),
 * <p>
 * You can define items which serve simultaneously as places and can
 * therefore contain other items (e.g. safe, window etc.).
 * You have to enter in these items/places with a special command
 * (e.g. <i>open safe</i>, <i>look_from window</i>, etc.) and leave them with
 * another special command (e.g. <i>close safe</i>, <i>shut window</i> etc.).
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2017-Summer
 */
public   class G_Item
       extends ANamed
    implements IItem
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============
     
    /** Váha nepřenositelných h-objektů. */
    private static final int HEAVY = Bag.CAPACITY + 1;

    /** Příznak standardního přenositelného h-objektu. */
    static final char STANDARD = '1';

    /** Příznak zabitelného objektu */
    static final char KILLABLE = '#';

    /** Příznak nepřenositelnosti h-objektu. */
    static final char NOT_MOVABLE = '0';

    /** Příznak alkoholického nápoje. */
    static final char COMMUNICATIVE = '@';
    
//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================

//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================




//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
    
    private final boolean SMRTELNOST;
    private final boolean KOMUNIKATIVITA;
        
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============

    private int váha;
    private int stav;
    


//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Creates the item with the given name and other given properties.
     * These additional properties are entered through a prefix,
     * that is the first character of the given name.
     * The name of the item itself is created by the remaining letters.
     *
     * @param name The name of the created item
     */
    G_Item(String name)
    {
        super(name.substring(1));
        
        boolean eSMRTELNOST = false;
        boolean eKOMUNIKATIVITA = false;
        váha = HEAVY;
        stav = 1;
//        boolean alcoholic = false;
//        int estimatedWight = 1;
        char prefix = name.charAt(0);
        switch (prefix)
        {
        case STANDARD:
        váha = 1;
        break;

        case KILLABLE:
        eSMRTELNOST = true;
        break;

        case NOT_MOVABLE:
        break;

        case COMMUNICATIVE:
        eKOMUNIKATIVITA = true;
        break;
        
        default:
        throw new RuntimeException(
        "\nNeznámá hodnota prefixu: «" + prefix + '»');
        }
        SMRTELNOST = eSMRTELNOST;
        KOMUNIKATIVITA = eKOMUNIKATIVITA;
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Returns the item weight, and/or the corresponding characteristics.
     * The items that cannot be raised
     * have higher weight than the bag capacity is.
     *
     * @return Weight of the item
     */
    @Override
    public int getWeight()
    {
        return váha;
    }
    
    public void setWeight(int weight)
    {
        váha = weight;
    }  

    public boolean getSmrtelnost()
    {
        return SMRTELNOST;
    }
    
    public boolean getKOMUNIKATIVITA()
    {
        return KOMUNIKATIVITA;
    }
    
    public int getStav()
    {
        return stav;
    }
    
    public void setStav(int stav2)
    {
        stav = stav2;
    }

//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
