class Solution {
    public String reverseWords(String s) {
        String str = "";
        String resultStr = "";
        StringBuilder builder = new StringBuilder();
        // continue checking from last until the string ends
        for(int i=s.length()-1; i>=0; i--) {
            // Go on concatinating letters until space is found
            String newStr = String.valueOf(s.charAt(i));
            if(!newStr.equals(" ")) {
                
                str = newStr.concat(str);
                // System.out.println(str);
            } else if(newStr.equals(" ") && !str.equals("")){
                resultStr = resultStr + str + " ";
                // System.out.println(resultStr);
                str = "";
            }

            if(i==0 && !str.equals("")) {
                resultStr = resultStr + str;
                // System.out.println(resultStr);
                str = "";
            }

        }
        // System.out.println(resultStr);
        return resultStr.trim();
    }
}