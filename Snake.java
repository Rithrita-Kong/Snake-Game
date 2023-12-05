public class Snake {
    private int[] snakeX;
    private int[] snakeY;
    private int length = 0;
    private char direction = 'd';
    private String color;

    public Snake(int target, String color) {
        snakeX = new int[target];
        snakeY = new int[target];
        this.color = color;
    }

    public void setDirection(char newDirection) {
        this.direction = newDirection;
    }

    public void move() {
        turn();
        for (int i = length; i > 0; i--) {
            // shift the snake one unit to the desired direction to create a move
            snakeX[i] = snakeX[i - 1];
            snakeY[i] = snakeY[i - 1];
        }
        System.out.println("Snake head is in position: x = " + snakeX[0] + ", y = " +
                snakeY[0]);
    }

    private void turn() {

        if (direction == 'd') {
            this.snakeX[0]++;
        } else if (direction == 'a') {
            this.snakeX[0]--;
        } else if (direction == 'w') {
            this.snakeY[0]++;
        } else if (direction == 's') {
            this.snakeY[0]--;
        }
    }

    public void eat_food() {
        length++;
    }

    public int getLength() {
        return length;
    }

    public int getX() {
        return snakeX[0];
    }

    public int getY() {
        return snakeY[0];
    }

    public int[] getBodyX() {
        return snakeX;
    }

    public int[] getBodyY() {
        return snakeY;
    }

    public char getDirection() {
        return direction;
    }

}
