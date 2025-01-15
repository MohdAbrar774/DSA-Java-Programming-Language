import java.util.*;

public class PracticeQs {

    public static int maxEqualPartition(String str) {// O(n)
        int n = str.length();

        int ans = 0;
        int r = 0, l = 0;

        for (int i = 0; i < n; i++) {

            if (str.charAt(i) == 'R') {

                r++;
            } else if (str.charAt(i) == 'L') {

                l++;
            }

            if (r == l) {

                ans++;

            }
        }
        return ans;
    }

    public static int nthOddNumInRange(int range[], int K){

        if (K <= 0) {
            return 0;
        }

        int L = range[0];
        int R = range[1];

        if ((R&1) > 0) {
            
            int count = (int) Math.ceil((R-L+2)/2);

            if (K > count) {
                return 0;
            }else{
                return (R-2*K+2);
            }

        }
        else{

            int count =(R-L+2)/2;

            if (K > count) {
                return 0;
            }else{
                return (R-2*K+1);
            }

        }
    }

    public static char[] lexoStringLenNSumK(int n, int k){

        char arr[] = new char[n];

        Arrays.fill(arr, 'a');

        for(int i=n-1; i>=0; i--){

           k -= i;

           if (k >= 0) {
            
            if (k >= 26) {
                
                arr[i] = 'z';
                k -= 26;
            }

            else{
                arr[i] = (char)(k + 97 - 1);
                k -= arr[i] - 'a' + 1;
            }
           }else{

            break;
           }

           k += i;
        }

        return arr;
    }
    public static void main(String[] args) {


        int n = 5, k = 72;
        char arr[] = lexoStringLenNSumK(n, k);
        System.out.println(new String(arr));
 
       /*
       int p[] = {-10, 10};
       int k = 8;
       //  System.out.println(nthOddNumInRange(p, k));
       */

       
      // String str = "LRLLRRLRRL";

        // System.out.println(maxEqualPartition(str));

    }
}
