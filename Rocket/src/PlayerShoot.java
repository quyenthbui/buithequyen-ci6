import java.util.ArrayList;
import java.util.List;

public class PlayerShoot {
    public List<Bullet> bulletPlayers;
    private FrameCounter frameCounter;

    public PlayerShoot() {
        this.frameCounter = new FrameCounter(40);
        this.bulletPlayers = new ArrayList<>();
    }

    public void run(Player player) {
        if (this.frameCounter.run()) {
            Bullet bulletPlayer = new Bullet();
            bulletPlayer.position.set(player.position);

            Vector2D rotate = player.playerMove.velocity.add(
                    (new Vector2D(2, 0)).rotate(player.playerMove.angle)
            );

            bulletPlayer.velocity.set(rotate);
            this.bulletPlayers.add(bulletPlayer);
            this.frameCounter.reset();
        }
    }
}