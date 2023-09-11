//{ Driver Code Starts
//Initial template for JAVA

import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])
    {
        //taking input using class Scanner
        Scanner sc = new Scanner(System.in);
        
        //taking total count of testcases
        int t = sc.nextInt();
        
        
        
        while(t-- > 0)
        {
            //taking total number of elements
            int n = sc.nextInt();
            
            //taking size of subArrays 
            int k = sc.nextInt();
            
            //Declaring and Intializing an array of size n
            int arr[] = new int[n];
            
            //adding all the elements to the array 
            for(int i = 0; i <n; i++)
            {
                arr[i] =sc.nextInt();
            }
            
            //Calling the method max_of_subarrays of class solve
            //and storing the result in an ArrayList
            ArrayList <Integer> res = new Solution().max_of_subarrays(arr, n, k);
            
            //printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++)
                System.out.print (res.get (i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function template for JAVA

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        int temp =0;
        int count = 0;
        int max=0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0; i<=(n-k); i++) {
            count=0;
            temp=i;
            max=0;
            while(count < k) {
                if(arr[temp] > max ) max = arr[temp];
                count++;
                temp++;
            }
            
            list.add(max);
        }
        
        // for loop from 0 to n-1
        // for(int i=0; i<n; i++) {
        //     if(queue.size() == k) {
        //         queue.poll();
        //         list.add(max);
        //         max = Math.max(max, arr[i]);
        //         queue.offer(arr[i]);
        //     } else {
        //         max = Math.max(max, arr[i]);
        //         queue.offer(arr[i]);
        //     }  
        // }
            
        // list.add(max);
            
        
        return list;
    }
}