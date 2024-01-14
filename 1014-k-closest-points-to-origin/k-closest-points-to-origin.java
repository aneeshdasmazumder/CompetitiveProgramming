class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(k, new DistanceComparator());

        int[][] result = new int[k][2];

        for(int i=0; i<k; i++) {
            int dist = (int)Math.pow(points[i][0], 2) + (int)Math.pow(points[i][1], 2);
            // System.out.println(points[i][0] + " &" + points[i][1]+" :" +dist);
            pq.offer(new Pair(dist, i));
        }

        for(int i=k; i<points.length; i++) {
            int dist = (int)Math.pow(points[i][0], 2) + (int)Math.pow(points[i][1], 2);
            // System.out.println(points[i][0] + " &" + points[i][1]+" :" +dist + " top: "+pq.peek().dist);
            if(dist < pq.peek().dist) {
                pq.poll();
                pq.offer(new Pair(dist, i));
            }
                
        }

        int i = 0;

        while(!pq.isEmpty()) {
            Pair p = pq.poll();
            result[i][0] = points[p.idx][0];
            result[i][1] = points[p.idx][1];
            i++;
        }

        return result;
    }
}

class Pair {
    int dist;
    int idx;

    Pair(int dist, int idx) {
        this.dist = dist;
        this.idx = idx;
    }
}

class DistanceComparator implements Comparator<Pair>{
    public int compare(Pair a, Pair b) {
        return -a.dist + b.dist;
    }
}