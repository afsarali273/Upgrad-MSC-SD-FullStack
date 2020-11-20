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

       for(int i=0 ; i<stack.size();i++){
           if(stack.size() < 5){
               System.out.println("There are not enough elements in the stack");
               break;
           }
           if(i ==5){
               System.out.println(stack.get(i-1).intValue());
               break;
           }
       }

    }
}