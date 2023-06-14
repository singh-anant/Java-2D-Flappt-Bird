import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class FlappyBirdAndWalls implements GameConstant,FlappyBirdConstant{
    int flappyHeight = PHEIGHT / 4;
    int flappyVelocity = 0;
    int flappyAccelaration = 4;
    int flappyImpulse = 1;
    int score=0;



    int[] wallX = {PWIDTH, PWIDTH / 2};
    int[] gap = {(int) (Math.random() * (PHEIGHT - 150)), (int) (Math.random() * (PHEIGHT - 100))};

    boolean gameOver = false;

    public void drawBird(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(75, flappyHeight + flappyVelocity, 25, 25);
    }

    public void drawWall(Graphics g) {
        for (int i = 0; i < 2; i++) {
            g.setColor(Color.red);
            g.fillRect(wallX[i], 0, WALLWIDTH, PHEIGHT);
            g.setColor(Color.black);
            g.fillRect(wallX[i], gap[i], WALLWIDTH, 100);
        }
    }
        public void logic() {
            for (int i = 0; i < 2; i++) {
                if (wallX[i] <= 100 && wallX[i] + WALLWIDTH >= 100 || wallX[i] <= 75 && wallX[i] + WALLWIDTH >= 75) {
                    if ((flappyHeight + flappyVelocity) >= 0 && (flappyHeight + flappyVelocity) <= gap[i]
                            || (flappyVelocity + flappyHeight + 25) >= gap[i] + 100 && (flappyHeight + flappyVelocity + 25) <= PHEIGHT) {
                        gameOver = true;
                    }
                }
                if((flappyHeight+flappyVelocity)<=0||(flappyHeight+flappyVelocity+25)>=PHEIGHT){
                    gameOver=true;
                }
                if (75 > wallX[i]+WALLWIDTH ) {
                    score++;
                }
                if (wallX[i] + WALLWIDTH <= 0) {
                    wallX[i] = PWIDTH;
                    gap[i] = (int) (Math.random() * (PHEIGHT - 150));
                }
            }
        }
    }

