package demo.beibaowenti;

/**
 * @author weish
 */
public class demo {

    /**
     * 体积
     */
    private static int[] volume = {1, 5, 10, 6, 10};
    /**
     * 物品价格
     */
    private static int[] price = {2000, 5, 100000, 30, 6000};

    public static int solution(int maxVolume, int count, int[] volume, int[] price) {
        int[][] b = new int[count + 1][maxVolume + 1];
        for (int i = 1; i <= count; i++) {
            //拿到物品的价格
            int p = price[i - 1];
            //拿到物品的体积
            int v = volume[i - 1];
            for (int j = 1; j <= maxVolume; j++) {
                //如果物品的体积大于背包容量时，选择不拿。
                if (j < v) {
                    b[i][j] = b[i - 1][j];
                    continue;
                }
                b[i][j] = Math.max(b[i - 1][j], b[i - 1][j - v] + p);
                System.out.println("i: " + i + ",j : "+ j + ", 价格 : " + b[i][j]);
            }
        }
        return b[count][maxVolume];
    }

    public static void main(String[] args) {
        //背包容量
        int maxVolume = 16;
        //物品数量
        int count = 5;
        System.out.println(solution(maxVolume, count, volume, price));
    }
}
