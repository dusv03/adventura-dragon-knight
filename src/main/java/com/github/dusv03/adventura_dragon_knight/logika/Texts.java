/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.dusv03.adventura_dragon_knight.logika;

import java.util.stream.Collectors;
import java.util.Arrays;

/**
 *
 * @author vladi
 */
public class Texts {

//== CONSTANT CLASS ATTRIBUTES =================================================

    
    /** Jméno autora programu. */
    static final String AUTHOR_NAME = "DUŠEK Vladimír";

    /** Xname autora programu. */
    static final String AUTHOR_ID = "dusv03";

    /** Názvy používaných prostorů - místností. */
    static final String
            ROZCESTÍ = "rozcestí",
            ČARODĚJOVA_VĚŽ = "čarodějova_věž",
            LESNÍ_MÝTINA = "lesní_mýtina",
            DŮL = "důl",
            ŠTOLA = "štola",
            KOVÁRNA = "kovárna",
            JESKYNĚ = "jeskyně",
            SLŮJ = "slůj";
    
    /** Názvy používaných h-objektů. */
    static final String
            MEČ = "meč",
            PRSTEN = "prsten",
            TALISMAN = "talisman",
            AMULET = "amulet",
            BYLINY = "byliny",
            KRUMPÁČ = "krumpáč",
            METEORITSKÁ_RUDA = "meteoritská_ruda",
            LOPATA = "lopata",
            VĚDRO = "vědro",
            METEORITSKÝ_MEČ = "meteoritský_meč",
            ČARODĚJ = "čaroděj",
            LESNÍ_VÍLA = "lesní_víla",
            PŘÍZRAK = "přízrak",
            KOVÁŘ = "kovář",
            DRAK = "drak";
                
    /** Názvy používaných akcí. */
    static final String
            pPOMOC = "pomoc",
            pJDI_DO = "jdi_do",
            pSEBRAT = "sebrat",
            pMLUVIT_S = "mluvit_s",
            pPOLOŽIT = "položit",
            pPŘEDAT = "předat",
            pAKTIVOVAT = "aktivovat",
            pZABÍT = "zabít",
            pNATĚŽIT = "natěžit",
            pEND_GAME = "end_game",
            pSTART = "start";
    
    /** Formát dodatku zprávy informujícího o aktuálním stavu hráče. */
    static final String
        SOUSEDÉ = "Sousedé: ",
        PŘEDMĚTY = "Předměty: ",
        BATOH = "Batoh: ",
        FORMÁT_INFORMACE = "\n\nNacházíte se v místnosti: %s" +
            "\n" + SOUSEDÉ + "[%s]" +
            "\n" + PŘEDMĚTY + "[%s]" +
            "\n" + BATOH + "[%s]";


 /** Texty zpráv vypisovaných v reakci na příkazy vyvolávají povinné akce.
 * Počáteční z (zpráva) slouží k odlišení od stavů. */
    static final String
            zUVÍTÁNÍ = "Vítej u hry Dragon Knight, jsi potulný rytíř putující "
           + "od města k\n"
           + " městu Vlastníš pouze svůj meč a starý rodový prsten. Právě se \n"
           + "nacházíš v kraji, který je sužovaný útoky draka. Tvým \n"
           + "úkolem je draka zabít a získat jeho moc. Právě jsi na rozcestí \n"
           + "poblíž věže čaroděje, tam by si měl nalézt infromace potřebné \n"
           + "k zabití draka.",
            
            zPŘESUN = "Přišel jsi do",
            
            zČARODĚJ1 = "Zdravím tě rytíři,řekl čaroděj, vím že jsi tu, abys\n"
          + "zabil draka. Na to, abys draka zabil potřebuješ\n"
          + "meč z meteoritské oceli,o tom si budeš muset promluvit s \n"
          + "kovářem.Kousek odsud je důl, ale nikdo do něj už \n"
          + "léta nešel, protože se tam usídlily přízraky, které zabijí \n"
          + "každého, kdo se přiblíží.Zde je talisman, který ti umožní \n"
          + "se jim postavit. Ale aby si přízraky zabil, budeš jej muset \n"
          + "aktivovat, jinak nebude fungovat Také budeš potřebovat amulet,\n"
          + " který tě ochrání před dračím ohněm. Ten ti mohu dát ale pouze \n"
          + "výměnou za vzácné byliny roustoucí na lesní mýtině.\n"
          + " Když mi je přineseš dám ti ten amulet.",
            
            zČARODĚJ2 = "Vidím že jsi mi přinesl byliny, stačí mi je dát "
            + "a dostaneš svůj amulet",
            
            zČARODĚJ3 = "Pokud mi neneseš byliny, nemám se s Tebou o čem bavit."
            ,
            
            zČARODĚJ4 = "Amulet jsem ti už dal, pokud máš meč můžeš jít zabít\n"
            + " draka",
            
            zSEBRÁNÍ = "Sebral jsi",
            
            zLESNÍMÝTINA = "Už z dálky slyšíš z mýtiny zpívat lesní vílu.",
            
            zLESNÍVÍLA1 = "Když přijdeš blíž víla si tě všimne a řekne:\n"
          + "Vím proč jsi tu, mé květinky ale nejsou pro každého, musiš mi \n"
          + "dát něco na oplátku,ale musí mě ta věc zaujmout a nejradši \n"
          + "mám šperky.",
            
            zLESNÍVÍLA2 = "Ten je krásný, něco tak krásného mi ještě nikdy \n"
          + "nikdo nedal, děkuji Ti. Nyní si můřeš natrhat mé květiny.",
            
            zLESNÍVÍLA3 = "Pokud mi nedáš dárek, nemám ti co říct.",
            
            zLESNÍVÍLA4 = "Byliny už sis mohl natrhat, už ti nemám co říct.",
            
            zTALISMAN = "Talisman se rozzářil",
            
            zPŘÍZRAK = "a přízrak jako by se zhmotnil.",
            
            zZABITÍ = "Zabil jsi",
            
            zNATĚŽENÍ = "Natěžil jsi",
            
            zPOLOŽENÍ = "Položil jsi",
            
            zKOVÁŘ1 = "Čaroděj říkal, že potřebuješ meč, který zabije\n "
          + "draka. Muřu ti ho vyrobit, ale potřebuju meteoritskou rudu a \n"
          + "něco čím mi zaplatíš za práci. Myslím, že tvůj starý meč \n"
          + "by mohl stačit.",
            
            zKOVÁŘ2 = "Ještě potřebuju tvůj meč.",
            
            zKOVÁŘ3= "Ještě potřebuju tu meteoritskou rudu.",
            
            zKOVÁŘ4= "Meteoritský meč jsem ti už dal, už ti nemám co říct.",
            
            zPŘEDÁNÍ = "Předal jsi",
                        
            zAMULETA = "Během chvilky se proti tobě přivalil\n"
          + "proud ohně, amulet od čaroděje však kolem tebe vytvořil\n"
          + "barieru, která tě před ním ochránila. Můžeš tedy pokračovat do\n"
          + "slůje.",
            
            zJESKYNĚ_SMRT = "Během chvilky se proti tobě přivalil\n"
          + "proud ohně, který tě spálil na škvarek.",
            
            zSLŮJ = "Všude kolem tebe jsou hory zlata, na \n"
          + "kterých se ovšem rozvaluje drak chrlící oheň. Protože tě však\n"
          + "chrání bariéra můžeš se přiblížit k drakovi a zabít ho.\n",
            
            zZABITÍDRAKA = "Meč z meteoritské oceli prejel drakovou kůží \n"
          + "jako nůž máslem. Drak se krátce zazmítal a poté padl \n"
          + "k zemi mrtev. Po chvilce se jeho mrtvola změnila v pronikavé \n"
          + "světlo, které vletělo přímo do tebe. S úžazem si zjistil, že \n"
          + "jsi získal drakovu sílu chrlit ohěn a jako bonus i celý jeho \n"
          + "poklad.\n",
            
            zNENÍ_START = "Zadal jste špatný startovací příkaz. Startovacím\n"
            + "příkazem je prázdný příkaz",
    
            zNEZNÁMÝ_PŘÍKAZ = "Zadaný příkaz je neplatný. Pro výpis příkazů\n"
            + "napište příkaz pomoc",
            
            zPRÁZDNÝ_PŘÍKAZ = "Zadal jste prázdný příkaz.",
            
            zCHYBNÝ_PARAMETR = "Zadal jsi chybý parametr k zadanemu příkazu.",
            
            zCHYBA_PŘESUN_A = "\nParametrem musí být soused momentální lokace.",
            
            zCHYBA_SEBRAT = "\nParametrem musí být zvednutelný předmět \n"
            + "v aktuální lokaci.",
            
            zCHYBA_ZABÍT = "\nParametrem musí být zabitelný nepřítel \n"
            + "v aktuální lokaci.",

            zCHYBA_ZABÍT2 = "Tento objekt nelze zabít.",
            
            zCHYBA_ZABÍT3 = "Meč duchem jen proletěl, měl byste \n"
            + "aktivoat talisman.",
            
            zCHYBA_MLUVIT = "\nParametrem musí být objekt s nímž lze mluvit.",
            
            zSMRT_DRAK = "Tvůj meč nedokázal prorazit dračí kůži. Drak\n"
            + "se během chvilky vzpamatoval a zabil Tě.",
            
            zCHYBA_POLOŽIT = "\nParametrem musí být předmět z batohu.",
            
            zCHYBA_PŘEDÁNÍ = "V aktuálním prostoru není nikdo, kdo zadaný\n"
            + "předmět požaduje.",
            
            zPOMOC = "Jsi potulný rytíř, jehož úkolem je zabít draka.\n"
          + "Sezbírej potřebné věci k jeho zabití a pokud si nevíš rady \n"
          + "promluv si ostatními bytostmi na které narazíš.\n"          
          + "Seznam příkazů:\n"
          + "pomoc - Vypíše základní nápovědu a seznam dostupných příkazů.\n "
          + "jdi_do parametr - Přesune hrdinu do lokace zadané parametrem.\n"
          + "sebrat parametr - Sebere z prostředí předmět určený parametrem.\n"
          + "položit parametr - Přesune věc určenou parametrem z batohu \n"
          + "do aktuálního prostoru.\n"
          + "zabít parametr - Zabije nepřítele určeného parametrem.\n"
          + "předat parametr - Předá věc určenou parametrem osobě \n"
          + "v současné lokaci.\n"
          + "mluvit_s parametr - Hráč promluví s postavou určenou parametrem.\n"
          + "natěžit parametr - Pomocí krumpáče v inventáři natěží objekt \n"
          + "zadaný parametrem.\n"
          + "aktivovat parametr - Aktivuje věc zadanou parametrem.\n"
          + "end_game - Poděkuje a okamžitě ukončí hru.",
            
            zNÁPOVĚDA = "Jsi potulný rytíř, jehož úkolem je zabít draka.\n"
          + "Sezbírej potřebné věci k jeho zabití a pokud si nevíš rady \n"
          + "promluv si ostatními bytostmi na které narazíš.\n"          
          + "Seznam příkazů:\n",
            
            zŠPATNÝ_PŘEDMĚT = "Tento předmět se v současné lokaci nenachází.",
            
            zŽÁDNÝ_PARAMETR = "Nezadal jsi žádný parametr.",
            
            zPLNÝ_BATOH = "Batoh je plný.",
                    
            zNEPOHYBLIVÝ = "Tento předmět nelze zvednout.",
                                    
            zNENÍ_V_BATOHU = "Zadaný předmět není v batohu.",
            
            zNELZE_TĚŽIT = "Zadaný předmět nelze natěžit.",
            
            zCHYBÍ_KRUMPÁČ = "K těžení potřebujete krumpáč.",
            
            zCHYBA_AKTIVOVAT = "Paramtrem musí být aktivovatelný předmět.\n "
            + "V naší hře je to pouze předmět amulet.",
            
            zUKONČENÍ = "Konec hry. Děkujime, že jste zkusil naši hru.";
            
            
    

//== OTHER NON-PRIVATE CLASS METHODS ===========================================

 /***************************************************************************
 * Vrátí řetězec obsahující zadané názvy oddělené čárkami.
 *
 * @param názvy Názvy, které je třeba sloučit
 * @return Výsledný řetězec ze sloučených zadaných názvů
 */
    static String cm(String... názvy)
    {
        String result = Arrays.stream(názvy)
            .collect(Collectors.joining(", "));
        return result;
    }

//== CONSTUCTORS AND FACTORY METHODS ===========================================
    /** Soukromý konstruktor zabraňující vytvoření instance.*/
    private Texts() {} 
     
     
    
}
