class Solution {
    public boolean isBipartite(int[][] graph) {
        List<List<Integer>> adjL = new ArrayList<>();

        // for(int i=0; i<graph.length; i++) {
        //     adjL.add(new ArrayList<>());
        // }

        // for(int i=0; i<graph.length; i++) {
        //     for((int))
        //     adjL.get(i).add(graph[i][0]);
        //     adjL.get(i).add(graph[i][1]);
        // }

        int[] isVisited = new int[graph.length];

        Arrays.fill(isVisited, 0);

        for(int i=0; i<graph.length; i++) {
            for(int j=0; j<graph[i].length; j++) {
                // System.out.println(graph[i][j] + " " + isVisited[graph[i][j]]);
                if(isVisited[graph[i][j]] == 0) {
                    if(!checkBipartite(i, graph, isVisited, 1, -1)) return false;
                }
            }
        }

        return true;
    }

    public boolean checkBipartite(int v, int[][] graph, int[] isVisited, int count, int parent) {
        // System.out.println(parent + " " + v + " " + isVisited[v]);
        if(isVisited[v] != 0) {
            if(isVisited[v] == count) return false;
            return true;
        }
        isVisited[v] = count;
        
        for(int i : graph[v]) {
            if(isVisited[i] == 0) {
                if(!checkBipartite(i, graph, isVisited, -(count), v)) return false;
            } else if(i != parent) {
                if(isVisited[i] == isVisited[v]) return false;
            }
        }

        return true;
    }
}