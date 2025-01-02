import java.text.BreakIterator;
import java.util.Scanner;

public class JavaFunctions {
    public static void printHelloWorld() {
        System.out.println("Hello World");
        System.out.println("Hello Duniya");
        System.out.println("Hello Kainaat");
    }

    public static int calculateSum(int num1, int num2) {
        int sum = num1 + num2;// Formal Parameters
        return sum;
    }

    /* SWAP FUNCTION */
    public static void swap(int a, int b) {
        int temp = a;
        a = 10;
        b = temp;
        System.out.println("a is = " + a);
        System.out.println("b is = " + b);
    }

    // MULTIPLICATION OF TWO NUMBER
    public static int multiply(int a, int b) {
        int product = a * b;
        return product;
    }

    // FACTORIAL OF A NUMBER
    public static int factorial(int n) {
        int f;
        f = 1;
        for (int i = 1; i <= n; i++) {
            f = f * i;
        }
        return f;
    }

    // BINOMIAL COFFICIENT
    public static int binCoeff(int n, int r) {
        int fact_n = factorial(n);
        int fact_r = factorial(r);
        int fact_nmr = factorial(n - r);

        int binCoeff = fact_n / (fact_r * fact_nmr);
        return binCoeff;
    }

    // function pverload{ SUM OF TWO NUM
    public static int sum(int a, int b) {
        return a + b;
    }

    // SUM OF THREE NUM
    public static float sum(float a, Float b, Float c) {
        return a + b + c;
    } // }functiion overload

    public static boolean isPrime(int n) {
        // corner cases
        // for 2

        for (int i = 2; i <= n - 1; i++) {

            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // PRINE IN A RANGE
    public static void primeinrange(int n) {

        for (int i = 2; i <= n; i++) {

            if (isPrime(i)) {
                System.err.print(i + " ");
            }
        }
        System.err.println();
    }

    public static void binTODeci(int binNum) {
        int myNum = binNum;
        int pow = 0;
        int decNum = 0;

        while (binNum > 0) {
            int lastdigit = binNum % 10;
            decNum = decNum + (lastdigit * (int) Math.pow(2, pow));

            pow++;
            binNum = binNum / 10;

        }
        System.err.println("decimal of " + myNum + " = " + decNum);

    } // AVG OF THREE NUM

    public static void NumAvg(int a, int b, int c) {
        int sum = a + b + c;
        int avg = sum / 3;
        System.err.println("Average of the three num  = " + avg);
    }

    // IS EVEN
    public static void isEven(int b) {

        for (int i = 2; i <= b - 1; i++) {
            if (b % i == 0) {
                System.err.println("ture");
                break;
            }
            System.err.println("false");
            break;
        }
    }

    // SUM OF INTEGERS INPUT BY USER
    public static int lastDigit(int n) {
        int sumOfDigits = 0;

        while (n > 0) {

            int lastDigit = n % 10;

            sumOfDigits += lastDigit;
            n /= 10;

        }
        return sumOfDigits;
    }

    public static void hallow_rectangle(int totRows, int totCols) {
        // Boundary
        for (int i = 1; i <= totRows; i++) {
            // inner -columns
            for (int j = 1; j <= totCols; j++) {
                // cell-(i,j)
                if (i == 1 || i == totRows || j == 1 || j == totCols) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.err.println();
        }
    }

    public static void inverted_half_pyramid(int n) {
        for (int i = 1; i <= n; i++) {

            // for space
            for (int j = 1; j <= n - i; j++) {
                System.err.print(" ");

            }
            // star
            for (int j = 1; j <= i; j++) {
                System.err.print("*");
            }
            System.err.println();
        }
    }

    public static void inverted_half_pyramid_withnumbers(int n) {
        for (int i = 1; i <= n; i++) {

            // inner loop
            for (int j = 1; j <= n - i + 1; j++) {
                System.err.print(j + " ");
            }
            System.err.println();
        }
    }

    public static void floyds_pyramid(int n) {
        // outer loop
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            // inner-how mant times will counter printed
            for (int j = 1; j <= i; j++) {
                System.err.print(counter + " ");
                counter++;
            }
            System.err.println();
        }
    }

    public static void butterfly_pattern(int n) {
        // 1st Half - outer loop
        for (int i = 1; i <= n; i++) {

            // stars-i
            for (int j = 1; j <= i; j++) {
                System.err.print("*");
            }

            // spaces - 2*(n-i)
            for (int j = 1; j <= 2 * (n - i); j++) {

                System.err.print(" ");
            }

            // stars - i
            for (int j = 1; j <= i; j++) {
                System.err.print("*");
            }
            System.err.println();
        }
        // 2nd Half
        for (int i = n; i >= 1; i--) {

            // stars-i
            for (int j = 1; j <= i; j++) {
                System.err.print("*");
            }

            // spaces - 2*(n-i)
            for (int j = 1; j <= 2 * (n - i); j++) {

                System.err.print(" ");
            }

            // stars - i
            for (int j = 1; j <= i; j++) {
                System.err.print("*");
            }
            System.err.println();
     }
}
           public static void hallow_rhombus(int n) {

            for(int i=1; i<=n;i++){

                //spaces
                for(int j =1; j<=(n-i);j++){
                    System.err.print(" ");
                }

                 //Hallow-rectangal-star
                 for(int j=1;j<=n;j++){
                    if(i==1 || i==n || j==1 || j==n){
                           
                        System.err.print("*");

                    }
                    else{
                        System.err.print(" ");
                    }
                }
                System.err.println();
            }            
           }
           public static void diamond(int n) {

            // 1st half
            for(int i=1;i<=n;i++){
              
                // spaces
                for(int j=1;j<=(n-i);j++){

                    System.err.print(" ");
                }

                //stars
                for(int j=1;j<=(2*i)-1;j++){

                    System.err.print("*");
                }
                System.err.println();
             }
            // 2nd half
            for(int i=n;i>=1;i--){
              
                // spaces
                for(int j=1;j<=(n-i);j++){

                    System.err.print(" ");
                }

                //stars
                for(int j=1;j<=(2*i)-1;j++){

                    System.err.print("*");
                }
                System.err.println();
             }
           }

    public static void main(String args[]) {
        // inverted_half_pyramid(4);
        // inverted_half_pyramid_withnumbers(5);
        // floyds_pyramid(20);
        //butterfly_pattern(5);
        //hallow_rhombus(35);
        diamond(8);



        // Scanner sc = new Scanner (System.in);
        // System.out.print("Input an integer: ");
        // int digits = sc.nextInt();
        // System.out.println("The sum is " + lastDigit(digits));

        // int a = 2;
        // int b = 8;
        // int prod= multiply(a, b);
        // System.err.println("a * b = " + prod);
        // prod = multiply(10,3);
        // System.err.println("a * b = " + prod);

        /* SWAP FUNCTION */
        /*
         * int a = 5;
         * int b = 10;
         * swap(a ,b)
         */

        // printHelloWorld();
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Enter a");
        // int a= sc.nextInt();
        // System.out.println("Enter b");
        // int b = sc.nextInt();
        // int sum = calculateSum(a, b); // Actual Parameters
        // System.out.println("Sum is: " + sum);

    }
}
