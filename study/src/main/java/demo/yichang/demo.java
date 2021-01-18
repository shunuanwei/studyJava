package demo.yichang;

public class demo {


    public static void main(String[] args) {
        System.out.println(step1(0));
    }


    private static boolean step1(int i) {
        try {
            return 0 == 2 / step2(i);
        } catch (Exception e) {
            System.out.println("s 1 异常");
            return false;
        }

    }

    private static int step2(int i) {
        try {
            return i % 0;
        } catch (Exception e) {
            System.out.println("s 2  异常了");
            return 0;
        }
    }
}


