/*
Print all primes less than or equal to n
Description
You will be given an integer n. You need to print all the prime numbers less than or equal to n in the ascending order.
Input: The input will be in the following format : 
The first line should be the value of n.

Output: The output should be of the following format
In the first line print all the prime numbers less than or equal to n in ascending order separated by spaces.
Note: If there are no primes less than or equal to n then print “There are no prime numbers less than n”.

Example : 
Input A: 
19
Output A:
2 3 5 7 11 13 17 19

Input B: 
-5
Output B:
There are no prime numbers less than -5
Execution Time Limit
15 seconds
*/

import java.util.*;

public class Source {
   public static void main(String args[]) {
       Scanner s = new Scanner(System.in);
       int n = s.nextInt();
       primesLessThanOrEqualTon(n);
   }

   // Method to print all primes less than or equal to n in ascending order
   static void primesLessThanOrEqualTon(int n) {
       // Write your code here
       if(n < 2){
         System.out.println("There are no prime numbers less than or equal to "+n); 
         return;
       }
       
    boolean prime[] = new boolean[n+1]; 
        for(int i=0;i<=n;i++) {
            prime[i] = true; 
        }
        
        for(int p = 2; p*p <=n; p++) 
        { 
            // If prime[p] is not changed, then it is a prime 
            if(prime[p] == true) { 
                // Update all multiples of p 
                for(int i = p*p; i <= n; i += p) {
                    prime[i] = false;
                }
            } 
        } 
          
        // Print all prime numbers 
        for(int i = 2; i <= n; i++) { 
            if(prime[i] == true) {
                System.out.print(i + " "); 
            }
        }
   }
       
       
   }

