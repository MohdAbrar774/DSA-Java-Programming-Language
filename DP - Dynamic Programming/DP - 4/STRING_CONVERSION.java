public class STRING_CONVERSION{


    public static int lcs(String s1, String s2){
        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n+1][m+1];

        for(int i=0; i<n-1;i++){
            for(int j=0; j<m+1; j++){
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j=1; j<m+1; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    int ans1 =  dp[i-1][j];
                    int ans2 = dp[i][j-1];
                    dp[i][j]  = Math.max(ans1, ans2);
                }
            }
        }
        return dp[n][m];
    }

    public static void strConversion(String word1, String  word2){

        int n = word1.length();
        int m = word2.length();
        int lcs = lcs(word1, word2);

        int del = n - lcs;
        int add = m - lcs;

        System.out.println("Deletion: "+del);
        System.out.println("Insertion: "+add);
    }

    public static void main(String[] args) {
        String s1 = "pear";
        String s2 = "sea";

       strConversion(s1, s2);
    }
}