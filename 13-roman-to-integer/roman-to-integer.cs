public class Solution {
    public int RomanToInt(string s) {
        Dictionary<char, int> symb1 = new Dictionary<char, int>();
        Dictionary<string, int> symb2 = new Dictionary<string, int>();

        symb1['I'] = 1;
        symb1['V'] = 5;
        symb1['X'] = 10;
        symb1['L'] = 50;
        symb1['C'] = 100;
        symb1['D'] = 500;
        symb1['M'] = 1000;

        symb2["IV"] = 4;
        symb2["IX"] = 9;
        symb2["XL"] = 40;
        symb2["XC"] = 90;
        symb2["CD"] = 400;
        symb2["CM"] = 900;

        int sum = 0;
        int i = s.Length - 1;

        for(; i>0; i--) {
            string str = s[i-1] + "" + s[i];

            if(symb2.ContainsKey(str)) {
                sum += symb2[str];
                i = i-1;
            } else {
                sum += symb1[s[i]];
            }
        }

        if(i==0) {
            sum += symb1[s[i]];
        }

        return sum;
    }
}