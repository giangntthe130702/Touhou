package game;

import tklibs.SpriteUtils;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Background  extends  GameObject{
//    BufferedImage image;                                                      extends GameObject
////    Vector2D position;

    public Background() {
        image = SpriteUtils.loadImage("assets/images/background/0.png");
//        position = new Vector2D(0, 600 - 3109);
        position.set(0, 600-3109);
    }

//    public void render(Graphics g) {                                          extends GameObject
//        g.drawImage(image, (int) position.x, (int) position.y, null);
//    }

    @Override
    public void run() {
        position.y+=2;
        if(position.y >= 0) {
            position.y = 0;
        }
    }
}
