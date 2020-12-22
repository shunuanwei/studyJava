package demo.hongbao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class divide {

    public static void main(String[] args) {
        double random = Math.random();
        System.out.println(doubleMeanMethod(100, 10));
    }


    private static List<Double> doubleMeanMethod(double money, int number) {
        double temp = money;
        List<Double> result = new ArrayList<Double>();
        if (money < 0 && number < 1) {
            return null;
        }
        double amount, sum = 0;
        int remainingNumber = number;
        int i = 1;
        while (remainingNumber > 1) {
            amount = nextDouble(0.01, 2 * (money / remainingNumber));
            //发放红包金额
            String format = format(amount);
            sum += new Double(format);
            System.out.println("第" + i + "个人领取的红包金额为：" + format);
            money -= amount;
            remainingNumber--;
            result.add(amount);
            i++;
        }
        /*
         * result.add(money);
         */
        double last = temp - sum;
        result.add(last);
        System.out.println("第" + i + "个人领取的红包金额为：" + format(last));
        sum += money;
        System.out.println("验证发出的红包总金额为：" + format(sum));
        return result;
    }

    private static double nextDouble(final double min, final double max) {
        double v = new Random().nextDouble();
        double temp = max - min;
        double r = temp * v;
        double ret = min + r;
        return ret;
    }

    private static String format(double value) {
        // 保留两位小数
        String format = new DecimalFormat("0.00").format(value);
        return format;
    }

}


