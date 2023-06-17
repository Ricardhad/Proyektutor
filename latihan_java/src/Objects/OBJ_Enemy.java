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
public class OBJ_Enemy extends SuperObject{
    public OBJ_Enemy(){
        name="Portal";
        try{
            kiri = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_portal0.png"));
            kanan = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_portal1.png"));
            
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
