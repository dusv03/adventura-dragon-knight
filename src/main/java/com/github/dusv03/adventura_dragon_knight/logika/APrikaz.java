/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dusv03.adventura_dragon_knight.logika;

/**
 *
 * @author dusv03
 *
 */
public abstract class APrikaz implements IPrikaz{
    private String popis;
    private String nazev;
    
    /**
     * veřejný konstruktor
     * @param nazev název příkazu
     * @param popis jeho popis
     */
    public APrikaz(String nazev, String popis){
        this.nazev = nazev;
        this.popis = popis;
    }
    
    /**
     * 
     * @return popis předmětu
     */
    @Override
    public String getPopis(){
        return popis;
    }
    
    /**
     * 
     * @return název předmětu
     */
    @Override
    public String getNazev(){
        return nazev;
    }
    
}
