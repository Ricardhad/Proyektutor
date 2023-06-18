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
    public boolean up,down,left,right;

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
<<<<<<< HEAD
<<<<<<< HEAD
//        if (code==KeyEvent.VK_P) {
//            if (gp.gameState==gp.playState) {
//                gp.gameState=gp.pausedState;
//            }else if (gp.gameState==gp.pausedState) {
//                gp.gameState=gp.playState;
//            }
//        }
=======
>>>>>>> parent of 17e8b3d (Hasil final)
=======
>>>>>>> parent of 17e8b3d (Hasil final)
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code =e.getKeyCode();
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
