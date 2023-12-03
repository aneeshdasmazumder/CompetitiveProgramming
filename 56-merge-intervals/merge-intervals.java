class Solution {
    public int[][] merge(int[][] intervals) {

        if(intervals.length == 1) return intervals;

        List<Interval> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<intervals.length; i++) {
            list.add(new Interval(intervals[i][0], intervals[i][1]));
        }

        Collections.sort(list, new SortIntervals());

        Interval iv = new Interval(list.get(0).start, list.get(0).end);

        for(int i=1; i<list.size(); i++) {
            if(isOverLapping(iv, list.get(i))) {
                iv.start = Math.min(iv.start, list.get(i).start);
                iv.end = Math.max(iv.end, list.get(i).end);
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(iv.start);
                temp.add(iv.end);
                result.add(temp);
                iv.start = list.get(i).start;
                iv.end = list.get(i).end;
            }
        }
        result.add(Arrays.asList(iv.start, iv.end));
        int[][] resultIntervals = new int[result.size()][2];

        for(int i=0; i<result.size(); i++) {
            resultIntervals[i][0] = result.get(i).get(0);
            resultIntervals[i][1] = result.get(i).get(1);
        }

        return resultIntervals;
    }

    public boolean isOverLapping(Interval i, Interval j) {
        return i.end >= j.start;
    }
}

class SortIntervals implements Comparator<Interval> {
    public int compare(Interval i, Interval j) {
        return i.start - j.start;
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