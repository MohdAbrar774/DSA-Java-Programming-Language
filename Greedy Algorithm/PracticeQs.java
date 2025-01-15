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

    public static void main(String[] args) {



        int p[] = {-10, 10};
        int k = 8;
        System.out.println(nthOddNumInRange(p, k));
        // String str = "LRLLRRLRRL";

        // System.out.println(maxEqualPartition(str));

    }
}
