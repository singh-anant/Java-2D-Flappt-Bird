import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class GamePanel extends JPanel implements KeyListener, ActionListener,FlappyBirdConstant,WallsConstant,GameConstant {


FlappyBirdAndWalls fb=new FlappyBirdAndWalls();
    Timer time = new Timer(40, this);


    public GamePanel() throws IOException {
        setSize(PWIDTH, PHEIGHT);
        setFocusable(true);
        addKeyListener(this);
        setBackground(Color.BLACK);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        fb.flappyAccelaration += fb.flappyImpulse;
        fb.flappyVelocity += fb.flappyAccelaration;
        fb.wallX[0] -= WALLXVelocity;
        fb.wallX[1] -= WALLXVelocity;
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!fb.gameOver) {
            g.setColor(Color.green);
            g.drawString("SCORE:"+fb.score,PWIDTH/2,10);
            fb.logic();
            fb.drawWall(g);
            fb.drawBird(g);
        }
else{
            g.setColor(Color.green);
            g.drawString("SCORE:"+fb.score,PWIDTH/2,10);
        }
    }


    private void printBackgroundImage(Graphics g) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == e.VK_SPACE) {
            fb.flappyAccelaration = -10;
        }
        if (code == e.VK_S)
            time.start();
        if (code == e.VK_R) {
            time.stop();
            fb.flappyHeight = HEIGHT / 4;
            fb.flappyVelocity = 0;
            fb.flappyAccelaration = 4;
            fb.score=0;
            fb.wallX[0] = PWIDTH;
            fb.wallX[1] = PWIDTH + PWIDTH / 2;
            fb.gap[0] = (int) (Math.random() * (HEIGHT - 150));
            fb.gap[1] = (int) (Math.random() * (HEIGHT - 150));
            fb.gameOver = false;
            repaint();
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
