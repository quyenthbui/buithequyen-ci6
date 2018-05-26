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

    BufferedImage playerImage;
    BufferedImage backBuffered;
    Graphics graphics;

    List<Star> stars;
    private Random randomstar = new Random();
    private int countStar = 0;

    Player player;

    List<Enemy> enemies;
    private Random randomenemy = new Random();
    private int countEnemy = 0;

    private Random randomplayer = new Random();

    public int positionXplayer = 250;
    public int positionYplayer = 250;

    public GameCanvas() {
        this.setSize(1024, 600);
        this.setVisible(true);

        //load
//        try {
//            this.enemyImage = ImageIO.read(new File("resources/images/circle.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            this.playerImage = ImageIO.read(new File("resources/images/circle.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            this.starImage = ImageIO.read(new File("resources/images/star.png"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        this.setupBackBuffered();
        this.setupCharacter();

        this.setVisible(true);
    }

    private void setupBackBuffered() {
        this.backBuffered = new BufferedImage(1024, 600, BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();

    }

    private void setupCharacter() {
        this.setupEnemy();

        this.createPlayer();

        this.setupStar();
    }

    private void setupStar() {
        this.stars = new ArrayList<>();
    }

    private void setupEnemy() {
        this.enemies = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered, 0, 0, null);
//        g.setColor(Color.BLACK);
//        g.fillRect(0,0,1024,600);
//
//        g.drawImage(this.starImage, this.positionXstar, this.positionYstar, 20, 20, null);
//        g.drawImage(this.enemyImage, this.positionXenemy, this.positionYenemy, 20, 20, null);
//        g.drawImage(this.playerImage, this.positionXplayer, this.positionYplayer, 20, 20, null);

    }

    public void renderAll() {
        this.renderBackground();

        this.stars.forEach(star -> star.render(graphics));

        this.enemies.forEach(enemy -> enemy.render(graphics));

        this.player.render(graphics);

        this.repaint();
    }

    private void renderBackground() {
        this.graphics.setColor(Color.BLACK);
        this.graphics.fillRect(0, 0, 1024, 600);
    }

    public void runAll() {
        this.createStar();
        this.stars.forEach(star -> star.run());
        this.createEnemy();
        this.enemies.forEach(enemy -> enemy.run(1024,600,this.player.x, this.player.y));
    }

    private void createStar() {
        if (this.countStar == 30) {
            Star star = new Star(
                    this.loadImage("resources/images/star.png"),
                    1024,
                    this.randomstar.nextInt(600),
                    5,
                    5,
                    -(this.randomstar.nextInt(3) + 1),
                    0
            );
            this.stars.add(star);
            this.countStar = 0;
        } else {
            this.countStar += 1;
        }
    }

    private void createEnemy() {
        int veloX, veloY;
        veloX = 0;
        veloY = 0;
        while(veloX==0 && veloY==0){
            veloX = this.randomenemy.nextInt(10)-5;
            veloY = this.randomenemy.nextInt(10)-5;
        }
        if(this.countEnemy==500 ){
            Enemy enemy = new Enemy(this.loadImage("resources/images/circle.png"),
                    this.randomenemy.nextInt(800),
                    this.randomenemy.nextInt(600),
                    20,
                    20,
                    veloX,
                    veloY);
            this.enemies.add(enemy);
//            this.countEnemy =101;
            this.countEnemy =0;
        }
        else{
            this.countEnemy +=1;
        }
    }

    private void createPlayer() {
        this.player = new Player(this.loadImage("resources/images/circle.png"),
                this.randomplayer.nextInt(1024),
                this.randomplayer.nextInt(600),
                30,
                30,10);
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

