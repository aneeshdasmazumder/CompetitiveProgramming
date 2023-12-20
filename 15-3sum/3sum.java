class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        // for(int i=0; i<nums.length; i++) {
        //     for(int j=i+1; j<nums.length; j++) {
        //         for(int k=j+1; k<nums.length; k++) {
        //             if(nums[i] + nums[j] + nums[k] == 0) {
        //                 temp.add(nums[i]);
        //                 temp.add(nums[j]);
        //                 temp.add(nums[k]);
        //                 result.add(temp);
        //                 temp = new ArrayList<>();
        //             }
        //         }
        //     }
        // }

        for(int i=0; i<nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i])+1);
            }
        }

        // int left = 0;
        // int right = nums.length - 1;
        Arrays.sort(nums);
        // while(left < right) {
        //     int value = nums[left] + nums[right];
        //     if(map.containsKey((0-value)) && map.get(0-value) != 1) {
        //         System.out.println((0-value) + " " + nums[left] + " " + nums[right]);
        //         temp.add(0-value);
        //         temp.add(nums[left]);
        //         temp.add(nums[right]);
        //         result.add(temp);
        //         temp = new ArrayList<>();
        //         if(map.get(0-value) == 1) map.remove(0-value);
        //         else map.put(0-value, map.get(0-value) - 1);
        //     }

        //     if(value <= 0) left++;
        //     else right--;
        // }
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            int left = i+1;
            int right = nums.length -1;

            while (left < right) {
                if(nums[i] + nums[left] + nums[right] == 0) {
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    set.add(temp);
                    temp = new ArrayList<>();
                }

                if(nums[left] + nums[right] + nums[i] <= 0) left++;
                else right--;
            }

            
        }

        for(List l : set) {
            result.add(l);
        }

        return result;
    }
}