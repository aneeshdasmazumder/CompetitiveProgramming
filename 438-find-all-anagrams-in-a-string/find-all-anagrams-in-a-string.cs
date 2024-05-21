public class Solution {
    public IList<int> FindAnagrams(string s, string p) {
        if(s.Length < p.Length) return new List<int>();
        List<int> result = new List<int>();
        Dictionary<char, int> charMap = new Dictionary<char, int>();
        int count = p.Length;
        for (int i = 0; i <= count - 1; i++ ) {
            if(charMap.ContainsKey(p[i])) {
                int c = charMap[p[i]];
                charMap[p[i]] = c+1;
                
            } else {
                charMap.Add(p[i], 1);
            }
        }
        int left =0;
        int right =0;
        
        while(right < p.Length) {
            if(charMap.ContainsKey(s[right])) {
                int c = charMap[s[right]];
                charMap[s[right]] = c-1;
                if(charMap[s[right]] >= 0) count--;
            }
            right++;
        }

        if(count == 0) 
            result.Add(left);

        while(right < s.Length) {
            if(charMap.ContainsKey(s[left])) {
                int c = charMap[s[left]];
                charMap[s[left]] = c+1;
                if(charMap[s[left]] > 0) count++;
            }

            left++;

            if(charMap.ContainsKey(s[right])) {
                int c = charMap[s[right]];
                charMap[s[right]] = c-1;
                if(charMap[s[right]] >= 0)
                    count--;
            }
            
            if(count == 0) {
                result.Add(left);
            }
                

            right++;
        }

        return result;
    }
}