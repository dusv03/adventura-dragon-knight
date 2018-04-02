/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dusv03.adventura_dragon_knight.logika;

import java.util.Collection;
import java.util.Collections;
import static java.util.Collections.unmodifiableCollection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Observable;

/**
 *
 * @author dusv03
 */
public abstract class AKontejner extends Observable{
    /**
     * Kolekce h-objektů v prostoru
     */
    protected Map<String, Vec> seznamVeci ;

    /**
     * Obalení kolekce h-objektů v prostoru
     */
    protected Collection<Vec> exportedItems;

    /**
     * veřejný konstruktor, 
     * vytvoří seznamVeci a jeho exportovatelnou verzi
     */
    public AKontejner() {
            this.seznamVeci          = new HashMap<>();
            this.exportedItems  = unmodifiableCollection(this.seznamVeci.values());
        }

    /**
     * 
     * @return nemodifikovatelnou verzi seznamu věcí seznamVeci
     */
    public Collection<Vec> getVeci() {
            return Collections.unmodifiableCollection(seznamVeci.values());
        }

    /**
     * @param itemName1 název věci, která se v kontejneru hledá
     * @return optionál věci, ketrá by měla být v kontejenru
     */
    Optional<Vec> vratOVec(String itemName1) {
        for (Vec v : seznamVeci.values()){
            if(v.getJmeno().equals(itemName1))  
                return Optional.of(seznamVeci.get(itemName1));
        }  
        return Optional.empty();
        }

    /**
     * pokud je věc nalezena v kontejneru, tak je její odkaz z kontejenru odstraněn
     * @param jmeno název věci, která se hledá
     * @return optionál nalezené věci
     */
    public Optional<Vec> vyberOVec (String jmeno) {
        Optional<Vec> OVec = null;    
        if (seznamVeci.containsKey(jmeno)) {
                OVec = Optional.of(seznamVeci.get(jmeno));
                seznamVeci.remove(jmeno);
                this.setChanged();
                this.notifyObservers();
                return OVec;

            }   
            return Optional.empty();
        }

    /**
     * Vloží věc do batohu
     *
     *@param  vec  instance věci, která se má vložit
     */
   public void vlozVec (Vec vec) {
     seznamVeci.put(vec.getJmeno(),vec);
     this.setChanged();
     this.notifyObservers();
    }
}


