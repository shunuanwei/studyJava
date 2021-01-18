package demo.stream;

import java.util.ArrayList;
import java.util.List;

public class demo1 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(3);
        list.add(4);
        list.add(5);


        list.stream().map(value -> value * 2).forEach( value -> {
            if (value > 10){
                System.out.println(value);
            }else {
                System.out.println(value);
            }
        });

    }
}
