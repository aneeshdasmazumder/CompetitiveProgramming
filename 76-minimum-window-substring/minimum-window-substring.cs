public class Solution {
    public string MinWindow(string s, string t) {
        if(t.Length > s.Length) return "";
        if(s.Equals(t)) return s;
        Dictionary<char, int> tMap = new Dictionary<char, int>();
        int minLen = s.Length+1;
        int len = s.Length;
        int l = -1, r=-1;
        int count = t.Length;
        String result = "";
        for(int i=0; i<t.Length; i++) {
            if(tMap.ContainsKey(t[i])) {
                int c = tMap[t[i]];
                tMap[t[i]] = c+1;
            } else {
                tMap[t[i]] = 1;
            }
        }

        int right = 0, left = 0;

        while(right < s.Length) {
            if(tMap.ContainsKey(s[right])) {
                int c = tMap[s[right]];
                tMap[s[right]] = c-1;
                if(tMap[s[right]] >= 0) count--;
            }

            while(count == 0) {
                if(tMap.ContainsKey(s[left])) {
                    
                    int c = tMap[s[left]];
                    tMap[s[left]] = c+1;
                    if(tMap[s[left]] > 0) count++;
                }
                if(count > 0) {
                    len = (right - left) + 1;
                    if(minLen > len) {
                        minLen = len;
                        l = left;
                        r = minLen;
                    }
                }
                left++;
            }

            right++;
        }
        
        if(l >= 0 && r >= 0) {
            result = s.Substring(l, r);
        }

        return result;
    }
}