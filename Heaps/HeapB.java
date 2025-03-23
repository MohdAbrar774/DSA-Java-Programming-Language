import java.util.ArrayList;

public class HeapB {
    

    static class  heap{
        ArrayList<Integer> arr = new ArrayList<>();


        public void add(int data){

            arr.add(data);

            int x = arr.size()-1;
            int para = (x-1)/2;

            while (arr.get(x) < arr.get(para)) {
                //swap
                int temp = arr.get(x);
                arr.set(x,arr.get(para));
                arr.set(para,temp);

                x = para;
                para = (x-1)/2;
            }
        }

        public  int peek(){
            return arr.get(0);
        }

        public boolean isEmpty(){
            return arr.size() == 0;
        }
        private void heapify(int i){

            int left = 2*i+1;
            int right = 2*i+2;
            int minIdx = i;

            if(left < arr.size() && arr.get(left) < arr.get(minIdx)){
                minIdx = left;
            }

            if(right < arr.size() && arr.get(right) < arr.get(minIdx)){
                minIdx = right;
            }

            if(minIdx != i){
                int temp = arr.get(i);
                arr.set(i,arr.get(minIdx));
                arr.set(minIdx,temp);
                
                heapify(minIdx);
            }


        }

        public int remove(){
            //step 1 - swap first and last ele
            int data = arr.get(0);

            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size()-1));
            arr.set(arr.size()-1, temp);

            //Remove last ele
            arr.remove(arr.size()-1);

            //step 3- call heapify 
            heapify(0);

            return data;

        }
    }



    public static void main(String[] args) {
        heap pq = new heap();

        pq.add(2);
        pq.add(4);
        pq.add(5);
        pq.add(3);
        pq.add(7);
System.out.println();
        while (!pq.isEmpty()) {
            System.out.print(pq.peek()+" ");
            pq.remove();
        }
        System.out.println();
    }
}
