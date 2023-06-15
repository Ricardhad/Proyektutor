/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Sprite.Ammo;
import Sprite.Enemy;
import Sprite.Entity;
import Sprite.Player;
import Tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author Reynaldy
 */
public class GamePanel extends JPanel implements Runnable {

    final int originalTileSize = 16;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;//harus di ubah public supaya bisa mengakses packages Sprite
    public final int maxScreenCol = 32; // ratio 8
    public final int maxScreenRow = 16; // ratio 4
    public final int screenWidth = tileSize * maxScreenCol;// rumus width 48*32=1536
    public final int screenHeight = tileSize * maxScreenRow;//rumus height 48*16=768
    
    //World map
    public final int maxWorldCol=30;
    public final int maxWorldRow=30;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    
    
    //fps
    int FPS = 60;

    TileManager tilem=new TileManager(this);
    
    KeyHandler keyh = new KeyHandler();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);

    public Player user = new Player(this,keyh);
    // array enemy
    public Entity enemy[] = new Entity[10];
    public Entity ammo[] = new Entity[10];
  
    public int gameState;
    public final int playState=1;
    public final int pausedState=2;
  

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyh);
        this.setFocusable(true);
        
        
        //lokasi enemy
        enemy[0] = new Enemy(this);
        enemy[0].worldX = tileSize*12;
        enemy[0].worldY = tileSize*6;
        
        enemy[1] = new Enemy(this);
        enemy[1].worldX = tileSize*8;
        enemy[1].worldY = tileSize*8;
        
        ammo[0] = new Ammo(this);
        ammo[0].worldX = tileSize*11;
        ammo[0].worldY = tileSize*16;
        
        ammo[1] = new Ammo(this);
        ammo[1].worldX = tileSize*11;
        ammo[1].worldY = tileSize*18;
      
    }

    public void startGamethread() {
        gameThread = new Thread(this);
        // inisialisasi & lokasi
        gameThread.start();
    }

    @Override
    public void run() {
       
        
        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
       
        while (gameThread != null) {
 
            // update user
            update();
            
            //update_enemy jangan lupa ini juga dipanggil
            enemy[0].update();// ini yang enemy
            enemy[1].update();
            
            ammo[0].update();
            ammo[1].update();
            
            repaint();
            
            
            try {
            double remainingTime = nextDrawTime - System.nanoTime();
            remainingTime = remainingTime/1000000;
            
            if(remainingTime<0){
                remainingTime=0;
            }
            
            Thread.sleep((long) remainingTime);
            
            nextDrawTime += drawInterval;
            
            
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        user.update();
    }
    
 

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        
        //tilem.draw(g2);
        tilem.draw(g2);
        
        // draw enemy
        enemy[0].draw(g2);
        enemy[1].draw(g2);
        
        ammo[1].draw(g2);
        ammo[0].draw(g2);
        user.draw(g2);
        
        
        g2.dispose();
    }

}
