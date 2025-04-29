package algopractice;

/**
 * @author trinapal
 */
public class HeapSortPractice {
    public static void main(String[] args) {
        int [] arr = new int [] {9,7,3,4,6,9,10};
        heapSort(arr);
        printSortedArray(arr);
    }

    private static void printSortedArray(int[] arr) {
        for(int num: arr){
            System.out.println(num + " ");
        }
    }

    private static void heapify(int[] arr, int n, int i) {

        int largest = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left <n && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < n && arr[right]>arr[largest]){
            largest = right;
        }

        if(largest != i){
            swap(arr, largest, i);
            heapify(arr,n,largest);
        }
    }

    private static void swap(int[] arr, int largest, int i) {
        int temp = arr[largest];
        arr[largest] = arr[i];
        arr[i] = temp;
    }

    private static void heapSort(int[] arr) {
        //build max heap
        int n = arr.length;
        for(int i = n/2-1; i>= 0;i--){
            heapify(arr, n, i);
        }
        //extract last element and swap it with root
        for(int i = n-1; i >=0; i--){
            swap(arr, 0, i);
            //then heapify
            heapify(arr, i, 0);
        }
    }


}
