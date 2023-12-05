import java.util.Random;

public class Food {
    private int width;
    private int height;
    public int foodX;
    public int foodY;
    private String color;

    public Food(int width, int height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void generate_food() {
        // Generate a random location for the food.
        Random random = new Random();
        this.foodX = random.nextInt(width);
        this.foodY = random.nextInt(height);
    }

    public int getFoodX() {
        return foodX;
    }

    public int getFoodY() {
        return foodY;
    }

}
