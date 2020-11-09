/*
Match Locks and Keys
Description
Consider you are given the array of locks and keys. Write the program to print the key and its corresponding lock in the order of the keys present in the array.

Note:
You should not compare any lock with any other lock; similarly, you should not compare any key with any other key. 
The size of the array of locks and keys is the same.

Input: The input will be in the following format:
The first line will be ‘n’ indicating the size of the array of keys.
The next line will be ‘n’ space-separated characters indicating keys.
The next line will be ‘n’ space-separated characters indicating locks.

Output: The output should be in the following format:
Print each key and its corresponding lock separated by space, in a new line, in the same order of keys. 
If any of the lock corresponding to the key is not present, then print ‘Not possible’. 


Sample input-1:
5
# % ! @ $
! # $ % @

Sample output-1:
# #
% %
! !
@ @
$ $
Here the input 5 indicates the size of locks and keys array. The next line in input represents Locks array with 5 elements. The third line in input represents Keys array with 5 elements. The output contains space-separated key-lock pairs in order in which keys are present, that is, # is the first element in key array so # is searched and printed first and same process is followed for other keys.

Sample input-2:
5
# % ! @ $
! # $ % 1

Sample output-2:
Not possible
Here the input 5 indicates the size of locks and keys array. The next line in input represents Locks array with 5 elements. The third line in input represents Keys array with 5 elements. The output is Not possible as the key @ has no matching lock in locks array.
Execution Time Limit
*/

import java.util.*;

class HashMap_Match_Lock_Key {

    public static void main(String arg[]) {
        Scanner in = new Scanner(System.in);

        // get the number of keys
        int n = in.nextInt();

        char keys[] = new char[n];
        char locks[] = new char[n];

        // store all the keys to the array "keys"
        for (int i = 0; i < n; i++) {
            keys[i] = in.next(".").charAt(0);
        }
        in.nextLine();

        //store all the locks to the array "locks"
        for (int i = 0; i < n; i++) {
            locks[i] = in.next(".").charAt(0);
        }

        //write your code here
       HashMap<Character,Integer>  hashMap = new HashMap<>(); 
       // Add locks[i] to the HashMap
       for(int i =0; i < n; i++){
          hashMap.put(locks[i],i); 
       }
       
    for (int i = 0; i < n; i++){
        if (hashMap.get(keys[i]) != null){
            locks[i] = keys[i];
        }else{
          System.out.println("Not possible");  
          return;
        }
    }
    
    for(int i = 0; i < n; i++)
        System.out.println(keys[i]+" "+ locks[i]);
    }
}



