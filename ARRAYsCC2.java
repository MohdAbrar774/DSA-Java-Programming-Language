
public class ARRAYsCC2 {


    public static void updates(int marks[]) {
        for(int i=0;i<marks.length;i++){
                marks[i]= marks[i]+1;

        }       
    }

    public static void main(String args[]){

         int marks[]={98,99,100};


                updates(marks);
        System.err.println( );

        //print oue marks

        for(int i=0;i<marks.length;i++){
             System.err.print(marks[i]+" ");
        }
        System.err.println();
    }
    
}
