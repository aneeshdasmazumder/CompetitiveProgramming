class Solution {
    // Please change the array in-place
    public void insertionSort(int arr[]) {
        // code here
        
        for(int i=0; i<arr.length - 1; i++) {
            int n = i;
            int j = i+1;
            int temp = arr[j];
            while(n >= 0 && temp < arr[n]) {
                arr[j] = arr[n];
                j--;
                n--;
            }
            
            arr[j] = temp;
        }
    }
}