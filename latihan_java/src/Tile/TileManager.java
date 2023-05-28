/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tile;

import Game.GamePanel;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import javax.imageio.ImageIO;

/**
 *
 * @author Reynaldy
 */
public class TileManager {

    GamePanel gp;
    Tile[] tile;
    int MapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;

        tile = new Tile[10];//banyak sprite
        MapTileNum = new int[gp.maxScreenCol][gp.maxScreenRow];
        getTileImage();
    }

    public void loadmap() {

        try {
            InputStream is = getClass().getResourceAsStream("/res/tomb_sprite/tomb_wall.png");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            int col = 0;
            int row = 0;
            while (col < gp.maxScreenCol && row < gp.maxScreenRow) {
                String line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void getTileImage() {
        try {
            tile[0] = new Tile();
            tile[0].image = ImageIO.read(getClass().getResourceAsStream("/res/tomb_sprite/tomb_wall.png"));// isi anchor sprite dalam array
            tile[1] = new Tile();
            tile[1].image = ImageIO.read(getClass().getResourceAsStream("/res/tomb_sprite/tomb_ghost_left.png"));
            tile[2] = new Tile();
            tile[2].image = ImageIO.read(getClass().getResourceAsStream("/res/tomb_sprite/tomb_spike.png"));
            tile[3] = new Tile();
            tile[3].image = ImageIO.read(getClass().getResourceAsStream("/res/tomb_sprite/tomb_cannon.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);//lokasi setiap sprite
        g2.drawImage(tile[1].image, 96, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[2].image, 192, 0, gp.tileSize, gp.tileSize, null);
        g2.drawImage(tile[3].image, 288, 0, gp.tileSize, gp.tileSize, null);

//        g2.drawImage(tile[0].image, 0, 0, gp.tileSize, gp.tileSize, null);
        //rey jagan lupa setiap kotak/1 pixel di map game nya tiu 1 pixel =48 x dan y
    }
}
