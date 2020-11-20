
/*
Print the element
Description
You are given a queue with n integers and you need to print the fifth element from the tail of the queue.
Input Format:
The first line of input is an integer n denoting the size of the queue. The next line  contains n space separated integer.
Output format:
An integer which is the fifth element from tail of the queue.
Example: 
Queue = [1, 2, 3, 4, 5, 6, 7, 8]
Output: 4
Sample Input 1:
12
1 2 3 4 5 6 7 8 9 10 11 12
Sample Output 1:
8
Sample Input 2:
4
1 2 3 4
Sample Output 2:
There are not enough elements in the queue
Note: If the number of elements in the queue is less than 5, then print “There are not enough elements in the queue”.
Execution Time Limit
15 seconds

*/

import java.util.*;

public class Print_5thElement_QueueFromEnd {
    public static void main(String args[]) {
        Queue<Integer> queue = new LinkedList<Integer>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            queue.add(s.nextInt());
          
        // Reverse Queue first    
        reversequeue(queue);   
        printFifthElementFromEnd(queue);
    }

    // Method to print the fifth element from the tail of the queue
    //Used same logic for printing 5th element from start
    static void printFifthElementFromEnd(Queue<Integer> queue) {
         if(queue.size()<5)
            System.out.println("There are not enough elements in the queue");

        Iterator e = queue.iterator();
        int count =1;
        while(e.hasNext()){
            if(count ==5){
                System.out.println(e.next());
                break;
            }
            e.next();
            count++;
        }
    }
    
    //Reverse the Queue
    static void reversequeue(Queue<Integer> queue) 
    { 
        Stack<Integer> stack = new Stack<>(); 
        while (!queue.isEmpty()) { 
            stack.add(queue.peek()); 
            queue.remove(); 
        } 
        while (!stack.isEmpty()) { 
            queue.add(stack.peek()); 
            stack.pop(); 
        } 
    }
    
}

