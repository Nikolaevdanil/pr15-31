package pr17;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

public class GameField extends JPanel implements ActionListener {

    ImageIcon hR = new ImageIcon("src/pr17/headR.png");
    ImageIcon hL = new ImageIcon("src/pr17/headL.png");
    ImageIcon hU = new ImageIcon("src/pr17/headU.png");
    ImageIcon hD = new ImageIcon("src/pr17/headD.png");
    private final int SIZE = 640;
    private final int PART_SIZE = 32;
    private final int ALL_PARTS = 400;
    private Image apple, snake, head;
    private int appleX, appleY, parts, time = 250, score = 0;
    private int[] x = new int[ALL_PARTS];
    private int[] y = new int[ALL_PARTS];
    private Timer timer;
    private boolean right = true, inGame = true, left = false, up = false, down = false;

    GameField() {
        setBackground(Color.black);
        LoadImages();
        initGame();
        addKeyListener(new FieldKeyListener());
        setFocusable(true);
    }


    private void initGame() {
        parts = 3;
        for (int i = 0; i < parts; i++) {
            x[i] = 64 - i * PART_SIZE;
            y[i] = 64;
        }
        timer = new Timer(time, this);
        timer.start();
        CreateApple();
    }

    private void move() {
        for (int i = parts; i > 0; i--) {
            x[i] = x[i - 1];
            y[i] = y[i - 1];
        }

        if (left) {
            x[0] -= PART_SIZE;
        }
        if (right) {
            x[0] += PART_SIZE;
        }
        if (up) {
            y[0] -= PART_SIZE;
        }
        if (down) {
            y[0] += PART_SIZE;
        }

    }

    private void CheckApple() {
        if (x[0] == appleX && y[0] == appleY) {
            parts++;
            CreateApple();
            score++;
            if(score  % 2 == 0 && score !=0) {
                time -= 25;
                timer.setDelay(time);
            }
        }
    }

    private void CheckWalls() {

        for (int i = parts; i > 0; i--)
            if(i > 4 && x[0] == x[i] && y[0] == y[i]) {
                inGame = false;
                break;
            }

        if (x[0] > SIZE) {
            inGame = false;
        }
        if (x[0] < 0) {
            inGame = false;
        }
        if (y[0] > SIZE-25) {
            inGame = false;
        }
        if (y[0] < 0) {
            inGame = false;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (inGame) {
            move();
            CheckApple();
            CheckWalls();
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (inGame) {
            g.drawImage(apple, appleX, appleY, this);
            g.drawImage(head, x[0], y[0], this);
            for (int i = 1; i < parts; i++) {
                g.drawImage(snake, x[i], y[i], this);
            }
        } else {
            String str = "Game Over";
            g.setColor(Color.white);
            Font f = new Font("Arial",Font.BOLD, 30);
            g.setFont(f);
            g.drawString(str, SIZE / 2-85, SIZE / 2-25);
            str = "Your score: "+score;
            f = new Font("Arial",Font.PLAIN, 15);
            g.setFont(f);
            g.drawString(str, SIZE / 2-45, SIZE / 2);
            str = "Press SPACE to play again!";
            g.drawString(str, SIZE / 2-95, SIZE / 2+50);
            str = "[Esc] - out the game";
            g.drawString(str, 0, 25);
        }
    }

    private void CreateApple() {
        appleX = new Random().nextInt(20) * PART_SIZE;
        appleY = new Random().nextInt(20) * PART_SIZE;
    }

    private void LoadImages() {
        ImageIcon a = new ImageIcon("src/pr17/apple.png");
        apple = a.getImage();
        ImageIcon s = new ImageIcon("src/pr17/snake.png");
        snake = s.getImage();
        head = hR.getImage();
    }

    class FieldKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            int key = e.getKeyCode();

            if(key == KeyEvent.VK_LEFT && !right) {
                left = true;
                up = false;
                down = false;
                head = hL.getImage();
            }
            if(key == KeyEvent.VK_RIGHT && !left) {
                right = true;
                up = false;
                down = false;
                head = hR.getImage();
            }
            if(key == KeyEvent.VK_UP && !down) {
                up = true;
                left = false;
                right = false;
                head = hU.getImage();
            }
            if(key == KeyEvent.VK_DOWN && !up) {
                down = true;
                left = false;
                right = false;
                head = hD.getImage();
            }
            if(key == KeyEvent.VK_SPACE) {
                inGame = right = true; down = up = left = false;
                head = hR.getImage();
                score = 0;
                time = 250;
                timer.stop();
                repaint();
                initGame();
            }

            if(key == KeyEvent.VK_ESCAPE) {
                System.exit(0);
            }
        }
    }
}
