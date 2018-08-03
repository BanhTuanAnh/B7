import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameCanvas extends JPanel {// van la class tach roi chua dc dua vafo window
    //cach dat ten bien
    //snake case user_name
    //camel case: userName
    private Graphics graphics;
    private BufferedImage backBuffered;
    private List<Star> stars;
    private List<Enemy> enemies;
    private List<EnemyLevel1> enemyLevel1s;
    public Player player;
    public Background background;
    public int timeIntervalStar=0;
    public int timeIntervalEnemy=0;
    public int timeIntervalEnemyLevel1=0;
    private Random random=new Random();
    private Creater createrStar;
    private Creater createrEnemy;
    private Creater createrEnemyLevel1;
    public GameCanvas(){
        this.setSize(1024,600);
        this.setUpBackBuffered();
        this.setUpBackground();
        this.setCharacter();
        createrStar=new CreateStar();
        createrEnemyLevel1=new CreateEnemyLevel1() ;
        createrEnemy=new CreateEnemy();
    }
    @Override
    protected void paintComponent(Graphics g) {// noi ve tat ca moi thu
        g.drawImage(this.backBuffered,0,0,null);        // ve
    }
    private void playerRun(){
        this.player.run();
    }
    private void enemyLevel1Run(){this.enemyLevel1s.forEach(enemyLevel1 -> enemyLevel1.run(this.player.position));}
    private void enemyRun(){
        this.enemies.forEach(enemy -> enemy.run());
    }
    private void starRun(){
        this.stars.forEach(star -> star.run());
    }
    public void runAll(){
        this.enemyRun();
        this.enemyLevel1Run();
        this.starRun();
        this.playerRun();
    }
    public void createAll(){
        this.createStar();
        this.createEnemy();
        this.createEnemyLevel1();
    }
    public void renderAll(){
        //1 ve nen
        this.background.render(graphics);
        this.stars.forEach(star ->star.render(graphics));
        this.enemyLevel1s.forEach(enemyLevel1 -> enemyLevel1.render(graphics));
        this.enemies.forEach(enemy -> enemy.render(graphics));
        this.player.render(graphics);
        this.repaint();// goi luon ham ve laij man hinh trong renderAll
    }
    private void createEnemyLevel1(){
        createrEnemyLevel1.createEnemyLevel1((ArrayList<EnemyLevel1>) enemyLevel1s);
    }
    private void createEnemy(){
        createrEnemy.createEnemy((ArrayList<Enemy>) enemies);
    }
    private  void createStar(){
        createrStar.createStar((ArrayList<Star>) stars);
    }
    private void setUpBackground(){ this.background=new Background(); }
    private void setUpEnemies(){
        this.enemies=new ArrayList<>();
    }
    private void setUpEnemyLevel1(){this.enemyLevel1s=new ArrayList<>();}
    private void setUpStar(){
        this.stars=new ArrayList<>();
    }
    private void setUpBackBuffered(){
        this.backBuffered=new BufferedImage(1024,600,BufferedImage.TYPE_INT_ARGB);
        this.graphics=this.backBuffered.getGraphics();// co ve sex ve len backbuffer
    }
    private  void setUpPlayer(){
        this.player=new Player();
        this.player.position.set(100,200);
        this.player.velocity.set(3.5f,0);
    }
    private void setCharacter(){
        this.setUpStar();
        this.setUpEnemies();
        this.setUpEnemyLevel1();
        this.setUpPlayer();
    }
}
