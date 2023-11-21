import java.util.ArrayList;

public class Snake {
    private ArrayList<Integer> body = new ArrayList<>(5);
    private int[] head = { 0, 0 };
    private int length = 0;
    private char direction = 'd';
    private String color;

    public Snake(String color) {
        this.color = color;
    }

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

    private void grow() {
        length++;
    }

    public int get_length() {
        return length;
    }

    public void eat_food() {
        grow();
    }

    public int[] get_head() {
        return head;
    }
}
