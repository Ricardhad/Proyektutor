/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Game.GamePanel;
import Game.utilitytool;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Reynaldy
 */
public class Enemy extends Entity{
    public Enemy(GamePanel gp){
        super(gp);
        direction = "left";
        speed = 2;
        spriteNum = 1;
        
        getPlayerImage();
    }
    
        public void getPlayerImage() {
            try {
              left1 =  setup("tomb_ghost_left");
              right1 =   setup("tomb_ghost_right");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        public void update(){
          
   
            collisionOn = false;
            gp.cChecker.checkTile(this);
            
            if(collisionOn){
                
            //worldX = gp.tileSize*10;//buat ammmo            
                if(direction == "left") {direction = "right"; }//buat enemy kemana - kemana gitu
                else direction = "left";
            }
           
            
            if(collisionOn == false){
                switch(direction){
                    case "left" : worldX-= speed;  break;
                    case "right" : worldX += speed;  break;
                }
                        
            }
        }
           public BufferedImage setup(String imagename) {
        utilitytool uTool = new utilitytool();
        BufferedImage image = null;
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/" + imagename + ".png"));
            image = uTool.scaledimage(image, gp.tileSize, gp.tileSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
        public void draw(Graphics2D g2){
           BufferedImage image = null;
            int screenX = worldX - gp.user.worldX + gp.user.screenX;
            int screenY = worldY - gp.user.worldY + gp.user.screenY;
            
            if(worldX + gp.tileSize>gp.user.worldX - gp.user.screenX &&
               worldX - gp.tileSize<gp.user.worldX + gp.user.screenX &&
               worldY + gp.tileSize>gp.user.worldY - gp.user.screenY &&
               worldY - gp.tileSize<gp.user.worldY + gp.user.screenY ){
                
                 switch (direction) {
                 
                    case "left":
                        if (spriteNum == 1) {
                            image = left1;

                        }
                        if (spriteNum == 2) {
                            image = left2;
                        }
                        break;
                    case "right":
                        if (spriteNum == 1) {
                            image = right1;
                        }
                        if (spriteNum == 2) {
                            image = right2;
                        }
                        break;
                }
                
                g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
    }
}
