public class ROD_CUTTING {

    public static int rodCuttingTab(int length[], int price[], int totalRod) {
        int n = length.length;
        int[][] dp = new int[n + 1][totalRod + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < totalRod + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < totalRod + 1; j++) {
                int v = price[i - 1];
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(v + dp[i][j - length[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][totalRod];
    }

    public static void main(String[] args) {
        int length[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int price[] = { 1, 5, 8, 9 , 10, 17, 17, 20 };

        int rodlength = 8;

       System.out.println(rodCuttingTab(length, price, rodlength));
    }
}
