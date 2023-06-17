/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Objects.OBJ_Ammo;
import Objects.OBJ_Fruit;
import Objects.OBJ_Portal;

/**
 *
 * @author Reynaldy
 */
public class AssetSetter {
    GamePanel gp;
    public AssetSetter(GamePanel gp){
        this.gp=gp;
    }
    public void setObject(){
        
        gp.obj[0] = new OBJ_Fruit();
        gp.obj[0].worldX = gp.tileSize * 3;
        gp.obj[0].worldY = gp.tileSize * 19;
        
        gp.obj[1] = new OBJ_Fruit();
        gp.obj[1].worldX = gp.tileSize * 7;
        gp.obj[1].worldY = gp.tileSize * 8;
        
        gp.obj[2] = new OBJ_Fruit();
        gp.obj[2].worldX = gp.tileSize * 16;
        gp.obj[2].worldY = gp.tileSize * 14;
        
        gp.obj[3] = new OBJ_Portal();
        gp.obj[3].worldX = gp.tileSize * 20;
        gp.obj[3].worldY = gp.tileSize * 2;
        
//        gp.obj[4] = new OBJ_Ammo();
//        gp.obj[4].worldX = gp.tileSize * 11;
//        gp.obj[4].worldY = gp.tileSize * 16;
//        
//        gp.obj[5] = new OBJ_Ammo();
//        gp.obj[5].worldX = gp.tileSize * 11;
//        gp.obj[5].worldY = gp.tileSize * 18;
        
        
 

    }
}
