package demo.duixiangfuzhi;
import org.springframework.beans.BeanUtils;

public class demo {


    /**
     * 对象赋值
     * @param args
     */
    public static void mai1n(String[] args) {
        Persion p = new Persion();
        p.setAge(12);
        p.setName("小明");

        Student s = new Student();
        s.setClassName("一年级一班");
        s.setPoints(90.0);

        BeanUtils.copyProperties(p,s);

        System.out.println("P==="+p.toString());
        System.out.println("S==="+s.getName());
        System.out.println("S==="+s.getAge());
        System.out.println("S==="+s.getClassName());
        System.out.println("S==="+s.getPoints());
    }

    public static void main(String[] args) {
//        Student student = new Student();
//
//        student.setName("张三");
//        student.setAge(23);
//
//        fatherUsed(student);
//
//
//        Student build = Student.builder().age(11).build();
//
//        System.out.println(Double.parseDouble("0"));
//
//        double v = Double.parseDouble("0");
//        System.out.println(v == 0.0);


        System.out.println(Integer.parseInt("1.1"));
    }


    /**
     * 继承之后的,对象使用
     */
    private static void fatherUsed(Persion  persion){
        System.out.println(persion.toString());
    }
}
