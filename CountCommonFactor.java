/*
 This problem is asked in one of the HackerEarth contests.

Problem Statement: Little Robert likes mathematics. Today his teacher has given him two integers and asked him to find out how many 
integers can divide both the numbers. Would you like to help him in completing his school assignment?

Input Formatting: There are two integers, a and b as input to the program.

Output Formatting: Print the number of common factors of a and b. Both the input value should be in a range of 1 to 10^12.
 */

import java.util.Scanner;

class CountCommonFactor {

    static int findCount( int val1, int val2) {
        int count = 0;
        int divisor = 1;
        while(divisor <= val1) {
            if(val1 % divisor == 0 && val2 % divisor == 0) {
                System.out.println("divisor= "+divisor);
                count = count +1;
            }
            divisor++;
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();

        int b = sc.nextInt();
        int count = 0;
        if(a < b) {
            count = findCount(a, b);
        } else {
            count = findCount(b, a);
        }

        System.out.println(count);
        
    }

    

}