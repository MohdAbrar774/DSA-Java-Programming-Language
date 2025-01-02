    import java.util.*;

public class JavaBasic {

    public static void main(String args[]) {
    
    try (Scanner sc = new Scanner(System.in)) {
        int n = sc.nextInt();

                     if( n ==2){
                        System.out.println("n is prime");
                     }
                     else{ 
                        boolean isPrime = true;
                        for(int i=2;i<=(n-1);i++){
                           if(n %i==0){
                               isPrime = false;
                           }
                      }
                      if(isPrime == true ){
                        System.out.println("n is a prime number");
                    }
                    else{
                        System.out.println("n is not prime number");
                    }
                      
                     
                     }
    }    




        //   Scanner sc = new Scanner(System.in);
        //        System.out.println("Enter Value Year :");
        //        int year = sc.nextInt();
               
        //        boolean x = (year%4)==0;
               
        //        boolean y = (year%100)!=0;
               
        //        boolean z = ((year%100)==0  &&   (year%400)==0);


        //  if(x && (y || z)){
        //     System.out.println(year + " is an leap year");
        //  }else{
            
        //     System.out.println(year + " is not an leap year");
        // }

        //  }
        // TERNERY OPERATOR
        // int num = 9;
        // String type= ((num%2) == 0)? "even" : "odd";
        // System.out.println(type);

        /* GREATER OF THREE NUMBER */
        // int c = 11 , b = 1 , a = 7;
        // if( a >= b && a>=c){
        // System.out.println( "The Greater is a");
        // }
        // else if(b>=c && b>=a ){
        // System.out.println( "The Greater is b");
        // }
        // else{
        // System.out.println( "The Greater is c");
        // }

        // INCOME TAX CALCULATOR
        // int income = sc.nextInt();
        // int tax ;
        // if(income< 500000){
        // tax = 0;
        // }
        // else if(income >= 500000 && income < 100000){
        // tax = (int)(income * 0.2);

        // }
        // else{
        // tax = (int)(income * 0.3);
        // }
        // System.out.println( "Your tax is " + tax);

        // int num = sc.nextInt();
        // if(num % 2==0){
        // System.out.println("even");
        // }else{
        // System.out.println("odd");
        // }

        // int x = 9, y = 12;
        // int a = 2, b = 4, c = 6;
        // int exp = 4/3 * (x + 34) + 9 * (a + b * c) + (3 + y * (2 + a)) / (a + b*y);
        // System.out.println(exp);

        // int x, y, z;
        // x = y = z = 2;
        // x += y;
        // y -= z;
        // z /= (x + y);
        // System.out.println(x + " " + y + " " + z);

        // Scanner sc = new Scanner(System.in);
        // int x =2 , y = 5;
        // int expl1 = (x * y/x);
        // int expl2 = ( x * (y/x));

        // System.out.println(expl1 +",");
        // System.out.println(expl2);

        // float pen = sc.nextFloat();
        // float pencil = sc.nextFloat();
        // float eraser = sc.nextFloat();
        // byte b = 4;
        // char c ='a';
        // short s = 512;
        // int i = 1000;
        // float f = 3.14f;
        // double d = 99.9954;

        // float fe = (float) ((f * b) + (i % c) - (d * s));
        // System.out.println(fe);

        // float bill=pen+pencil+eraser;
        // System.out.println("The bill is "+bill);
        // float gstbill = (bill*18)/100;
        // System.out.println( "with 18% GST " + (gstbill+bill));
        /*
         * char ch = 'a';
         * char ch2 = 'b';
         * int number = 'a';
         * int number2 = 'b';
         * System.out.println(number);
         * System.out.println(number2);
         */

        // **TYPE CASTING**
        // Scanner sc = new Scanner(System.in);
        // float num= 82.99f;
        // int a = (int)num;
        // System.out.println(a);

        // int a =10;
        // int b = 5;
        // int sum = a+b;
        // System.out.println(sum);
        // Scanner ab = new Scanner(System.in);
        // double input = ab.nextDouble();
        // System.out.println(input);
        // ab.close();

    }

            }
