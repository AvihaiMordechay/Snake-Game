
public class Main {
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.runGUI();
        Game game = new Game();
        game.runGame();
        while (true){
            GUIafterGame guIafterGame = new GUIafterGame(game.getScore());
            guIafterGame.runGUIafterGame();
            game = new Game();
            game.runGame();
        }
    }
}
