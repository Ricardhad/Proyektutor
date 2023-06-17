/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Reynaldy
 */
public class OBJ_Ammo extends SuperObject{
    public OBJ_Ammo(){
        name="Portal";
        try{
            kiri =  ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_ammo.png"));
            kanan =  ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_ghost_right.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
    
}
