import java.util.Random;

public class Food {
    private int width;
    private int height;
    private int[] food_position = { 1, 10 };
    private String color;

    public Food(String color) {
        this.color = color;
    }

    public Food(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void generate_food() {
        // Generate a random location for the food.
        Random random = new Random();
        int foodX = random.nextInt(width);
        int foodY = random.nextInt(height);
        food_position[0] = foodX;
        food_position[1] = foodY;
    }

    public int[] get_food_position() {
        return food_position;
    }

}
