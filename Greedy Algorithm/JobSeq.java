import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class JobSeq {

    static class Jobs{

        int deadline;
        int profit;
        int id;

        public Jobs(int i, int d, int p){

            id = i;
            deadline = d;
            profit = p;
        }
    }
    public static void main(String[] args) {
        
        int jobInfo[][] = {{4, 20}, {2, 10}, {2, 40}, {2, 30}};

        ArrayList<Jobs> job = new ArrayList<>();

     for(int i=0; i<jobInfo.length; i++){

        job.add(new Jobs(i, jobInfo[i][0], jobInfo[i][1]));
     }

     //Sorted by profit  in descending order // FOR SORTING OBJECTS // This is Called Lemda Function
     Collections.sort(job, (obj1, obj2) -> obj2.profit - obj1.profit);//forAscending(obj1.PARAMETER-obj2.PARAMETER)


     ArrayList<Integer> seq = new ArrayList<>();
     int time = 0;

     for(int i=0; i<job.size(); i++){
        Jobs  curr = job.get(i);

        if (curr.deadline > time) {
            
            seq.add(curr.id);
            time++;
        }
     }

     System.out.println("max jobs: "+ seq.size());
     for(int i=0; i<seq.size(); i++){

        System.out.print(seq.get(i)+" ");
     }

     System.out.println();

    }
    
}
