import java.util.*;
public class MinAbsoult {
    

    public static void main(String[] args) {
        
        int A[] = {3, 6, 5, 2};
        int B[] = {4, 2, 1, 3};

        Arrays.sort(A);
        Arrays.sort(B);

        int minAbsValue  = 0;

        for(int i=0; i<A.length; i++){

            minAbsValue += Math.abs(A[i]-B[i]);
        }

        System.out.println("The minAbsoult Value is: "+ minAbsValue);
    }
}
