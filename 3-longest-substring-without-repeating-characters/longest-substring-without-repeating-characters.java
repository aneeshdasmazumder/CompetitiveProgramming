class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        Map<Character,Integer> map = new HashMap<>();
        int left = 0;
        int right = 1;
        int length = 1;
        map.put(s.charAt(0), 0);
        while(right < s.length()) {
            if(!map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), right);
            } else {
                if(map.get(s.charAt(right)) >= left) {
                    left = map.get(s.charAt(right)) + 1;
                }
                map.put(s.charAt(right), right);
            }

            length = Math.max(length, ((right - left)+1));
            right++;
        }

        return length;
    }
}