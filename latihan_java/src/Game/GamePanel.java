/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Creature.Ammo;

import Creature.Enemy;
import Creature.Entity;
import Creature.Player;

import Objects.SuperObject;
import Tile.Level1;
import Tile.Tilemanager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
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

    //public Color currentColor = Color.RED;
    
    //World map
    public final int maxWorldCol = 30;
    public final int maxWorldRow = 30;
    
    public final int maxMap=10;
    public int currentmap=0;
    

    //fps
    int FPS = 60;

    Tilemanager tilem = new Tilemanager(this);
    KeyHandler keyh = new KeyHandler();
    Sound sound = new Sound();
    public CollisionChecker cChecker = new CollisionChecker(this);
    public AssetSetter AssSett = new AssetSetter(this);
    public UI ui = new UI(this);
    Thread gameThread;
    
    //entity dan player
    //inheritance
    public Player user = new Player(this, keyh);
    //public SuperObject obj[] = new SuperObject[10];
    public ArrayList <SuperObject> obj = new ArrayList<>();
    // array enemy
    //polymorph
    public Entity enemy[] = new Enemy[10];
    public Entity ammo[] = new Ammo[10];
    
    //game state
    public int gameState;
    public final int titleState = 0;
    public final int playState=1;
    public final int pauseState = 2;
    public final int dialogueState = 3;
    
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
        
        //lokasi shooter ammo
        ammo[0] = new Ammo(this);
        ammo[0].worldX = tileSize * 11;
        ammo[0].worldY = tileSize * 16;

        ammo[1] = new Ammo(this);
        ammo[1].worldX = tileSize * 11;
        ammo[1].worldY = tileSize * 18;
//        

    }
    
    public void setupGame(){
        AssSett.setObject();
        
        playMusic(0);
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
           // ctr ++; // ctr lava
          
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
                remainingTime = remainingTime / 1000000;

                if (remainingTime < 0) {
                    remainingTime = 0;
                }

                Thread.sleep((long) remainingTime);

                nextDrawTime += drawInterval;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            
            if(user.finish == true){
                 ctr ++; 
            }
            
            if(ctr == 100){
                gameThread = null;
                stopMusic();       
            }
        }
    }

    public void update() {
        user.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        
//        if(gameState == titleState){
//            
//        }
        //others

        tilem.draw(g2);

        // draw enemy
        enemy[0].draw(g2);
        enemy[1].draw(g2);
        ammo[1].draw(g2);
        ammo[0].draw(g2);


        for (int i = 0; i < obj.size(); i++) {
            if(obj.get(i)!=null){
               obj.get(i).draw(g2, this);
            }
        }
        
        user.draw(g2);
        
        //UI
        ui.draw(g2);

        g2.dispose();
    }
    
    public void playMusic(int i){
        sound.setFile(i);
        sound.play();
        sound.loop();   
    }
    public void stopMusic(){
        sound.stop();
    }
    public void playSE(int i){
        sound.setFile(i);
        sound.play();
    }

}
