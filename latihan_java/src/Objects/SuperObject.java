/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import Creature.Entity;
import Game.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Reynaldy
 */
public class SuperObject {
    public BufferedImage image,satu,dua,tiga,empat,kiri,kanan;
    public String name;
    public boolean collision = false;
    public int worldX,worldY;
    public Rectangle solidArea = new Rectangle(0,0,48,48);
    public int solidAreaDefaultX=0;
    public int solidAreaDefaultY=0;
    
    public int  spriteCounter = 0;
    public int spriteNum=1;
    public boolean collisionOn = false;
    public String direction;
    
    public void draw(Graphics2D g2,GamePanel gp){
            int screenX = worldX - gp.user.worldX + gp.user.screenX;
            int screenY = worldY - gp.user.worldY + gp.user.screenY;
            
            
            
            
            if(worldX + gp.tileSize>gp.user.worldX - gp.user.screenX &&
               worldX - gp.tileSize<gp.user.worldX + gp.user.screenX &&
               worldY + gp.tileSize>gp.user.worldY - gp.user.screenY &&
               worldY - gp.tileSize<gp.user.worldY + gp.user.screenY ){
                spriteCounter++;// ganti frame sprite nya
            if (spriteCounter > 10) {// per detik
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 3;
                }else if (spriteNum == 3) {
                    spriteNum = 4;
                }else if (spriteNum == 4) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
            if(spriteNum==1){
               g2.drawImage(satu, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            if(spriteNum==2){
               g2.drawImage(dua, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            if(spriteNum==3){
               g2.drawImage(tiga, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            if(spriteNum==4){
               g2.drawImage(empat, screenX, screenY, gp.tileSize, gp.tileSize, null);
            }
            }
    }
}
