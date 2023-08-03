import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel implements ActionListener {
    /**
     * Fields.
     */
    private final JButton cmdPlay;
    private final JButton cmdExit;
    private Timer timer;
    private final JFrame frameGUI;

    /**
     * Constructor.
     */
    public GUI() {
        frameGUI = new JFrame("Snake");
        frameGUI.setSize(500, 500);
        frameGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameGUI.setLocationRelativeTo(null);
        this.cmdExit = new JButton("EXIT");
        this.cmdPlay = new JButton("PLAY");
        this.add(cmdPlay);
        this.add(cmdExit);
        cmdPlay.addActionListener(this);
        cmdExit.addActionListener(this);
        frameGUI.add(this);
    }

    /**
     * Methods.
     */
    public void runGUI() {
        frameGUI.setVisible(true);
        timer = new Timer(1000, this);
        timer.start();
        while (true) {
            if (!timer.isRunning()) break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.cmdPlay) {
            timer.stop();
            frameGUI.setVisible(false);
        }
        if(e.getSource() == this.cmdExit)
            System.exit(1);

    }


}


