/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv17s._4_1100.dusv03_dusek.game;

import eu.pedu.adv17s_fw.scenario.AScenarioManager;
import eu.pedu.adv17s_fw.scenario.ScenarioStep;
import eu.pedu.adv17s_fw.scenario.TypeOfScenario;

import static eu.pedu.adv17s_fw.scenario.TypeOfStep.*;
import static eu.pedu.adv17s._4_1100.dusv03_dusek.game.Texts.*;



/*******************************************************************************
 * Instance of the {@code RUPScenarioManagerLit} class serves as
 * scenario manager, that has to manage the scenarios of the associated game.
 * These scenarios should allow to test and demonstrate
 * the functionality of the associated game.
 * <p>
 * Each manager has to offer:
 * <ul>
 *   <li>The <b>happy scenario</b> (the basic successful one)
 *     demonstrating certain successful path through the game possibilities
 *     leading to the game goal.
 *   </li>
 *   <li>The <b>mistake scenario</b>
 *     demonstrating the game reaction to the wrongly entered commands.
 *   </li>
 * </ul>
 * <p>
 * Individual managed scenarios have to differ by their names;
 * the names of the happy scenario and the mistake one
 * are firmly pre-determined and cannot be arbitrarily set.
 * <p>
 * Individual scenarios are iterable and "streamable" sequences of steps
 * specified by instances of the framework class
 * {@link eu.pedu.adv17s_fw.scenario.ScenarioStep},
 * to which the designed game should associated.
 * <p>
 * Scenario manager is a singleton, that is responsible
 * for all scenarios concerning the game associated with it.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2017-Summer
 */
public   class DK_ScenarioManager
       extends AScenarioManager
    implements IAuthor_VD
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    /***************************************************************************
     * The initial game step identical for all scenarios.
     * <p>
     * Constructor of the full-fledged {@link ScenarioStep} class instance
     * requires the following parameters:
     <pre> {@code
TypeOfStep typeOfStep; //Type of the given scenario step
String     command;    //Command realizing this scenario step
String     message;    //Message written after entering the command
String     place;      //Current place after entering the command
String[]   neighbors;  //Neighbors of the current place (= exits)
String[]   items;      //Items occuring in the current place
String[]   bag;        //Current bag content
     }</pre>
     =======================================================================<br>
     * Scenario steps have to comply with the following requirements:
     * <ul>
     *   <li>None the items may contain the {@code null} value.</li>
     *   <li>With the exception of {@code command} no string may be
     *     empty (i.e. {@code ""})</li>
     *   <li>Empty string may occur neither as an item in the array
     *     {@code neighbors}, nor {@code items} nor {@code bag}</li>
     * </ul>
     * <br>
     **************************************************************************/
     public static final ScenarioStep START_STEP =
        new ScenarioStep(0, tsSTART, "", //Název spouštěcího příkazu = ""
            zUVÍTÁNÍ
            ,
            ROZCESTÍ,
            new String[] { LESNÍ_MÝTINA,DŮL,ČARODĚJOVA_VĚŽ,
                KOVÁRNA,JESKYNĚ},
            new String[] {},
            new String[] { MEČ,PRSTEN}
        );

     private static final String REQUIRED_STEPS_SCENARIO_NAME = "REQUIRED";
    /***************************************************************************
     * Steps of the happy scenario
     * describing the expectable successful game running. It is not necessary
     * for the scenario compiled of these steps to be the shortest possible
     * (it implies, that it has not to be the true basic successful scenario),
     * but it has to comply with all marginal conditions of the assignment,
     * i.e. it has to contain minimal number of steps,
     * pass through the required minimal number of places
     * and demonstrate using of all required actions.
     */
    private static final ScenarioStep[] HAPPY_SCENARIO_STEPS =
    {
        START_STEP,

        new ScenarioStep(tsMOVE, pJDI_DO + " " + ČARODĚJOVA_VĚŽ,
            zPŘESUN + " " + ČARODĚJOVA_VĚŽ          
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA},
            new String[] { ČARODĚJ},
            new String[] { MEČ,PRSTEN}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pMLUVIT_S + " " + ČARODĚJ,
            zČARODĚJ1          
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA },
            new String[] { ČARODĚJ,TALISMAN},
            new String[] { MEČ,PRSTEN}
        )
        ,
                
        new ScenarioStep(tsTAKE, pSEBRAT + " " + TALISMAN,
            zSEBRÁNÍ + " " + TALISMAN
            
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA },
            new String[] { ČARODĚJ},
            new String[] { MEČ,PRSTEN,TALISMAN}
        )
        , 
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + ROZCESTÍ,
            zPŘESUN + " " + ROZCESTÍ               
            ,
            ROZCESTÍ,
            new String[] {LESNÍ_MÝTINA,DŮL,ČARODĚJOVA_VĚŽ,
                KOVÁRNA,JESKYNĚ},
            new String[] { },
            new String[] { MEČ,PRSTEN,TALISMAN}
        )
        , 
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + LESNÍ_MÝTINA,
            zPŘESUN + " " + LESNÍ_MÝTINA
            ,
            LESNÍ_MÝTINA,
            new String[] { ROZCESTÍ},
            new String[] { LESNÍ_VÍLA},
            new String[] { MEČ,PRSTEN,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pMLUVIT_S + " " + 
                                          LESNÍ_VÍLA,
            zLESNÍVÍLA1
            ,
            LESNÍ_MÝTINA,
            new String[] { ROZCESTÍ},
            new String[] { LESNÍ_VÍLA},
            new String[] { MEČ,PRSTEN,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pPŘEDAT + " " + PRSTEN,
            zLESNÍVÍLA2
            ,
            LESNÍ_MÝTINA,
            new String[] { ROZCESTÍ},
            new String[] { LESNÍ_VÍLA,BYLINY},
            new String[] { MEČ,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsTAKE, pSEBRAT + " " + BYLINY,
            zSEBRÁNÍ + " " + BYLINY
            ,
            LESNÍ_MÝTINA,
            new String[] { ROZCESTÍ},
            new String[] { LESNÍ_VÍLA},
            new String[] { MEČ,BYLINY,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + ROZCESTÍ,
            zPŘESUN + " " + ROZCESTÍ                
            ,
            ROZCESTÍ,
            new String[] { LESNÍ_MÝTINA,DŮL,ČARODĚJOVA_VĚŽ,
                KOVÁRNA,JESKYNĚ},
            new String[] { },
            new String[] { MEČ,BYLINY,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + DŮL,
            zPŘESUN + " " + DŮL
            ,
            DŮL,
            new String[] { ROZCESTÍ,KOVÁRNA},
            new String[] { PŘÍZRAK,KRUMPÁČ,LOPATA,
                           VĚDRO},
            new String[] { MEČ,BYLINY,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1,pAKTIVOVAT + " " +TALISMAN,
            zTALISMAN + " " + zPŘÍZRAK
            ,
            DŮL,
            new String[] { ROZCESTÍ,KOVÁRNA},
            new String[] { PŘÍZRAK,KRUMPÁČ,LOPATA,
                           VĚDRO},
            new String[] { MEČ,BYLINY,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pZABÍT + " " + PŘÍZRAK,
            zZABITÍ + " " + PŘÍZRAK
            ,
            DŮL,
            new String[] { ROZCESTÍ,KOVÁRNA,ŠTOLA},
            new String[] { KRUMPÁČ,LOPATA, VĚDRO },
            new String[] { MEČ,BYLINY,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsTAKE, pSEBRAT + " " + KRUMPÁČ,
            zSEBRÁNÍ + " " + KRUMPÁČ
            ,
           DŮL,
            new String[] { ROZCESTÍ,KOVÁRNA,ŠTOLA},
            new String[] { LOPATA, VĚDRO},
            new String[] { MEČ,BYLINY,TALISMAN,KRUMPÁČ}
        )
        ,
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + ŠTOLA,
            zPŘESUN + " " + ŠTOLA
                
            ,
            ŠTOLA,
            new String[] { DŮL},
            new String[] { METEORITSKÁ_RUDA},
            new String[] { MEČ,BYLINY,TALISMAN,KRUMPÁČ}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pNATĚŽIT + " " + 
            METEORITSKÁ_RUDA,
            zNATĚŽENÍ + " " + METEORITSKÁ_RUDA  
            ,
            ŠTOLA,
            new String[] { DŮL},
            new String[] { METEORITSKÁ_RUDA},
            new String[] { MEČ,BYLINY,TALISMAN,KRUMPÁČ}
        )
        ,
        
        new ScenarioStep(tsPUT_DOWN, pPOLOŽIT + " " + KRUMPÁČ,
            zPOLOŽENÍ + " " + KRUMPÁČ
            ,
            ŠTOLA,
            new String[] { DŮL},
            new String[] { METEORITSKÁ_RUDA, KRUMPÁČ},
            new String[] { MEČ,BYLINY,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsTAKE, pSEBRAT + " " + METEORITSKÁ_RUDA,
            zSEBRÁNÍ + " " + METEORITSKÁ_RUDA
            ,
            ŠTOLA,
            new String[] { DŮL},
            new String[] { KRUMPÁČ},
            new String[] { MEČ,BYLINY,TALISMAN, 
                           METEORITSKÁ_RUDA}
        )
        ,
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + DŮL,
            zPŘESUN + " " + DŮL
                
            ,
            DŮL,
            new String[] { ROZCESTÍ,KOVÁRNA,ŠTOLA},
            new String[] { LOPATA, VĚDRO},
            new String[] { MEČ,BYLINY,TALISMAN, 
                           METEORITSKÁ_RUDA}
        )
        ,
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + KOVÁRNA,
            zPŘESUN + " " + KOVÁRNA
            ,
            KOVÁRNA,
            new String[] { ROZCESTÍ,DŮL,ČARODĚJOVA_VĚŽ},
            new String[] { KOVÁŘ},
            new String[] { MEČ,BYLINY,TALISMAN, 
                           METEORITSKÁ_RUDA}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pMLUVIT_S + " " + KOVÁŘ,
            zKOVÁŘ1
            ,
            KOVÁRNA,
            new String[] { ROZCESTÍ,DŮL,ČARODĚJOVA_VĚŽ},
            new String[] { KOVÁŘ},
            new String[] { MEČ,BYLINY,TALISMAN, 
                           METEORITSKÁ_RUDA}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pPŘEDAT + " " + 
                                          METEORITSKÁ_RUDA,
            zPŘEDÁNÍ + " " + METEORITSKÁ_RUDA 
            ,
            KOVÁRNA,
            new String[] { ROZCESTÍ,DŮL,ČARODĚJOVA_VĚŽ},
            new String[] { KOVÁŘ},
            new String[] { MEČ,BYLINY,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pPŘEDAT + " " + MEČ,
            zPŘEDÁNÍ + " " + MEČ
            ,
            KOVÁRNA,
            new String[] { ROZCESTÍ,DŮL,ČARODĚJOVA_VĚŽ},
            new String[] { KOVÁŘ,METEORITSKÝ_MEČ},
            new String[] { BYLINY,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsTAKE, pSEBRAT + " " + METEORITSKÝ_MEČ,
            zSEBRÁNÍ + " " + METEORITSKÝ_MEČ
                
            ,
            KOVÁRNA,
            new String[] { ROZCESTÍ,DŮL,ČARODĚJOVA_VĚŽ},
            new String[] { KOVÁŘ},
            new String[] { BYLINY,TALISMAN,METEORITSKÝ_MEČ}
        )
        ,
        
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + ČARODĚJOVA_VĚŽ,
            zPŘESUN + " " + ČARODĚJOVA_VĚŽ          
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA},
            new String[] { ČARODĚJ},
            new String[] { BYLINY,TALISMAN,METEORITSKÝ_MEČ}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pMLUVIT_S + " " + ČARODĚJ,
            zČARODĚJ2          
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA },
            new String[] { ČARODĚJ},
            new String[] { BYLINY,TALISMAN,METEORITSKÝ_MEČ}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pPŘEDAT + " " + BYLINY,
            zPŘEDÁNÍ + " " + BYLINY    
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA},
            new String[] { ČARODĚJ, AMULET},
            new String[] { TALISMAN,METEORITSKÝ_MEČ}
        )
        ,
        
        new ScenarioStep(tsTAKE, pSEBRAT + " " + AMULET,
            zSEBRÁNÍ + " " + AMULET
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA},
            new String[] { ČARODĚJ},
            new String[] { TALISMAN,METEORITSKÝ_MEČ,AMULET}
        )
        ,
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + ROZCESTÍ,
            zPŘESUN + " " + ROZCESTÍ               
            ,
            ROZCESTÍ,
            new String[] { LESNÍ_MÝTINA,DŮL,ČARODĚJOVA_VĚŽ,
                KOVÁRNA,JESKYNĚ},
            new String[] { },
            new String[] { TALISMAN,METEORITSKÝ_MEČ,AMULET}
        )
        , 
        
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + JESKYNĚ,
            zPŘESUN + " " + JESKYNĚ + ". " + zAMULETA              
            ,
            JESKYNĚ,
            new String[] { ROZCESTÍ,SLŮJ},
            new String[] { },
            new String[] { TALISMAN,METEORITSKÝ_MEČ,AMULET}
        )
        ,
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + SLŮJ,
            zPŘESUN + " " + SLŮJ + ". " + zSLŮJ                
            ,
            SLŮJ,
            new String[] { JESKYNĚ},
            new String[] { DRAK},
            new String[] { TALISMAN,METEORITSKÝ_MEČ,AMULET}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pZABÍT + " " + DRAK,
            zZABITÍDRAKA + "\n" + zUKONČENÍ
                  
                
            ,
            SLŮJ,
            new String[] { JESKYNĚ},
            new String[] { },
            new String[] { TALISMAN,METEORITSKÝ_MEČ,AMULET}
        )
        ,
    };


    /** Step testing the incorrect game starting is defined separately,
     *  so that the indexes of the following steps could be simply adjusted. */
    private static final ScenarioStep WRONG_START =
    new ScenarioStep(-1,
            tsNOT_START, pSTART,
            zNENÍ_START
            ,
            "",
            new String[] {},
            new String[] {},
            new String[] {}
        );


    static { ScenarioStep.setIndex(1); }


    /***************************************************************************
     * Mistake scenario defining reactions
     * to mandatory set of types of incorrectly given commands.
     */
    private static final ScenarioStep[] MISTAKE_SCENARIO_STEPS =
    {
        WRONG_START,

        START_STEP,

        new ScenarioStep(tsEMPTY, "",
            zPRÁZDNÝ_PŘÍKAZ
            ,
            ROZCESTÍ,
            new String[] { LESNÍ_MÝTINA,DŮL,ČARODĚJOVA_VĚŽ,
                KOVÁRNA,JESKYNĚ},
            new String[] {},
            new String[] { MEČ,PRSTEN}
        )
        ,
        
        new ScenarioStep(tsMOVE_WA, "jdi_do",
            zŽÁDNÝ_PARAMETR + zCHYBA_PŘESUN_A
            ,
            ROZCESTÍ,
            new String[] { LESNÍ_MÝTINA,DŮL,ČARODĚJOVA_VĚŽ,
                KOVÁRNA,JESKYNĚ},
            new String[] {},
            new String[] { MEČ,PRSTEN}
        )
        ,
        
        new ScenarioStep(tsHELP, pPOMOC,
            zPOMOC
            ,
            ROZCESTÍ,
            new String[] { LESNÍ_MÝTINA,DŮL,ČARODĚJOVA_VĚŽ,
                KOVÁRNA,JESKYNĚ},
            new String[] {},
            new String[] { MEČ,PRSTEN}
        )
        ,
        
        new ScenarioStep(tsUNKNOWN, "jdu_do " + ČARODĚJOVA_VĚŽ,
            zNEZNÁMÝ_PŘÍKAZ
            ,
            ROZCESTÍ,
            new String[] { LESNÍ_MÝTINA,DŮL,ČARODĚJOVA_VĚŽ,
                KOVÁRNA,JESKYNĚ},
            new String[] {},
            new String[] { MEČ,PRSTEN}
        )
        ,
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + ČARODĚJOVA_VĚŽ,
            zPŘESUN + " " + ČARODĚJOVA_VĚŽ          
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA},
            new String[] { ČARODĚJ},
            new String[] { MEČ,PRSTEN}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pMLUVIT_S + " " + ČARODĚJ,
            zČARODĚJ1          
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA },
            new String[] { ČARODĚJ,TALISMAN},
            new String[] { MEČ,PRSTEN}
        )
        ,
                
        new ScenarioStep(tsTAKE, pSEBRAT + " " + TALISMAN,
            zSEBRÁNÍ + " " + TALISMAN
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA },
            new String[] { ČARODĚJ},
            new String[] { MEČ,PRSTEN,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsBAD_NEIGHBOR, pJDI_DO + " " + 
                LESNÍ_MÝTINA,
            zCHYBNÝ_PARAMETR + zCHYBA_PŘESUN_A
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA },
            new String[] { ČARODĚJ},
            new String[] { MEČ,PRSTEN,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + ROZCESTÍ,
            zPŘESUN + " " + ROZCESTÍ               
            ,
            ROZCESTÍ,
            new String[] {LESNÍ_MÝTINA,DŮL,ČARODĚJOVA_VĚŽ,
                KOVÁRNA,JESKYNĚ},
            new String[] { },
            new String[] { MEČ,PRSTEN,TALISMAN}
        )
        , 
        
        
        new ScenarioStep(tsBAD_ITEM, pSEBRAT + " " + BYLINY,
            zŠPATNÝ_PŘEDMĚT
            ,
            ROZCESTÍ,
            new String[] {LESNÍ_MÝTINA,DŮL,ČARODĚJOVA_VĚŽ,
                KOVÁRNA,JESKYNĚ},
            new String[] { },
            new String[] { MEČ,PRSTEN,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + LESNÍ_MÝTINA,
            zPŘESUN + " " + LESNÍ_MÝTINA
            ,
            LESNÍ_MÝTINA,
            new String[] { ROZCESTÍ},
            new String[] { LESNÍ_VÍLA},
            new String[] { MEČ,PRSTEN,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pMLUVIT_S + " " + 
                                          LESNÍ_VÍLA,
            zLESNÍVÍLA1
            ,
            LESNÍ_MÝTINA,
            new String[] { ROZCESTÍ},
            new String[] { LESNÍ_VÍLA},
            new String[] { MEČ,PRSTEN,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pPŘEDAT + " " + PRSTEN,
            zLESNÍVÍLA2
            ,
            LESNÍ_MÝTINA,
            new String[] { ROZCESTÍ},
            new String[] { LESNÍ_VÍLA,BYLINY},
            new String[] { MEČ,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsTAKE_WA, pSEBRAT,
            zŽÁDNÝ_PARAMETR + zCHYBA_SEBRAT
            ,
            LESNÍ_MÝTINA,
            new String[] { ROZCESTÍ},
            new String[] { LESNÍ_VÍLA,BYLINY},
            new String[] { MEČ,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsTAKE, pSEBRAT + " " + BYLINY,
            zSEBRÁNÍ + " " + BYLINY
            ,
            LESNÍ_MÝTINA,
            new String[] { ROZCESTÍ},
            new String[] { LESNÍ_VÍLA},
            new String[] { MEČ,BYLINY,TALISMAN}
        )
        ,
                
        new ScenarioStep(tsMOVE, pJDI_DO + " " + ROZCESTÍ,
            zPŘESUN + " " + ROZCESTÍ                
            ,
            ROZCESTÍ,
            new String[] { LESNÍ_MÝTINA,DŮL,ČARODĚJOVA_VĚŽ,
                KOVÁRNA,JESKYNĚ},
            new String[] { },
            new String[] { MEČ,BYLINY,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + DŮL,
            zPŘESUN + " " + DŮL
            ,
            DŮL,
            new String[] { ROZCESTÍ,KOVÁRNA},
            new String[] { PŘÍZRAK,KRUMPÁČ,LOPATA,
                           VĚDRO},
            new String[] { MEČ,BYLINY,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1,pAKTIVOVAT + " " +TALISMAN,
            zTALISMAN + " " + zPŘÍZRAK
            ,
            DŮL,
            new String[] { ROZCESTÍ,KOVÁRNA},
            new String[] { PŘÍZRAK,KRUMPÁČ,LOPATA,
                           VĚDRO},
            new String[] { MEČ,BYLINY,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pZABÍT + " " + PŘÍZRAK,
            zZABITÍ + " " + PŘÍZRAK
            ,
            DŮL,
            new String[] { ROZCESTÍ,KOVÁRNA,ŠTOLA},
            new String[] { KRUMPÁČ,LOPATA, VĚDRO },
            new String[] { MEČ,BYLINY,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsTAKE, pSEBRAT + " " + KRUMPÁČ,
            zSEBRÁNÍ + " " + KRUMPÁČ
            ,
           DŮL,
            new String[] { ROZCESTÍ,KOVÁRNA,ŠTOLA},
            new String[] { LOPATA, VĚDRO},
            new String[] { MEČ,BYLINY,TALISMAN,KRUMPÁČ}
        )
        ,
        
         new ScenarioStep(tsBAG_FULL, pSEBRAT + " " + LOPATA,
            zPLNÝ_BATOH
                
            ,
            DŮL,
            new String[] { ROZCESTÍ,KOVÁRNA,ŠTOLA},
            new String[] { LOPATA, VĚDRO},
            new String[] { MEČ,BYLINY,TALISMAN,KRUMPÁČ}
        )
        ,
        
        new ScenarioStep(tsMOVE, pJDI_DO + " " + ŠTOLA,
            zPŘESUN + " " + ŠTOLA
                
            ,
            ŠTOLA,
            new String[] { DŮL},
            new String[] { METEORITSKÁ_RUDA},
            new String[] { MEČ,BYLINY,TALISMAN,KRUMPÁČ}
        )
        ,
        
        new ScenarioStep(tsUNMOVABLE, pSEBRAT + " " + 
                                      METEORITSKÁ_RUDA,
            zNEPOHYBLIVÝ
            ,
            ŠTOLA,
            new String[] { DŮL},
            new String[] { METEORITSKÁ_RUDA},
            new String[] { MEČ,BYLINY,TALISMAN,KRUMPÁČ}
        )
        ,
        
        new ScenarioStep(tsNON_STANDARD1, pNATĚŽIT + " " + 
            METEORITSKÁ_RUDA,
            zNATĚŽENÍ + " " + METEORITSKÁ_RUDA  
            ,
            ŠTOLA,
            new String[] { DŮL},
            new String[] { METEORITSKÁ_RUDA},
            new String[] { MEČ,BYLINY,TALISMAN,KRUMPÁČ}
        )
        ,
        
        new ScenarioStep(tsPUT_DOWN_WA, pPOLOŽIT,
            zŽÁDNÝ_PARAMETR + zCHYBA_POLOŽIT
                
            ,
            ŠTOLA,
            new String[] { DŮL},
            new String[] { METEORITSKÁ_RUDA},
            new String[] { MEČ,BYLINY,TALISMAN,KRUMPÁČ}
        )
        ,
        
        new ScenarioStep(tsPUT_DOWN, pPOLOŽIT + " " + KRUMPÁČ,
            zPOLOŽENÍ + " " + KRUMPÁČ                
            ,
            ŠTOLA,
            new String[] { DŮL},
            new String[] { METEORITSKÁ_RUDA,KRUMPÁČ},
            new String[] { MEČ,BYLINY,TALISMAN}
        )
        ,
        
        new ScenarioStep(tsNOT_IN_BAG, pPOLOŽIT + " " + LOPATA,
            zNENÍ_V_BATOHU
                
            ,
            ŠTOLA,
            new String[] { DŮL},
            new String[] { METEORITSKÁ_RUDA,KRUMPÁČ},
            new String[] { MEČ,BYLINY,TALISMAN}
        )
        ,
                
        new ScenarioStep(tsEND, pEND_GAME,
            zUKONČENÍ
            ,
            ŠTOLA,
            new String[] { DŮL},
            new String[] { METEORITSKÁ_RUDA,KRUMPÁČ},
            new String[] { MEČ,BYLINY,TALISMAN}
        )
    };

        static { ScenarioStep.setIndex(1); }
        
        private static final ScenarioStep[] REQUIRED_STEPS =
        {
         START_STEP,
         
         new ScenarioStep(tsHELP, pPOMOC,
            zPOMOC
            ,
            ROZCESTÍ,
            new String[] { LESNÍ_MÝTINA,DŮL,ČARODĚJOVA_VĚŽ,
                KOVÁRNA,JESKYNĚ},
            new String[] {},
            new String[] { MEČ,PRSTEN}
        )
        ,
                 
         new ScenarioStep(tsMOVE, pJDI_DO + " " + ČARODĚJOVA_VĚŽ,
            zPŘESUN + " " + ČARODĚJOVA_VĚŽ          
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA},
            new String[] { ČARODĚJ},
            new String[] { MEČ,PRSTEN}
        )
        ,
         
         new ScenarioStep(tsPUT_DOWN, pPOLOŽIT + " " + MEČ,
            zPOLOŽENÍ + " " + MEČ
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA},
            new String[] { ČARODĚJ, MEČ},
            new String[] { PRSTEN}
        )
        ,
         
         new ScenarioStep(tsTAKE, pSEBRAT + " " + MEČ,
            zSEBRÁNÍ + " " + MEČ
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA},
            new String[] { ČARODĚJ},
            new String[] { MEČ,PRSTEN}
        )
        ,
         
         new ScenarioStep(tsEND, pEND_GAME,
            zUKONČENÍ
            ,
            ČARODĚJOVA_VĚŽ,
            new String[] { ROZCESTÍ,KOVÁRNA},
            new String[] { ČARODĚJ},
            new String[] { MEČ,PRSTEN}
        )
            
        };

    /** The only instance of this class.
     *  It manages all scenarios of the associated game. */
    private static final DK_ScenarioManager MANAGER =
                                          new DK_ScenarioManager();



//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============



//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================

    /***************************************************************************
     * Static constructor is placed before definitions of constants
     * {@link #AGE}, {@link #THIS_YEAR} and {@link #BORN_YEAR}
     * and once again before the definition of a constant
     * {@link MISTAKE_SCENARIO_STEPS}.
     * Such initialization should be before each further constant
     * defining the steps of the following scenario.
     */



//\CF== CLASS (STATIC) FACTORY METHODS =========================================

    /***************************************************************************
     * Returns scenario manager - the only instance of this class.
     *
     * @return Scenario manager
     */
    public static DK_ScenarioManager getInstance()
    {
        return MANAGER;
    }



//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================

//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================




//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============
//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Creates an instance representing the game scenario manager.
     * Within the constructor framework it is suitable to create all scenarios
     * and seal the scenario manager after it.
     * <p>
     * Individual managed scenarios have to differ by their names,
     * the names of the happy scenario and the mistake one
     * are firmly pre-determined and cannot be changed.
     * Names given to them in the
     * {@link #addScenario(String, TypeOfScenario, ScenarioStep...)} method
     * are therefore only formal, because the called method assignes to them
     * the names defined in advance in appropriate constants.
     * <p>
     *´Contract of the
     * {@link #addScenario(String, TypeOfScenario, ScenarioStep...)} method
     * requires so that the happy scenario, i.e. scenario of the
     * {@link TypeOfScenario.scHAPPY}) type, would be added as the first one,
     * and the mistake scenario, i.e. the scenario of the
     * {@link MISTAKE_SCENARIO_NAME} type, as the second one.
     * The order of the subsequently added scenarios is not decisive.
      */
    private DK_ScenarioManager()
    {
        super(FACTORY_CLASS);

        addScenario(HAPPY_SCENARIO_NAME,
                    TypeOfScenario.scHAPPY,    HAPPY_SCENARIO_STEPS);
        addScenario(MISTAKE_SCENARIO_NAME,
                    TypeOfScenario.scMISTAKES, MISTAKE_SCENARIO_STEPS);
        addScenario(REQUIRED_STEPS_SCENARIO_NAME,
                    TypeOfScenario.scGENERAL, REQUIRED_STEPS);
        seal();
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================
//\IG== INSTANCE GETTERS AND SETTERS ===========================================
//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================



//##############################################################################
//== TEST METHODS AND CLASSES ==================================================

    /***************************************************************************
     * Method verifying the given scenario manager and the associated game
     * by scenarios of this manager.
     * <p>
     * The scenario manager is verified if it complies
     * with the following conditions:
     * <ul>
     *   <li>It knows to return properly formated name of the game author
     *       and his/her ID.</li>
     *   <li>It defines the happy scenario and the mistake one.</li>
     *   <li>The mistake scenario has the following properties:
     *     <ul>
     *       <li>Starting command, the name of which is an empty string</li>
     *       <li>Minimal required number of steps</li>
     *       <li>Minimal number of visited places</li>
     *       <li>Minimal number of "glimpsed" places</li>
     *       <li>Minimal number of own (optional) actions</li>
     *       <li>Usage of actions for moving from the current place
     *         to a neighboring place, taking item and putting down item</li>
     *       <li>Cross consistence of actions and states after execution
     *         of the actions</li>
     *     </ul>
     *   </li>
     *   <li>The mistake scenario has the following properties:
     *     <ul>
     *       <li>Incorrect starting by a not empty command,</li>
     *       <li>Starting command the name of which is an empty string</li>
     *       <li>Usage of all mandatory error step types defined in the<br>
     *         {@link eu.pedu.adv17s_fw.scenario.TypeOfStep} enum type</li>
     *       <li>Asking for a help</li>
     *       <li>Premature game termination</li>
     *     </ul>
     *   </li>
     * </ul>
     * <p>
     * The game is verified if it can be played exactly
     * as is planned in scenarios.
     *
     * @param args Command line parameters - unused.
     */
    public static void main(String[] args)
    {
        //Tests if the scenario manager and its scenarios
        //comply with requirements
//        MANAGER.autoTest();

        //Simulates playing the game according to happy scenario
//        MANAGER.getHappyScenario().simulate();

        //Game testing made gradually according to both mandatory scenarios,
        //the happy scenario is passed twice one after the other
        MANAGER.testGame();

        //Game testing according to scenarios with the given names
//        MANAGER.testGameByScenarios(REQUIRED_STEPS_SCENARIO_NAME);
//        MANAGER.testGameByScenarios(MISTAKE_SCENARIO_NAME);
        //Playing the game according to the scenario with the given name
//       MANAGER.playGameByScenario("???");

        System.exit(0);
    }

}
