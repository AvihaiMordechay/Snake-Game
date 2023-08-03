import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIafterGame extends JPanel implements ActionListener {
    private Timer timer;
    private final JFrame GUIafterGame;
    private final JButton cmdRetry;
    private final JButton cmdExit;
    private final JLabel lblScore;

    public GUIafterGame(int score) {
        GUIafterGame = new JFrame("Game");
        GUIafterGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUIafterGame.setSize(300, 300);
        GUIafterGame.setLocationRelativeTo(null);
        cmdRetry = new JButton("RETRY");
        cmdExit = new JButton("EXIT");
        lblScore = new JLabel("YOUR SCORE : " + score);
        this.add(cmdRetry);
        this.add(cmdExit);
        this.add(lblScore);
        cmdRetry.addActionListener(this);
        cmdExit.addActionListener(this);
        GUIafterGame.add(this);
        GUIafterGame.setVisible(true);


    }

    public void runGUIafterGame() {
        timer = new Timer(1000, this);
        timer.start();
        while (true) {
            if (!timer.isRunning()) break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cmdRetry) {
            timer.stop();
            GUIafterGame.setVisible(false);
        }
        if (e.getSource() == this.cmdExit)
            System.exit(1);

    }
}

