import java.util.ArrayList;

public class HeapB {

    static class heap {
        ArrayList<Integer> arr = new ArrayList<>();

        public void add(int data) {

            arr.add(data);

            int x = arr.size() - 1;
            int para = (x - 1) / 2;

            while (arr.get(x) < arr.get(para)) {
                // swap
                int temp = arr.get(x);
                arr.set(x, arr.get(para));
                arr.set(para, temp);

                x = para;
                para = (x - 1) / 2;
            }
        }

        public int peek() {
            return arr.get(0);
        }

        public boolean isEmpty() {
            return arr.size() == 0;
        }

        private void heapify(int i) {

            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int minIdx = i;

            if (left < arr.size() && arr.get(left) < arr.get(minIdx)) {
                minIdx = left;
            }

            if (right < arr.size() && arr.get(right) < arr.get(minIdx)) {
                minIdx = right;
            }

            if (minIdx != i) {
                int temp = arr.get(i);
                arr.set(i, arr.get(minIdx));
                arr.set(minIdx, temp);

                heapify(minIdx);
            }

        }

        public int remove() {
            // step 1 - swap first and last ele
            int data = arr.get(0);

            int temp = arr.get(0);
            arr.set(0, arr.get(arr.size() - 1));
            arr.set(arr.size() - 1, temp);

            // Remove last ele
            arr.remove(arr.size() - 1);

            // step 3- call heapify
            heapify(0);

            return data;

        }
    }

    public static void heapSort(int arr[]) {
        // Step 1 - Build maxHeap
        int n = arr.length;

        for (int i = n / 2; i >= 0; i--) {

            heapify(arr, i, n);
        }

        // Step 2 - push larger to end
        for (int i = n - 1; i > 0; i--) {

            // Swap(largest first with last)
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, 0, i); //Call for n-1,..........1
        }
    }

    public static void heapify(int arr[], int i, int size) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int maxIdx = i;

        if (left < size && arr[left] > arr[maxIdx]) {
            maxIdx = left;
        }

        if (right < size && arr[right] > arr[maxIdx]) {
            maxIdx = right;
        }

        if (maxIdx != i) {

            // swap
            int temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;

            heapify(arr, maxIdx, size);
        }
    }

    public static void main(String[] args) {
     int arr[] = {1, 2, 4, 3, 5};
     heapSort(arr);

     for(int i=0; i<arr.length; i++){
        System.out.print(arr[i]+" ");
     }
     System.out.println();
    }
}
