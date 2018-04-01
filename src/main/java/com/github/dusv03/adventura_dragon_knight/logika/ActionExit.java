/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺
 */
package com.github.dusv03.adventura_dragon_knight.logika;

import com.github.dusv03.adventura_dragon_knight.logika.APrikaz;
import com.github.dusv03.adventura_dragon_knight.logika.Hra;
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
public class ActionExit
	extends APrikaz
{
	private final Hra hra;
	private static final String NAZEV = pEND_GAME;
    public ActionExit(Hra hra)
    {
        super (Texts.pEND_GAME,
               "Poděkuje a okamžitě ukončí hru.");
        this.hra = hra;
    }




    @Override
    public String proved(String... arguments)
    {
    	if (arguments.length > 1) {
            return zEXIT_PARA;
        }
        else {
    	hra.setKonecHry(true);
        return zUKONČENÍ;
        }
    }
}
