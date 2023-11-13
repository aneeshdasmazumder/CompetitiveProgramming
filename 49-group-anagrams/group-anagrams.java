class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        for(int i=0; i<strs.length; i++) {
            char[] str = strs[i].toCharArray();
            Arrays.sort(str);
            String newStr = new String(str);
            if(!map.containsKey(newStr)) {
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                map.put(newStr, temp);
            } else {
                List<String> temp = map.get(newStr);
                temp.add(strs[i]);
                map.put(newStr, temp);
            }
        }

        Set<String> keys = map.keySet();

        for(String key : keys) {
            result.add(map.get(key));
        }

        return result;
    }
}