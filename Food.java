import java.util.Random;

public class Food {
    // Attributes
    private int width;
    private int height;
    public int foodX;
    public int foodY;
    private String color;

    // Constructor
    public Food(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    // Generate a new food
    public void generate_food() {
        // Generate a random location for the food.
        Random random = new Random();
        this.foodX = random.nextInt(width);
        this.foodY = random.nextInt(height);
    }

    // Get the x position of the food
    public int getFoodX() {
        return foodX;
    }

    // Get the y position of the food
    public int getFoodY() {
        return foodY;
    }

}
