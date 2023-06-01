/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sprite;

import Game.GamePanel;// Game itu berasal dari pakage Game nya
import Game.KeyHandler;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Reynaldy
 */
public class Player extends Entity {

    GamePanel gp;
    KeyHandler keyh;

    public final int screenX;
    public final int screenY;

    public Player(GamePanel gp, KeyHandler keyh) {
        this.gp = gp;
        this.keyh = keyh;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle(8, 16, 32, 32);

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 23;//lokasi players
        worldY = gp.tileSize * 21;
        speed = 20;
        direction = "down";
    }

    public void getPlayerImage() {
        try {
            up1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_down_2.png"));
            left1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_left_2.png"));
            right1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));
//            idle1 = ImageIO.read(getClass().getResourceAsStream("/player/boy_right_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    boolean isMoving = false;

    public void update() {
        if (keyh.up == true || keyh.down == true || keyh.left == true || keyh.right == true) {//ini guna nya supaya sprite nya tidak ganti setiap detik,dan figanti ketika menekan wasd nya
//            if (!isMoving) { 
            if (keyh.up) {
                direction = "up";
            } else if (keyh.down) {
                direction = "down";
            } else if (keyh.left) {
                direction = "left";
            } else if (keyh.right) {
                direction = "right";
            }
            isMoving = true;
//            }

            // cek collision
            collisionOn = false;
            gp.cChecker.checkTile(this);
            isMoving = false;
            if (collisionOn == false) {

                switch (direction) {
                    case "up":
                        worldY -= speed;
                        break;
                    case "down":
                        worldY += speed;
                        break;
                    case "left":
                        worldX -= speed;
                        break;
                    case "right":
                        worldX += speed;
                        break;
                }

            } else {
//            speed=0;
//                keyh.down = false;
//                keyh.up = false;
//                keyh.left = false;
//                keyh.right = false;
                isMoving = false;
            }

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

    public void draw(Graphics2D g2) {

        // g2.setColor(Color.pink);
        // g2.fillRect(x, y, gp.tileSize, gp.tileSize); 
        // ini yang kotak hijau
        BufferedImage image = null;
        if (keyh.up == false && keyh.down == false && keyh.left == false && keyh.right == false) {
             switch (direction) {
                case "up":
                    if (spriteNum == 1) {
                        image = down1;

                    }
                    if (spriteNum == 2) {
                        image = down2;
                    }
                    break;
                case "down":
                    if (spriteNum == 1) {
                        image = up1;
                    }
                    if (spriteNum == 2) {
                        image = up2;
                    }
                    break;
                case "left":
                    if (spriteNum == 1) {
                        image = right1;

                    }
                    if (spriteNum == 2) {
                        image = right2;
                    }
                    break;
                case "right":
                    if (spriteNum == 1) {
                        image = left1;
                    }
                    if (spriteNum == 2) {
                        image = left2;
                    }
                    break;
            }
        } else {
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
        }
        g2.drawImage(image, screenX, screenY, gp.tileSize, gp.tileSize, null);
    }
}
