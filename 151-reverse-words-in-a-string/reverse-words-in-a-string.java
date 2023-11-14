class Solution {
    public String reverseWords(String s) {
        List<String> str = new ArrayList<>();
        String st = "";
        int i=0;
        for(; i<s.length(); i++) {
            // System.out.println(s.charAt(i));
            if(Character.isWhitespace(s.charAt(i))) {
                str.add(st);
                st = "";
            } else {
                String tempS = String.valueOf(s.charAt(i));
                st = st + tempS;
            }
        }
        if(!Character.isWhitespace(s.charAt(i-1))) {
            str.add(st);
        }
        System.out.println(str);
        String newStr = "";

        for(int j=str.size() -1; j>=0; j--) {
            // System.out.println(str[i].trim());
            if(str.get(j) != "")
                newStr =newStr + str.get(j) + " ";
        }

        
        return newStr.trim();
    }
}