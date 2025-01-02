import java.util.*;

public class ContainWater {

    // <--------Brute Force-------->

    // public static int ContainWaterArea(ArrayList<Integer> heights){

    // int maxContainWater = Integer.MIN_VALUE , width , height, currWaterArea;

    // for(int i=0; i<heights.size(); i++){
    // for(int j=i+1; j<heights.size(); j++){

    // height = Math.min(heights.get(i), heights.get(j));
    // width = j-i;
    // currWaterArea = height * width;
    // maxContainWater = Math.max(maxContainWater, currWaterArea);
    // }
    // }
    // return maxContainWater;
    // }

    public static int containWater(ArrayList<Integer> heights) {
        int maxContainWater = 0, width, height, currWaterarea;

        for (int i = 0; i < heights.size(); i++) {
            for (int j = i + 1; j < heights.size(); j++) {
                height = Math.min(heights.get(i), heights.get(j));
                width = j - i;
                currWaterarea = height * width;
                maxContainWater = Math.max(maxContainWater, currWaterarea);
            }

        }

        return maxContainWater;
    }

    // <----------2 pointer approach-------->
    public static int storeWater(ArrayList<Integer> heights){
        int maxContainWater = 0;
        int lp = 0;
        int rp = heights.size()-1;

        while (rp>lp) {
            //current water
            int ht = Math.min(heights.get(rp),heights.get(lp));
            int width = rp-lp;
            int currWaterArea = ht * width;
            maxContainWater = Math.max(maxContainWater, currWaterArea);
            //upadate ptr
            if (heights.get(lp)<heights.get(rp)) {
                lp++;
            }else{
                rp--;
            }
        }
        return maxContainWater;
    }
    public static void main(String[] args) {

        ArrayList<Integer> heights = new ArrayList<>();
        heights.add(1);
        heights.add(8);
        heights.add(6);
        heights.add(2);
        heights.add(5);
        heights.add(4);
        heights.add(8);
        heights.add(3);
        heights.add(7);

        System.out.println((storeWater(heights)));
    }

}
