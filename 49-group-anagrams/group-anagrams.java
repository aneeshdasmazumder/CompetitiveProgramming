class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap<>();
        List<List<String>> result = new ArrayList<>();

        for(int i=0; i<strs.length; i++) {
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);

            String s = new String(ch);

            if(!map.containsKey(s)) {
                List<String> tempList = new ArrayList<>();
                tempList.add(strs[i]);
                map.put(s, tempList);
            } else {
                List<String> tempList = map.get(s);
                tempList.add(strs[i]);
                map.put(s, tempList);
            }
        }

        Set<String> keys = map.keySet();

        for(String key : keys) {
            result.add(map.get(key));
        }

        return result;
    }
}