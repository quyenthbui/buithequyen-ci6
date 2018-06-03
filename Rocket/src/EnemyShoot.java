import java.util.ArrayList;
import java.util.List;

public class EnemyShoot {
    public List<Bullet> bulletEnemies;
    private FrameCounter frameCounter;

    public EnemyShoot() {
        this.frameCounter = new FrameCounter(50);
        this.bulletEnemies = new ArrayList<>();
    }

    public void run(Enemy enemy) {
        if (this.frameCounter.run()) {
            for (double angle = 0.0; angle <= 360.0; angle += 15.0) {
                Bullet bulletEnemy = new Bullet();
                bulletEnemy.position.set(enemy.position);
                bulletEnemy.velocity.set((new Vector2D(3, 0)).rotate(angle));
                this.bulletEnemies.add(bulletEnemy);
            }
            this.frameCounter.reset();
        }
    }
}