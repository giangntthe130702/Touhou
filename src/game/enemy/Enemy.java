package game.enemy;

import game.BoxCollider;
import game.GameObject;
import tklibs.SpriteUtils;

public class Enemy extends GameObject {
    public int hp;
    public Enemy(){
        image = SpriteUtils.loadImage("assets/images/enemies/level0/blue/0.png");
        position.set(0,-50);
        velocity.set(0,1.5);
        velocity.setAngle(Math.toRadians(20));
        hitBox = new BoxCollider(this,24,24);
        hp=3;
    }

    public void takeDamage(int damage){
        hp -= damage;
        if (hp <= 0){
            hp = 0;
            this.deactive();
        }
    }
    @Override
    public void run(){
        super.run();    // giu logic velociity
        if(this.onGoingRight() && this.outOfBoundRight()){
            this.reverseVelocity();
        }

        if(this.onGoingLeft() && this.outOfBoundLeft()){
            this.reverseVelocity();
        }
        this.deactiveIfNeeded();


    }

    @Override
    public void reset() {
        super.reset(); // active = true
        position.set(0,-50);
        velocity.set(0,15);
        velocity.setAngle(Math.toRadians(20));
        hp=3;
    }

    private void deactiveIfNeeded() {
        if (position.y > 600){
            this.deactive();
        }
    }

    private boolean outOfBoundLeft() {
        return position.x < 0;
    }

    private boolean outOfBoundRight() {
        return position.x > 384 - 32;
    }

    private boolean onGoingLeft() {
        return velocity.x < 0;
    }

    private boolean onGoingRight() {
        return velocity.x > 0;
    }

    private void reverseVelocity() {
        velocity.x = - velocity.x;
    }




}
