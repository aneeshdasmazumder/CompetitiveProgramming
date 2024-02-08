class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjL = new ArrayList<>();

        for(int i=0; i<n; i++) {
            adjL.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {
            adjL.get(edges[i][0]).add(edges[i][1]);
            adjL.get(edges[i][1]).add(edges[i][0]);
        }

        boolean[] isVisited = new boolean[n];
        
        for(int i=0; i<n; i++) {
            isVisited[i] = false;
        }

        Queue<Integer> q = new LinkedList<>();

        // for(int i=0; i<adjL.size(); i++) {
        //     if(!isVisited[i]) {
        //         System.out.println(i);
        //         q.offer(i);
        //         if(isTree(i, isVisited, adjL, q)) return 1;
        //     }
                
        // }

        for(int i=0; i<adjL.size(); i++) {
            if(!isVisited[i]) {
                if(i > 0) return false;
                q.offer(i);

                while(!q.isEmpty()) {
                    int val = q.poll();
                    if(isVisited[val]) return false;

                    isVisited[val] = true;
                    // System.out.println(adjL.get(val));
                    for(Integer j : adjL.get(val)) {
                        if(!isVisited[j])
                            q.offer(j);
                    }
                }
            }
        }

        return true;
    }
}