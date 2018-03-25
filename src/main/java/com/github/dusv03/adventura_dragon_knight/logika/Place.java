/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv17s._4_1100.dusv03_dusek.game;

import java.util.Collection;
import eu.pedu.adv17s_fw.game_txt.IPlace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

/*******************************************************************************
 * Instances of the {@code EmptyPlace} class represent the places in the game.
 *
 * We can take the place visiting as a partial goal,
 * which the player tries to reach.
 * The places can be rooms, planets, life stages etc.
 * The places can contain various items.that may help user to reach the goal.
 * Each place knows its current neighboring places and it knows
 * which items it currently contains.
 * The neighbors as well as the contained items can change during the game.
 * <p>
 * In this program the places are ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2017-Summer
 */
public   class Place
       extends AItemContainer
    implements IPlace
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
    
    /** Názvy sousedů prostoru na počátku hry. */
     private final String[] neighborNames;

     private final Collection<Place> neighbors;
     
     private final Collection<Place> exportedNeighbors;
     
    
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
    * Vytvoří nový prostor se zadaným názvem a
    * zadanými názvy jeho počátečních sousedů a h-objektů.
    *
    * @param name Název daného prostoru
    * @param neighborNames Názvy sousedů prostoru na počátku hry
    * @param itemNames Názvy h-objektů v prostoru na počátku hry
    */
    Place(String name, String[] neighborNames, String... itemNames)
    {
        super(name, itemNames);
        this.neighborNames    = neighborNames;
        this.neighbors        = new ArrayList<>();
        this.exportedNeighbors= Collections.unmodifiableCollection(neighbors);
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Returns the collection of current neighbors of this place, i.e. the
     * collection of places, to which we can move from this place with the
     * command of the {@link eu.pedu.adv17s_fw.scenario.TypeOfStep#tsMOVE
     * TypeOfStep.tsMOVE} type.
     *
     * @return Collection of neighbors
     */
    @Override
    public Collection<Place> getNeighbors()
    {
        return exportedNeighbors;
    }



  /***************************************************************************
  * Metoda inicializující daný prostor.
  * Na základě konstruktorem zapamatovaných jmen
  * inicializuje sousedy daného prostoru a přítomné h-objekty.
  */
    void initialize()
    {   
    initializeItems();
    initializeNeighbors();
    }
    
    
    
    /***************************************************************************
* Vyčistí kolekci {@link #neighbors} a uloží do ní objekty reprezentující
* prostory sousedící s daným prostorem na počátku hry.
*/
    private void initializeNeighbors()
    {
        World world = World.getInstance();
        neighbors.clear();
        Arrays.stream(neighborNames)
            .map(world::getOPlace)
            .map(Optional<Place>::get)
            .forEach(neighbors::add);
    }     
   
    public void addNeighbor(Place neighbor)
    {
        neighbors.add(neighbor);
    }
    
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
