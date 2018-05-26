import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Enemy {

    public BufferedImage image;
    public int x,y;
    public int width, height;
    public int velocityX, velocityY;
    Random rand = new Random();


    //constructor

    public Enemy(BufferedImage image, int x, int y, int width, int height, int velocityX, int velocityY) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
    }

    public void run(int windowWidth, int windowHeight,int playerPosX, int playerPosY){
        boolean outX= false, outY= false;
        this.chase(playerPosX, playerPosY);

        if(this.x + this.velocityX <=0){
            this.x = windowWidth;
            outX = true;
        }
        else if(this.x + this.velocityX >= windowWidth){
            this.x =0;
            outX = true;
        }

        if(this.y + this.velocityY <=0){
            this.y = windowHeight;
            outY = true;
        }
        else if(this.y +this.velocityY >= windowHeight){
            this.y =0;
            outY = true;
        }

        if(!outX && !outY){
            this.x += this.velocityX;
            this.y += this.velocityY;
        }
        else if (outX && !outY){
            this.y = rand.nextInt(windowHeight);
        }
        else if(outY && !outX){
            this.x = rand.nextInt(windowWidth);
        }

    }
    public void chase(int playerPosX, int playerPosY){
        if(playerPosX == this.x && playerPosY ==this.y){
            this.velocityX =0;
            this.velocityY =0;
        }
        else if(playerPosX == this.x){
            this.velocityX =0;
            this.velocityY = (playerPosY - this.y)/Math.abs(playerPosY - this.y) *(rand.nextInt(2) +2);
        }
        else if(playerPosY == this.y){
            this.velocityY =0;
            this.velocityX = (playerPosX - this.x)/Math.abs(playerPosX - this.x) *(rand.nextInt(2) +2);
        }
        else{
            this.velocityY = (playerPosY - this.y)/Math.abs(playerPosY - this.y) *(rand.nextInt(2) +2);
            this.velocityX = (playerPosX - this.x)/Math.abs(playerPosX - this.x) *(rand.nextInt(2) +2);
        }

    }

    public void render(Graphics graphics){
        graphics.drawImage(this.image, this.x, this.y,this.width,this.height,null);
    }
}