/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Objects.OBJ_Fruit;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Billy
 */
public class UI {
    GamePanel gp;
    Graphics2D g2;
    Font arial_40;
    BufferedImage keyImage;
    
    public UI(GamePanel gp){
        this.gp = gp;
        
        arial_40 = new Font("Arial",Font.PLAIN,40);
        OBJ_Fruit Fruit = new OBJ_Fruit();
        keyImage = Fruit.satu;
    }
    
    public void draw(Graphics2D g2){
        this.g2=g2;
        g2.setFont(arial_40);
        g2.setColor(Color.yellow);
      g2.drawImage(keyImage, gp.tileSize/2, gp.tileSize/2,gp.tileSize,gp.tileSize,null);
       g2.drawString("x  "+gp.user.hasKey,95,55);
        if(gp.gameState==gp.playState){
            
        }
        if(gp.gameState==gp.pauseState){
            
        }

    }
    
//    public void drawPauseScreen(){
//        String text = "PAUSED";
//        int x;
//        int length = (int)g2.getFontMatrics().getStringBounds(text,g2).getWidth();
//    }
    
   
}
