class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxFreq = 0;
        int result = 1;
        int left = 0, right = 0;

        // Loop from left -> right
        while(right < s.length()) {

            // Store the frequency
            if(!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), 1);
            } else {
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            }

            // Store the most frequent char
            maxFreq = Math.max(maxFreq, map.get(s.charAt(right)));

            // Check is number of exchange can be done
            if(((right - left) + 1) - maxFreq <= k) result = Math.max(result, (right - left) + 1);

            
            while(((right - left) + 1) - maxFreq > k) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                maxFreq = Math.max(maxFreq, map.get(s.charAt(left)));
                left++;
                
                if(((right - left) + 1) - maxFreq <= k) result = Math.max(result, (right - left) + 1);
            }

            right++;
        }

        return result;
    }
}