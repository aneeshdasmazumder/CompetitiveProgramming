class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        String[] str1 = s.split("");
        String[] str2 = t.split("");
        
        Arrays.sort(str1);
        Arrays.sort(str2);
        // for(int i=0; i<str1.length; i++) {
        //     System.out.println(str1[i] + " " + str2[i]);
        //     // if(str1[i] != str2[i])
        //     //     return false;
        // }
        
        for(int i=0; i<str1.length; i++) {
            // System.out.println(str1[i] + " " + str2[i]);
            if(!str1[i].equals(str2[i])) return false;
        }

        return true;
    }
}