import javax.swing.*;
import java.awt.*;

public class Apple extends JPanel implements Variables {
    private int x,y;
    public void drawApple (Graphics g){
        g.setColor(Color.RED);
        g.fillOval(x,y,APPLE_SIZE,APPLE_SIZE);
    }
    public void setXAndY (){
        x = (int) (Math.random()*NUMBER_OF_COLUMNS) * RECT_SIZE_OF_SNAKE;
        y = (int) (Math.random()*NUMBER_OF_ROWS) * RECT_SIZE_OF_SNAKE;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
