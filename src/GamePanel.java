import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener, ActionListener, FlappyBirdAndWallConstant, GameConstant {
Walls w;
FlappyBird fb;
Timer time=  new Timer(40, this);


    public GamePanel()  {
        fb=new FlappyBird();
        w=new Walls();
        setSize(PWIDTH, PHEIGHT);
        setFocusable(true);
        addKeyListener(this);
        setBackground(Color.BLACK);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        fb.floppyAcceleration += fb.flappyImpulse;
        fb.flappyVelocity += fb.floppyAcceleration;
        w.wallX[0] -= WALLXVelocity;
        w.wallX[1] -= WALLXVelocity;
        repaint();
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        System.out.println(w.gameOver);
        if (!w.gameOver) {
            g.setColor(Color.green);
            g.drawString("SCORE:"+w.score,PWIDTH/2,10);
            w.logic();
            w.drawWall(g);
            fb.drawBird(g);
        }
else{
            g.setColor(Color.green);
            g.drawString("SCORE:"+w.score,PWIDTH/2,10);
        }
    }



    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == e.VK_SPACE) {
            fb.floppyAcceleration = -10;
        }
        if (code == e.VK_S)
            time.start();
        if (code == e.VK_R) {
            time.stop();
            fb.flappyHeight = HEIGHT / 4;
            fb.flappyVelocity = 0;
            fb.floppyAcceleration = 4;
            w.score=0;
            w.wallX[0] = PWIDTH;
            w.wallX[1] = PWIDTH + PWIDTH / 2;
            w.gap[0] = (int) (Math.random() * (HEIGHT - 150));
            w.gap[1] = (int) (Math.random() * (HEIGHT - 150));
            w.gameOver = false;
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
