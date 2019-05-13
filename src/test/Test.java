package test;

import game.Vector2D;

import java.util.ArrayList;
import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        ArrayList<Vector2D> vectors = new ArrayList<>();
        // add(), remove(), size(), get()
        vectors.add(new Vector2D(1,1));
        vectors.add(new Vector2D(3,4));
        vectors.add(new Vector2D(5,9));
        vectors.add(new Vector2D(2,8));
        vectors.add(new Vector2D(4,7));
        vectors.add(new Vector2D(6,2));


        double maxTotal = 0;
        int indexMax = 0;
        for (int i = 0; i< vectors.size(); i++){
            Vector2D vector = vectors.get(i);
            if (vector.x + vector.y > maxTotal){
                maxTotal = vector.y + vector.x;
                indexMax = i;
            }
        }
        System.out.println(vectors.get(indexMax).x + " " + vectors.get(indexMax).y);

//        for(Vector2D vector : vectors){
//            System.out.println(vector.x + " " + vector.y);
//        }

    }
}
