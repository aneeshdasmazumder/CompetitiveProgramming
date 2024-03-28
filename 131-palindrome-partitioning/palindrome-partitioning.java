class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> tempResultStr = new ArrayList<>();
        getAllPalindromicPartition(s, result, 0, tempResultStr);
        return result;
    }

    public void getAllPalindromicPartition(String s, List<List<String>> result, int idx, List<String> tempResultStr) {
        if(idx == s.length()) {
            // System.out.println(tempResultStr);
            List<String> temp = new ArrayList<>();
            temp.addAll(tempResultStr);
            // System.out.println("temp: "+temp);
            result.add(temp);
            // System.out.println(result);
            return;
        }
        // int j = idx;
        
        for(int i=idx+1; i<= s.length(); i++) {
            // j = j+1;
            String tempStr = s.substring(idx,i);
            // System.out.println("tempStr: "+ idx + " " + i + " " +tempStr);
            if(isPalindrome(tempStr)) {
                // str = str + tempStr;
                tempResultStr.add(tempStr);
                // System.out.println("str before: "+ idx + " " +tempResultStr);
                getAllPalindromicPartition(s, result, i, tempResultStr);
                // System.out.println("str after: "+ idx + " " +tempResultStr);
                tempResultStr.remove(tempResultStr.size()-1);
            }
            
            // System.out.println("result: "+result);
        }

        
    }

    public boolean isPalindrome(String plmStr) {
        int len = plmStr.length();
        int mid = len / 2;
        if(len % 2 == 0) {
            int left = mid-1;
            int right = mid;

            while(plmStr.charAt(left) == plmStr.charAt(right)){
                left--; right++;
                if(left < 0 || right >= plmStr.length()) {
                    return true;
                }
            }
        } else {
            int left = mid;
            int right = mid;

            while(plmStr.charAt(left) == plmStr.charAt(right)) {
                left--; right++;
                if(left < 0 || right >= plmStr.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}