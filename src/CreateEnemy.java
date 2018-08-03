import java.util.ArrayList;
import java.util.Random;

public class CreateEnemy implements Creater {
    private int timeIntervalEnemy;
    private Random random;
    public CreateEnemy(){
        timeIntervalEnemy=0;
        random=new Random();
    }
    @Override
    public void createStar(ArrayList<Star> stars) {

    }

    @Override
    public void createEnemy(ArrayList<Enemy> enemies) {
        if(this.timeIntervalEnemy==100){
            Enemy enemy=new Enemy();
            enemy.position.x=1020;
            enemy.position.y=this.random.nextInt(590);
            //     enemy.image=this.loadImage("resources-rocket-master/resources/images/circle.png");
            enemy.velocity.x=random.nextInt(10);
            enemy.velocity.y=enemy.velocity.x;
            enemy.width=random.nextInt(20)+10;
            enemy.height=enemy.width;
            enemies.add(enemy);
            this.timeIntervalEnemy=0;
        }
        else{
            this.timeIntervalEnemy++;
        }
    }

    @Override
    public void createEnemyLevel1(ArrayList<EnemyLevel1> enemyLevel1s) {

    }
}
