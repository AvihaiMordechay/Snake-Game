import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends JPanel implements Variables, KeyListener, ActionListener {
    /**
     * Fields.
     */
    private Timer timer;
    private final JFrame frameGame;
    private Snake snake;
    private Apple apple;
    private int score;
    private JLabel lblScore;


    /**
     * Constructor.
     */
    public Game() {
        this.frameGame = new JFrame("Snake game by Avihai");
        this.frameGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frameGame.setSize(SCREEN_SIZE, SCREEN_SIZE);
        this.frameGame.setLocationRelativeTo(null);
        this.setBackground(Color.BLACK);
    }

    /**
     * Methods.
     */
    public void runGame() {
        this.timer = new Timer(400, this);
        this.score = 0;
        this.lblScore = new JLabel("SCORE: " + score);
        lblScore.setForeground(Color.cyan);
        this.snake = new Snake();
        this.apple = new Apple();
        this.apple.setXAndY();
        add(this.apple);
        add(this.snake);
        add(this.lblScore);
        this.frameGame.addKeyListener(this);
        this.frameGame.add(this);
        this.frameGame.setVisible(true);
        this.timer.start();
        while (true) {
            if (!timer.isRunning()) break;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        paintColumnAndRows(g);
        this.apple.drawApple(g);
        this.snake.drawSnake(g);
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (this.snake.clickedWASD(e)) {
            this.snake.setDirection(e);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.snake.isInsideTheScreen() && this.snake.didNotTouchHimself()) {
            if (thereIsCollisionBetweenSnakeAndApple()) {
                this.score++;
                lblScore.setText("SCORE: " + this.score);
                if (this.timer.getDelay() > 50)
                    this.timer.setDelay(timer.getDelay() - 40);
                this.snake.addPart();
                this.apple.setXAndY();
                repaint();
            }
            if (this.snake.getDirection().equals(UP)) {
                changePosition();
                changeHeadPosition(UP);

            }
            if (this.snake.getDirection().equals(DOWN)) {
                changePosition();
                changeHeadPosition(DOWN);

            }
            if (this.snake.getDirection().equals(LEFT)) {
                changePosition();
                changeHeadPosition(LEFT);

            }
            if (this.snake.getDirection().equals(RIGHT)) {
                changePosition();
                changeHeadPosition(RIGHT);
            }

        } else {
            this.timer.stop();
            this.frameGame.setVisible(false);
        }

    }


    // Paints the grid on the screen. NOT necessary.
    private void paintColumnAndRows(Graphics g) {
        int i = 0;
        int y = 0;
        int x = 0;
        g.setColor(Color.lightGray);
        while (i != NUMBER_OF_COLUMNS + 2) {
            // Rows
            g.drawLine(0, y, SCREEN_SIZE, y);
            // Column
            g.drawLine(x, 0, x, SCREEN_SIZE);
            x += SCREEN_SIZE / (NUMBER_OF_COLUMNS + 1);
            y += SCREEN_SIZE / (NUMBER_OF_COLUMNS + 1);
            i++;
        }
    }


    private boolean thereIsCollisionBetweenSnakeAndApple() {
        return this.snake.getHead().getX() == this.apple.getX() && this.snake.getHead().getY() == this.apple.getY();
    }

    // Changes position of the head snake each frame.
    private void changeHeadPosition(String diriction) {
        if (diriction.equals(UP))
            this.snake.getHead().setRect(this.snake.getHead().getX(), this.snake.getHead().getY() - RECT_SIZE_OF_SNAKE,
                    RECT_SIZE_OF_SNAKE, RECT_SIZE_OF_SNAKE);
        if (diriction.equals(DOWN))
            snake.getHead().setRect(this.snake.getHead().getX(), this.snake.getHead().getY() + RECT_SIZE_OF_SNAKE,
                    RECT_SIZE_OF_SNAKE, RECT_SIZE_OF_SNAKE);
        if (diriction.equals(LEFT))
            snake.getHead().setRect(this.snake.getHead().getX() - RECT_SIZE_OF_SNAKE, this.snake.getHead().getY(),
                    RECT_SIZE_OF_SNAKE, RECT_SIZE_OF_SNAKE);
        if (diriction.equals(RIGHT))
            snake.getHead().setRect(this.snake.getHead().getX() + RECT_SIZE_OF_SNAKE, this.snake.getHead().getY(),
                    RECT_SIZE_OF_SNAKE, RECT_SIZE_OF_SNAKE);
        repaint();
    }

    // Changes position of the snake each frame without the head.
    private void changePosition() {
        Rectangle headOfTheSnake = new Rectangle((int) this.snake.getHead().getX(), (int) this.snake.getHead().getY(),
                (int) this.snake.getHead().getWidth(), (int) this.snake.getHead().getHeight());

        for (int i = 1; i < this.snake.snake.size(); i++) {
            Rectangle curRect = new Rectangle((int) this.snake.snake.get(i).getX()
                    , (int) this.snake.snake.get(i).getY()
                    , (int) this.snake.snake.get(i).getWidth(),
                    (int) this.snake.snake.get(i).getHeight());
            this.snake.snake.get(i).setRect(headOfTheSnake);
            headOfTheSnake = curRect;
            repaint();

        }
    }

    public int getScore() {
        return score;
    }

    // Not used.
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}