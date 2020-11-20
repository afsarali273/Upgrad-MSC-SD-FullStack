/*
Pair With a Given Sum
Description
You will be given an array of integers and a target sum. You have to check whether there exist any two integers in the array whose sum is equal to the given target sum. If so, then print true; otherwise, print false.

Input: The input will be in the following format:
The first line will be ‘n’ indicating the size of the input array, i.e., the number of integers in the array.
The next line will be ‘n’ integers, indicating the integers of the array.
The next line will be the target sum.
Output: The output should be in the following format:
If there exist any two integers in the array whose sum is equal to the given target sum then print ‘true’; otherwise, print ‘false’.

Sample input-1:
6
1 7 40 8 -7 3
15

Sample output-1:
true
The first input is 'n', that is the size of the input array. The next line of input represents n integers space-separated. The last input is the target sum. The output is true because there exist 2 integers in the input array whose sum is equal to the target sum that is 7,8.

Sample Input-2:
6
1 7 40 8 -7 3
1

Sample output-2:
true
The first input is 'n', that is the size of the input array. The next line of input represents n integers space-separated. The last input is the target sum. The output is true because there exist 2 integers in the input array whose sum is equal to the target sum that is 7,8. 
Execution Time Limit
15 seconds

*/

import java.util.Scanner;

class HashMap_FindPairOfGivenSum
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);

        // number of the elements
        int n = in.nextInt();

        int array[] = new int[n];

        //storing the input integers to an array
        for(int i =0;i<n;i++){
            array[i] = in.nextInt();
        }
        
        // getting the target sum from input
        int targetSum = in.nextInt();
        
        boolean flag = false; 
  
        // Consider all possible pairs and check their sums 
        for (int i = 0; i < array.length; i++) 
            for (int j = i + 1; j < array.length; j++) 
                if ((array[i] + array[j]) == targetSum) 
                    flag=true; 
                    
        System.out.println(flag); 
    }
} 
