import java.util.*;
//import java.util.Collections.sort();

public class BasicFnxArrayList {

    public static void swapFnx(ArrayList<Integer> list, int idx1, int idx2){

        int temp = list.get(idx1);
        list.set(idx1, list.get(idx2));
        list.set(idx2, temp);

    }

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for(int i=1; i<=5; i++){
            list1.add(i*1);
            list2.add(i*2);
            list3.add(i*3);
        }
        

        mainlist.add(list1);
        mainlist.add(list2);
        mainlist.add(list3);

        System.out.println(mainlist);
        for(int i=0; i<mainlist.size();i++){
            ArrayList<Integer> currList = mainlist.get(i);
            for(int j=0; j<currList.size(); j++){

                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }





        // ArrayList<Integer> list = new ArrayList<>();
        // list.add(2);
        // list.add(4);
        // list.add(9);
        // list.add(6);
        // list.add(8);

        //<-----Finding max value------->

        // int max = Integer.MIN_VALUE;

        // for (int i = list.size() - 1; i >= 0; i--) {
        //     // if (max < list.get(i)) {

        //     // max = list.get(i);
        //     // }
        //     max = Math.max(max, list.get(i));
        // }
        // System.out.print("max element is: " + max);


        //<-------Swapping In ArrayList--------->

        // int idx1 = 1 , idx2 = 3;
        // System.out.println(list);
        // swapFnx(list , idx1, idx2);
        // System.out.println(list);


        //<-------Sorting in ArrayList(Ascending order)------->

        // System.out.println(list);
        // Collections.sort(list);
        // System.out.println(list);
        
        
        //Collections.reverseOrder() = Comparator - define fnx(sort) logic

        // Collections.sort(list,Collections.reverseOrder());
        // System.out.println(list);

        


    }
    



}