class Solution {
    public String minWindow(String s, String t) {
        int start = 0;
        int end = 0;
        int i=0;
        int j=s.length();
        int min = s.length();
        int count = t.length();
        boolean isPresent = false;
        Map<Character, Integer> map = new HashMap<>();
        for(int x=0; x< t.length(); x++) {
            map.put(t.charAt(x), map.getOrDefault(t.charAt(x), 0)+1);
        }
        // Start moving end from 0 and check if letter is present in the map
        while(end < s.length()) {
            // if count is not equal to 0
            
            System.out.println("Entering : "+end);
            // If found in map decrement the value and count (if value is >= 0)
            if(map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), map.get(s.charAt(end))-1);
                if(map.get(s.charAt(end)) >= 0)
                    count--;
            }
            end++;
        
            
        
            // loop until count > 0
            while(count == 0) {
                // check if i is present in the map
                if(map.containsKey(s.charAt(start))) {
                    // If yes increment the value in the map and count (if value is > 0)
                    map.put(s.charAt(start), map.get(s.charAt(start))+1);
                    if(map.get(s.charAt(start)) > 0)
                        count++;
                }
                    
                start++;
                if(count > 0) {
                    int diff = end - start;
                    if(diff < min) {
                        i = start-1;
                        j = end;
                        min = diff;
                    }
                    isPresent = true;
                }
            }
                
            // System.out.println("Start: "+start);
            // System.out.println("End: "+end);
            // System.out.println("count: "+count); 
        }
        // System.out.println(i);
        if(isPresent) {
            String finalStr = s.substring(i, j);
            return finalStr;
        } else return "";
        
            
    }
}