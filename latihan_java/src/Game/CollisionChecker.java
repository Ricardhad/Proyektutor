/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Sprite.Entity;

/**
 *
 * @author Reynaldy
 */
public class CollisionChecker {
    GamePanel gp;
    public CollisionChecker(GamePanel gp){
        this.gp = gp;
    }
    
    public void checkTile(Entity et){
        int entLeftWorldX = et.worldX + et.solidArea.x;
        int entRightWorldX = et.worldX + et.solidArea.x + et.solidArea.width;
        int entTopWorldY = et.worldY + et.solidArea.y;
        int entBottomtWorldY = et.worldY + et.solidArea.y + et.solidArea.height;
     
        
        int entitiyLeftCol = entLeftWorldX / gp.tileSize;
        int entitiyRightCol = entRightWorldX/gp.tileSize;
        int entitiyTopRow = entTopWorldY/gp.tileSize;
        int entitiyBottomRow = entBottomtWorldY/gp.tileSize;
        
        int tileNum1, tileNum2;
        
        switch(et.direction){
            case "up" :
                entitiyTopRow = (entTopWorldY - et.speed)/ gp.tileSize;
                tileNum1 = gp.tilem.mapTileNum[entitiyLeftCol][entitiyTopRow];
                tileNum2 = gp.tilem.mapTileNum[entitiyRightCol][entitiyTopRow];
                if(gp.tilem.tile[tileNum1].collision == true || gp.tilem.tile[tileNum2].collision == true ){
                    et.collisionOn = true;
                }

                break;
            case "down" :
                entitiyBottomRow = (entBottomtWorldY +et.speed)/ gp.tileSize;
                tileNum1 = gp.tilem.mapTileNum[entitiyLeftCol][entitiyBottomRow];
                tileNum2 = gp.tilem.mapTileNum[entitiyRightCol][entitiyBottomRow];
                if(gp.tilem.tile[tileNum1].collision == true || gp.tilem.tile[tileNum2].collision == true ){
                    et.collisionOn = true;
                }
                break;
            case "left" :
                entitiyLeftCol = (entLeftWorldX - et.speed)/ gp.tileSize;
                tileNum1 = gp.tilem.mapTileNum[entitiyLeftCol][entitiyTopRow];
                tileNum2 = gp.tilem.mapTileNum[entitiyLeftCol][entitiyBottomRow];
                if(gp.tilem.tile[tileNum1].collision == true || gp.tilem.tile[tileNum2].collision == true ){
                    et.collisionOn = true;
                }
                break;
            case "right" :
                entitiyRightCol = (entRightWorldX + et.speed)/ gp.tileSize;
                tileNum1 = gp.tilem.mapTileNum[entitiyRightCol][entitiyTopRow];
                tileNum2 = gp.tilem.mapTileNum[entitiyRightCol][entitiyBottomRow];
                if(gp.tilem.tile[tileNum1].collision == true || gp.tilem.tile[tileNum2].collision == true ){
                    et.collisionOn = true;
                }
                break;
        }
        

    }
}
