//if(x[0]<0){
//            y[0]=random.nextInt(500);
//            x[0]= 950;
//        }
//        if(x[0]>950){
//            y[0]=random.nextInt(500);
//            x[0]=0;
//        }
//        if(y[0]>500){
//            y[0]= 0;
//            x[0]= random.nextInt(950);
//        }
//        if(y[0]<0){
//            x[0]=random.nextInt(950);
//            y[0]= 500;
//        }

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player {
    // public BufferedImage image; // mac dinh ko khai bao truy xuat thi la publi
    public Vector2D position ;
    public Vector2D velocity;
    public List<BulletPlayer> bulletPlayers;
    private Random random=new Random();
    public Renderer renderer;
    public double angle=0;
    public PlayerShoot playerShoot;
    public Player() { // constructer alt+fn+insret
        position=new Vector2D();
        velocity=new Vector2D();
//        this.vectices = Arrays.asList(
//                new Vector2D(),
//                new Vector2D(0,16),
//                new Vector2D(20,8)
//        );
        this.bulletPlayers =new ArrayList<>();
        this.renderer=new PolygonRenderer(Color.blue,
                new Vector2D(),
                new Vector2D(0,16),
                new Vector2D(20,8)
        );
        this.playerShoot=new PlayerAttack();
    }
    public void run(){
        this.position.addUp(this.velocity);
        //this.shoot();
        if(this.position.x<0){
            this.position.y=random.nextInt(600);
            this.position.x=1024;
        }
        if(this.position.x>1024){
            position.y=random.nextInt(500);
            position.x= 0;
        }
        if(position.y>600){
            this.position.y= 0;
            this.position.x= random.nextInt(1024);
        }
        if(this.position.y<0){
            this.position.x=random.nextInt(1024);
            this.position.y= 600;
        }
        ((PolygonRenderer) this.renderer).angle=this.angle;
        this.playerShoot.shoot(this);
        // xu ly player shoot
    }

    public void render(Graphics graphics){
        this.renderer.render(graphics, this.position);
        ((PlayerAttack) this.playerShoot)
                .bulletPlayers
                .forEach(bulletPlayer -> bulletPlayer.render(graphics));
    }
//    public void shoot(){
//        if(this.timeIntervalBullet==50){
//            BulletPlayer bulletPlayer = new BulletPlayer();
//            try{
//                bulletPlayer.image=ImageIO.read((new File( "resources-rocket-master/resources/images/circle.png")));
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//            bulletPlayer.position.set(this.position);
//            bulletPlayer.velocity.set(this.velocity.copy().multiply(1.5f));
//            this.bulletPlayers.add(bulletPlayer);
//            this.timeIntervalBullet=0;
//        }else
//            this.timeIntervalBullet++;
//        this.bulletPlayers.forEach(bulletPlayer -> bulletPlayer.shoot());
//    }
    //private void backToScreen()
}









