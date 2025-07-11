public class MOUNTAIN_RANGES {

    public static int mountRanges(int n) {
        int dp[] = new int[n + 1];

        dp[0] = dp[1] = 0;

        for (int i = 2; i < n + 1; i++) {
            // i --> pairs <of mountain ranges => Ci
            for (int j = 0; j < i; j++) {
                int inside = dp[j];
                int outside = dp[i - j - 1];

                dp[i] += inside * outside;
            }
        }

        return dp[n];
    }
}
