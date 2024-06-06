class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> charMap = new HashMap<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(s.length(), new CharSort());
        String result = "";
        for(int i=0; i<s.length(); i++) {
            if(!charMap.containsKey(s.charAt(i))) {
                charMap.put(s.charAt(i), 1);
            } else {
                charMap.put(s.charAt(i), charMap.get(s.charAt(i))+1);
            }
        }

        for(Map.Entry<Character, Integer> m : charMap.entrySet()) {
            pq.offer(new Pair(m.getKey(), m.getValue()));
        }

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            int c = p.count;
            System.out.println("c: "+c);
            for(int i=0; i<c; i++) {
                System.out.println("ch: "+p.ch);
                result = result + p.ch;
            }
            
        }

        return result;
    }
}

public class Pair {
    char ch;
    int count;

    Pair(char ch, int count) {
        this.ch = ch;
        this.count = count;
    }
}

class CharSort implements Comparator<Pair> {
    public int compare(Pair a, Pair b) {
        return b.count - a.count;
    }
}