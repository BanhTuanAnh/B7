import java.awt.*;
import java.awt.image.BufferedImage;

public class BulletEnemy {
    public  Vector2D position;
    public Vector2D velocity;
    public Renderer renderer;
    public BulletEnemy() {
        this.position = new Vector2D();
        this.velocity = new Vector2D(2,0);
        this.renderer=new ImageRenderer(
                "resources-rocket-master/resources/images/circle.png",
                10,
                5
        );
    }
    public void run(){
        this.position .addUp(this.velocity);
    }
    public void render(Graphics graphics){
        renderer.render(graphics,this.position);
      //  graphics.drawImage(this.image, (int) this.position.x, (int) this.position.y, 10, 5, null);
    }
}
