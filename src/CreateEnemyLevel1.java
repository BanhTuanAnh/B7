import java.util.ArrayList;
import java.util.Random;

public class CreateEnemyLevel1 implements Creater {
    private int timeIntervalEnemyLevel1;
    private Random random;
    public CreateEnemyLevel1(){
        random=new Random();
        timeIntervalEnemyLevel1=0;
    }

    @Override
    public void createStar(ArrayList<Star> stars) {

    }

    @Override
    public void createEnemy(ArrayList<Enemy> enemies) {

    }

    @Override
    public void createEnemyLevel1(ArrayList<EnemyLevel1> enemyLevel1s) {
        if(this.timeIntervalEnemyLevel1==100){
            EnemyLevel1 enemyLevel1=new EnemyLevel1();
            enemyLevel1.position.x=40;
            enemyLevel1.position.y=this.random.nextInt(590);
            //      enemyLevel1.image=this.loadImage("resources-rocket-master/resources/images/star.png");
            enemyLevel1.velocity.x=random.nextInt(10);
            enemyLevel1.velocity.y=enemyLevel1.velocity.x;
            enemyLevel1.width=random.nextInt(20)+10;
            enemyLevel1.height=enemyLevel1.width;
            enemyLevel1s.add(enemyLevel1);
            this.timeIntervalEnemyLevel1=0;
        }
        else{
            this.timeIntervalEnemyLevel1++;
        }
    }
}
