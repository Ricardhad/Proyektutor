/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.io.File;
import javax.sound.sampled.*;

/**
 *
 * @author Reynaldy
 */
public class sound1 {

    String filepath;
    Clip clip;
    public sound1 pm;
    String lagu ="";
    
    public sound1(String filepath, Clip clip) {
        this.filepath = filepath;
        this.clip = clip;
    }
    
    
    public void stopsound(){
    clip.stop();
    }
    
    public void changesound(String newpath){
    this.filepath = filepath;
    music();
    }
    
    
    public void change(){
    this.pm.stopsound();
//    ganti ke scene selanjutnya(masuk battle ataulainnya)
    
    }
    
    public void music() {
        try {
            File musicpath = new File(filepath);
            
            if (musicpath.exists()) {
                
                AudioInputStream audioinput = AudioSystem.getAudioInputStream(musicpath);
                clip =AudioSystem.getClip();
                clip.open(audioinput);
                clip.start();
                clip.loop(clip.LOOP_CONTINUOUSLY);
                Thread.sleep(100);
                
            } else {
                System.out.println("file tdk ada");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }
}
