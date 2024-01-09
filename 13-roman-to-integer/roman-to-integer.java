class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        map2.put("IV", 4);
        map2.put("IX", 9);
        map2.put("XL", 40);
        map2.put("XC", 90);
        map2.put("CD", 400);
        map2.put("CM", 900);
        int sum = 0;
        int i=s.length()-1;
        for(; i>0; i--) {
            String str = s.charAt(i-1) + "" +s.charAt(i);
            System.out.println("str :"+str);

            if(map2.containsKey(str)) {
                System.out.println(map2.get(str));
                sum += map2.get(str);
                i = i - 1;
            } else if(map.containsKey(s.charAt(i))) {
                System.out.println(map.get(s.charAt(i)));
                sum += map.get(s.charAt(i));
            }
        }

        if(i == 0) {
            System.out.println(map.get(s.charAt(i)));
            sum += map.get(s.charAt(i));
        }

        return sum;
    }
}