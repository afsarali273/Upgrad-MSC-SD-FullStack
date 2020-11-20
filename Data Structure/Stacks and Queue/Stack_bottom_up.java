import java.util.*;

public class Source {
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        while (n-- > 0)
            stack.push(s.nextInt());
        printFifthElementFromStart(stack);
    }

       static void printFifthElementFromStart(Stack<Integer> stack) {
        int count =1;
       for(int i=stack.size()-1 ; i>=0;i--){
            if(stack.size() < 5){
               System.out.println("There are not enough elements in the stack");
               break;
                }
           if(count==5){
               System.out.println(stack.get(i).intValue());
               break;
           }
           count++;

       }
    }
}
