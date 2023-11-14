class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        Map<Character, Integer> map = new HashMap<>();
        int len = s1.length();

        for(int i=0; i<len; i++) {
            if(!map.containsKey(s1.charAt(i))) {
                map.put(s1.charAt(i), 1);
            } else {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            }
        }
        int start = 0; int end = 0;
        int count = len;
        while(end < len) {
            if(map.containsKey(s2.charAt(end))) {
                if(map.get(s2.charAt(end)) > 0) count--;
                map.put(s2.charAt(end), map.get(s2.charAt(end)) - 1);
                
            }
            if(count == 0) return true;
            end++;
        }
        

        while (end < s2.length()) {
            if(map.containsKey(s2.charAt(start))) {
                map.put(s2.charAt(start), map.get(s2.charAt(start)) + 1);
                if(map.get(s2.charAt(start)) > 0) count++;
            }
            start++;

            if(map.containsKey(s2.charAt(end))) {
                if(map.get(s2.charAt(end)) > 0) count--;
                map.put(s2.charAt(end), map.get(s2.charAt(end)) - 1);
            }

            if(count == 0) return true;
            end++;
        }
        return false;
    }
}