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
public class OBJ_Fruit extends SuperObject {

    public OBJ_Fruit() {
        name = "Fruit";
        try {
            satu = ImageIO.read(getClass().getResourceAsStream("/Object/tomb_fruit0.png"));
            dua = ImageIO.read(getClass().getResourceAsStream("/Object/tomb_fruit1.png"));
            tiga = ImageIO.read(getClass().getResourceAsStream("/Object/tomb_fruit2.png"));
            empat = ImageIO.read(getClass().getResourceAsStream("/Object/tomb_fruit3.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
