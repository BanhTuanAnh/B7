import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

public class PolygonRenderer implements Renderer {
    private Polygon polygon;
    private List<Vector2D> vectices;
    public double angle=0;
    private Color color;
    public PolygonRenderer(Color color, Vector2D... vertices) { // cach truyen khac cha co gi dac biet
        this.polygon = new Polygon();
        this.color=color;
        this.vectices= Arrays.asList(
                new Vector2D(),
                new Vector2D(0,16),
                new Vector2D(20,8));
    }

    public void updateTriangle(Vector2D position){
        this.polygon.reset();
        Vector2D center = this.vectices
                .stream()
                .reduce(new Vector2D(),((vector2D, vector2D2) ->vector2D.add(vector2D2) ))
                .multiply(1.0f/(float) this.vectices.size())
                .rotate(angle);// tinh vetoe GG'
        Vector2D translate = position.subtract(center);
//        List<Vector2D> list = new ArrayList<>();
//        this.vectices.forEach(vector2D ->list.add(vector2D.add(translate)));
        this.vectices
                .stream()
                .map(vector2D -> vector2D.rotate(angle))
                .map(vector2D -> vector2D.add(translate))
                .forEach(vector2D -> polygon.addPoint((int) vector2D.x,(int) vector2D.y));//keo 3 dinh ra vi tri can tinh

    }
    @Override
    public void render(Graphics graphics,Vector2D position) {
        graphics.setColor(this.color);
        this.updateTriangle(position);
        graphics.fillPolygon(this.polygon);
      //  this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }

}
