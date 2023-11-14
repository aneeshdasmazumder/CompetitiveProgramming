class Solution {
    public boolean canPermutePalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i))+1);
            }
        }
        Set<Character> keys = map.keySet();
        if(s.length() % 2 == 0) {
            for(Character key : keys) {
                if(map.get(key) % 2 != 0) return false;
            }

            return true;
        } else {
            int isOdd = 0;
            for(Character key : keys) {
                if(map.get(key) % 2 != 0) {
                    isOdd++;
                    if(isOdd > 1) return false;
                } 
            }

            return true;
        }
    }
}