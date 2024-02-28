//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.characterReplacement(s, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int characterReplacement(String s, int k)
    {
        Map<Character, Integer> charMap = new HashMap<>();
        int maxFreq = 0;
        int maxLen = 1;
        int left = 0, right = 0;
        
        while(right < s.length()) {
            if(!charMap.containsKey(s.charAt(right))) {
                charMap.put(s.charAt(right), 1);
            } else {
                charMap.put(s.charAt(right), charMap.get(s.charAt(right)) + 1);
            }
            
            maxFreq = Math.max(maxFreq, charMap.get(s.charAt(right)));
            
            if(((right - left) + 1) - maxFreq <= k) maxLen = Math.max(maxLen, ((right - left)+1));
            
            while(((right - left) + 1) - maxFreq > k) {
                charMap.put(s.charAt(left), charMap.get(s.charAt(left)) - 1);
                maxFreq = Math.max(maxFreq, charMap.get(s.charAt(left)));
                
                left++;
                
                if(((right - left) + 1) - maxFreq <= k) maxLen = Math.max(maxLen, ((right - left)+1));
            }
            
            right++;
        }
        
        return maxLen;
    }
}