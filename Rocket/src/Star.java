import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {

    BufferedImage image;
    public Vector2D position;
    public int width;
    public int height;
    public Vector2D velocity;

    public Star(BufferedImage image, Vector2D position, int width, int height, Vector2D velocity) {
        this.image = image;
        this.position = position;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
    }

    public void run() {
        this.position.x += this.velocity.x;
        this.position.y += this.velocity.y;
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, this.width, this.height, null);
    }
}
