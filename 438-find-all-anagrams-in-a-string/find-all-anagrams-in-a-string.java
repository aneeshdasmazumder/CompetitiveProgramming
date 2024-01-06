class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        if(p.length() > s.length()) return result;
        int count = p.length();

        for(int i=0; i< count; i++) {
            if(!map.containsKey(p.charAt(i))) {
                map.put(p.charAt(i), 1);
            } else {
                map.put(p.charAt(i), map.get(p.charAt(i)) + 1);
            }
        }
        int left = 0, right = 0;
        
        while(right < p.length()) {
            if(map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if(map.get(s.charAt(right)) >= 0) count--;
            }

            right++;
        }

        if(count == 0) result.add(left);

        while(right < s.length()) {

            if(map.containsKey(s.charAt(left))) {
                map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                if(map.get(s.charAt(left)) > 0) count++;
            }
            left++;

            if(map.containsKey(s.charAt(right))) {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                if(map.get(s.charAt(right)) >= 0) count--;
            }
            if(count == 0) result.add(left);
            right++;
        }

        return result;
    }
}