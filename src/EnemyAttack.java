import java.util.ArrayList;
import java.util.List;

public class EnemyAttack implements EnemyShoot {
    public List<BulletEnemy> bulletEnemies;
    private int timeIntervalBullet;

    public EnemyAttack() {
        this.bulletEnemies = new ArrayList<>();
        this.timeIntervalBullet = 0;
    }

    @Override
    public void shoot(Enemy enemy) {
        if(this.timeIntervalBullet==50){
            int numberBullet=6;
            Vector2D tempVelocity=new Vector2D();
            tempVelocity.set(2,0);
            for (int angle = 0; angle < 360; angle+=360/numberBullet) {
                    BulletEnemy bulletEnemy = new BulletEnemy();
                    bulletEnemy.position.set(enemy.position);
                    bulletEnemy.velocity.set(new Vector2D(2,0).rotate(angle));

                    bulletEnemies.add(bulletEnemy);
            }
            this.timeIntervalBullet=0;
        }else
            this.timeIntervalBullet++;
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }
}
