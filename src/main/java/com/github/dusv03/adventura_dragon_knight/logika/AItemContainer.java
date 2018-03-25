/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.adv17s._4_1100.dusv03_dusek.game;

import eu.pedu.adv17s_fw.game_txt.IItemContainer;
import eu.pedu.adv17s_fw.game_txt.INamed;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 *
 * @author vladi
 */
abstract class AItemContainer 
        extends ANamed
        implements IItemContainer
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
    
     /** Názvy h-objektů v prostoru na počátku hry. */
     private final String[] itemNames;

    /** Názvy předmětů aktuálně přítomných v daném prostoru. */
    private final Collection<G_Item> items;

    /** Nezměnitelná kolekce předmětů aktuálně přítomných v daném prostoru,
     * která však průběžně mapuje obsah kolekce {@link #items}. */
    private final Collection<G_Item> exportedItems;
    
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    
    
    public AItemContainer(String name, String... itemNames)
    {
        super (name);
        this.itemNames        = itemNames;
        this.items            = new ArrayList<>();
        this.exportedItems    = Collections.unmodifiableCollection(items);
    }


//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================
    
    /***************************************************************************
    * Vrátí h-objekt se zadaným názvem zabalený do objektu typu
    * {@link Optional}{@code <}{@link Item}{@code >}.
    *
    * @return H-objekt se zadaným názvem zabalený do objektu typu
    * {@link Optional}{@code <}{@link Item}{@code >}
    */
    
    public Optional<G_Item> getOItem(String name)
    {
        return INamed.getO(name, items);
    }
    
    @Override
    public Collection<G_Item> getItems()
    {
        return exportedItems;
    }
    
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================

    /***************************************************************************
    * Přidá zadaný h-objekt do kontejneru.
    *
    * @param item H-objekt, který se má přidat do kontejneru
    */
     protected void addItem(G_Item item)
    {
        items.add(item);
    }
    
    /***************************************************************************
    * Odebere zadaný h-objekt ze své kolekce h-objektů.
    *
    * @param item Odebíraný h-objekt
    */
    void removeItem(G_Item item)
    {
        items.remove(item);
    }

    
    
    protected void initializeItems()
    {
          items.clear();
            Arrays.stream(itemNames)
            .map(G_Item::new)
            .forEach(items::add);  
    }
    
   
    

//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================

}
