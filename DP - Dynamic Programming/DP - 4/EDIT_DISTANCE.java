
public class EDIT_DISTANCE{



    public static int editDist(String str1, String str2){
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n+1][m+1];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        for(int i=1; i<n+1; i++){
            for(int j =1; j<dp[0].length; j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else{
                    int ad = dp[i][j-1] + 1;
                    int del = dp[i-1][j] + 1;
                    int rep = dp[i-1][j-1] +1;
                    dp[i][j] = Math.min(ad, Math.min(del,rep));
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        String s1 = "abd";
        String s2 = "sbc";

        System.out.println(editDist(s1, s2));
    }
}