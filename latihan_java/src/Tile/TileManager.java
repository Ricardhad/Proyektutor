/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tile;

import Game.GamePanel;
import Game.utilitytool;
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
    public Tile[] tile;
    public int mapTileNum[][];

    public TileManager(GamePanel gp) {
        this.gp = gp;
        tile = new Tile[10];//banyak sprite
        mapTileNum = new int[gp.maxWorldCol][gp.maxWorldRow];
        getTileImage();

        loadmap();
    }

    public void getTileImage() {
        try {
            setup(0, "black", false);
            setup(1, "tomb_wall", true);
            setup(2, "tomb_spike", true);
            setup(3, "tomb_portal0", true);
            setup(4, "tomb_cannon_left", true);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setup(int index, String imagePath, boolean collision) {
        utilitytool uTool = new utilitytool();
        try {
            tile[index] = new Tile();
            tile[index].image = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/" + imagePath+".png"));
                tile[index].image = uTool.scaledimage(tile[index].image, gp.tileSize, gp.tileSize);
            tile[index].collision = collision;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadmap() {
        try {
            InputStream is = getClass().getResourceAsStream("/Maps/peta2.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int row = 0;

            while (col < gp.maxWorldCol && row < gp.maxWorldRow) {
                String line = br.readLine();

                while (col < gp.maxWorldCol) {

                    String numbers[] = line.split(" ");

                    int num = Integer.parseInt(numbers[col]);

                    mapTileNum[col][row] = num;
                    col++;

                }
                if (col == gp.maxWorldCol) {
                    col = 0;
                    row++;

                }
            }
            br.close();
        } catch (Exception e) {

        }
    }

    public void draw(Graphics2D g2) {
        getTileImage();
        int worldCol = 0;
        int worldRow = 0;

        while (worldCol < gp.maxWorldCol && worldRow < gp.maxWorldRow) {

            int tileNum = mapTileNum[worldCol][worldRow];

            int worldX = worldCol * gp.tileSize;
            int worldY = worldRow * gp.tileSize;
            int screenX = worldX - gp.user.worldX + gp.user.screenX;
            int screenY = worldY - gp.user.worldY + gp.user.screenY;

            if (worldX + gp.tileSize > gp.user.worldX - gp.user.screenX
                    && worldX - gp.tileSize < gp.user.worldX + gp.user.screenX
                    && worldY + gp.tileSize > gp.user.worldY - gp.user.screenY
                    && worldY - gp.tileSize < gp.user.worldY + gp.user.screenY) {
                g2.drawImage(tile[tileNum].image, screenX, screenY, null);
            }

            worldCol++;

            if (worldCol == gp.maxWorldCol) {
                worldCol = 0;

                worldRow++;

            }
        }

        //rey jangan lupa setiap kotak/1 pixel di map game nya itu 1 pixel =48 x dan y
    }
}
