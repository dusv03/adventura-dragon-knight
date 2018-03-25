/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.dusv03.adventura_dragon_knight.logika;

import java.util.Collection;
import eu.pedu.adv17s_fw.game_txt.IWorld;
import eu.pedu.adv17s_fw.game_txt.INamed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static com.github.dusv03.adventura_dragon_knight.logika.Texts.*;
import static com.github.dusv03.adventura_dragon_knight.logika.G_Item.*;



/*******************************************************************************
 * An instance of the {@code EmptyWorld} class represents the game world.
 * It should be defined as a singleton.
 * It is responsible for arrangement of individual places and keeps information,
 * in which place the player is just situated.
 * The mutual arrangement may change during the game,
 * the places can gain and/or lose their neighbors.
 * <p>
 * In this game the world is ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2017-Summer
 */
public   class World
    implements IWorld
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /** The only instance (singleton) of this world. */
    private static final World SINGLETON = new World();
    
    private final Place startingPlace;

    private final Collection<Place> places;
    
    private final Collection<Place> exportedPlaces;

//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================
//\CF== CLASS (STATIC) FACTORY METHODS =========================================

    /***************************************************************************
     * The factory method returning the only existing instance of the game.
     *
     * @return The only instance of the given game
     */
    static World getInstance()
    {
        return SINGLETON;
    }



//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================

//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================




//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============

        private Place currentPlace;

//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * The private constructor creating the only instance of the place world.
     * Within this manager definition it creates all game places.
     */
    private World()
    {
        this.places = new ArrayList<>();
        this.exportedPlaces = Collections.unmodifiableCollection(places);
        
        startingPlace = (new Place(ROZCESTÍ,
        new String[] {LESNÍ_MÝTINA,DŮL,ČARODĚJOVA_VĚŽ,KOVÁRNA,JESKYNĚ}
         ));
        places.add(startingPlace);
        places.add(new Place(ČARODĚJOVA_VĚŽ,
        new String[] {ROZCESTÍ,KOVÁRNA},
            COMMUNICATIVE+ČARODĚJ
         ));
        places.add(new Place(LESNÍ_MÝTINA,
        new String[] {ROZCESTÍ},COMMUNICATIVE+LESNÍ_VÍLA
         ));
        places.add(new Place(DŮL,
        new String[] {ROZCESTÍ,KOVÁRNA},KILLABLE+PŘÍZRAK,
                STANDARD+KRUMPÁČ,STANDARD+LOPATA,STANDARD+VĚDRO
         ));
        places.add(new Place(ŠTOLA,
        new String[] {DŮL},NOT_MOVABLE+METEORITSKÁ_RUDA
         ));
        places.add(new Place(KOVÁRNA,
        new String[] {ROZCESTÍ,ČARODĚJOVA_VĚŽ,DŮL},COMMUNICATIVE+KOVÁŘ
         ));
        places.add(new Place(JESKYNĚ,
        new String[] {ROZCESTÍ,SLŮJ}
         ));
        places.add(new Place(SLŮJ,
        new String[] {JESKYNĚ},KILLABLE+DRAK
         ));
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Returns the collection of all places of the game.
     *
     * @return Collection of all places performing in the game
     */
    @Override
    public Collection<Place> getAllPlaces()
    {
        return exportedPlaces;
    }


    /***************************************************************************
     * Returns the current place,
     * i.e. to the place in which the player is just situated.
     *
     * @return The place in which the player is just situated
     */
    @Override
    public Place getCurrentPlace()
    {
        return currentPlace;
    }
    
    void setCurrentPlace(Place newPlace)
    {
        currentPlace = newPlace;
    }



//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================

     void initialize()
    {
        places.forEach(Place::initialize);
        currentPlace = startingPlace;
    }
     
     public Optional<Place> getOPlace(String name)
    {
        Optional<Place> result = INamed.getO(name, places);
        return result;
    }

//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
