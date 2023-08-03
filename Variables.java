public interface Variables {
    // If you want to change the border of the game, change only the "SCREEN_SIZE"
    int SCREEN_SIZE = 600;
    int CENTER_OF_SCREEN = SCREEN_SIZE / 2;
    int RECT_SIZE_OF_SNAKE = (int) (SCREEN_SIZE * 0.05);

    int LAST_COLUMN = SCREEN_SIZE-RECT_SIZE_OF_SNAKE;
    int LAST_ROW = SCREEN_SIZE - RECT_SIZE_OF_SNAKE - RECT_SIZE_OF_SNAKE;

    int NUMBER_OF_COLUMNS = LAST_COLUMN / RECT_SIZE_OF_SNAKE;
    int NUMBER_OF_ROWS = LAST_ROW / RECT_SIZE_OF_SNAKE;
    int APPLE_SIZE = (int) (SCREEN_SIZE * 0.05);
     String UP = "UP";
     String DOWN = "DOWN";
     String LEFT = "LEFT";
     String RIGHT = "RIGHT";


}
