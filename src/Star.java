import java.awt.*;

import java.awt.image.BufferedImage;

public class Star {
    public BufferedImage image; // mac dinh ko khai bao truy xuat thi la publi
    public Vector2D position;
    public int width;
    public int height;
    public Vector2D velocity;
    public Renderer renderer;
    public Star() { // constructer alt+fn+insret
        this.position = new Vector2D();
        this.velocity = new Vector2D();
        this.renderer= new ImageRenderer(
                "resources-rocket-master/resources/images/star.png",
                this.width=5,
                this.height=5
        );
    }

    public void run() {
        this.position.subtractBy(this.velocity);
    }

    public void render(Graphics graphics) {
            this.renderer.render(graphics,position);
    }
}
