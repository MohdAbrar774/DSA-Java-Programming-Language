import java.util.ArrayList;

public class PairsSum {


    //<---------Brute force Aproach---------->
    // public static Boolean pairSum(ArrayList<Integer> list,int target){

    

    //     for(int i=0; i<list.size()-1; i++){
    //         for(int j=i+1; j<list.size()-1; j++){

    //             if((list.get(i) + list.get(j)) == target){
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

//  <----------2 Pointer Aproach------------>
    public static Boolean pairSum(ArrayList<Integer> list,  int target){
        int lp = 0;
        int rp = list.size()-1;

        while(lp != rp){

            // case 1
            if(list.get(rp)+list.get( lp) == target){
                return true;
            }

            //case 2
            if(list.get(rp)+list.get( lp) < target){
                lp++;
            }
            //case 3
            else{
                rp--;
            }
        }
        return false;
        
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);

        int target = 50;
        System.out.println(pairSum(list, target));
    }

}
