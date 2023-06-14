
import javax.swing.*;
import java.io.IOException;

public class GameFrame extends JFrame implements GameConstant{
    public GameFrame() throws IOException {
        setSize(GWIDTH,GHEIGHT);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new GamePanel());
    }

    public static void main(String[] args) throws IOException {
        new GameFrame();
    }
}
