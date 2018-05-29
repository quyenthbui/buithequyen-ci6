import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Player {
    public Vector2D position;
    public Vector2D velocity;
    public double angle;

    private Random random;
    private List<Vector2D> vertices;
    private Polygon polygon;

    public Player() {
        this.position = new Vector2D();
        this.velocity = new Vector2D(1,0);
        this.random = new Random();
        this.angle = 0;
        this.polygon = new Polygon();

    }

    public void run() {
        this.velocity = (this.velocity.normalize());
        this.velocity = this.velocity.rotate(angle);
        this.position.addUp(this.velocity);
        this.setVertices();
        this.backToScreen();
    }

    public void backToScreen() {
        if (this.position.x > 1024) {
            this.position.set(0, this.random.nextInt(600));
        }

        if (this.position.x < 0) {
            this.position.set(1024, this.random.nextInt(600));
        }

        if (this.position.y > 600) {
            this.position.set(this.random.nextInt(1024), 0);
        }

        if (this.position.y < 0) {
            this.position.set(this.random.nextInt(1024), 600);
        }
    }

    private void setVertices(){
        List<Vector2D> vectorG = Arrays.asList(
                this.velocity.normalize().multiply(16),
                this.velocity.normalize().multiply((float)(8*Math.sqrt(2))),
                this.velocity.normalize().multiply((float)(8*Math.sqrt(2)))
        );

        this.vertices = Arrays.asList(
                this.position.add(vectorG.get(0)),
                this.position.add(vectorG.get(1).rotate(135)),
                this.position.add(vectorG.get(1).rotate(-135))
        );
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.RED);
        this.polygon.reset();
        this.vertices.forEach(vertex -> polygon.addPoint((int) vertex.x, (int) vertex.y));
        graphics.fillPolygon(this.polygon);
    }
}

