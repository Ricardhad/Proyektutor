/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Game;

/**
 *
 * @author Reynaldy
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MovementGame extends JFrame implements KeyListener {
    private JLabel playerLabel;
    private int playerX;
    private int playerY;

    private static final int WINDOW_WIDTH = 400;
    private static final int WINDOW_HEIGHT = 400;
    private static final int PLAYER_SIZE = 1000;
    private static final int FPS = 60;

    public MovementGame() {
        setTitle("Movement Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setLocationRelativeTo(null);

        ImageIcon playerIcon = new ImageIcon("src/player/boy_down_1.png"); // Replace "player.png" with your sprite image path
        playerLabel = new JLabel(playerIcon);
        playerX = (WINDOW_WIDTH - PLAYER_SIZE) / 2;
        playerY = (WINDOW_HEIGHT - PLAYER_SIZE) / 2;

        setLayout(null);
        playerLabel.setBounds(playerX, playerY, PLAYER_SIZE, PLAYER_SIZE);
        add(playerLabel);

        addKeyListener(this);
        setFocusable(true);

        Timer timer = new Timer(1000 / FPS, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Update game logic or animations here

                repaint();
            }
        });
        timer.start();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        switch (keyCode) {
            case KeyEvent.VK_W:
                if (playerY - 10 >= 0) {
                    playerY -= 100;
                }
                break;
            case KeyEvent.VK_S:
                if (playerY + PLAYER_SIZE + 10 <= WINDOW_HEIGHT) {
                    playerY += 100;
                }
                break;
            case KeyEvent.VK_A:
                if (playerX - 10 >= 0) {
                    playerX -= 100;
                }
                break;
            case KeyEvent.VK_D:
                if (playerX + PLAYER_SIZE + 10 <= WINDOW_WIDTH) {
                    playerX += 100;
                }
                break;
        }

        playerLabel.setLocation(playerX, playerY);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not used in this example
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used in this example
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MovementGame game = new MovementGame();
                game.setVisible(true);
            }
        });
    }
}

