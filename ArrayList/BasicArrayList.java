import java.util.ArrayList;

public class BasicArrayList{

    public static void main(String args[]){

        ArrayList<Integer> list = new ArrayList<>();
        //ArrayList<Boolean> list2 = new ArrayList<>();
        //ArrayList<String> list3 = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);

        // System.out.println(list.get(2));
        
        list.set(2,20);
        System.out.println(list);
        
        // list.remove(2);
        // System.out.println(list);
        
        // System.out.println(list.contains(2));
        // System.out.println(list.contains(20));
       
        

        // list.add(2,20);
        // System.out.print(list);


        // for(int i=list.size()-1; i>=0; i--){
        //     System.out.print(list.get(i)+" ");
        // }



    }
}