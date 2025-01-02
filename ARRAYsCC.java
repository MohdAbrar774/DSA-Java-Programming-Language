
import java.lang.annotation.Target;
import java.util.*;

import javax.print.attribute.standard.RequestingUserName;

public class ARRAYsCC {

  public static int linerSearch(String menu[], String order) {

    for (int i = 0; i < menu.length; i++) {
      if (menu[i] == order) {
        return i;

      }
    }
    return -1;
  }

  public static int getlargest(int number[]) {
    int largest = Integer.MIN_VALUE;

    for (int i = 0; i < number.length; i++) {
      if (largest < number[i]) {
        largest = number[i];
      }
    }
    return largest;
  }

  public static int binarySearch(int numbers[], int key) {
    int start = 0, end = numbers.length - 1;

    while (start <= end) {
      int mid = (start + end) / 2;

      // comparisons
      if (numbers[mid] == key) {
        return mid;
      }
      if (numbers[mid] < key) {
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }
    return -1;
  }

  public static void reverse(int numbers[]) {
    int first = 0, last = numbers.length - 1;

    while (first < last) {
      // swap
      int temp = numbers[last];
      numbers[last] = numbers[first];
      numbers[first] = temp;

      first++;
      last--;
    }
  }

  public static void printPairs(int numbers[]) {
    int tp = 0;
    for (int i = 0; i < numbers.length; i++) {

      int curr = numbers[i];
      for (int j = i + 1; j < numbers.length; j++) {
        System.out.print("(" + curr + "," + numbers[j] + ")");
        tp++;

      }
      System.err.println();
    }
    System.err.println("Total pairs =" + tp);

  }

  public static void maxSubarraySum(int numbers[]) {
    int currSum = 0;
    int maxSum = Integer.MIN_VALUE;
    int prefix[] = new int[numbers.length];

    // prefix[0] = numbers[0];
    // calculate prefix arrays
    for (int i = 1; i < prefix.length; i++) {
      prefix[i] = prefix[i - 1] + numbers[i];
    }

    for (int i = 0; i < numbers.length; i++) {
      int start = i;
      for (int j = i; j < numbers.length; j++) {
        int end = j;

        currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
        ;

        if (maxSum < currSum) {
          maxSum = currSum;
        }

      }

    }
    System.err.println("max sum = " + maxSum);

  }

  public static void kadanes(int numbers[]) {
    int ms = Integer.MIN_VALUE;
    int cs = 0;
    for (int i = 0; i < numbers.length; i++) {
      cs += numbers[i];
      if (cs < 0) {
        cs = 0;
      }
      ms = Math.max(cs, ms);
    }
    System.err.println("our sub arrays sum is :" + ms);

  }

  public static void kadanesFornegative(int numbers[]) {
    int ms = Integer.MIN_VALUE;
    int cs = 0;
    for (int i = 0; i < numbers.length; i++) {
      cs = numbers[i];
      if (cs < 0) {
        ms = Math.max(cs, ms);
      }

    }
    System.err.println("our smallest -ve number is :" + ms);

  }

  // public static int trappedRainwater(int height[]) {
  // int n = height.length;
  // // Left Max boundary - Array
  // int Leftmax[] = new int[n];
  // Leftmax[0] = height[0];
  // for (int i = 1; i < n; i++) {

  // Leftmax[i] = Math.max(height[i], Leftmax[i - 1]);
  // }

  // // Right Max boundary - Array
  // int rightmax[] = new int[n];
  // rightmax[n - 1] = height[n - 1];
  // for (int i = n - 2; i >= 0; i--) {

  // rightmax[i] = Math.max(height[i], rightmax[i + 1]);
  // }

  // int trappedwater = 0;
  // // Loop
  // for (int i = 0; i < n; i++) {
  // // waterlevel = math.min(leftmax bound,rightmax bound)
  // int waterlevel = Math.min(Leftmax[i], rightmax[i]);

  // // trappedwater = Waterlevel - height
  // trappedwater += waterlevel - height[i];
  // }

  // return trappedwater;
  // }

  // public static int buyAndSellStocks(int prices[]) {
  // int buyPrices = Integer.MAX_VALUE;
  // int maxProfit = 0;

  // for (int i = 0; i < prices.length; i++) {
  // if (buyPrices < prices[i]) {
  // int profit = prices[i] - buyPrices; //today's profit
  // maxProfit = Math.max(maxProfit, profit);
  // } else {
  // buyPrices = prices[i];
  // }
  // }
  // return maxProfit;

  // }

 

  public static int maxProfites(int prices[]) {
    int buyPrices = Integer.MAX_VALUE;
    int maxProfit = 0;

    for (int i = 0; i < prices.length; i++) {
      if (buyPrices < prices[i]) {
        int profit = prices[i] - buyPrices;
        maxProfit = Math.max(maxProfit, profit);
      } else {
        buyPrices = prices[i];
      }

    }
    return maxProfit;
  }

  public static int trappedRainwater(int height[]) {
    int n = height.length;
    // left max boundary - Array
    int Leftmax[] = new int[n];
    Leftmax[0] = height[0];
    for (int i = 1; i < n; i++) {
      Leftmax[i] = Math.max(height[i], Leftmax[i - 1]);
    }
    // right max boundary - Array
    int rightmax[] = new int[n];
    rightmax[n - 1] = height[n - 1];
    for (int i = n - 2; i >= 0; i--) {
      rightmax[i] = Math.max(height[i], rightmax[i + 1]);
    }

    int trappedwater = 0;
    // loop
    for (int i = 0; i < n; i++) {
      // waterlevel = Math.max(leftmax bound , rightmax bound);
      int waterlevel = Math.min(Leftmax[i], rightmax[i]);

      // trappedwater = waterlevel - height[i];

      trappedwater += waterlevel - height[i];

    }
    return trappedwater;
  }

  public static void printTiplets(int nums[]) {
    int tt = 0;
    int n = nums.length;
    int maxsum = 0;
    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j <= n; j++) {
        for (int k = j + 1; k < n; k++) {
          int sum = nums[i] + nums[j] + nums[k];
          if (sum == 0)
            System.out.println("(" + nums[i] + "," + nums[j] + "," + nums[k] + ")");
          maxsum = sum;
          tt++;
        }
      }
    }

  }

  public static int toSearch(int nums[], int target) {
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == 0) {
        return i;
      }

    }
    return -1;
  }
  public static boolean trueAndflase(int nums[]) {
    HashSet<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (set.contains(nums[i])) {
        return true;
      } else {
        set.add(nums[i]);
      }
    }
    return false;
  }
  // int n = nums.length;
  // for (int i = 0; i < n - 1; i++) {

  // for (int j = i + 1; j < n; j++) {

  // if (nums[i] == nums[j]) {
  // System.out.println("true");

  // }
  // }

  // }
  // System.out.println("false");
  // }

  public static void main(String args[]) {
    // int nums[] = { 4,  6,  0, 1, 2, 3};
    // System.out.println(trueAndflase(nums)); 
  

    
    // int target = 0;
    // int index = toSearch(nums,target);
    // if(index == -1){
    // System.out.println("Invalid ");
    // }else{
    // System.out.println("Your target is at index "+ index);
    // }

    // reverse(numbers);
    // print

    // for (int i = 0; i < numbers.length; i++) {

    // System.err.print(numbers[i] + " ");
    // }

    // System.err.println();

    // System.err.println("Index for key is :" + binarySearch(numbers, key));

    // int marks[] = new int[100];
    // Scanner sc = new Scanner(System.in);
    // // int phy;
    // //phy = sc.nextInt();

    // marks[0]= sc.nextInt();
    // marks[1]= sc.nextInt();
    // marks[2]= sc.nextInt();

    // System.err.println("phy :"+ marks[0]);
    // System.err.println("chem :"+ marks[1]);
    // System.err.println("math:"+ marks[2]);

    // int percentage = (marks[0]+marks[1]+marks[2])/3;
    // // marks[0]= marks[0] +2;
    // System.err.println("percentage :"+ percentage);

  };

}
