import java.util.ArrayList;
import java.util.Collections;

public class Assignment {

    public static boolean isMonotonic(ArrayList<Integer> list) {

        int n = list.size()-1;
        boolean inc = true;
        boolean dec = true;

        for (int i = 0; i < n; i++) {

            if (list.get(i) > list.get(i + 1)) {
                inc = false;
            }
            if (list.get(i) < list.get(i + 1)) {

                dec = false;
            }

        }
        return inc || dec;
    }

    public static ArrayList<Integer> findingLonley(ArrayList<Integer> A){

        Collections.sort(A);
        ArrayList<Integer> sol = new ArrayList<>();

        for(int i=1 ;i<A.size()-1; i++){

            if(A.get(i-1) +1 < A.get(i) && A.get(i)+1 < A.get(i+1)){
                
                sol.add(A.get(i));
                
            }

        }
        if(A.size() == 1){

            sol.add(A.get(0));
          
        }

        if(A.size() > 1){

            if(A.get(0)+1 < A.get(1)){
                sol.add(A.get(0));
            }
            
            if(A.get(A.size()-2) < A.get(A.size()-1)){
                sol.add(A.get(A.size()-1));

            }
        }
        return sol;
    }

    public  static int mostFreqNum(ArrayList<Integer> nums, int key){

        int[]  result = new int[1000];

        for(int i=0; i<nums.size()-1; i++){

            if(nums.get(i) == key){
                result[nums.get(i+1)]++;
            }
        }

        int max =0; //for finding max occurence
        int ans =0; //to get - max occurence number
        for(int i=0; i<1000; i++){
                 
            if(max < result[i]){
                max = result[i];
                ans = i;
            }
        }
        return ans;
    }

    public static ArrayList<Integer> beautifyArray(int n){

        ArrayList<Integer> ans = new ArrayList<>();

        ans.add(1);

        for(int i=2; i<=n; i++){
            
            ArrayList<Integer> temp  = new ArrayList<>();
            for(Integer e:ans){
                
                if(2*e <= n){ temp.add(2*e);}
                if(2*e-1 <= n){ temp.add(2*e-1);}
            }

            ans = temp;

        }
        return ans;
    } 

    public static ArrayList<Integer> beautifulArray(int n){

        ArrayList<Integer> res =  new ArrayList<>();
        divideConq(1,1,res, n);

        return res;
    }

    private static void divideConq(int start, int increment,ArrayList<Integer> res, int n) {

        if(start+increment > n){
            res.add(start);
            return;
        }

        divideConq(start, increment*2, res, n);
        divideConq(start+increment, increment*2, res, n);
    }

    public static void main(String[] args) {

        ArrayList<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(2);
        nums.add(2);
        nums.add(2);
        nums.add(3);
        

        System.out.println(beautifyArray(4));
        System.out.println(beautifulArray(4));
    }

}
