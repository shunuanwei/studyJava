package demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class demo {

    public static void m1ain(String[] args) {
        System.out.println(Math.random());
        Random random = new Random();
        double v = random.nextDouble();
        System.out.println(v);
        int i = random.nextInt();
        System.out.println(i);
    }


    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<Integer, String>(2);

        map.put(1,"hello");
        map.put(2,"world");
        map.put(3,"HELLOWORLD");

        System.out.println(map);

    }
}
