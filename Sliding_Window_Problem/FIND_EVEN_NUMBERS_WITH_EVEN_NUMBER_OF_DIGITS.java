public class FIND_EVEN_NUMBERS_WITH_EVEN_NUMBER_OF_DIGITS{



//Approach-1 (Using simple loop and counting digits)
//T.C : O(n * log10m)
//S.C : O(1)
class Solution1 {
    public boolean isEvenDigits(int num) {
        int digitCount = 0;
        while (num != 0) {
            digitCount++;
            num /= 10;
        }
        return (digitCount % 2) == 0;
    }

    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            if (isEvenDigits(num)) {
                result++;
            }
        }
        return result;
    }
}


//Approach-2 (converting to string)
//T.C : O(n * log10m)
//S.C : O(1)
class Solution2 {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            String s = Integer.toString(num);
            if (s.length() % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}


//Approach-3 (Using floor)
//T.C : O(n), assuming floor(log10(num)) function takes constant time
//S.C : O(1)
class Solution3 {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int digitCount = (int)Math.floor(Math.log10(num)) + 1;
            if (digitCount % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}


//Approach-4 (Using ceil)
//T.C : O(n), by assuming ceil(log10(num)) function takes constant time
//S.C : O(1)
class Solution4 {
    public int findNumbers(int[] nums) {
        int result = 0;
        for (int num : nums) {
            int digitCount = (int)Math.ceil(Math.log10(num + 1));
            if (digitCount % 2 == 0) {
                result++;
            }
        }
        return result;
    }
}


//Approach-5 (making use of given constraints )
//T.C : O(n)
//S.C : O(1)
class Solution5 {
    public int findNumbers(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if ((nums[i] >= 10 && nums[i] <= 99) ||
                (nums[i] >= 1000 && nums[i] <= 9999) ||
                (nums[i] == 100000)) {
                result++;
            }
        }
        return result;
    }
}




}