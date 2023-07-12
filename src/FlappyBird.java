import java.awt.*;

public class FlappyBird implements GameConstant,FlappyBirdAndWallConstant {
    int flappyHeight = PHEIGHT / 4;
    int flappyVelocity = 0;
    int floppyAcceleration = 4;
    int flappyImpulse = 1;

    public void drawBird(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(75, flappyHeight + flappyVelocity, BIRDWIDTH, BIRDHEIGHT);
    }
    public boolean logic1(int gap){
        return (flappyHeight + flappyVelocity) >= 0 && (flappyHeight + flappyVelocity) <= gap
                || (flappyVelocity + flappyHeight + 25) >= gap + 100 && (flappyHeight + flappyVelocity + 25) <= PHEIGHT;
    }
    public boolean logic2(){
        return (flappyHeight + flappyVelocity) <= 0 || (flappyHeight + flappyVelocity + 25) >= PHEIGHT;
    }

}
