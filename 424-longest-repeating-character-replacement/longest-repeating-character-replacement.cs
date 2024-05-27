public class Solution {
    public int CharacterReplacement(string s, int k) {
        Dictionary<char, int> dic = new Dictionary<char, int>();

        int maxFreq = 0;
        int maxLen = 0;
        int left = 0, right = 0;

        while(right < s.Length) {
            if(dic.ContainsKey(s[right])) {
                int i = dic[s[right]];
                dic[s[right]] = i+1;
            } else {
                dic[s[right]] = 1;
            }

            maxFreq = Math.Max(maxFreq, dic[s[right]]);

            if(((right - left) + 1 ) - maxFreq <= k) {
                maxLen = Math.Max(maxLen, (right - left) + 1);
            }

            while(((right - left) + 1 ) - maxFreq > k) {
                int i = dic[s[left]];
                dic[s[left]] = i-1;
                left++;
                maxFreq = Math.Max(maxFreq, dic[s[left]]);
            }

            right++;
        }

        return maxLen;
    }
}