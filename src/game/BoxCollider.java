package game;

import javax.swing.*;
import java.awt.*;

public class BoxCollider {
    public Vector2D position;
    public int width;
    public int height;

    public BoxCollider(GameObject master, int width, int height) {
        this.position = master.position;
        this.width = width;
        this.height = height;
    }

//    public BoxCollider(double x, double y, int width, int height) {
//        this.position = new Vector2D(x, y);
//        this.width = width;
//        this.height = height;
//    }


    public double top() {
        return position.y;
    }

    public double bot() {
        return this.top() + this.height;
    }

    public double left() {
        return position.x;
    }

    public double right() {
        return this.left() + this.width;
    }


    /**
     * @param other: the rectangle need to check intersects with this rectangle
     * @return
     */
    // Chua HW3
    public boolean intersects(BoxCollider other) {
//         TODO: 1. remove default return statement and fill logic check intersects 'this' and 'other'
//
//        if ((this.bot() >= other.top()) && (this.right() >= other.left()) && (this.left() <= other.right())){
//            return true;
//        }
//
//        if ((this.top() <= other.bot()) && (this.right() >= other.left()) && (this.left() <= other.right())){
//            return true;
//        }
//
//        return false;

        return other.bot() >= this.top() &&
                other.top() <= this.bot() &&
                other.left() >= this.left() &&
                other.right() <= this.right();
    }

}

//    public static void main(String[] args) {
////        // TODO: 2. Run this file to test the result
//        BoxCollider rect1 = new BoxCollider(0,0,5,5);
//        BoxCollider rect2 = new BoxCollider(3, 3, 5,5);
//        BoxCollider rect3 = new BoxCollider(6,6,5,5);
//
//        System.out.println(rect1.intersects(rect2) + " - " + true);
//        System.out.println(rect2.intersects(rect3) + " - " + true);
//        System.out.println(rect1.intersects(rect3) + " - " + false);
////        // the result must be:
////        // true - true
////        // true - true
////        // false - false
//    }


