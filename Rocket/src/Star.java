public class Star extends GameObject {

    public Vector2D velocity;

    public Star() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/images/star.png", 5, 5);
    }

    public void run() {
        this.position.addUp(this.velocity);
    }

}
