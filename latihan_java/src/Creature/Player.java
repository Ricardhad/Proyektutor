/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Game.GamePanel;// Game itu berasal dari pakage Game nya
import Game.KeyHandler;
import Game.utilitytool;
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

    KeyHandler keyh;

    public final int screenX;
    public final int screenY;
    public int hasKey=0;

    public Player(GamePanel gp, KeyHandler keyh) {
        super(gp);

        this.keyh = keyh;

        screenX = gp.screenWidth / 2 - (gp.tileSize / 2);
        screenY = gp.screenHeight / 2 - (gp.tileSize / 2);

        solidArea = new Rectangle(8, 16, 32, 38);//8,16,32,32
        solidAreaDefaultX=solidArea.x;
        solidAreaDefaultX=solidArea.y;
        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues() {
        worldX = gp.tileSize * 5;//lokasi players
        worldY = gp.tileSize * 27;
        speed = 10;//5
        direction = "idledown";
    }

    public void getPlayerImage() {
        try {
            up1 = setup("tomb_char_move_up0");
            up2 = setup("tomb_char_move_up1");
            down1 = setup("tomb_char_move_down0");
            down2 = setup("tomb_char_move_down1");
            left1 = setup("tomb_char_move_left0");
            left2 = setup("tomb_char_move_left1");
            right1 = setup("tomb_char_move_right0");
            right2 = setup("tomb_char_move_right1");
            idleup1 = setup("tomb_char_up0");
            idleup2 = setup("tomb_char_up1");
            idleleft1 = setup("tomb_char_left0");
            idleleft2 = setup("tomb_char_left1");
            idleright1 = setup("tomb_char_right0");
            idleright2 = setup("tomb_char_right1");
            idledown1 = setup("tomb_char_down0");
            idledown2 = setup("tomb_char_down1");

        } catch (Exception e) {
            e.printStackTrace();
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

        boolean isMoving = false;
    public void update() {
        if (keyh.map1==true) {
            gp.currentmap=0;
        }
        if (keyh.map2==true) {
            gp.currentmap=1;
        }
        if (keyh.map3==true) {
            gp.currentmap=2;
        }
        if (keyh.up == true || keyh.down == true || keyh.left == true || keyh.right == true) {//ini guna nya supaya sprite nya tidak ganti setiap detik,dan figanti ketika menekan wasd nya
            if (!isMoving) { // Only change direction if not already moving
            isMoving = true;
                if (keyh.up) {
                    direction = "up";
                } else if (keyh.down) {
                    direction = "down";
                } else if (keyh.left) {
                    direction = "left";
                } else if (keyh.right) {
                    direction = "right";
                }
            }
        } else {
            switch (direction) {
                case "up":
                    direction="idleup";
                    break;
                case "down":
                    direction="idledown";
                    break;
                case "left":
                    direction="idleleft";
                    break;
                case "right":
                    direction="idleright";
                    break;
            }
            isMoving = false;
        }

        // cek collision
        collisionOn = false;
        gp.cChecker.checkTile(this);
        
        //cek object
        int objIndex = gp.cChecker.checkObject(this, true);
        pickUpObject(objIndex);
        
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
                keyh.down = false;
            keyh.up = false;
            keyh.left = false;
            keyh.right = false;
            isMoving = false;
        
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
    public void pickUpObject(int i){
        if(i!=999){
            String objectName = gp.obj[i].name;
            switch(objectName){
                case "Fruit":
                    gp.playSE(1);
                    hasKey++;
                    gp.obj[i]=null;
                    System.out.println("Key: "+hasKey);
                    break;
                case "Portal":
                    gp.playSE(3);
                    if(hasKey>=3){
                        gp.obj[i]=null;
                        hasKey-=3;
                    }
                    System.out.println("Key: "+hasKey);
                    break;
            }
        }
    }

    public void draw(Graphics2D g2) {

        //g2.setColor(Color.pink);
        //g2.fillRect(screenX, screenY, gp.tileSize, gp.tileSize); 
        // ini yang kotak hijau
        BufferedImage image = null;
        if (keyh.up == false && keyh.down == false && keyh.left == false && keyh.right == false) {
            switch (direction) {
                case "idleup":
                    if (spriteNum == 1) {
                        image = idleleft1;
                    }
                    if (spriteNum == 2) {
                        image = idleleft2;
                    }
                    break;
                case "idledown":
                    if (spriteNum == 1) {
                        image = idleright1;
                    }
                    if (spriteNum == 2) {
                        image = idleright2;
                    }
                    break;
                case "idleleft":
                    if (spriteNum == 1) {
                        image = idledown1;
                    }
                    if (spriteNum == 2) {
                        image = idledown2;
                    }
                    break;
                case "idleright":
                    if (spriteNum == 1) {
                        image = idleup1;
                    }
                    if (spriteNum == 2) {
                        image = idleup2;
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

        g2.drawImage(image, screenX, screenY, null);
    }
}
