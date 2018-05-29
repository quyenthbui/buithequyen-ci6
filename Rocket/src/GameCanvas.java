import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {
    BufferedImage backBuffered;
    Graphics graphics;
    Background background;
    List<Star> stars;
    private int countStar = 0;
    List<Enemy> enemies;
    private int countEnemy = 0;
    Player player;
    private Random random = new Random();


    public GameCanvas() {
        this.setSize(1024, 600);
        this.setupBackBuffered();
        this.setupCharacter();
        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }

    private void setupCharacter() {
        this.background = new Background(0, 0, 1024, 600, Color.black);
        this.setupEnemy();
        this.player = new Player();
        this.player.position.set(500, 300);
        this.setupStar();
    }

    private void setupEnemy() {
        this.enemies = new ArrayList<>();
    }

    private void setupStar() {
        this.stars = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
    }

    public void renderAll() {
        this.background.render(this.graphics);
        this.stars.forEach(star -> star.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.player.render(this.graphics);
        this.repaint();
    }

    public void runAll() {
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.createEnemy();
        this.enemies.forEach(enemy -> enemy.run(this.player.position));
        this.player.run();
    }

    private void createStar() {
        if (this.countStar == 30) {
            Star star = new Star(
                    this.loadImage("resources/images/star.png"),
                    new Vector2D(1024, this.random.nextInt(600)),
                    5,
                    5,
                    new Vector2D(-this.random.nextInt(3) - 1, 0)
            );
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
    }

    private void createEnemy() {
        if (this.countEnemy == 200) {
            int sign = this.random.nextInt(2);
            if (sign == 0) sign = -1;
            else sign = 1;
            int velocityX = sign * (this.random.nextInt(4) + 1);

            sign = this.random.nextInt(2);
            if (sign == 0) sign = -1;
            else sign = 1;
            int velocityY = sign * (this.random.nextInt(4) + 1);

            Enemy enemy = new Enemy(this.loadImage("resources/images/circle.png"),
                    new Vector2D(this.random.nextInt(1024), this.random.nextInt(600)),
                    20,
                    20,
                    new Vector2D(velocityX, velocityY)
            );
            this.enemies.add(enemy);
            this.countEnemy = 0;
        } else {
            this.countEnemy += 1;
        }
    }


    private BufferedImage loadImage(String path) {
        try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}

