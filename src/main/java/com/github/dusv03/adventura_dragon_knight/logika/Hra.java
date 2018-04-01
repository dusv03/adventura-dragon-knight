package com.github.dusv03.adventura_dragon_knight.logika;

import static com.github.dusv03.adventura_dragon_knight.logika.Texts.*;
import static com.github.dusv03.adventura_dragon_knight.logika.Vec.*;

import com.github.dusv03.adventura_dragon_knight.logika.Hra;

import com.github.dusv03.adventura_dragon_knight.logika.SeznamPrikazu;  
/**
 *  Třída Hra - třída představující logiku adventury.
 * 
 *  Toto je hlavní třída  logiky aplikace.  Tato třída vytváří instanci třídy HerniPlan, která inicializuje mistnosti hry
 *  a vytváří seznam platných příkazů a instance tříd provádějící jednotlivé příkazy.
 *  Vypisuje uvítací a ukončovací text hry.
 *  Také vyhodnocuje jednotlivé příkazy zadané uživatelem.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Alena Buchalcevova
 *@version    z kurzu 4IT101 pro školní rok 2014/2015
 */

public class Hra implements IHra {
    private SeznamPrikazu platnePrikazy;    // obsahuje seznam přípustných příkazů
    private HerniPlan herniPlan;
    private boolean konecHry = false;
    private Batoh batoh;
    private static final Hra SINGLETON = new Hra();

    /**
     *  Vytváří hru a inicializuje místnosti (prostřednictvím třídy HerniPlan) a seznam platných příkazů.
     */
    public Hra() {
        herniPlan = new HerniPlan();
        batoh = new Batoh();
        platnePrikazy = new SeznamPrikazu();
        platnePrikazy.vlozPrikaz(new ActionHelp(this));
        platnePrikazy.vlozPrikaz(new ActionMove(herniPlan, batoh, this));
        platnePrikazy.vlozPrikaz(new ActionExit(this));
        platnePrikazy.vlozPrikaz(new ActionPickUp(herniPlan, batoh));
        platnePrikazy.vlozPrikaz(new PrikazOBatohu(batoh));
        platnePrikazy.vlozPrikaz(new ActionPutDown(herniPlan, batoh));
        platnePrikazy.vlozPrikaz(new ActionActivate(herniPlan, batoh));
        platnePrikazy.vlozPrikaz(new ActionKill(herniPlan, batoh, this));
        platnePrikazy.vlozPrikaz(new ActionMine(herniPlan, batoh));
        platnePrikazy.vlozPrikaz(new ActionTalk(herniPlan, batoh));
        platnePrikazy.vlozPrikaz(new ActionGive(herniPlan, batoh));
        batoh.vlozVec(new Vec(STANDARD + MEČ));
        batoh.vlozVec(new Vec(STANDARD + PRSTEN));
    }

    /**
     *  Vrátí úvodní zprávu pro hráče.
     */
    public String vratUvitani() {
        return zUVÍTÁNÍ +
               herniPlan.getAktualniProstor().dlouhyPopis();
    }
    
    /**
     *  Vrátí závěrečnou zprávu pro hráče.
     */
    public String vratEpilog() {
        return "Dík, že jste si zahráli.  Ahoj.";
    }
    
    /** 
     * Vrací true, pokud hra skončila.
     */
     public boolean konecHry() {
        return konecHry;
    }

    /**
     *  Metoda zpracuje řetězec uvedený jako parametr, rozdělí ho na slovo příkazu a další parametry.
     *  Pak otestuje zda příkaz je klíčovým slovem  např. jdi.
     *  Pokud ano spustí samotné provádění příkazu.
     *
     *@param  radek  text, který zadal uživatel jako příkaz do hry.
     *@return          vrací se řetězec, který se má vypsat na obrazovku
     */
     public String zpracujPrikaz(String radek) {
        String [] slova = radek.split("[ \t]+");
        String slovoPrikazu = slova[0];
        String []parametry = new String[slova.length-1];
        for(int i=0 ;i<parametry.length;i++){
           	parametry[i]= slova[i+1];  	
        }
        String textKVypsani=" .... ";
        if (platnePrikazy.jePlatnyPrikaz(slovoPrikazu)) {
            IPrikaz prikaz = platnePrikazy.vratPrikaz(slovoPrikazu);
            textKVypsani = prikaz.proved(parametry);
            if (herniPlan.getAktualniProstor() == herniPlan.getViteznyProstor()  ) {
                konecHry = true ;
                textKVypsani = textKVypsani + "\n Hurá";
            }
        }
        else {
            textKVypsani="Nevím co tím myslíš, tento příkaz neznám? ";
        }
        return textKVypsani;
    }
    
    
     /**
     *  Nastaví, že je konec hry, metodu využívá třída PrikazKonec,
     *  mohou ji použít i další implementace rozhraní Prikaz.
     *  
     *  @param  konecHry  hodnota false= konec hry, true = hra pokračuje
     */
    void setKonecHry(boolean konecHry) {
        this.konecHry = konecHry;
    }
    
     /**
     *  Metoda vrátí odkaz na herní plán, je využita hlavně v testech,
     *  kde se jejím prostřednictvím získává aktualní místnost hry.
     *  
     *  @return     odkaz na herní plán
     */
     public HerniPlan getHerniPlan(){
        return herniPlan;
     }
     
     public SeznamPrikazu vratSeznam(){
         return platnePrikazy;
     }
    
}

