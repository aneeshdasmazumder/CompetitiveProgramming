/*
 Problem Statement: Suppose you have given the stock prices for respective days like (100, 180, 260, 310, 40, 535, 695). The stock price for the 1st day is 100, the 2nd day it is 180 and so on. Write a Python program to determine what days the user should buy and sell the stocks to get the maximum profit.

In the above case, in the following scenarios user will get maximum profit.

Buy stock on 1st day (100)
Sell stock on 4th day (310)
Buy stock on 5th day  (100)
Sell stock on 7th day (695)
 */

import java.util.Scanner;

public class GoldmanSachs {

    static void trade(int[] stockPrice) {
        int Buy = stockPrice[0];
        int day = 1;
        int i = 1;
        System.out.println("Buy stock on day "+day+" "+Buy);
        for(i=1; i< stockPrice.length; i++) {
            day++;
            if(stockPrice[i] < Buy) {
                System.out.println("sell stock on day "+(day-i)+" "+stockPrice[i -1]);
                Buy = stockPrice[i];
                System.out.println("Buy stock on day "+day+" "+Buy);
            }

            if(i == stockPrice.length - 1 && stockPrice[i] > Buy)
                System.out.println("sell stock on day "+day+" "+stockPrice[i]);
        }
    }

    public static void main(String[] args) {
        int[] stockPrice = new int[7];
        Scanner sc = new Scanner(System.in);

        for(int i=0; i< stockPrice.length; i++) {
            stockPrice[i] = sc.nextInt();
        }
        trade(stockPrice);

    }
}
