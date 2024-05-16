public class Solution {
    public int MinSubArrayLen(int target, int[] nums) {
        if(nums[0] == target) return 1;
        int left =0;
        int right = 0;
        int count = 0;
        int sum = 0;
        int minLen = Int32.MaxValue;
        while(right < nums.Length) {
            sum += nums[right];
            if(sum >= target) {
                minLen = Math.Min(minLen, (right - left) + 1);
                Console.WriteLine(right + " " +minLen + " " + sum);
            }
                
            
            while(sum > target  && left < right) {
                Console.WriteLine(right + " " +sum);
                sum -= nums[left];
                left++;
                if(sum >= target) {
                    minLen = Math.Min(minLen, (right - left) + 1);
                }
            }

            right++;
        }

        if(minLen == Int32.MaxValue) return 0;

        return minLen;
    }
}