class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> keyMaps = new HashMap<>();
        List<String> listOfStrs = new ArrayList<>();
        if(digits.length() == 0) return listOfStrs;
        assignKeys(keyMaps);

        fetchListofStringsFromDigits(digits, "", keyMaps, listOfStrs, 0);

        return listOfStrs;


    }

    public void fetchListofStringsFromDigits(String digits, String resultStr,  Map<Character, List<Character>> keyMaps, List<String> listOfStrs, int idx) {

        if(idx == digits.length()) {
            listOfStrs.add(resultStr); return;
        }
        char digit = digits.charAt(idx);
        List<Character> digitsChar = keyMaps.get(digit);
        for(char ch : digitsChar) {
            fetchListofStringsFromDigits(digits, resultStr + ch, keyMaps, listOfStrs, idx+1);
        }
    }

    public void assignKeys(Map<Character, List<Character>> keyMaps) {
        keyMaps.put('2', Arrays.asList('a', 'b', 'c'));
        keyMaps.put('3', Arrays.asList('d', 'e', 'f'));
        keyMaps.put('4', Arrays.asList('g', 'h', 'i'));
        keyMaps.put('5', Arrays.asList('j', 'k', 'l'));
        keyMaps.put('6', Arrays.asList('m', 'n', 'o'));
        keyMaps.put('7', Arrays.asList('p', 'q', 'r', 's'));
        keyMaps.put('8', Arrays.asList('t', 'u', 'v'));
        keyMaps.put('9', Arrays.asList('w', 'x', 'y', 'z'));

        // return map;
    }
}