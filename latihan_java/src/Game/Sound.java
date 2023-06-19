/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

/**
 *
 * @author Reynaldy
 */
public class Sound {
    Clip clip;
    URL soundURL[]=new URL[30]; 
    
    public Sound(){
        soundURL[0] = getClass().getResource("/Sounds/BlueBoyAdventure.wav");
        soundURL[1] = getClass().getResource("/Sounds/coin.wav");
        soundURL[2] = getClass().getResource("/Sounds/powerup.wav");
        soundURL[3] = getClass().getResource("/Sounds/unlock.wav");
        soundURL[4] = getClass().getResource("/Sounds/hitmonster.wav");
    }
    public void setFile(int i){
        try{
        AudioInputStream ais = AudioSystem.getAudioInputStream(soundURL[i]);
        clip = AudioSystem.getClip();
        clip.open(ais);
        
        }catch(Exception e){
        }
    }
    
    public void play(){
        clip.start();
    }
    
    public void loop(){
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        clip.stop();
    }
}
