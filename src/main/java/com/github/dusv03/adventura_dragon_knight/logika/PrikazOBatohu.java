package com.github.dusv03.adventura_dragon_knight.logika;


import static com.github.dusv03.adventura_dragon_knight.logika.Texts.*;
/**
 *  Třída PrikazObsahBatohu implementuje pro hru příkaz obsahBatohu.
 *@author     Alena Buchalcevova
 *@version    z kurzu 4IT101 pro školní rok 2014/2015  
 */


public class PrikazOBatohu extends APrikaz
{
private static final String NAZEV = "obsahBatohu";
    private Batoh batoh;
  /**
    *  Konstruktor třídy
    *  
    *  @param plan herní plán, ve kterém se bude hledat aktuální místnost 
    */      
    public PrikazOBatohu( Batoh batoh) {
    	super (pOBSAH_BATOHU,
                "Vypíše obsah batohu");
        this.batoh = batoh;
    }
    /**
     *  Provádí příkaz "obsahBatohu". Vypíše názvy věcí v batohu
     *  
     *@return zpráva, kterou vypíše hra hráči
     */ 
    public String proved(String... parametry) {
            return batoh.nazvyVeci();
    }
}


