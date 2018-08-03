import java.awt.*;
import java.awt.image.BufferedImage;

public class Background {
    public Vector2D position;
    public Renderer renderer;
    public Background() {
        position=new Vector2D();
        renderer=new BackgroundRenderer(
                Color.BLACK,
                1024,
                600
        );
    }
    public void render(Graphics graphics){
        renderer.render(graphics,position);
    }
}
