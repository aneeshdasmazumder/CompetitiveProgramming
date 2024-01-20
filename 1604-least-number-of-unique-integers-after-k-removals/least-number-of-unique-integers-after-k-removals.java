class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        
        // if(k > arr.length) return -1;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], 1);
            } else {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
        }
        if(k == 0) return map.size();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<Integer, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        Set<Integer> keys = result.keySet();
        for(Integer key : keys) {
            if(k >= result.get(key)) {
                k = Math.abs(k - result.get(key));
                result.put(key, 0);
            } else {
                map.put(key, result.get(key) - k);
                k=0;
            }
            // System.out.println(result.get(key)); 
        }
        int count = 0;
        for(Integer key : keys) {
            if(result.get(key) > 0)
                count++;
            // System.out.println(result.get(key)); 
        }

        return count;
    }
}