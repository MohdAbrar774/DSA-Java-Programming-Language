import java.util.*;

public class Sets {

    public static void main(String[] args) {//Count Distinct Numbers
        int nums[] = { 4, 3, 2, 5, 6, 7, 3, 4, 2, 1 };

        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            hs.add(nums[i]);
        }

        System.out.println("Distinct Numbers: " + hs.size());

    }
}
