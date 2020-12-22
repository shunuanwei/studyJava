package demo.hongbao;

import java.util.Random;
import java.util.Scanner;

public class timeOrder {


	/*Random 随机生成一个区间在[min , max]的数值
	randNumber 将被赋值为一个 MIN 和 MAX 范围内的随机数
	 int randNumber =rand.nextInt(MAX - MIN + 1) + MIN; */


    /**
     * 生成min到max范围的浮点数
     **/
    private static double nextDouble(final double min, final double max) {
        double v = new Random().nextDouble();
        double dValue = max - min;
        double v1 = dValue * v;
        double ret = min + v1;
        return ret;
    }

    private static String format(double value) {
        String ret = new java.text.DecimalFormat("0.00").format(value);
        return ret;
    }



    /**
    线段切割法
     */
    private static void lineSegmentCutting(double money, int number) {
        if (money < 0 && number < 1){
            System.out.println("输入错误！");
        }
        double begin = 0, end = money;
        double y = 0;
        for (int i = 0; i < number - 1; i++) {
            double nn = 0;
            double amount = nextDouble(begin, end);

            nn = amount - begin;
            System.out.println("第" + (i + 1) + "个人领取的红包金额为：" + format(nn));
            y += nn;
            begin = amount;

        }
        System.out.println("第" + number + "个人领取的红包金额为：" + format(end - begin));
        y += (end - begin);
        System.out.println("验证发出的红包总金额为：" + format(y));

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("这是一段模拟抢红包的代码。");

        int number;
        double money;
        System.out.print("请输入红包总金额：");
        money = sc.nextDouble();
        System.out.print("请输入红包数量：");
        number = sc.nextInt();
        //System.out.println(money + " " + number);

        //System.out.println(doubleMeanMethod(money,number).toString());
        //也是可以直接输出list的，为了观察方便，我就在循环中输出了，存在list里主要是为了后续方便数据的使用

        //线段切割法
        lineSegmentCutting(money, number);

    }

}


