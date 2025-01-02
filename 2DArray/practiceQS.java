public class practiceQS {

    public static void countKey(int matrix[][], int key) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (matrix[i][j] == key) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    public static void sumofRow(int matrix[][]) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                if (i == 1) {
                    sum += matrix[i][j];
                }
            }
        }
        System.out.println(sum);
    }

    public static void printMatrix(int arrs[][]) {
        
        System.out.println("matrix is :-");

        for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j< arrs[0].length; j++) {

                System.out.print(arrs[i][j] + " ");

            }
                       System.out.println();
               
        }
    

    }

    public static void main(String[] args) {
        int row = 2, col = 3;

        int arrs[][] = { { 1, 4, 9 },
                { 11, 4, 3 } };

                //Display Matrix :-
                printMatrix(arrs);

                //Transpose process :-

                int transpose[][] = new int[col][row];
                for (int i = 0; i < arrs.length; i++) {
            for (int j = 0; j< arrs[0].length; j++) {
               transpose[j][i] = arrs[i][j];


              
            }
        }
         //Display Transpose :-

               printMatrix(transpose);


            

    
        // countKey(arr, key);
        // sumofRow(arr);

    }

}
