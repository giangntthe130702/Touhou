package game.player;

import game.BoxCollider;
import game.GameObject;
import game.Vector2D;
import game.enemy.Enemy;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject { // PlayerBulletType2
//    BufferedImage image;
//    Vector2D position;

//    public Vector2D velocity;

    public int damage;

    public PlayerBullet() {
        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
//        position = new Vector2D();
//            velocity = new Vector2D(0,-3);  vector thang dung
        velocity.set(0,-3);
//            velocity.setAngle(-Math.PI / 4);
//            velocity.setAngle(Math.toRadians(-45));     chuyen ra goc
        hitBox = new BoxCollider(this,24,24);
        damage = 1;
    }


    @Override
    public void run() {
        // bay tu duoi len
//        position.y -= 4;
//        position.add(velocity.x, velocity.y);         extends GameObject()
        super.run();
        this.deactiveIfNeeded();
        this.checkEnemy();

    }

    private void checkEnemy() {
        Enemy enemy = GameObject.findIntersects(Enemy.class, hitBox);
        if (enemy != null){
//            enemy.deactive();
            enemy.takeDamage(damage);
            this.deactive();
        }
    }

    private void deactiveIfNeeded() {
        if(position.y < -30){
            this.deactive();
        }
    }
}
