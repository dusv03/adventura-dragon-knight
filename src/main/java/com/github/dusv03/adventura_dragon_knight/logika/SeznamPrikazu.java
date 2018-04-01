package com.github.dusv03.adventura_dragon_knight.logika;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.github.dusv03.adventura_dragon_knight.logika.IPrikaz;
import com.github.dusv03.adventura_dragon_knight.logika.SeznamPrikazu;

/**
 *  Class SeznamPrikazu - eviduje seznam přípustných příkazů adventury.
 *  Používá se pro rozpoznávání příkazů
 *  a vrácení odkazu na třídu implementující konkrétní příkaz.
 *  Každý nový příkaz (instance implementující rozhraní Prikaz) se
 *  musí do seznamu přidat metodou vlozPrikaz.
 *
 *  Tato třída je součástí jednoduché textové hry.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Alena Buchalcevova
 *@version    z kurzu 4IT101 pro školní rok 2013/2014
 */
public class SeznamPrikazu {
    // mapa pro uložení přípustných příkazů
    private final Map<String,IPrikaz> mapaSPrikazy;
    private static final SeznamPrikazu SINGLETON = new SeznamPrikazu();
   
    
    /**
     * Konstruktor
     */
    public SeznamPrikazu() {
        mapaSPrikazy = new HashMap<>();
    }
    
    static SeznamPrikazu getInstance(){
        return SINGLETON;
    }
    
    
    /**
     * Vkládá nový příkaz.
     *
     *@param  prikaz  Instance třídy implementující rozhraní IPrikaz
     */
    public void vlozPrikaz(IPrikaz prikaz) {
        mapaSPrikazy.put(prikaz.getNazev(),prikaz);
    }
    
    /**
     * Vrací odkaz na instanci třídy implementující rozhraní IPrikaz,
     * která provádí příkaz uvedený jako parametr.
     *
     *@param  retezec  klíčové slovo příkazu, který chce hráč zavolat
     *@return          instance třídy, která provede požadovaný příkaz
     */
    public IPrikaz vratPrikaz(String nazevPrikazu) {
        if (mapaSPrikazy.containsKey(nazevPrikazu)) {
            return mapaSPrikazy.get(nazevPrikazu);
        }
        else {
            return null;
        }
    }

    /**
     * Kontroluje, zda zadaný řetězec je přípustný příkaz.
     *
     *@param  retezec  Řetězec, který se má otestovat, zda je přípustný příkaz
     *@return          Vrací hodnotu true, pokud je zadaný
     *                     řetězec přípustný příkaz
     */
    public boolean jePlatnyPrikaz(String nazevPrikazu) {
        return mapaSPrikazy.containsKey(nazevPrikazu);
    }

    /**
     *  Vrací seznam přípustných příkazů, jednotlivé příkazy jsou odděleny mezerou.
     *  
     *  @return     Řetězec, který obsahuje seznam přípustných příkazů
     */
    public String vratNazvyPrikazu() {
        String seznam = "";
        for (String slovoPrikazu : mapaSPrikazy.keySet()){
            seznam += slovoPrikazu + " ";
        }
        return seznam;
    }
    
    public Collection<IPrikaz> vratPrikazy(){
        return Collections.unmodifiableCollection(mapaSPrikazy.values());
    }
    
}

