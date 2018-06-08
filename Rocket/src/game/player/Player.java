package game.player;

import base.GameObject;
import base.GameObjectManager;
import base.Vector2D;
import game.enemy.Enemy;
import physic.BoxCollider;
import renderer.PolygonRenderer;

import java.awt.*;

public class Player extends GameObject {
    public PlayerMove playerMove;
    public PlayerShoot playerShoot;
    public boolean shooting = false;

    public Player() {
        this.position = new Vector2D();
        this.renderer = new PolygonRenderer(
                Color.RED,
                new Vector2D(),
                new Vector2D(0, 16),
                new Vector2D(20, 8)
        );
        this.playerMove = new PlayerMove();
        this.playerShoot = new PlayerShoot();
        this.boxCollider = new BoxCollider(16, 20);
    }

    @Override
    public void run() {
        super.run();
        this.playerMove.run(this);
        if (shooting) this.playerShoot.run(this);
        ((PolygonRenderer) this.renderer).angle = this.playerMove.angle;
        this.boxCollider.position.set(this.position.x - 3, this.position.y - 3);
        Enemy enemy = GameObjectManager.instance.checkCollision(this);
        if (enemy != null) {
            enemy.isAlive = false;
            this.isAlive = false;
        }
    }
}
