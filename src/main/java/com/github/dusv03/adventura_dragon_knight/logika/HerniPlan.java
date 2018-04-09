package com.github.dusv03.adventura_dragon_knight.logika;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Observable;

import com.github.dusv03.adventura_dragon_knight.logika.HerniPlan;
import com.github.dusv03.adventura_dragon_knight.logika.Prostor;
import com.github.dusv03.adventura_dragon_knight.logika.Batoh;
import com.github.dusv03.adventura_dragon_knight.logika.Hra;

import static com.github.dusv03.adventura_dragon_knight.logika.Texts.*;
import static com.github.dusv03.adventura_dragon_knight.logika.Vec.*;
/**
 *  Class HerniPlan - třída představující mapu a stav adventury.
 * 
 *  Tato třída inicializuje prvky ze kterých se hra skládá:
 *  vytváří všechny prostory,
 *  propojuje je vzájemně pomocí východů 
 *  a pamatuje si aktuální prostor, ve kterém se hráč právě nachází.
 *
 *@author     Michael Kolling, Lubos Pavlicek, Jarmila Pavlickova, Alena Buchalcevova
 *@version    z kurzu 4IT101 pro školní rok 2014/2015
 */
public class HerniPlan extends Observable{
    
	private Map<String, Prostor> prostory;
	private Prostor aktualniProstor;
    private Batoh batoh;    
    private Hra hra;
    
     /**
     *  Konstruktor který vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví halu.
     */
    public HerniPlan(Batoh batoh,Hra hra) {
    	prostory = new HashMap<String, Prostor>();
        zalozProstoryHry();
        this.batoh = batoh;
        this.hra = hra;

    }
    

    
    /**
     *  Vytváří jednotlivé prostory a propojuje je pomocí východů.
     *  Jako výchozí aktuální prostor nastaví domeček.
     */
    private void zalozProstoryHry() {
        
        Prostor rozcesti = new Prostor(ROZCESTÍ,"rozcestí kam vedou všechny cesty",0,0);
        Prostor carodejova_vez = new Prostor(ČARODĚJOVA_VĚŽ,"domov mocného čaroděje",110,0);
        Prostor lesni_mytina = new Prostor(LESNÍ_MÝTINA,"mýtina uprostřed lesa, kde žijí různá tajemná stvoření",-10,80);
        Prostor dul = new Prostor(DŮL,"starý železný důl",-50,-60);
        Prostor stola = new Prostor(ŠTOLA,"štola, kde se těžilo železo",-180,-100);
        Prostor kovarna = new Prostor(KOVÁRNA,"domov a dílna proslulého kováře",55,-70);
        Prostor jeskyne = new Prostor(JESKYNĚ,"tmavá desivá jeskyně",-110,10);
        Prostor sluj = new Prostor(SLŮJ,"slůj draka terorizující celý kraj",-190,10);
              
        prostory.put(rozcesti.getNazev(), rozcesti);
        prostory.put(carodejova_vez.getNazev(), carodejova_vez);
        prostory.put(lesni_mytina.getNazev(), lesni_mytina);
        prostory.put(dul.getNazev(), dul);
        prostory.put(stola.getNazev(), stola);
        prostory.put(kovarna.getNazev(), kovarna);
        prostory.put(jeskyne.getNazev(), jeskyne);
        prostory.put(sluj.getNazev(), sluj);

        
        rozcesti.setVychod(carodejova_vez);
        rozcesti.setVychod(lesni_mytina);
        rozcesti.setVychod(dul);
        rozcesti.setVychod(kovarna);
        rozcesti.setVychod(jeskyne);
        carodejova_vez.setVychod(rozcesti);
        carodejova_vez.setVychod(kovarna);
        lesni_mytina.setVychod(rozcesti);
        dul.setVychod(rozcesti);
        dul.setVychod(kovarna);
        dul.setVychod(stola);
        stola.setVychod(dul);
        kovarna.setVychod(rozcesti);
        kovarna.setVychod(carodejova_vez);
        kovarna.setVychod(dul);
        jeskyne.setVychod(rozcesti);
        jeskyne.setVychod(sluj);
        sluj.setVychod(jeskyne);
        
        aktualniProstor = rozcesti;  // hra začíná v domečku  
        carodejova_vez.vlozVec(new Vec(COMMUNICATIVE+ČARODĚJ, "/ui/mage.png"));
        lesni_mytina.vlozVec(new Vec(COMMUNICATIVE+LESNÍ_VÍLA, "/ui/fairy.png")); 
        dul.vlozVec(new Vec(STANDARD+KRUMPÁČ, "/ui/pickaxe.png"));
        dul.vlozVec(new Vec(STANDARD+LOPATA, "/ui/shovel.png"));
        dul.vlozVec(new Vec(STANDARD+VĚDRO, "/ui/bucket.png"));
        dul.vlozVec(new Vec(KILLABLE+PŘÍZRAK, "/ui/ghost.png"));
        stola.vlozVec(new Vec(NOT_MOVABLE+METEORITSKÁ_RUDA, "/ui/rock.png"));
        kovarna.vlozVec(new Vec(COMMUNICATIVE+KOVÁŘ, "/ui/blacksmith.png"));
        sluj.vlozVec(new Vec(KILLABLE+DRAK, "/ui/dragon.png"));
    }
    
    /**
     *  Metoda vrací odkaz na aktuální prostor, ve ktetém se hráč právě nachází.
     *
     *@return     aktuální prostor
     */
    
    public Prostor getAktualniProstor() {
        return aktualniProstor;
    }
    
    /**
     *  Metoda nastaví aktuální prostor, používá se nejčastěji při přechodu mezi prostory
     *
     *@param  prostor nový aktuální prostor
     */
    public void setAktualniProstor(Prostor prostor) {
       aktualniProstor = prostor;
       this.setChanged();
       this.notifyObservers();
    }
    /**
     *  Metoda vrací odkaz na vítězný prostor.
     *
     *@return     vítězný prostor
     */
    
    
    public Map<String, Prostor> getProstory() {
    	return prostory;
    }

}
