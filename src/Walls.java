import java.awt.*;

public class Walls implements GameConstant, FlappyBirdAndWallConstant {
    int score=0;
    boolean gameOver;
    int[] wallX = {PWIDTH, PWIDTH / 2};
    int[] gap = {(int) (Math.random() * (PHEIGHT - 150)), (int) (Math.random() * (PHEIGHT - 100))};
    FlappyBird fb;

    public Walls(){
       fb =new FlappyBird();
       gameOver=false;
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
                        gameOver = fb.logic1(gap[i]) && fb.logic2();;
                }

                if (75 > wallX[i]+WALLWIDTH ) {
                    score++;
                }
                if (wallX[i] + WALLWIDTH <= 0) {
                    wallX[i] = PWIDTH;
                    // Regenerate the gap here when the wall goes off the screen
                    gap[i] = (int) (Math.random() * (PHEIGHT - 150));
                }
            }
        }
    }

