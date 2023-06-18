/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Reynaldy
 */
public interface NewInterface {
  
    void update();

    void draw(Graphics2D graphics2D);

    String getName();

    void speak();

    void damageReaction();

    void setIndex(int i);

    int getIndex();

    Rectangle getCollisionArea();

    int getCollisionDefaultX();

    int getCollisionDefaultY();

    boolean isCollision();

    int getWorldX();

    int getWorldY();

    void setWorldX(int i);

    void setWorldY(int i);

    boolean isInvincible();

    void setInvincible(boolean invincible);

    int getCurrentLife();

    void setCurrentLife(int currentLife);

    boolean isAlive();

    void setAlive(boolean alive);

    boolean isDying();

    void setDying(boolean dying);

    int getLevel();

    int getStrength();

    int getDexterity();

    int getAttackPower();

    int getDefensePower();

    int getExp();

    int getNextLevelExp();

    int getCoins();

    Object getCurrentWeapon();

    Object getCurrentShield();

    BufferedImage getImage1();

    String getDescription();

    Rectangle getAttackArea();

    void setAttackArea(Rectangle attackArea);

    void use();

    int getMaxLife();

    void checkDrop();

    void dropObject(NewInterface droppedObject);

    Color getParticleColor();

    int getParticleSize();

    int getParticleSpeed();

    int getParticleMaxLife();

    int getPrice();
}


