/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.dusv03.adventura_dragon_knight.logika;

import java.util.Collection;
import java.util.stream.Collectors;

import com.github.dusv03.adventura_dragon_knight.logika.Hra;
import com.github.dusv03.adventura_dragon_knight.logika.IPrikaz;
import static com.github.dusv03.adventura_dragon_knight.logika.Texts.*;



/*******************************************************************************
 * Instances of the {@code EmptyAction} class process the commands, which
 * ???.
 * <p>
 * Instances of the action classes are effectively singletons,
 * however we do not need to ensure it explicitely, because for their creation
 * and further management the specified action manager takes care
 * which ensures the only instance of each such class.
 * </p>
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 2017-Summer
 */
public class ActionHelp
     extends APrikaz
{
	private final Hra hra;
    private static final String NAZEV = pPOMOC;
    /***************************************************************************
     * Creates the action instance for ...
     */
    public ActionHelp(Hra hra)
    {
        super (pPOMOC,
               "Vypíše základní nápovědu a seznam dostupných příkazů.");
        this.hra = hra;
    }

    @Override
    public String proved(String... arguments)
    {
    	Collection<IPrikaz> commands = hra.vratSeznam().vratPrikazy();
        String result = commands.stream()
                       .map(cmd -> cmd.getNazev() + "\n" + cmd.getPopis())
                       .collect(Collectors.joining
                                 ("\n\n", zNÁPOVĚDA,"\n"));
        return result;
    }



//\IP== INSTANCE PRIVATE AND AUXILIARY METHODS =================================



//##############################################################################
//\NT== NESTED DATA TYPES ======================================================
}
