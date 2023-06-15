/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Game.GamePanel;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Reynaldy
 */
public class Portal extends Entity{
    public Portal(GamePanel gp) {
        super(gp);
        direction = "down";
        speed = 2;
        spriteNum = 1;

        getPlayerImage();
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_portal0.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_portal1.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_portal2.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_portal0.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        collisionOn = false;
        gp.cChecker.checkTile(this);

        if (collisionOn) {

            worldX = gp.tileSize * 10; //buat ammmo

//                if(direction == "left") {direction = "right"; }//buat enemy kemana - kemana gitu
//                else direction = "left";
        }

        if (collisionOn == false) {
            switch (direction) {
                case "left":
                    worldX -= speed;
                    break;
                case "right":
                    worldX += speed;
                    break;
            }
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
            System.out.println("test");
            switch (direction) {
                case "down":
                    if (spriteNum == 1) {
                        image = down1;
                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    if (spriteNum == 3) {
                        image = up1;
                    }
                    if (spriteNum == 4) {
                        image = up2;
                    }
                    break;
                
            }

            g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
        }
    }
}
