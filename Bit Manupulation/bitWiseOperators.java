public class bitWiseOperators {

    public static void oddOrEven(int n) {
        
        if ((n & 1) == 0) {

            System.out.println("This is an even Number");
        } else {
            System.out.println("This is an odd Number");
        }
    }

    public static int getIthbit(int n, int i) {
        int bitmask = (1 << i);

        if ((n & bitmask) == 0) {

            return 0;

        } else {
            return 1;
        }
    }

    public static int setIthBit(int n, int i) {
        int bitmask = 1 << i;

        return n | bitmask;

    }

    public static int clearIthBit(int n, int i) {
        int bitmask = ~(1 << i);

        return n & bitmask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        // if(newBit == 0){

        // return clearIthBit( n, i);
        // }else{
        // return setIthBit(n, i);
        // }

        n = clearIthBit(n, i);
        int Bitmask = newBit << 1;
        return n | Bitmask;
    }

    public static int clearIBit(int n, int i) {
        int bitmask = ~(0) << i;

        return n & bitmask;
    }

    public static int clearIBitinRange(int n, int i, int j) {
        int a = ((~0) << (j + 1));
        int b = (i << 1) - 1;
        int bitmask = a | b;

        return n & bitmask;
    }

    public static boolean isPowerOfTwo(int n) {

        return (n & (n - 1)) == 0;
    }

    public static int setBitNumbers(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }

            n = n >> 1;

        }
        return count++;
    }
    public static int fastExpo( int a,int n){
          int ans =1;

          while (n > 0 ) {

            if((n & 1) != 0){

                ans = ans * a;

            }
            a = a * a;
            n = n>>1;
            
          }
          return ans;


    }

    public static void main(String[] args) {

        // System.out.println(getIthbit(17, 4));

        // System.out.println(setIthBit(10, 1));

        // System.out.println(clearIthBit(10, 1));

        // System.out.println(updateIthBit(10, 2 , 1));

        // System.out.println(clearIBit(15, 2));

        // System.out.println(clearIBitinRange(10, 2,4));

        // System.out.println(isPowerOfTwo(68));

        // System.out.println(setBitNumbers(10));

        System.out.println(fastExpo(4,5));



        // oddOrEven(1);
        // oddOrEven(4);
        // oddOrEven(5);
        // oddOrEven(16);

        // And Operator (5) = 101 , (6) = 110
        // |5&6 = 101
        // | 110
        // | = 100
        // | = (4)
        // System.out.println(5 & 6);//////////////////////

        // Or Operator
        System.out.println(5 | 6);////////////////////////

        // XOr Operator
        System.out.println(5 ^ 6);////////////////////////

        // Not or Binary One's Operator
        System.out.println(~6);////////////////////////

        // Left Shift Operator (<<)
        // Trick to find a<<b = a*2^b
        System.out.println(6 << 2);////////////////////////

        // Right Shift Operator (>>)
        // Trick to find a>>b = a/2^b
        System.out.println(6 >> 2);////////////////////////

    }

}