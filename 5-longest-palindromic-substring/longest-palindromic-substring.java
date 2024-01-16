class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 1) return s;
        int low = 0;
        int high = 0;
        String lps = "";
        for(int i=1; i<s.length(); i++) {
            low = i;
            high = i;
            while(s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if(low < 0 || high == s.length()) break;
            }

            String palindrome = s.substring(low+1, high);
            if(palindrome.length() > lps.length()) 
                lps = palindrome;
            
            
            high = i;
            low = i-1;
            
            while(s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
                if(low < 0 || high == s.length()) break;
            }

            palindrome = s.substring(low+1, high);
            if(palindrome.length() > lps.length()) 
                lps = palindrome;
        }

        return lps;
    }
}