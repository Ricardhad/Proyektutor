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
public class OBJ_Portal extends SuperObject {
    public OBJ_Portal(){
        name="Portal";
        try{
            satu = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_portal0.png"));
            dua = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_portal1.png"));
            tiga = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_portal2.png"));
            empat = ImageIO.read(getClass().getResourceAsStream("/tomb_sprite/tomb_portal0.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
        collision = true;
    }
}
