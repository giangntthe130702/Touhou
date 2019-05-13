package game.player;

import game.GameObject;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public Enemy(){
        image = SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png");
        position.set(100,100);
    }


}
