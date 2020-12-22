package demo.interfaceAndAbstract;

/**
 * @author weish
 */
public class Cat extends Animal{

    private String leg;

    public String getLeg() {
        return leg;
    }

    public void setLeg(String leg) {
        this.leg = leg;
    }

    @Override
    public void run(String string) {
        System.out.println(".Animal" + string);
    }



//    @Override
//    public void call(){
//        System.out.println(" cat can call");
//    }
}
