/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import Creature.Entity;

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
                    if(gp.tilem.tile[tileNum1].trap == true && et.name.equals("player")){
                        // kembali untuk trap
                         et.worldX = gp.tileSize * 5;//lokasi players
                         et.worldY = gp.tileSize * 27;
                    }
                }

                break;
            case "down":
                entitiyBottomRow = (entBottomtWorldY + et.speed) / gp.tileSize;
                tileNum1 = gp.tilem.mapTileNum[gp.currentmap][entitiyLeftCol][entitiyBottomRow];
                tileNum2 = gp.tilem.mapTileNum[gp.currentmap][entitiyRightCol][entitiyBottomRow];
                if (gp.tilem.tile[tileNum1].collision == true || gp.tilem.tile[tileNum2].collision == true) {
                    et.collisionOn = true;
                     if(gp.tilem.tile[tileNum1].trap == true && et.name.equals("player")){
                         et.worldX = gp.tileSize * 5;//lokasi players
                         et.worldY = gp.tileSize * 27;
                    }
                }
                break;
            case "left":
                entitiyLeftCol = (entLeftWorldX - et.speed) / gp.tileSize;
                tileNum1 = gp.tilem.mapTileNum[gp.currentmap][entitiyLeftCol][entitiyTopRow];
                tileNum2 = gp.tilem.mapTileNum[gp.currentmap][entitiyLeftCol][entitiyBottomRow];
                if (gp.tilem.tile[tileNum1].collision == true || gp.tilem.tile[tileNum2].collision == true) {
                    et.collisionOn = true;
                     if(gp.tilem.tile[tileNum1].trap == true && et.name.equals("player")){
                         et.worldX = gp.tileSize * 5;//lokasi players
                         et.worldY = gp.tileSize * 27;
                    }
                }
                break;
            case "right":
                entitiyRightCol = (entRightWorldX + et.speed) / gp.tileSize;
                tileNum1 = gp.tilem.mapTileNum[gp.currentmap][entitiyRightCol][entitiyTopRow];
                tileNum2 = gp.tilem.mapTileNum[gp.currentmap][entitiyRightCol][entitiyBottomRow];
                if (gp.tilem.tile[tileNum1].collision == true || gp.tilem.tile[tileNum2].collision == true) {
                    et.collisionOn = true;
                     if(gp.tilem.tile[tileNum1].trap == true && et.name.equals("player")){
                         et.worldX = gp.tileSize * 5;//lokasi players
                         et.worldY = gp.tileSize * 27;
                    }
                }
                break;
        }

    }

    public int checkObject(Entity entity, boolean player) {
        int index = 999;
        for (int i = 0; i < gp.obj.size(); i++) {
            if (gp.obj.get(i) != null) {
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                gp.obj.get(i).solidArea.x = gp.obj.get(i).worldX + gp.obj.get(i).solidArea.x;
                gp.obj.get(i).solidArea.y = gp.obj.get(i).worldY + gp.obj.get(i).solidArea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj.get(i).solidArea)) {
                            if (gp.obj.get(i).collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gp.obj.get(i).solidArea)) {
                            if (gp.obj.get(i).collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.obj.get(i).solidArea)) {

                            if (gp.obj.get(i).collision == true) {
                                entity.collisionOn = true;
                            }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.obj.get(i).solidArea)) {
                            if (gp.obj.get(i).collision == true) {
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
                gp.obj.get(i).solidArea.x = gp.obj.get(i).solidAreaDefaultX;
                gp.obj.get(i).solidArea.y = gp.obj.get(i).solidAreaDefaultY;

            }

        }
        return index;
    }
    
    
      public int checkenemyectEne(Entity entity, boolean player) {
        int index = 999;
                        System.out.println("Masuk mas");

        for (int i = 0; i < gp.enemy.length; i++) {
            if (gp.enemy[i] != null) {
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                gp.enemy[i].solidArea.x = gp.enemy[i].worldX + gp.enemy[i].solidArea.x;
                gp.enemy[i].solidArea.y = gp.enemy[i].worldY + gp.enemy[i].solidArea.y;
                System.out.println("Masuk mas");
                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gp.enemy[i].solidArea)) {
                          //  if (gp.enemy[i].collisionOn == true) {
                                entity.collisionOn = true;
                           // }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gp.enemy[i].solidArea)) {
                           // if (gp.enemy[i].collisionOn == true) {
                                entity.collisionOn = true;
                            //}
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.enemy[i].solidArea)) {

                           // if (gp.enemy[i].collisionOn == true) {
                                entity.collisionOn = true;
                           // }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.enemy[i].solidArea)) {
                          //  if (gp.enemy[i].collisionOn == true) {
                               entity.collisionOn = true;
                           // }
                            if (player == true) {
                                index = i;
                            }
                            break;

                        }

                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.enemy[i].solidArea.x = gp.enemy[i].solidAreaDefaultX;
                gp.enemy[i].solidArea.y = gp.enemy[i].solidAreaDefaultY;

            }

        }
        
        for (int i = 0; i < gp.ammo.length; i++) {
            if (gp.ammo[i] != null) {
                entity.solidArea.x = entity.worldX + entity.solidArea.x;
                entity.solidArea.y = entity.worldY + entity.solidArea.y;

                gp.ammo[i].solidArea.x = gp.ammo[i].worldX + gp.ammo[i].solidArea.x;
                gp.ammo[i].solidArea.y = gp.ammo[i].worldY + gp.ammo[i].solidArea.y;
                System.out.println("Masuk mas");
                switch (entity.direction) {
                    case "up":
                        entity.solidArea.y -= entity.speed;
                        if (entity.solidArea.intersects(gp.ammo[i].solidArea)) {
                          //  if (gp.ammo[i].collisionOn == true) {
                                entity.collisionOn = true;
                           // }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "down":
                        entity.solidArea.y += entity.speed;
                        if (entity.solidArea.intersects(gp.ammo[i].solidArea)) {
                           // if (gp.ammo[i].collisionOn == true) {
                                entity.collisionOn = true;
                            //}
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "left":
                        entity.solidArea.x -= entity.speed;
                        if (entity.solidArea.intersects(gp.ammo[i].solidArea)) {

                           // if (gp.ammo[i].collisionOn == true) {
                                entity.collisionOn = true;
                           // }
                            if (player == true) {
                                index = i;
                            }
                        }
                        break;
                    case "right":
                        entity.solidArea.x += entity.speed;
                        if (entity.solidArea.intersects(gp.ammo[i].solidArea)) {
                          //  if (gp.ammo[i].collisionOn == true) {
                               entity.collisionOn = true;
                           // }
                            if (player == true) {
                                index = i;
                            }
                            break;

                        }

                }
                entity.solidArea.x = entity.solidAreaDefaultX;
                entity.solidArea.y = entity.solidAreaDefaultY;
                gp.ammo[i].solidArea.x = gp.ammo[i].solidAreaDefaultX;
                gp.ammo[i].solidArea.y = gp.ammo[i].solidAreaDefaultY;

            }

        }
        return index;
    }

}
