/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Creature.Entity;
import Creature.Player;
import Objects.SuperObject;

/**
 *
 * @author Reynaldy
 */
public class CollisionChecker {

    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }

    public void checkTile(Entity et) {
        int entLeftWorldX = et.worldX + et.solidArea.x;
        int entRightWorldX = et.worldX + et.solidArea.x + et.solidArea.width;
        int entTopWorldY = et.worldY + et.solidArea.y;
        int entBottomtWorldY = et.worldY + et.solidArea.y + et.solidArea.height;

        int entitiyLeftCol = entLeftWorldX / gp.tileSize;
        int entitiyRightCol = entRightWorldX / gp.tileSize;
        int entitiyTopRow = entTopWorldY / gp.tileSize;
        int entitiyBottomRow = entBottomtWorldY / gp.tileSize;

        int tileNum1, tileNum2;

        switch (et.direction) {
            case "up":
                entitiyTopRow = (entTopWorldY - et.speed) / gp.tileSize;
                tileNum1 = gp.tilem.mapTileNum[gp.currentmap][entitiyLeftCol][entitiyTopRow];
                tileNum2 = gp.tilem.mapTileNum[gp.currentmap][entitiyRightCol][entitiyTopRow];
                if (gp.tilem.tile[tileNum1].collision == true || gp.tilem.tile[tileNum2].collision == true) {
                    et.collisionOn = true;
                }

                break;
            case "down":
                entitiyBottomRow = (entBottomtWorldY + et.speed) / gp.tileSize;
                tileNum1 = gp.tilem.mapTileNum[gp.currentmap][entitiyLeftCol][entitiyBottomRow];
                tileNum2 = gp.tilem.mapTileNum[gp.currentmap][entitiyRightCol][entitiyBottomRow];
                if (gp.tilem.tile[tileNum1].collision == true || gp.tilem.tile[tileNum2].collision == true) {
                    et.collisionOn = true;
                }
                break;
            case "left":
                entitiyLeftCol = (entLeftWorldX - et.speed) / gp.tileSize;
                tileNum1 = gp.tilem.mapTileNum[gp.currentmap][entitiyLeftCol][entitiyTopRow];
                tileNum2 = gp.tilem.mapTileNum[gp.currentmap][entitiyLeftCol][entitiyBottomRow];
                if (gp.tilem.tile[tileNum1].collision == true || gp.tilem.tile[tileNum2].collision == true) {
                    et.collisionOn = true;
                }
                break;
            case "right":
                entitiyRightCol = (entRightWorldX + et.speed) / gp.tileSize;
                tileNum1 = gp.tilem.mapTileNum[gp.currentmap][entitiyRightCol][entitiyTopRow];
                tileNum2 = gp.tilem.mapTileNum[gp.currentmap][entitiyRightCol][entitiyBottomRow];
                if (gp.tilem.tile[tileNum1].collision == true || gp.tilem.tile[tileNum2].collision == true) {
                    et.collisionOn = true;
                }
                break;
        }

    }

    public int checkObject(Entity entity, boolean player) {
        int index = 999;
        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                gp.obj[i].solidArea.x = gp.obj[i].worldX + gp.obj[i].solidArea.x;
                gp.obj[i].solidArea.y = gp.obj[i].worldY + gp.obj[i].solidArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {

                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.obj[i].solidArea)) {
                            if (gp.obj[i].collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                            break;

                        }

                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.obj[i].solidArea.x = gp.obj[i].solidAreaDefaultX;
                gp.obj[i].solidArea.y = gp.obj[i].solidAreaDefaultY;

            }

        }
        return index;
    }

}
