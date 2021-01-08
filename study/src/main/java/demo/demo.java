package demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
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
        Map<Integer, String> map = new HashMap<Integer, String>(2);

        map.put(1, "hello");
        map.put(2, "world");
        map.put(3, "HELLOWORLD");

        System.out.println(map);

        String ret = "%s于%s，在“开盘侠区块链购房摇号系统”认购%s，建面%s方、总价%s万元。";
        String rr = String.format(ret, "张三", "时间点", "房间名称", "100.32", "345.66");

        System.out.println(rr);

        double a = 13.245;
        BigDecimal bd = new BigDecimal(a);
        Double b = bd.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(b);


        for (int i = 0; i < 2; i++) {
            String format = String.format("%06d", i);
            System.out.println(format);
        }


        System.out.println(Integer.parseInt("000000002"));

    }
}
