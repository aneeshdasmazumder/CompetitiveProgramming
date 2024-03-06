class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjL = new ArrayList<>();

        boolean[] isVisited = new boolean[numCourses];
        boolean[] recStk = new boolean[numCourses];

        Arrays.fill(isVisited, false);
        Arrays.fill(recStk, false);

        for(int i=0; i<numCourses; i++) {
            adjL.add(new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++) {
            adjL.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        for(int i=0; i<numCourses; i++) {
            if(!isVisited[i]) {
                if(!checkCourseSchedule(i,adjL,isVisited, recStk)) return false;
            }
        }

        return true;
    }

    public boolean checkCourseSchedule(int v, List<List<Integer>> adjL, boolean[] isVisited, boolean[] recStk) {
        isVisited[v] = true;
        recStk[v] = true;
        // System.out.println(v);
        for(Integer i : adjL.get(v)) {
            // System.out.println(v);
            
            if(!isVisited[i]) {
                if(!checkCourseSchedule(i,adjL,isVisited, recStk)) return false;
            } else if(recStk[i]) return false;
        }
        recStk[v] = false;
        // System.out.println(v);
        return true;
    }
}