/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Game.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Reynaldy
 */
public class Chaser extends Entity {

    public Chaser(GamePanel gp) {
        super(gp);
        direction = "left";
        speed = 1;
        spriteNum = 1;
        solidArea= new Rectangle(0,0,20,20);
        getPlayerImage();
    }

    public void getPlayerImage() {
        try {
            up2 = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_sprite_spider0.png"));
            up1 = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_sprite_spider1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_sprite_spider1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_sprite_spider2.png"));
            
             left1 = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_sprite_spider1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_sprite_spider2.png"));
            
             right1 = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_sprite_spider1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_sprite_spider2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update_loc(String player_location, int x_player, int y_player) {

        collisionOn = false;
        gp.cChecker.checkTile(this);
       // direction = player_location;
        
        // left side
        if(x_player <= worldX && y_player == worldY){
            direction = "left";
            if(collisionOn == true){
                direction = "up";
            }
        }else
         if(x_player <= worldX && y_player >= worldY){
            direction = "down";
            if(collisionOn == true){
                direction = "right";
            }
        }else
         if(x_player <= worldX && y_player <= worldY){
            direction = "up";
             if(collisionOn == true){
                direction = "left";
            }
        }
         
        // right
        if(x_player >= worldX && y_player == worldY){
            direction = "right";
             if(collisionOn == true){
                direction = "down";
            }
        } else
         if(x_player >= worldX && y_player >= worldY){
            direction = "down";
             if(collisionOn == true){
                direction = "left";
            }
        }else
        
         if(x_player >= worldX && y_player <= worldY){
            direction = "up";
            if(collisionOn == true){
                direction = "right";
            }
        }
       

        if (collisionOn == false) {
            switch (direction) {
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
                 case "up":
                    worldY -= speed;
                    break;
                 case "down":
                    worldY += speed;
                    break;
            }
            
            spriteCounter++;// ganti frame sprite nya
        if (spriteCounter > 10) {// per detik
            if (spriteNum == 1) {
                spriteNum = 2;
            } else if (spriteNum == 2) {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

        }
    }

    public void draw(Graphics2D g2) {
        BufferedImage image = null;
        int screenX = worldX - gp.user.worldX + gp.user.screenX;
        int screenY = worldY - gp.user.worldY + gp.user.screenY;

        if (worldX + gp.tileSize > gp.user.worldX - gp.user.screenX
                && worldX - gp.tileSize < gp.user.worldX + gp.user.screenX
                && worldY + gp.tileSize > gp.user.worldY - gp.user.screenY
                && worldY - gp.tileSize < gp.user.worldY + gp.user.screenY) {

            switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    break;
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
