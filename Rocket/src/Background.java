import java.awt.*;

public class Background extends GameObject {

    public Background() {
        this.position = new Vector2D();
        this.renderer = new BackgroundRenderer(1024, 600, Color.BLACK);
    }

}
