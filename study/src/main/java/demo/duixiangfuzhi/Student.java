package demo.duixiangfuzhi;



/**
 * @author weish
 */
public class Student extends Persion {
    private String className;
    private Double points;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }


    public static Builder builder(){
        return new Builder();
    }

    public static class Builder{
        private String name;

        private int age;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Student build() {
            Student studentBean = new Student();
            studentBean.setName(name);
            studentBean.setAge(age);
            return studentBean;
        }
    }
}
