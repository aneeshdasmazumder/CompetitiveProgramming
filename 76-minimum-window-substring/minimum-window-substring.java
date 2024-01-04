class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length()) return "";
        // Define a HashMap to store the unique chars and count
        Map<Character, Integer> uniqueChar = new HashMap<>();

        int count = t.length();

        for(int i=0; i<count; i++) {
            if(!uniqueChar.containsKey(t.charAt(i))) {
                uniqueChar.put(t.charAt(i), 1);
            } else {
                uniqueChar.put(t.charAt(i), uniqueChar.get(t.charAt(i)) + 1);
            }
        }

        int left = 0; int right = 0; int l = -1; int r = -1;
        int minLength = s.length();
        int len = 0;
        String resultStr = "";
        while(left <= right && right < s.length()) {
            // System.out.println(count + " " + s.charAt(right));

            if(uniqueChar.containsKey(s.charAt(right))) {
                uniqueChar.put(s.charAt(right), uniqueChar.get(s.charAt(right)) - 1);
                if(uniqueChar.get(s.charAt(right)) >= 0)
                    count--;
            }

            
            while(count == 0) {
                
                if(uniqueChar.containsKey(s.charAt(left))) {
                    uniqueChar.put(s.charAt(left), uniqueChar.get(s.charAt(left)) + 1);
                    if(uniqueChar.get(s.charAt(left)) > 0)
                        count++;
                }

                if(count > 0) {
                    int diff = right - left;
                    if(diff < minLength) {
                        l = left;
                        r = right+1;
                        minLength = diff;
                    }
                }

                left++;
            }

            right++;
            
        }
        // System.out.println(l + " " + r);
        if(l >=0 && r >= 0)
            resultStr = s.substring(l, r);
        
        return resultStr;
    }
}