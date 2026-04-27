class Solution {
    public void quickSort(int[] arr, int low, int high) {
        //System.out.println("low= "+low+" high= "+high);
        if(low < high) {
            int pi = partition(arr, low, high);
            //System.out.println("pi = "+pi+" v= "+arr[pi]);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        
        int lb = low;
        int rb = high;
        
        int pivot = low;
        while(lb <arr.length-1 && rb >= 0 && lb < rb) {
            while(lb <arr.length-1 && arr[lb] <= arr[pivot]) lb++;
            while(rb >= 0 && arr[rb] > arr[pivot]) rb--;
            if(lb < rb) swap(arr, lb, rb);
        }
        
        swap(arr, pivot, rb);
        return rb;
    }
    
    private void swap(int[] arr, int low, int high) {
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}