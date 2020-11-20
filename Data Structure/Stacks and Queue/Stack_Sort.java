/*
Sort the stack
Description
You are given a stack with n integers. You need to sort the elements of the stack in ascending order such that the minimum value is at the bottom-most position of the stack.
Input Format:
The first line of input is the number of elements in the stack. The next line of input consists n space separated integers in the order bottom to top.
Output Format:
The output is sorted stack with minimum value at bottom of the stack and maximum value at the top of the stack.
Example: 
Stack(bottom -> top) = [6, 12, 3, 4]
Output: [3, 4, 6,12]

*/

import java.util.*;

public class Stack_Sort {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
       sort(stack);
    }

    static void sort(Stack<Integer>stack) 
    { 
        Stack<Integer> tmpStack = new Stack<Integer>(); 
        while(!stack.isEmpty()) 
        { 
            // pop out the first element 
            int tmp = stack.pop(); 
          
            // while temporary stack is not empty and 
            // top of stack is greater than temp 
            while(!tmpStack.isEmpty() && tmpStack.peek()  
                                                 > tmp) 
            { 
                // pop from temporary stack and  
                // push it to the input stack 
            stack.push(tmpStack.pop()); 
            } 
              
            // push temp in tempory of stack 
            tmpStack.push(tmp); 
        } 
        System.out.println(tmpStack);
    }
    
}
