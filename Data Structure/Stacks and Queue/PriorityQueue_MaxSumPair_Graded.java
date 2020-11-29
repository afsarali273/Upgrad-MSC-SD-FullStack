/*
Maximum Sum Pairs
Description
You will be given two array lists ArrayL1 and ArrayL2 both of size ‘n’. You have to print ‘n’ maximum numbers which are formed from the sum of ArrayL1.get(i), ArrayL2.get(j) in the descending order.

Constraint: The time and space complexity of your solution code should be O(n^2 log n) and O(n) respectively.

Hint: Use heap.

Input Format:
The first line will be the value of ‘n’.
The second line will be the values of ArrayL1.
The third line will be the values of ArrayL2.

Output Format:
Print ‘n’ maximum numbers which are formed from the sum of ArrayL1.get(i), ArrayL2.get(j) in descending order. Each element should be on a new line.

Input:
3
1 2 3
4 5 6

Output:
9
8
8

All the elements formed from the sum of ArrayL1.get(i), ArrayL2.get(j) are as follows:

1 + 4 = 5
1 + 5 = 6
1 + 6 = 7

2 + 4 = 6
2 + 5 = 7
2 + 6 = 8

3 + 4 = 7
3 + 5 = 8
3 + 6 = 9

‘n’ is the number of elements  of the ArrayL1 or ArrayL2. So here n is 3. Therefore, the 3 maximum numbers formed from the sum of ArrayL1.get(i), ArrayL2.get(j) are 9, 8 and 8 in the descending order.
Execution Time Limit
15 seconds
*/

import java.util.*;
import java.util.Scanner;

public class Source {
    
    
    static void KMaxCombinations(ArrayList<Integer> ArrayL1,
            ArrayList<Integer> ArrayL2) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(
                Collections.reverseOrder());
        int N = ArrayL1.size();

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                pq.add(ArrayL1.get(i) + ArrayL2.get(j));

        int count = 0;

        while (count < N) {
            System.out.println(pq.peek());
            pq.remove();
            count++;
        }

    }

    public static void main(String args[]) {
        //below two ArrayList are used to store the given input
        ArrayList<Integer> ArrayL1 = new ArrayList<Integer>();
        ArrayList<Integer> ArrayL2 = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        int n, i;

        // size of ArrayL1 = size of ArrayL2 = n
        n = in.nextInt();

        for (i = 0; i < n; i++) {
            ArrayL1.add(in.nextInt());
        }
        for (i = 0; i < n; i++) {
            ArrayL2.add(in.nextInt());
        }

        //write your code here
        KMaxCombinations(ArrayL1, ArrayL2);

    }
}

