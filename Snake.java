import java.util.ArrayList;

public class Snake {
    private ArrayList<int[]> body = new ArrayList<>();
    private int[] head = { 0, 0 };
    private int length;
    private char direction = 'd';

    public void setDirection(char newDirection) {
        this.direction = newDirection;
    }

    public void move() {
        turn();
        System.out.println("Snake head is in position: x = " + head[0] + ", y = " + head[1]);
    }

    private void turn() {
        if (direction == 'd') {
            this.head[1]++;
        } else if (direction == 'a') {
            this.head[1]--;
        } else if (direction == 'w') {
            this.head[0]++;
        } else if (direction == 's') {
            this.head[0]--;
        }
    }
}
