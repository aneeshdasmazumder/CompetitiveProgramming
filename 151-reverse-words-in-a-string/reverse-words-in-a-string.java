class Solution {
    public String reverseWords(String s) {
        List<String> str = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        st.append("");
        int i=0;
        for(; i<s.length(); i++) {
            // System.out.println(s.charAt(i));
            if(Character.isWhitespace(s.charAt(i))) {
                str.add(st.toString());
                st = new StringBuilder();
                st.append("");
            } else {
                String tempS = String.valueOf(s.charAt(i));
                st.append(tempS);
                // st = st + tempS;
            }
        }
        if(!Character.isWhitespace(s.charAt(i-1))) {
            str.add(st.toString());
        }
        System.out.println(str);
        StringBuilder newStr = new StringBuilder();
        newStr.append("");
        for(int j=str.size() -1; j>=0; j--) {
            // System.out.println(str[i].trim());
            if(str.get(j) != "")
                // newStr =newStr + str.get(j) + " ";
                newStr.append(str.get(j)).append(" ");
        }

        
        return newStr.toString().trim();
    }
}