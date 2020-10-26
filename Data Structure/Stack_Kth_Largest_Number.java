/*
Find kth largest element
Description
Write a code to find the kth largest number of the given sequence in a stack. Your program should take the following lines of input: 

The number of elements in the input stack. 
The elements in the input stack. 
The value of ‘k’.
Note: 

If the input stack is empty, your program should print “ stack is empty”. 
If the value of ‘k’ is greater than the number of elements in the input stack, then print “ invalid input”
Sample Input 1:
6
4 2 0 9 6 1
4  // k=4, therefore, the 4th largest element has to be found

*/


import java.util.*;

public class Source {
  // This function returns the sorted stack
   
     public static Stack<Integer> sortStack(Stack<Integer> input) 
    { 
        Stack<Integer> tmpStack = new Stack<Integer>(); 
        while(!input.isEmpty()) 
        { 
            // pop out the first element 
            int tmp = input.pop(); 
          
            // while temporary stack is not empty and 
            // top of stack is greater than temp 
            while(!tmpStack.isEmpty() && tmpStack.peek()  > tmp) 
            { 
                // pop from temporary stack and  
                // push it to the input stack 
                input.push(tmpStack.pop()); 
            } 
            // push temp in tempory of stack 
            tmpStack.push(tmp); 
        } 
        return tmpStack; 
    } 
  
   public static void findKthLargestNum(Stack <Integer> sortedStack, int k) {
         for(int i=1;i<sortedStack.size()-(k+1);i++){
            sortedStack.pop();
        }

        System.out.println(sortedStack.peek());
   }


  public static void main(String args[]) {
        Stack < Integer > inputStack = new Stack < Integer > ();
        Scanner in = new Scanner(System.in);
        int n = in .nextInt();
        for (int i = 0; i < n; i++) {
            inputStack.add( in .nextInt());
        }

        if (inputStack.isEmpty()) {
            System.out.println("stack is empty");
            System.exit(0);
        }

        int k = in .nextInt();
        if (k > inputStack.size()) {
            System.out.println("invalid input");
            System.exit(0);
        }

        // This is the temporary stack

        Stack < Integer > temp = sortStack(inputStack);
        findKthLargestNum(temp, k);

    }
}
