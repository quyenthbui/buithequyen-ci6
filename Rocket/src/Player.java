import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Player {
    public BufferedImage image;
    public int x,y;
    public int width, height;
    public int velocityX;
    public int velocityY;
    Random rand = new Random();

    public Player(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void run(String direction, int windowWidth, int windowHeight) {
        int dX = 0;
        int dY = 0;
        if (direction.equalsIgnoreCase("left")) {
            dX -= this.velocityX;
        } else if (direction.equalsIgnoreCase("right")) {
            dX += this.velocityX;
        }

        if (direction.equalsIgnoreCase("up")) {
            dY -= this.velocityY;
        } else if (direction.equalsIgnoreCase("down")){
            dY += this.velocityY;
        }

        if (this.y + dY <= 0) {
            this.y = windowHeight;
            this.x = rand.nextInt(windowWidth)-30;

        } else if (this.y + dY >= windowHeight){
            this.y = 0;
            this.x = rand.nextInt(windowWidth)-30;
        } else {
            this.y += dY;
        }

        if (this.x + dX <= 0) {
            this.x = windowWidth;
            this.y = rand.nextInt(windowHeight)-30;

        } else if (this.x + dX >= windowWidth) {
            this.x = 0;
            this.y = rand.nextInt(windowHeight)-30;
        } else {
            this.x += dX;
        }
    }

    public void render(Graphics graphics){
        graphics.drawImage(this.image,this.x, this.y, this.width, this.height, null);
    }
}

