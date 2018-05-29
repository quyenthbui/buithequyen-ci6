import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    public int x;
    public int y;
    public int width;
    public int height;
    public Color color;

    public Background(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.fillRect(this.x, this.y, this.width, this.height);
    }
}