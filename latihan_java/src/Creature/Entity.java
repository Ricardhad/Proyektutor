/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Creature;

import Game.GamePanel;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Reynaldy
 */
public class Entity {

    GamePanel gp;
    public int worldX, worldY;
    public int speed;

    public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2,idle1,idle2;
    public String direction;
    
    public int  spriteCounter = 0;
    public int spriteNum=1;
    
    public Rectangle solidArea = new Rectangle(0,0,40,40); // solid Aarea merupakan rec -> x & y & width dan height
    public boolean collisionOn = false;
    
    public Entity(GamePanel gp){
        this.gp = gp;
    }
    
    public void draw(Graphics2D g2){}
    public void update(){}
    
   

    public void update_loc(String up, int x_player, int y_player) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
