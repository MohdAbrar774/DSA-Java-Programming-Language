public class spiralMatrix {

  public static void printSpiral(int matrix[][]) {

        int startRow = 0;
        int startCol = 0;
        int endRow   = matrix.length-1;
        int endCol   = matrix[0].length-1;    
        
        while(startRow<=endRow && startCol<=endCol){
            
          //top
            for(int j=startRow ; j<=endCol;j++){

              System.out.print(matrix[startRow][j] +" ");
            }

            //right
            for(int i=startRow+1 ; i<=endRow;i++){

              System.out.print(matrix[i][endCol] +" ");
            }
            
            //bottom

            for(int j=endCol-1 ; j>=startCol;j--){
                 if(startRow == endRow ){
                  break;
                 }
              System.out.print(matrix[endRow][j] +" ");
            }

            //left
            for(int i=endRow-1 ; i>=startRow+1;i--){
                if(startCol == endCol ){
                  break;
                 }
              System.out.print(matrix[i][startCol] +" ");
            }
         startRow++; 
         startCol++;
         endRow--; 
         endCol--; 
        }
        System.out.println();
      }

  public static void main(String[] args) {

    int matrix[][] = { { 1, 2, 5, 9, 10},
        { 11, 15, 18, 25, 28},
        { 30, 35, 39, 45, 47},
        { 50, 55, 65, 68, 69}, 
        { 70, 76, 89, 99, 102},
        { 106, 111, 115, 118, 121},
       { 124, 129, 131, 136, 144} 
      };
        printSpiral(matrix);
  }

}
