public class interview{

    static  int N = 100;
    public static void printArr(int ans[]){
        for( int i=1;i<=N;i++){
         System.out.print(ans[i]+" ");
         if(i%10==0){
            System.out.println();
         }
    }
    }
    public static void main(String args[]){
      
        int doors[] = new int[N];
       

            for( int i=1;i<N+1;i++){
                for(int j=0; j<N; j=j+i){
                if(doors[j] == 0){

                    doors[j] = 1;
                }else{

                    doors[j] = -1;
                }

            }
        }
        printArr(doors);
        
        }
    }
