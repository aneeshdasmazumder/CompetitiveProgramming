class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) return result;
        Map<Character, Integer> map = new HashMap<>();
        int len = p.length();
        
        for(int i=0; i<len; i++) {
            if(!map.containsKey(p.charAt(i))) {
                map.put(p.charAt(i), 1);
            } else {
                map.put(p.charAt(i), map.get(p.charAt(i)) + 1);
            }
        }
        int start = 0; int end = 0;
        int count = len;
        while(end < len) {
            if(map.containsKey(s.charAt(end))) {
                if(map.get(s.charAt(end)) > 0) count--;
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
                
            }
            if(count == 0) result.add(start);
            end++;
        }
        

        while (end < s.length()) {
            if(map.containsKey(s.charAt(start))) {
                map.put(s.charAt(start), map.get(s.charAt(start)) + 1);
                if(map.get(s.charAt(start)) > 0) count++;
            }
            start++;

            if(map.containsKey(s.charAt(end))) {
                if(map.get(s.charAt(end)) > 0) count--;
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
            }

            if(count == 0) result.add(start);
            end++;
        }
        return result;
    }
}