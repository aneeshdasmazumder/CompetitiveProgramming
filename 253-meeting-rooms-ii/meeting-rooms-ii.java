class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 1) return 1;
        List<Interval> list = new ArrayList<>();

        for(int i=0; i<intervals.length; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        Collections.sort(list, new Comparator<Interval>() {
            public int compare(Interval i, Interval j) {
                return i.start - j.start;
            }
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>(list.size(), new Comparator<Integer> () {
            public int compare(Integer i, Integer j) {
                return i - j;
            }
        });

        pq.offer(list.get(0).end);

        for(int i=1; i<list.size(); i++) {
            if(list.get(i).start >= pq.peek()) {
                pq.poll();
            }

            pq.offer(list.get(i).end);
        }

        return pq.size();
    }
}

class Interval {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}