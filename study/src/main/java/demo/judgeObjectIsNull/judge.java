package demo.judgeObjectIsNull;

import demo.duixiangfuzhi.Persion;
import demo.thisandsuper.Animal;

import java.lang.reflect.Field;
import java.util.Objects;

public class judge {


    public static void main(String[] args) {

        Persion p = new Persion();

        p.setAge(12);
        p.setName("123");
        System.out.println(allFieldIsNotNull(p));

    }


    private static boolean allFieldIsNotNull(Object o) {
        try {
            Field[] var1 = o.getClass().getDeclaredFields();
            int var2 = var1.length;

            for (int var3 = 0; var3 < var2; ++var3) {
                Field field = var1[var3];
                field.setAccessible(true);
                Object object = field.get(o);
                if (Objects.isNull(object)) {
                    return false;
                }
            }
            return true;
        } catch (Exception var6) {
            var6.printStackTrace();
            return false;
        }
    }
}
