import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class EnemyLevel1  {
    public Vector2D position ;
    public Vector2D velocity;
    public int width;
    public int height;
    public BufferedImage image;
    public List<BulletEnemy> bulletEnemies;
    private int timeIntervalBullet=0;
    public Renderer renderer;
    public EnemyLevel1() { // constructer alt+fn+insret
        position = new Vector2D();
        velocity = new Vector2D();
        this.bulletEnemies =new ArrayList<>();
        renderer=new ImageRenderer(
                "resources-rocket-master/resources/images/star.png",
                this.width=50,
                this.height=50
        );
    }
    public void run(Vector2D playerPosition){
        updateVelocity(playerPosition);
        this.velocity=this.velocity.multiply(2f);
        this.position.addUp(velocity);
        // this.shoot();
    }
    public void updateVelocity(Vector2D playerPosition){
        this.velocity.set(playerPosition.subtract(this.position));
        this.velocity=this.velocity.normal();
    }
    public void shoot(){
        if(this.timeIntervalBullet==100){
            BulletEnemy bulletEnemy = new BulletEnemy();
//            try{
//                bulletEnemy.image= ImageIO.read((new File( "resources-rocket-master/resources/images/circle.png")));
//            }catch (IOException e){
//                e.printStackTrace();
//            }
            bulletEnemy.position.set(this.position);
            bulletEnemy.velocity.set(15,0);
            this.bulletEnemies.add(bulletEnemy);
            this.timeIntervalBullet=0;
        }else
            this.timeIntervalBullet++;
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.run());
    }
    public void render(Graphics graphics){
        this.renderer.render(graphics,this.position);
        this.bulletEnemies.forEach(bulletEnemy -> bulletEnemy.render(graphics));
    }

}
