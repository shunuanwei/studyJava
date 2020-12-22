package demo.thisandsuper;

/**
 * @author weish
 */
public class Animal {

    int eye = 2;


    Animal() {
        super();
        System.out.println("动物");
    }

    public void run() {
        System.out.println("动物有不同走路方式");
    }

    public static void main(String[] args) {
        Bird b = new Bird();
        b.run();
    }

}
