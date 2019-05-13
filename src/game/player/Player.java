package game.player;

import game.GameObject;
import game.KeyEventPress;
import game.Vector2D;
import tklibs.Mathx;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends GameObject {
//    BufferedImage image;                                              extends GameObject
//    Vector2D position;
//    ArrayList<PlayerBullet> playerBullets;

    public Player() {
        image = SpriteUtils.loadImage("assets/images/players/straight/0.png");
//        position = new Vector2D(200, 500);  Extends GameObject;
        position.set(200,500);
//        playerBullets = new ArrayList<>(); // playerBullets = 1 mảng rỗng
//        playerBullets.add()
//        playerBullets.remove()
//        playerBullets.size()
//        playerBullets.get()
    }



    int count = 0; // dem so khung hinh

    @Override
    public void run() { // 60 fps >> 60 vien dan dc tao ra 1s >> 3 vien duoc tao ra 1s
        // di chuyen
        this.move();

        // gioi han vi tri
        this.limitPosition();

        // ban dan
        this.fire();
        System.out.println(GameObject.objects.size());
        // playerBullets run()


    }



    private void fire() {
        count++;
        if(KeyEventPress.isFirePress && count > 20) {
//            PlayerBullet bullet = new PlayerBullet();
            PlayerBullet bullet = GameObject.recycles(PlayerBullet.class);
            bullet.position.set(this.position.x, this.position.y);
//            playerBullets.add(bullet);

//            PlayerBullet bullet2 = new PlayerBullet();
            PlayerBullet bullet2 = GameObject.recycles(PlayerBullet.class);
            bullet2.position.set(this.position.x - 10, this.position.y);
//            playerBullets.add(bullet2);

//            PlayerBullet bullet3 = new PlayerBullet();
            PlayerBullet bullet3 = GameObject.recycles(PlayerBullet.class);
            bullet3.position.set(this.position.x + 10, this.position.y);
//            playerBullets.add(bullet3);

            count = 0;
        }
    }

    private void limitPosition() {
        position.x = Mathx.clamp(position.x, 0, 384 - 32);
        position.y = Mathx.clamp(position.y, 0, 600 - 48);
    }

    private void move() {
        if(KeyEventPress.isUpPress) {
            position.y-=4;
        }
        if(KeyEventPress.isLeftPress) {
            position.x-=4;
        }
        if(KeyEventPress.isRightPress) {
            position.x+=4;
        }
        if(KeyEventPress.isDownPress) {
            position.y+=4;
        }
    }
}
