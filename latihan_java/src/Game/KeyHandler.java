/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
/**
 *
 * @author Reynaldy
 */
public class KeyHandler implements KeyListener{
    public boolean up,down,left,right,map1,map2,map3;
    boolean checkDrawTime = false;

    @Override
    public void keyTyped(KeyEvent e) {
  
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code =e.getKeyCode();
        if(code==KeyEvent.VK_W){
            up=true;
        }
        if(code==KeyEvent.VK_S){
            down=true;
        }
        if(code==KeyEvent.VK_A){
           left=true;
        }
        if(code==KeyEvent.VK_D){
            right=true;
        }
        if (code==KeyEvent.VK_1) {
            map1=true;
        }
        if (code==KeyEvent.VK_2) {
            map2=true;
        }
        if (code==KeyEvent.VK_3) {
            map3=true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code =e.getKeyCode();
         if (code==KeyEvent.VK_1) {
            map1=false;
        }
         if (code==KeyEvent.VK_2) {
            map2=false;
        }
         if (code==KeyEvent.VK_3) {
            map3=true;
        }
//        if(code==KeyEvent.VK_W){
//           up=false;
//        }
//        if(code==KeyEvent.VK_S){
//            down=false;
//        }
//        if(code==KeyEvent.VK_A){
//           left=false;
//        }
//        if(code==KeyEvent.VK_D){
//            right=false;
//        }
    }
    
    
}
