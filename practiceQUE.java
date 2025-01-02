public class practiceQUE {

    public static void bubbleSort(int arrs[]) {

    
        for (int turn = 0; turn < arrs.length - 1; turn++) {
            for (int j = 0; j < arrs.length - 1 - turn; j++) {
                if (arrs[j] < arrs[j + 1]) {
                    // swap
                    int temp = arrs[j];
                    arrs[j] = arrs[j + 1];
                    arrs[j + 1] = temp;

                }
            }
        }

    }
    public static void Printarrs(int arrs[]){
        for(int i=0;i<arrs.length;i++){
            System.out.print(arrs[i]+" ");

        }
        System.out.println();
        
    }
    public static void Selectionsort(int arrs[]) {

        for(int i=0;i<arrs.length;i++){
            int minpos=i;
            for(int j=i+1;j<arrs.length;j++){
                if(arrs[minpos]>arrs[j]){
             
                    minpos = j;
                
                }

            }
            //swap
            int temp = arrs[minpos];
            arrs[i] = arrs[minpos];
            arrs[i] = temp;
        }
        
    }

    public static void main(String[] args) {
        int arrs[] = { 3, 6, 2, 1, 8, 7, 4, 5, 3, 1 };
         Selectionsort(arrs);
         Printarrs(arrs);
    }
}

