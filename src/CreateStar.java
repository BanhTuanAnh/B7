import java.util.ArrayList;
import java.util.Random;

public class CreateStar implements Creater {
    private int timeIntervalStar;
    private Random random;
    public CreateStar(){
        random=new Random();
        timeIntervalStar=0;
    }
    @Override
    public void createStar(ArrayList<Star> stars) {
        if(this.timeIntervalStar==20){
            Star star=new Star();
            star.position.set(1024,this.random.nextInt(600));
            star.height=5;
            star.width=5;
            //   star.image=this.loadImage("resources-rocket-master/resources/images/star.png");
            star.velocity.set(random.nextInt(10)+1,0);
            stars.add(star);
            this.timeIntervalStar=0;
        }else{
            this.timeIntervalStar++;
        }
    }

    @Override
    public void createEnemy(ArrayList<Enemy> enemies) {

    }

    @Override
    public void createEnemyLevel1(ArrayList<EnemyLevel1> enemyLevel1s) {

    }
}
