class Solution {
    public String smallestSubsequence(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Stack<Character> stk = new Stack<>();
        Set<Character> set = new HashSet<>();
        for(int i=0; i<s.length(); i++) {
            if(!map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), 1);
            } else {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
        }

        for(int i=0; i<s.length(); i++) {
            if(!set.contains(s.charAt(i))) {
                while(!stk.isEmpty() && stk.peek() > s.charAt(i) && map.containsKey(stk.peek())) {
                    set.remove(stk.pop());

                }

                stk.push(s.charAt(i));
                set.add(s.charAt(i));
            }

            if(map.get(s.charAt(i)) == 1)
                map.remove(s.charAt(i));
            else map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }

        StringBuilder str = new StringBuilder();
        StringBuilder result = new StringBuilder();

        while(!stk.isEmpty()) {
            str.insert(0,stk.pop());
        }

        return str.toString();
    }
}