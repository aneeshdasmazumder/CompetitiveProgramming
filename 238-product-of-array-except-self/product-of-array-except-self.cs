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
        int[] sufix = new int[size];
        prefix[0] = nums[0];

        for(int i=1; i<size; i++) {
            prefix[i] = prefix[i-1] * nums[i];
        }

        sufix[size-1] = nums[size-1];

        for(int i=size-2; i>=0; i--) {
            sufix[i] = sufix[i+1] * nums[i];
        }

        answer[0] = sufix[1];
        answer[size-1] = prefix[size-2];

        for(int i=1; i<size-1; i++) {
            answer[i] = prefix[i-1] * sufix[i+1];
        }

        return answer;
    }
}