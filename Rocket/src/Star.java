import java.awt.*;
import java.awt.image.BufferedImage;

public class Star {
    public Vector2D position;
    private ImageRenderer renderer;
    public Vector2D velocity;

    public Star() {
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/star.png",5,5);
    }

    public void run(){
        this.position.addUp(this.velocity);
    }

    public void render(Graphics graphics){
        this.renderer.render(graphics,position);
    }
}
