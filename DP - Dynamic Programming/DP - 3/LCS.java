public class LCS {

      //O(n*m)
    public static int LcsMemoize(String str1, String str2, int n, int m, int[][] dp) {
        if (n == 0 || m == 0) {
            return 0;
        }

        if (dp[n][m] != -1) {
            return dp[n][m];
        }

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            return dp[n][m] = LcsMemoize(str1, str2, n - 1, m - 1, dp) + 1;
        } else {
            int ans1 = LcsMemoize(str1, str2, n, m - 1, dp);
            int ans2 = LcsMemoize(str1, str2, n - 1, m, dp);

            return dp[n][m] = Math.max(ans1, ans2);
        }
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(LcsMemoize(str1, str2, str1.length(), str2.length(), dp));
    }
}