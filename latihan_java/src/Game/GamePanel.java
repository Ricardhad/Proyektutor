/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Creature.Ammo;
import Creature.Chaser;
import Creature.Enemy;
import Creature.Entity;
import Creature.Fruit;
import Creature.Player;
import Creature.Portal;
import Tile.TileManager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Timer;
import java.util.TimerTask;
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

    public Color currentColor = Color.RED;
    
    //World map
    public final int maxWorldCol = 30;
    public final int maxWorldRow = 30;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;

    //fps
    int FPS = 60;

    TileManager tilem = new TileManager(this);

    KeyHandler keyh = new KeyHandler();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);

    public Player user = new Player(this, keyh);
    // array enemy
    public Entity enemy[] = new Enemy[10];
    public Entity chaser[] = new Chaser[10];
    public Entity ammo[] = new Entity[10];
    public Entity fruit[] = new Entity[10];
    public Entity portal[] = new Entity[10];


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyh);
        this.setFocusable(true);

        //lokasi enemy
        enemy[0] = new Enemy(this);
        enemy[0].worldX = tileSize * 12;
        enemy[0].worldY = tileSize * 6;

        enemy[1] = new Enemy(this);
        enemy[1].worldX = tileSize * 8;
        enemy[1].worldY = tileSize * 8;
        
        
        //chaser[0] = new Chaser(this);
        //chaser[0].worldX = tileSize * 7;
        //chaser[0].worldY = tileSize * 27;
        
        //lokasi shooter ammo
        ammo[0] = new Ammo(this);
        ammo[0].worldX = tileSize * 11;
        ammo[0].worldY = tileSize * 16;

        ammo[1] = new Ammo(this);
        ammo[1].worldX = tileSize * 11;
        ammo[1].worldY = tileSize * 18;
        
        //lokasi buah
        fruit[0] = new Fruit(this);
        fruit[0].worldX = tileSize * 3;
        fruit[0].worldY = tileSize * 19;
        fruit[1] = new Fruit(this);
        fruit[1].worldX = tileSize * 7;
        fruit[1].worldY = tileSize * 8;
        fruit[2] = new Fruit(this);
        fruit[2].worldX = tileSize * 16;
        fruit[2].worldY = tileSize * 14;
        
        //lokasi portal
        portal[0] = new Portal(this);
        portal[0].worldX = tileSize * 20;
        portal[0].worldY = tileSize * 2;

        

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
        int y = 29;// player sakarang
        int ctr = 0;
        while (gameThread != null) {
            ctr ++; // ctr lava
          
            // update user
            update();

            //update_enemy jangan lupa ini juga dipanggil
            enemy[0].update();// ini yang enemy
            enemy[1].update();
           // chaser[0].update_loc(user.direction, user.worldX, user.worldY);

            ammo[0].update();
            ammo[1].update();
            
            fruit[0].update();
            fruit[1].update();
            fruit[2].update();
            
            portal[0].update();
            tilem.changeMapTileNum(y,6);
            if(y != 29){
                  tilem.changeMapTileNum(y+1,7);
            }
            if(ctr == 300){
                 y--;
                if(y<=0) y=0;
                ctr = 0;
            }
           

            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
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

        tilem.draw(g2);

        // draw enemy
        enemy[0].draw(g2);
        enemy[1].draw(g2);

        ammo[1].draw(g2);
        ammo[0].draw(g2);
        
       // chaser[0].draw(g2);
        
        fruit[0].draw(g2);
        fruit[1].draw(g2);
        fruit[2].draw(g2);
        
        portal[0].draw(g2);
        user.draw(g2);

        g2.dispose();
    }

}
