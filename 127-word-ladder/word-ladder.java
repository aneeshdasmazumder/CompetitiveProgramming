class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord))
            return 0;
       int cnt=0;
        Set<String> dict = new HashSet<>(wordList);
        Queue<Pair> que = new LinkedList<>();
        dict.remove(beginWord);
        que.add(new Pair(beginWord, 1));

        while(!que.isEmpty()){
            int size = que.size();
            Pair pairedword = que.poll();
            if(pairedword.word.equals(endWord))
                return pairedword.step;
            for(int i=0; i<pairedword.word.length(); i++){
                for(char ch= 'a'; ch <= 'z'; ch++){
                    char[] arr = pairedword.word.toCharArray();
                    arr[i] = ch;
                    String midWord = new String(arr);
                    if(dict.contains(midWord)){
                        que.add(new Pair(midWord, pairedword.step+1));
                        dict.remove(midWord);
                    }
                }
            }
        }
        return 0; 
    }
}

class Pair {
    String word;
    int step;
    Pair(String word, int step) {
        this.word = word;
        this.step = step;
    }
}