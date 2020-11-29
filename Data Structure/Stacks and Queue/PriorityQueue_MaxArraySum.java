/*
Modify an Array
Description
Consider that you have an array of size N and a number K. You must modify the array K times such that after K operations the sum of all elements in the array is the greatest and no greater sum can be achieved. 

In each modification, you can replace an array element, arr[i], with (-1)*arr[i]. Now, take a look at the given code. The maxSum() function in the code is incomplete. Your task is to complete the code and so that it outputs the desired solution.

Note: The array contains both negative and positive integers.

Hint: Use Priority Queue ADT and its functions.

Input: 
       1. The first line contains N.
       2. The second line contains K. 
       3. The following N lines inputs is N number of elements in the array.
Output: 
       1. An integer that shows the sum of the final array elements.

Sample input-1:
 7   
4
4
-3
6
2
-1
0
1

Sample output-1: 
17

Explanation:
Here N=7 (size of the array) and K=4 (number of times operation has to be performed).
At first, the minimum element will be replaced; thus, replace -3 with -(-3) to make it 3.
Second, replace the next minimum, -1 with -(-1) to make it 1.
Third, replace 0 with -(0) to make it 0.
Lastly, replace 0 with -(0) to make it 0.
The output is 17, that is, the sum of the elements after 4 operations.

Sample input-2:
12 
5 
-3 
4 
6 
0 
1 
-1 
2 
-21 
9 
11 
-10 
5
Sample output-2: 
73

Explanation:
Here N=12 (size of the array) and K=5 (number of times operation has to be performed).
At first, the minimum element will be replaced; thus, replace -21 with -(-21) to make it 21.
Second, replace the next minimum, -10 with -(-10) to make it 10.
Third, replace -3 with -(-3) to make it 3.
Fourth, replace -1 with -(-1) to make it 1.
Lastly, replace 0 with -(0) to make it 0.
The output is 73, that is, the sum of the elements after 5 operations.
*/

import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.util.Scanner;

class Source{
	public static int maxSum(int[] a, int K){
		// It creates a priority queue and inserts all array elements
                         // into the priority queue.
		
		PriorityQueue<Integer> priorqueue = new PriorityQueue<>();
		for (int x : a)
			priorqueue.add(x);

		// Performing K negation operations
		while (K-- > 0){
			// write your code here
			// Retrieve and remove min element 
            int temp = priorqueue.poll(); 
  
            // Modify the minimum element and add back 
            // to priority queue 
            temp *= -1; 
            priorqueue.add(temp); 
			
		}

		// Finds the total sum of the final array
		int sum = 0;
		for (int x : priorqueue)
			sum = sum + x;
		return sum;
	}

	public static int[] getArrayInput(int size, Scanner scanner) {
             int array[] = new int[size];
             for (int i = 0; i < size; i++) {
             array[i] = scanner.nextInt();
              }
            return array;
            }

	public static void main (String[] args){
		Scanner scanner = new Scanner(System.in);
                          int N = scanner.nextInt();
                         int K = scanner.nextInt();
                          int arr[] = getArrayInput(N, scanner);

		System.out.println(maxSum(arr, K));
	}
}



