package demo.interfaceAndAbstract;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weish
 */
public class Dome {


    public static void main(String[] args) {
//        Cat cat = new Cat();
//        cat.name = "hello cat";
//
//        cat.call();
//        System.out.println(cat.name);
//        cat.run("小叮当");


//        Cat cat1 = null;
//        cat1.setLeg("hello");
//        System.out.println(cat1.toString());

//        List<Integer> list  = new ArrayList<Integer>();
//
//        list.add(2);
//        list.add(3);
//
//        System.out.println(list.indexOf(1));




        List<Integer> temp = new ArrayList<Integer>();
        System.out.println(temp);
        System.out.println(temp.size());
        System.out.println(temp == null);

        List<Integer> rop = null;
        System.out.println(rop);
//        System.out.println(rop.size());
        System.out.println(rop == null);
    }

}
