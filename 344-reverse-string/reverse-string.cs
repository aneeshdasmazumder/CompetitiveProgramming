public class Solution {
    public void ReverseString(char[] s) {
        int len = s.Length;

        if(len%2==0)
            evenArrayRev(s);
        else oddArrayRev(s);
    }

    public void evenArrayRev(char[] s) {
        int left = 0;
        int right = s.Length - 1;

        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++; right--;
        }
    }

    public void oddArrayRev(char[] s) {
        int left = 0;
        int right = s.Length - 1;
        int mid = (right - left) / 2;
        while(left<mid && right>mid) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++; right--;
        }
    }
}