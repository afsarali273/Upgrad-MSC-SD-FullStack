/*
Check Array of Contiguous Integers
Description
You will be given the array of ‘n’ integers, and you have to print “true” if the distinct integers of the given n integers can form a set of contiguous integers. Otherwise, print “false”.
Note: the given array of integers may contain duplicates.


Input: The input will be in the following format:
The first line will be ‘n’ indicating the size of the input array.
The next line will be ‘n’ space-separated integers indicating the elements of the array.
Output: The output should be in the following format
Print 'true' if the distinct integers of the given n integers can form a set of contiguous integers. Otherwise, print 'false'.
Note: If the array is empty, then assume that the array did not contain any distinct integers that can form contiguous integers.
 
Sample input-1:
10
5 8 4 4 7 6 2 6 7 3

Sample output-1:
true
The first line of input, 10, represents the number of integers user will input. The next line in the input is 10 integers space-separated. The output here is true because if we remove all the duplicate integers the array looks something like {5,8,4,7,6,2,3} which can be rearranged to the array of contiguous integers {2,3,4,5,6,7,8}.

Sample input-2:
5
1 2 7 4 5

Sample output-2:
false
The first line of input, 5, represents the number of integers user will input. The next line in the input is 5 integers space-separated. The output here is false as the input integers cannot be arranged into contiguous integers.
Execution Time Limit
15 seconds
*/


import java.util.*;

class Hashset_CheckArrayContiguous {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        n = in.nextInt();

        //array to store the input elements
        int[] array = new int[n];

        //storing the elements to the array
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }

        System.out.println(areElementsContiguous(array,n));

    }
    
    static Boolean areElementsContiguous(int arr[], int n) 
    { 
        // Storing elements of 'arr[]' in  
        // a hash table 'us' 
        HashSet<Integer> us = new HashSet<Integer>(); 
          
        for (int i = 0; i < n; i++) 
            us.add(arr[i]); 
  
        // As arr[0] is present in 'us' 
        int count = 1; 
  
        // Starting with previous smaller  
        // element of arr[0] 
        int curr_ele = arr[0] - 1; 
  
        // If 'curr_ele' is present in 'us' 
        while (us.contains(curr_ele) == true) { 
            // increment count 
            count++; 
            // update 'curr_ele" 
            curr_ele--; 
        } 
        // Starting with next greater  
        // element of arr[0] 
        curr_ele = arr[0] + 1; 
  
        // If 'curr_ele' is present in 'us' 
        while (us.contains(curr_ele) == true) { 
            // increment count 
            count++; 
            // update 'curr_ele" 
            curr_ele++; 
        } 
  
        // Returns true if array contains a set of 
        // contiguous integers else returns false 
        return (count == (us.size())); 
    } 
  
}




