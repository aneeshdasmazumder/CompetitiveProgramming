class Solution {
    void selectionSort(int[] arr) {
        // code here
        for(int i=0; i<arr.length - 1; i++) {
            int indx = i;
            for(int j=i+1; j<arr.length; j++) {
                if(arr[indx] > arr[j]) {
                    indx = j;
                }
            }
            
            int temp = arr[indx];
            arr[indx] = arr[i];
            arr[i] = temp;
        }
    }
}