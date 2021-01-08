package demo.face;

public class sx {


    public static void move(int n, String a, String b, String c) {
        if (n == 1) {
            System.out.println(a + "-->" + c);
        } else {
            move(n - 1, b,c,a);
            move(n - 1, a, b, c);
            move( 1, c, b, a);
        }
    }

    public static void main(String[] args) {
        move(3, "a", "b", "c");
    }
}
