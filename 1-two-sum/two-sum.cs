public class Solution {
    public int[] TwoSum(int[] nums, int target) {
        Dictionary<int, int> val = new Dictionary<int, int>();
        int[] result = new int[2];
        for(int i=0; i<nums.Length; i++) {
            val[nums[i]] = i;
        }

        // for(int i=0; i<nums.Length; i++) {
        //     Console.WriteLine(val[nums[i]]);
        // }

        for(int i=0; i<nums.Length; i++) {
            // Console.WriteLine(target - nums[i] + " " + val[target - nums[i]] + " " + i);
            if(val.ContainsKey(target - nums[i]) && val[target - nums[i]] != i) {
                // Console.WriteLine(val[nums[i]]);
                result[0] = i;
                // Console.WriteLine(result[0]);
                result[1]  = val[target - nums[i]];

                return result;
            }
        }

        return result;

    }
}