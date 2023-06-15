/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.text.DecimalFormat;

/**
 *
 * @author Billy
 */
public class UI {

    Graphics2D g2;
    GamePanel gp;
    Font arial_40, arial_80b;
    public boolean messageOn = false;
    public String message = "";
    int messageCounter = 0;
    public boolean gameFinished = false;
    double playTime = 0;
    DecimalFormat DFormat = new DecimalFormat("#0.00");

    public UI(GamePanel gp) {
        this.gp = gp;
        arial_40 = new Font("Arial", Font.PLAIN, 40);
        arial_80b = new Font("Arial", Font.BOLD, 80);
    }

    public void showMessage(String text) {
        message = text;
        messageOn = true;
    }

    public void draw(Graphics2D g2) {
        this.g2 = g2;
        g2.setFont(arial_40);
        g2.setColor(Color.white);
        if (gp.gameState==gp.playState) {
            
        }
        if (gp.gameState==gp.pausedState) {
            
        }
    }
    public void drawPausedScreen(){
        String text="paused";
        int x=centerMessage(text),y=gp.screenHeight;
       
        g2.drawString(text, x, y);
    }
    public int centerMessage(String text){
     int length=(int)g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x= gp.screenWidth/2- length/2;
        return x;
    }
}
