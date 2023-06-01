/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

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
    public final int maxWorldCol=50;
    public final int maxWorldRow=50;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    
    
    //fps
    int FPS = 60;

    TileManager tilem=new TileManager(this);
    KeyHandler keyh = new KeyHandler();
    Thread gameThread;
    public CollisionChecker cChecker = new CollisionChecker(this);
    public Player user = new Player(this,keyh);

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyh);
        this.setFocusable(true);

    }

    public void startGamethread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while (gameThread != null) {

            update();

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
        
        tilem.draw(g2);
        
        user.draw(g2);
        g2.dispose();
    }

}
