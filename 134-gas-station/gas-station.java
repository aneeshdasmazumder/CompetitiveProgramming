class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int remaining=0;
        int total=0;
        int start=0;

        for(int i=0;i<gas.length;i++){
            int diff=gas[i]-cost[i];
            if(remaining>=0){
                remaining+=diff;
            }
            else{
                remaining=diff;
                start=i;
            }
            total+=diff;
        }
        if(total>=0){
            return start;
        }
        else{
            return -1;
        }
    }
}