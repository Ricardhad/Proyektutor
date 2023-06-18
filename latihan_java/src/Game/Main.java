/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.sound.sampled.*;


/**
 *
 * @author Reynaldy
 */


public class Main {
    
    
    public static void main(String[] args) {
         JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setResizable(true);
        jf.setTitle("Tomb Escape");
        
        GamePanel gamepanel= new GamePanel();
        jf.add(gamepanel);
        
        jf.pack();
        
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
        
        gamepanel.setupGame();
        gamepanel.startGamethread();
    }
    
    
}
