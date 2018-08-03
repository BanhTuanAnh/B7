import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy {
    public Vector2D position ;
    public Vector2D velocity;
    public int width;
    public int height;
    public BufferedImage image;
    public EnemyShoot enemyShoot;
    public Renderer renderer;
    public Enemy() { // constructer alt+fn+insret
        position = new Vector2D();
        velocity = new Vector2D();
        this.renderer= new ImageRenderer(
                "resources-rocket-master/resources/images/circle.png",
                this.width=10,
                this.height=10
        );
        enemyShoot=new EnemyAttack();
    }
    public void run(){
        this.position.addUp(this.velocity);
        if(this.position.y<0||this.position.y>600){
            this.velocity.y=-this.velocity.y;
        }
        if(this.position.x<0||this.position.x>1024){
            this.velocity.x=-this.velocity.x;
        }
        this.enemyShoot.shoot(this);
    }
    public void render(Graphics graphics){
        this.renderer.render(graphics,this.position);
        ((EnemyAttack) this.enemyShoot)
                .bulletEnemies
                .forEach(bulletEnemy ->bulletEnemy.render(graphics));
        //this.bulletEnemies.forEach(bulletEnemies1 -> bulletEnemies1.forEach(bulletEnemy -> bulletEnemy.render(graphics)));
    }


}
