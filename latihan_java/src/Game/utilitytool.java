/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 *
 * @author Billy
 */
public class utilitytool {
   public BufferedImage scaledimage(BufferedImage original,int width , int height){
       BufferedImage scaledimage= new BufferedImage(width, height, original.getType());
       Graphics2D g2= scaledimage.createGraphics();
       g2.drawImage(original, 0,0,width,height, null);
       g2.dispose();
       return scaledimage;
   }
}
