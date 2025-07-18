import java.util.*;

public class TRIBONACCI {

   //Tabulation
   public int tribonacci(int n) {
      if (n == 0) {
         return 0;
      } else if (n == 1 || n == 2) {
         return 1;
      }
      int dp[] = new int[n + 1];
      dp[0] = 0;
      dp[1] = dp[2] = 1;

      for (int i = 3; i <= n; i++) {

         dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
      }

      return dp[n];
   }

   //Memoization
   public static int tribonacci(int n, int dp[]) {
      if (n == 0 || n == 1) {
         return 0;
      } else if (n == 2) {
         return 1;
      }
      if (dp[n] != -1) {
         return dp[n];
      }

      int tribo = tribonacci(n - 1, dp) + tribonacci(n - 2, dp) + tribonacci(n - 3, dp);

      return dp[n] = tribo;
   }

   public static void main(String args[]) {
      int n = 5;

      int dp[] = new int[n + 1];
      Arrays.fill(dp, -1);
      System.out.println(tribonacci(n, dp));
   }
}