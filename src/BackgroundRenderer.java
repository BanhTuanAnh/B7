import java.awt.*;

public class BackgroundRenderer implements Renderer {
    private Color color;
    private int width;
    private int height;
    public BackgroundRenderer(Color color,int width,int height) {
        this.width=width;
        this.height=height;
        this.color = color;
    }

    @Override
    public void render(Graphics graphics, Vector2D position) {
        graphics.setColor(this.color); // set mau
        graphics.fillRect((int)position.x,(int)position.y,this.width,this.height);  // set hinh dang x, y , width,height
    }
}
