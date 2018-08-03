import java.awt.*;
import java.awt.image.BufferedImage;

public interface Renderer {
    void render (Graphics graphics, Vector2D position);
  //  void shoot ();
  // void imageRenderer(Graphics graphics, BufferedImage image, Vector2D position, int width, int height);
}
