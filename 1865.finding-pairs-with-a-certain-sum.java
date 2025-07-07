/*
 * @lc app=leetcode id=1865 lang=java
 *
 * [1865] Finding Pairs With a Certain Sum
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FindSumPairs {
    List<Integer> v1;
    List<Integer> v2;
    HashMap<Integer,Integer> map = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
    this.v1 = new ArrayList<>();
    for(int n:nums1){
        v1.add(n);
    }

      this.v2 = new ArrayList<>();
    for(int n:nums2){
        v2.add(n);
    }
     for(int n:nums2){
        map.put(n, map.getOrDefault(n,0)+1);
     }
    }
    
    public void add(int index, int val) {
        int oldVal = v2.get(index);
        map.put(oldVal,map.get(oldVal)-1);
        if(map.get(oldVal) == 0){
            map.remove(oldVal);
        }
        int newVal = oldVal + val;
        v2.set(index, newVal); 
        map.put(newVal,map.getOrDefault(newVal,0)+1);
    }
    
    public int count(int tot) {
        int c = 0;

        for(int v:v1){
            
            if(map.containsKey(tot-v)){
                c += map.get(tot-v);
            }
        }

        return c;
        
    }
}

/**
 * Your FindSumPairs object will be instantiated and called as such:
 * FindSumPairs obj = new FindSumPairs(nums1, nums2);
 * obj.add(index,val);
 * int param_2 = obj.count(tot);
 */
// @lc code=end

