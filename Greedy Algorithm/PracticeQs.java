public class PracticeQs {

    

    public static int maxEqualPartition(String str){//O(n)
        int n=str.length();

        int ans=0;
        int r =0 , l = 0;

        for(int i=0; i<n; i++){

            if( str.charAt(i) == 'R'){

                r++;
            }
            else if (str.charAt(i) == 'L') {
                
                l++;
            }

            if (r == l ) {

                ans++;
                
            }
        }
         return ans;
    }





    public static void main(String[] args) {

        String str = "LRLLRRLRRL";

       System.out.println(maxEqualPartition(str));
        
    }
}
