import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Game extends Frame implements KeyListener {
    private Snake snake;
    private int level;
    private int target;
    private int width;
    private int height;
    private int speed;
    private char direction;
    private boolean isRunning = true;

    public Game(int level, int target, int speed, int width, int height) {
        // Set properties of the frame
        setSize(width, height);
        setTitle("Snake Game Key listener: ");
        setVisible(true);

        // Initialize the snake object
        this.level = level;
        this.speed = speed;
        this.target = target;
        snake = new Snake();

        // Add key listener to the frame
        addKeyListener(this);

        // Set the focus on the frame so that it can receive key events
        setFocusable(true);
        requestFocus();
        Thread movementThread = new Thread(() -> {
            while (isRunning) {
                snake.move();
                try {
                    Thread.sleep(speed); // Adjust the sleep time as needed for desired speed
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        movementThread.start();
    }

    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        char keyChar = e.getKeyChar();

        // Up / W
        if (keyCode == 87 || keyCode == 38) {
            direction = 'w';
        }
        // Left / A
        else if (keyCode == 65 || keyCode == 37) {
            direction = 'a';
        }
        // Right / D
        else if (keyCode == 68 || keyCode == 39) {
            direction = 'd';
        }
        // Down / S
        else if (keyCode == 83 || keyCode == 40) {
            direction = 's';
        }
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
        // Create an instance of the Game class
        int level = 1;
        int target = 20;
        int speed = 1000;
        int width = 20;
        int height = 20;
        Game example = new Game(level, target, speed, width, height);
    }
}
