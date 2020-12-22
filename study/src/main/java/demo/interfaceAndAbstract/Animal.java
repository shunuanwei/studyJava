package demo.interfaceAndAbstract;

/**
 * @author weish
 */
abstract class Animal implements RunInter {

    String name;

    void call(){
        System.out.println("I can call ---");
    }
}
