import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Snake extends JPanel implements Variables {

    /**
     * Fields.
     */
    public ArrayList<Rectangle> snake;
    private String direction;

    private Icon head;
    /**
     * Constructor.
     */
    public Snake() {
        snake = new ArrayList<>();
        head = new ImageIcon(Snake)
        snake.add(new Rectangle(CENTER_OF_SCREEN, CENTER_OF_SCREEN, RECT_SIZE_OF_SNAKE, RECT_SIZE_OF_SNAKE));
        direction = UP;
    }

    /**
     * Methods.
     */
    public void drawSnake(Graphics g) {
        paintHead(g);
        g.setColor(Color.GREEN);
        for (int i = 1; i < snake.size(); i++) {
            g.fillRect((int) snake.get(i).getX(), (int) snake.get(i).getY(), (int) snake.get(i).getWidth(), (int) snake.get(i).getHeight());
        }
    }

    public boolean clickedWASD(KeyEvent e) {
        return e.getKeyCode() == KeyEvent.VK_W ||
                e.getKeyCode() == KeyEvent.VK_A ||
                e.getKeyCode() == KeyEvent.VK_S ||
                e.getKeyCode() == KeyEvent.VK_D;
    }

    public void setDirection(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W && !getDirection().equals(DOWN))
            direction = UP;
        if (e.getKeyCode() == KeyEvent.VK_S && !getDirection().equals(UP))
            direction = DOWN;
        if (e.getKeyCode() == KeyEvent.VK_A && !getDirection().equals(RIGHT))
            direction = LEFT;
        if (e.getKeyCode() == KeyEvent.VK_D && !getDirection().equals(LEFT))
            direction = RIGHT;
    }

    public void paintHead(Graphics g) {
        g.setColor(Color.GREEN);
        g.fillRect((int) snake.get(0).getX(), (int) snake.get(0).getY(), (int) snake.get(0).getWidth(), (int) snake.get(0).getHeight());
//        g.drawImage(head, (int) getHead().getX(), (int) getHead().getY(),this);
    }

    public String getDirection() {
        return direction;
    }

    public boolean isInsideTheScreen() {
        return getHead().getX() >= 0 && getHead().getX() != SCREEN_SIZE
                && getHead().getY() >= 0 && getHead().getY() != SCREEN_SIZE;
    }
    public boolean didNotTouchHimself(){
        for (int i = 1; i < snake.size(); i++) {
            if (getHead().getX() == snake.get(i).getX() && getHead().getY() == snake.get(i).getY())
                return false;
        }
        return true;
    }

    public void addPart() {
            snake.add(new Rectangle((int) getTail().getX(), (int) (getTail().getY() + RECT_SIZE_OF_SNAKE),
                    RECT_SIZE_OF_SNAKE, RECT_SIZE_OF_SNAKE));
    }

    private Rectangle getTail() {
        return snake.get(snake.size() - 1);
    }
    public Rectangle getHead(){
        return snake.get(0);
    }

}
