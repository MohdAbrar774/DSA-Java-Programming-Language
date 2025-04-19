import java.util.*;

public class Sets {

    public static void main(String[] args) {//Union & Intersection of 2 arrays
        int arr1[] = {7, 3, 9 };
        int arr2[] = {6, 3, 9, 2, 9, 4};

        ArrayList<Integer> arr = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }
        for (int i = 0; i<arr2.length; i++) {
            set.add(arr2[i]);
        }

        System.out.println("Union: " + set.size());
        System.out.println();
        //Home-Work
        for(Integer num : set){
            System.out.println(num+" ");
        }

        //intersection

        set.clear();
        for (int i = 0; i<arr1.length; i++) {
            set.add(arr1[i]);
        }

        int count = 0;
        for (int i = 0; i<arr2.length; i++) {
          int num = arr2[i];
            if(set.contains(num)){

                count++;
                arr.add(num);
                set.remove(num);
            }
        }

        System.out.println("Intersection: " + count);
        //Home-Work
        while(!arr.isEmpty()){
            System.out.println(arr.remove(0));
            
        }

    }
}
