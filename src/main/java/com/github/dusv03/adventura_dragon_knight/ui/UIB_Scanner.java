/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.adv17s._4_1100.dusv03_dusek.textui;

import eu.pedu.adv17s._4_1100.dusv03_dusek.game.DK_Game;
import eu.pedu.adv17s_fw.game_txt.IGSMFactory;
import eu.pedu.adv17s_fw.game_txt.IGame;
import eu.pedu.adv17s_fw.game_txt.IUI;
import java.util.Scanner;


/**
 *
 * @author vladi
 */
public class UIB_Scanner 
            implements IUI
{
    @Override
    public IGame getGame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void startGame(IGame game) {
        Scanner scanner = new Scanner(System.in);
        String command;
        String answer = game.executeCommand("");
        System.out.println(answer);
        do {
        command = scanner.nextLine();
        answer = game.executeCommand(command);
        System.out.println(answer);
        } while (game.isAlive());
    }
    
    @Override
    public void startGame() {
        startGame(DK_Game.getInstance());
    }

    @Override
    public Class<? extends IGSMFactory> getFactoryClass() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getAuthorName() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getAuthorID() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    
}
