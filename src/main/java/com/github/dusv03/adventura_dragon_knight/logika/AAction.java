/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package eu.pedu.adv17s._4_1100.dusv03_dusek.game;

import eu.pedu.adv17s_fw.game_txt.IAction;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;



/*******************************************************************************
 * The {@code AAction} abstract class is a common superclass of all classes,
 * the instances of which are responsible for interpretation of commands
 * entered by the user playing the game.
 * Name of the executed action is usually the first word of the entered command.
 * The further words are interpreted as arguments.
 * <p>
 * You can define also a command that opens the conversation
 * (e.g. with a person present in the room) and thus switch to the mode,
 * in which the entered texts are not interpreted as commands,
 * but are passed to the defined object up to moment,
 * when the conversation ends and the object controlling the dialogue
 * switches the game back to the basic command mode.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2017-Summer
 */
abstract class AAction
       extends ANamed
    implements IAction
{
//\CC== CLASS CONSTANTS (CONSTANT CLASS/STATIC ATTRIBUTES/FIELDS) ==============
    
    /** Mapa zprostředkovávající převod názvu akce na její instanci. */
    private static final Map<String, AAction> NAME_2_ACTION;


//\CV== CLASS VARIABLES (VARIABLE CLASS/STATIC ATTRIBUTES/FIELDS) ==============

    private static boolean isAlive = false;

//##############################################################################
//\CI== CLASS (STATIC) INITIALIZER (CLASS CONSTRUCTOR) =========================

        static
        {
        isAlive = false;
        NAME_2_ACTION = new HashMap<>();
        new ActionHelp();
        new ActionMove();
        new ActionPickUp();
        new ActionPutDown();
        new ActionExit();
        new ActionTalk();
        new ActionKill();
        new ActionMine();
        new ActionActivate();
        new ActionGive();
        }
        
//\CF== CLASS (STATIC) FACTORY METHODS =========================================
//\CG== CLASS (STATIC) GETTERS AND SETTERS =====================================
        
    public static boolean isAlive()
    {
       return isAlive;
    }
        
//\CM== CLASS (STATIC) REMAINING NON-PRIVATE METHODS ===========================
        
        public static String executeCommand(String command)
        { 
           command = command.trim();
           String answer;
           if(isAlive)
           {
               answer = executeCommonCommand(command);
           }
           else
           {
              answer = startGame(command);
           }
           return answer;
        }
        
        

//\CP== CLASS (STATIC) PRIVATE AND AUXILIARY METHODS ===========================

/***************************************************************************
* Zjistí, jaká akce má být zadaným příkazem aktivována,
* a jedná-li se o známou akci, provede ji.
*
* @param command Zadávaný příkaz
* @return Odpověď hry na zadaný příkaz
*/
    private static String executeCommonCommand(String command)
    {
        if (command.isEmpty()) {
            return Texts.zPRÁZDNÝ_PŘÍKAZ;
        }
        String[] words = command.toLowerCase().split("\\s+");
        String acttionName = words[0];
        AAction action = NAME_2_ACTION.get(acttionName);
        String answer;
        String info = "";
        if (action == null) {
            answer = Texts.zNEZNÁMÝ_PŘÍKAZ;
        }
        else
        {
        answer = action.execute(words);
        Place currentRoom = World.getInstance().getCurrentPlace();
        Bag batoh = Bag.getInstance();
        info = String.format(Texts.FORMÁT_INFORMACE,
        currentRoom.getName(), 
        Texts.cm(placesToArray(currentRoom.getNeighbors())), 
        Texts.cm(itemsToArray(currentRoom.getItems())),
        Texts.cm(itemsToArray(batoh.getItems())));}
        answer += info;
        
        return answer;
        }


    private static String[] placesToArray(Collection<Place> neighbors)
    {
        String[] result =
        neighbors.stream().map(in -> in.getName())
        .collect(Collectors.toList()).toArray(new String[neighbors.size()]);
        return result;
    }

    private static String[] itemsToArray(Collection<G_Item> items)
    {
        String[] result =
        items.stream().map(in -> in.getName())
        .collect(Collectors.toList()).toArray(new String[items.size()]);
        return result;
    }


 /***************************************************************************
* Ověří, jestli je hra spouštěna správným (= prázdným) příkazem,
* a pokud ano, spustí hru.
*
* @param command Příkaz spouštějící hru
* @return Odpověď hry na zadaný příkaz
*/
    private static String startGame(String command)
    {
    String answer;
    if (command.isEmpty()) {
        initialize();
        isAlive = true;
        answer = Texts.zUVÍTÁNÍ;
    }
    else {
        answer = Texts.zNENÍ_START;
    }
    return answer;
    }
    
    /***************************************************************************
    * Zabezpečí korektní ukončení hry.
    * Zapamatuje si, že hra je již ukončena.
    */
    static void stopGame()
    {
        isAlive = false;
    }

    private static void initialize()
        {
            World.getInstance().initialize();
            Bag  .getInstance().initialize();
            State              .initialize();
        }
    
    
//##############################################################################
//\IC== INSTANCE CONSTANTS (CONSTANT INSTANCE ATTRIBUTES/FIELDS) ===============

    /** Brief description of the given action. */
        private final String description;



//\IV== INSTANCE VARIABLES (VARIABLE INSTANCE ATTRIBUTES/FIELDS) ===============



//##############################################################################
//\II== INSTANCE INITIALIZERS (CONSTRUCTORS) ===================================

    /***************************************************************************
     * Creates the parent sub-object of the created action.
     *
     * @param name  Name of the created action = text, which the player has to
     *              enter as an initial word of the entered command
     * @param description Brief description of the created action
     */
    
    /***************************************************************************
     * Vytvoří rodičovský podobjekt vytvářené akce.
    *
    * @param name Název vytvářené akce = text, který musí hráč zadat
    * jako počáteční slovo zadávaného příkazu
    * @param description Stručný popis vytvářené akce
    */
    
    public AAction(String name, String description)
    {
        super(name);
        isAlive = false;
        this.description = description;
        AAction previous = NAME_2_ACTION.put(name.toLowerCase(), this);
        if (previous != null) {
            throw new IllegalArgumentException(
                "\nAkce s názvem «" + name + "» byl již vytvořena");
 }
    }



//\IA== INSTANCE ABSTRACT METHODS ==============================================

    /***************************************************************************
     * Processes the command composed from the given words
     * and returns the game answer to the user.
     * Number of word depends on particular action, however it must be
     * at least one, because the zeroth element contains the action name.
     * The remaining words are arguments of this action and they may differ:
     * the actions of <i>end</i> and <i>help</i> type do not have any,
     * the actions of <i>go</i> and <i>take</i> type have one,
     * the actions of <i>apply</i> type ) can have two (e.g. apply key lock)
     * or three (e.g. apply key to lock) etc.
     *
     * @param arguments Action arguments –
     *                  their number can be different for each action,
     *                  but for all execution of the same action is the same
     * @return The answer of the game after processing the command
     */
    @Override
    abstract
    public String execute(String... arguments)
    ;



//\IG== INSTANCE GETTERS AND SETTERS ===========================================

    /***************************************************************************
     * Returns the action description with explanation of its function
     * and the meaning of individual parameters.
     *
     * @return Action description
     */
    @Override
    public String getDescription()
    {
        return description;
    }
    

    /***************************************************************************
    * Vrátí kolekci všech akcí použitelných ve hře.
    *
    * @return Kolekce všech akcí použitelných ve hře
    */
    static Collection<AAction> getAllActions()
    {
        Collection<AAction> collection, result;
        collection = NAME_2_ACTION.values();
        result = Collections.unmodifiableCollection(collection);
        return result;
    }


//\IM== INSTANCE REMAINING NON-PRIVATE METHODS =================================
//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
