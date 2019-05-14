package game;

import game.enemy.Enemy;
import game.enemy.EnemySummoner;
import game.player.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    Player player;
    Background background;
//    Enemy enemy;
    EnemySummoner e;
    // game.player.PlayerBullet bullet;
    // ArrayList: add(), remove(), size(), get()

    public GamePanel() {

        background = new Background();
        player = new Player();
//        enemy = new Enemy();
        e = new EnemySummoner();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for(int i = 0; i < GameObject.objects.size(); i++){
            GameObject object = GameObject.objects.get(i);
            if(object.active) {
                object.render(g);
            }
        }

        g.setColor(Color.CYAN);
        g.fillRect(384, 0, 416, 600);

//        background.render(g);
//        player.render(g);
    }

    public void gameLoop() {
        long lastTime = 0;
        while (true) {
            long currentTime = System.currentTimeMillis();
            if (currentTime - lastTime > 1000 / 60) {
                // run logic
                this.runAll();
                // render
                this.repaint();
                lastTime = currentTime;
            }
        }
    }

    public void runAll() {
        /* // player run
        player.run();
        // background run
        background.run(); */
        for(int i = 0; i < GameObject.objects.size(); i++){
            GameObject object = GameObject.objects.get(i);
            if(object.active) {
                object.run();
            }
        }
    }
}
