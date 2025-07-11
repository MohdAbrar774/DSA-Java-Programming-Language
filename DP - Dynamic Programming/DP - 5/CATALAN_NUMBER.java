import java.util.*;
public class CATALAN_NUMBER {

    //Recursion
    public static int catalan(int n){
        if(n == 0 || n == 1){
            return 1;
        }

        int ans  = 0;
        for(int i=0; i<=n-1; i++){
            ans += catalan(i) * catalan(n-i-1);
        }

        return ans;
    }

    //Memoization
      public static int catalanMemo(int n, int dp[]){
        if(n == 0 || n == 1){
            return 1;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int ans  = 0;
        for(int i=0; i<n; i++){
            ans += catalanMemo(i, dp) * catalanMemo(n-i-1, dp);
        }

        return dp[n] = ans;
    }

    //Tabulation
    public static int catalanTab(int n){
        int dp[]= new int[n+1];
        //initilization

        dp[0] = dp[1] = 1;

        for(int i=2; i<=n; i++){
            for(int j=0; j<i; j++){

                dp[i] += dp[j] * dp[i-j-1];
            }
        }

        return dp[n];
    }
    public static void main(String[] args) {
        // int num = 4;

        // int dp[] = new int[num+1];
        // Arrays.fill(dp, -1);
        // System.out.println(catalanMemo(num, dp));

        int num = 5  ;
        System.out.println(catalanTab(num));
    }
    
}
