class Solution {
    public void quickSort(int[] arr, int low, int high) {
        //System.out.println("low= "+low+" high= "+high);
        if(low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = low;

        while(low < arr.length && high >=0 && low < high) {
            while(low < arr.length && arr[low] <= arr[pivot]) low++;
            while(high >=0 && arr[high] > arr[pivot]) high--;

            if(low < high) swap(arr, low, high);
        }

        swap(arr, pivot, high);

        return high;
    }
    
    private void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}