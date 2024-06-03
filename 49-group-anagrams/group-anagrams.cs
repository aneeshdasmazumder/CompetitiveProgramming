public class Solution {
    public IList<IList<string>> GroupAnagrams(string[] strs) {
        Dictionary<string, IList<string>> strMap = new Dictionary<string, IList<string>>();
        List<IList<string>> result = new List<IList<string>>();
        for(int i=0; i<strs.Length; i++) {
            char[] ch = strs[i].ToCharArray();

            Array.Sort(ch);

            string s = new string(ch);

            if(!strMap.ContainsKey(s)) {
                List<string> temp = new List<string>();
                temp.Add(strs[i]);
                strMap[s] = temp;
            } else {
                IList<string> temp = strMap[s];
                temp.Add(strs[i]);
                strMap[s] = temp;
            }
        }

        foreach(var val in strMap) {
            result.Add(val.Value);
        }

        return result;
    }
}