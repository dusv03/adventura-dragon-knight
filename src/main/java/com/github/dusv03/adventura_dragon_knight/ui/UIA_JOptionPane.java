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
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author vladi
 */
public class UIA_JOptionPane 
            implements IUI
{
    @Override
    public IGame getGame() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void startGame(IGame game) {
        Component parent = new JFrame();
        parent.setLocation(100, 100);
        parent.setVisible(true);
        String command;
        String answer = game.executeCommand("");
        do {
            command = JOptionPane.showInputDialog(parent, answer);
            answer = game.executeCommand(command);
        } while (game.isAlive());
        JOptionPane.showMessageDialog(parent, answer);
        System.exit(0);
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
