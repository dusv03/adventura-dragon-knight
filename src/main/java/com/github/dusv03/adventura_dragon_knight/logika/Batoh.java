package com.github.dusv03.adventura_dragon_knight.logika;

 

import java.util.Map;

import com.github.dusv03.adventura_dragon_knight.logika.AKontejner;
import com.github.dusv03.adventura_dragon_knight.logika.Batoh;
import com.github.dusv03.adventura_dragon_knight.logika.Vec;

import java.util.HashMap;
/**
 *  Trida Batoh 
 *
 *
 *@author     Alena Buchalcevova
 *@version    z kurzu 4IT101 pro školní rok 2014/2015
 */

public class Batoh extends AKontejner
{
	private static final Batoh SINGLETON = new Batoh();
	public static final int KAPACITA = 4 ;
	private Map<String, Vec> seznamVeci ;   // seznam věcí v batohu
	private  int remains;

	public Batoh () {
	seznamVeci = new HashMap<String, Vec>();
	remains = KAPACITA;
	}
 /**
     * Vloží věc do batohu
     *
     *@param  vec  instance věci, která se má vložit
     */
static int getCapacity() {
    return KAPACITA;
}


static Batoh getInstance(){
    return SINGLETON;
}


boolean tryAddItem(Vec i)
{
   if(i.getWeight()> this.remains) return false;
   else 
    {
	vlozVec(i);
    remains = remains - i.getWeight();
    return true;
    }
}
     /**
     * Vrací řetězec názvů věcí, které jsou v batohu

     *@return            řetězec názvů
     */
    public String nazvyVeci () {
        String nazvy = "věci v batohu: ";
        for (String jmenoVeci : seznamVeci.keySet()){
            	nazvy += jmenoVeci + " ";
        }
        return nazvy;
    }
     /**
     * Hledá věc daného jména a pokud je v batohu, tak ji vrátí a vymaže ze seznamu

     *@param  jmeno   Jméno věci
     *@return            věc nebo
     *                   hodnota null, pokud tam věc daného jména není 
     */
    public Vec vyberVec (String jmeno) {
        Vec nalezenaVec = null;
        if (seznamVeci.containsKey(jmeno)) {
            nalezenaVec = seznamVeci.get(jmeno);
            seznamVeci.remove(jmeno);
            remains = remains +1;
        }   
        return nalezenaVec;
    }
    
    public void set_remains(int r) {
    	remains = r;
    }
    
    public int get_remains() {
    	return remains;
    }

}



