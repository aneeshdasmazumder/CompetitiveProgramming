class Solution {
    public int numberOfBeams(String[] bank) {
        
        int prevLazer = 0;
        int ans = 0;
        for(String s: bank) {
            int currLazer = 0;
            for(char c: s.toCharArray()) {
                if(c == '1') {
                    currLazer++;
                }
            }

            if(currLazer > 0) {
                ans += (currLazer * prevLazer);
                prevLazer = currLazer;
            }
        }
        return ans;
    }
}