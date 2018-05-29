import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy {
    public BufferedImage image;
    public Vector2D position;
    public int width, height;
    public Vector2D velocity;
    Random random = new Random();

    public Enemy(BufferedImage image, Vector2D position, int width, int height, Vector2D velocity) {
        this.image = image;
        this.position = position;
        this.width = width;
        this.height = height;
        this.velocity = velocity;
    }

    private Vector2D followPlayer(Vector2D positionPlayer){
        Vector2D velocitySubtract;
        velocitySubtract = positionPlayer.subtract(this.position);
        return velocitySubtract.normalize();
    }

    public void run(Vector2D positionPlayer ) {
        this.velocity = this.followPlayer(positionPlayer).multiply(3);
        this.position.x += this.velocity.x;
        this.position.y += this.velocity.y;
        this.backToScreen();
    }

    private void backToScreen() {
        if (this.position.x > 1024) {
            this.position.set(0,this.random.nextInt(600));
        }
        if (this.position.x < 0) {
            this.position.set(1024,this.random.nextInt(600));
        }
        if (this.position.y > 600) {
            this.position.set(this.random.nextInt(1024),0);
        }
        if (this.position.y < 0) {
            this.position.set(this.random.nextInt(1024),600);
        }
    }

    public void render(Graphics graphics) {
        graphics.drawImage(this.image, (int)this.position.x, (int)this.position.y, this.width, this.height, null);
    }
}