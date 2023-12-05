import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game extends JFrame implements KeyListener {
    // Attributes
    private Snake snake;
    private Food food;
    private int level;
    private int target;
    private int score;
    private int width;
    private int height;
    private int speed;
    private char direction;
    private boolean isRunning = true;

    // Constructor
    public Game(int level, int target, int speed, int width, int height) {
        // Set properties of the frame
        setSize(20, 20);
        setTitle("Snake Game Key listener: ");
        setVisible(true);

        // Set the attribute to its corrrespond value
        this.level = level;
        this.speed = speed;
        this.target = target;
        this.width = width;
        this.height = height;

        // Initialize snake and food object
        snake = new Snake(30, "Green");
        food = new Food(width, height, "Red");

        // Add key listener to the frame
        addKeyListener(this);

        // Set the focus on the frame so that it can receive key events
        setFocusable(true);
        requestFocus();
        food.generate_food();
        // Game Logic
        // We are still working on the game logic at the moment

        Thread movementThread = new Thread(() -> {

            while (isRunning) {
                snake.move();
                System.out.println(food.getFoodX() + " " + food.getFoodY());
                checkFood();
                checkHit();

                try {
                    Thread.sleep(speed); // Adjust the sleep time as needed for desired speed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (!isRunning) {
                System.out.println("Game Over!");
            }

        });
        movementThread.start();

    }

    // Check if the snake head equal to the food position
    public void checkFood() {
        if ((snake.getX() == food.getFoodX()) && (snake.getY() == food.getFoodY())) {
            System.out.println("You eat sth");
            snake.eat_food();
            food.generate_food();
            System.out.println(snake.getLength());
            score++;
        }
    }

    // Check if the snake head hit its body or the wall
    public void checkHit() {
        // check if head run into walls

        if ((snake.getX() < 0 || snake.getX() > this.width) || (snake.getY() < 0 ||
                snake.getY() > this.height)) {
            isRunning = false;
        }

        // check if head run into its body
        int[] bodyX = snake.getBodyX();
        int[] bodyY = snake.getBodyY();
        for (int i = score; i > 1; i--) {
            System.out.println("Body x " + bodyX[i] + ", y " + bodyY[i]);
            if (snake.getX() == bodyX[i] && snake.getY() == bodyY[i]) {
                isRunning = false;
            }
        }
    }

    // Key Listener events
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        char keyChar = e.getKeyChar();
        char currentdirection = snake.getDirection();

        // Up / W
        if (keyCode == 87 || keyCode == 38) {
            if (currentdirection != 's')
                direction = 'w';
        }
        // Left / A
        else if (keyCode == 65 || keyCode == 37) {
            if (currentdirection != 'd')
                direction = 'a';
        }
        // Right / D
        else if (keyCode == 68 || keyCode == 39) {
            if (currentdirection != 'a')
                direction = 'd';
        }
        // Down / S
        else if (keyCode == 83 || keyCode == 40) {
            if (currentdirection != 'w')
                direction = 's';
        }
        // Change the snake direction
        snake.setDirection(direction);
        System.out.println("Key pressed - KeyCode: " + keyCode + ", KeyChar: " + keyChar);
    }

    public void keyReleased(KeyEvent e) {
        // Implementation for keyReleased, if needed
    }

    public void keyTyped(KeyEvent e) {
        // Implementation for keyTyped, if needed
    }

    public static void main(String[] args) {
        int level = 1;
        int target = 20;
        int speed = 750;
        int width = 20;
        int height = 20;
        Game level1 = new Game(level, target, speed, width, height);
    }
}
