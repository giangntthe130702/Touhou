package game;

import game.player.Player;
import game.player.PlayerBullet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class GameObject {
    // Manage Object (static)
    public static ArrayList<GameObject> objects = new ArrayList<>();

    public static <E extends GameObject> E recycles(Class<E> cls){
        // 1. Tim phan tu bi deactive >> neu tim thay reset phan tu >> tra ve
        // 2. Neu ko tim thay phan tu deactive >> tao moi
        E object = findInactive(cls);
        if (object != null) {
            object.reset();
            return object;
        }
        try{
            object = cls.getConstructor().newInstance();
            return object;
        }
        catch (Exception ex){
            ex.printStackTrace();
            return null;
        }
    }


    public static <E extends GameObject> E findInactive(Class<E> cls){
        // cls = BackGround.class or Player.class
        // E = Player or BackGround

        for(int i=0;i<objects.size();i++){
            GameObject object = objects.get(i);
            // object kiem tra dung cls ko ?;
            // object.active == false Check;
            if(cls.isAssignableFrom(object.getClass()) && !object.active){
                return (E)object; // (E) la ep kieu du lieu
            }
        }
        return null;
    }

    // Ví dụ
    /* public static void main(String[] args) {
        Player deActivatedPlayer = findInactive(Player.class);
        PlayerBullet deActivatedBullet = findInactive(PlayerBullet.class);
    } */

    // Object define
    public BufferedImage image; // null
    public Vector2D position;
    public boolean active;

    public GameObject(){
        objects.add(this);
        System.out.println(objects.size());
        position = new Vector2D(); // default position(0,0);
        active = true;
    }

    public void render(Graphics g){
        if (image != null){
            g.drawImage(image, (int) position.x, (int)position.y, null);
        }
    }

    public void run(){

    }

    public void deactive(){
        active = false;
    }

    public void reset(){
        active = true;
    }
}
