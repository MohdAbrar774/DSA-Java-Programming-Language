public class DP_FIBONACCI{


    public static int fibMemoization(int n, int[] f){

        if(n == 0 || n == 1){
         return n;
        }

        if (f[n] != 0) { 
            return f[n];
        }
        f[n]  = fibMemoization(n-1, f) + fibMemoization(n-2, f);
        return f[n];
    }
    public static int fibTabulation(int n){

        int fib[] = new int[n+1];
        fib[1] = 1;

        for(int i=2; i<= n; i++){
            fib[i] = fib[i-1]+fib[i-2];
        }

        return fib[n];

    }


    public static void main(String[] args) {
        int n = 5;

        int fib[] = new int[n+1];
        fibMemoization(n, fib);
        System.out.println(fibTabulation(n));
    }
}