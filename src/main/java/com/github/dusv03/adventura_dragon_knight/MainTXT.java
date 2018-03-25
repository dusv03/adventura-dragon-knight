/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.pedu.adv17s._4_1100.dusv03_dusek;

import eu.pedu.adv17s._4_1100.dusv03_dusek.textui.UIA_JOptionPane;
import eu.pedu.adv17s._4_1100.dusv03_dusek.textui.UIB_Scanner;
import eu.pedu.adv17s_fw.game_txt.IUI;

/**
 *
 * @author vladi
 */
public class MainTXT 
{
    public static void main(String[] args) {
        IUI ui;
        ui = new UIA_JOptionPane();
//        ui = new UIB_Scanner();
        ui.startGame();
        
    }
    
    /** Soukromý konstruktor zabraňující vytvoření instance. */
    private MainTXT() {}
}
