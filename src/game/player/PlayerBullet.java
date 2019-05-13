package game.player;

import game.GameObject;
import game.Vector2D;
import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerBullet extends GameObject { // PlayerBulletType2
//    BufferedImage image;
//    Vector2D position;

    public PlayerBullet() {
        image = SpriteUtils.loadImage("assets/images/player-bullets/a/1.png");
        position = new Vector2D();
    }


    @Override
    public void run() {
        // bay tu duoi len
        position.y -= 4;
        this.deactiveIfNeeded();

    }

    private void deactiveIfNeeded() {
        if(position.y < -30){
            this.deactive();
        }
    }
}
