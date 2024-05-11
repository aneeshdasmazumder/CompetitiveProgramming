public class Solution {
    public int[] ProductExceptSelf(int[] nums) {
        int size = nums.Length;
        int[] answer = new int[size];
        // Brute Force
        // for(int i=0; i<nums.Length; i++) {
        //     int product = 1;
        //     for(int j=0; j<nums.Length; j++) {
        //         if(i!=j) {
        //             product *= nums[j];
        //         }
        //     }

        //     answer[i] = product;
        // }

        // Optimized
        int[] prefix = new int[size];

        // Since left of nums[0] has nothing so prefix[0] = 1
        answer[0] = 1;

        // In every index, we are storing the product of all the values right to it.
        for(int i=1; i<size; i++) {
            answer[i] = answer[i-1] * nums[i-1];
        }

        int productOfRightIndex = 1;

        for(int i=size-1; i>=0; --i) {
            answer[i] = answer[i] * productOfRightIndex;
            productOfRightIndex *= nums[i];
        }

        return answer;
    }
}