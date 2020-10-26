import java.util.Stack;

public class Check_Balanced_Parethesis {


    public static boolean checkBalanced(String inputString){
        Stack< Integer > inputStack = new Stack < Integer > ();
        Stack<Character> newStack=new Stack<>();
        for(int i=0;i<inputString.length();i++) {
            if (inputString.charAt(i) == '(') {
                newStack.push(inputString.charAt(i));
            }
            if (inputString.charAt(i) == ')') {
                if (newStack.isEmpty()) {
                    return false;
                } else {
                    newStack.pop();
                }
            }
        }
        if(newStack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {


        String input = "((a+b)+c)";
        System.out.println(checkBalanced(input));
    }
}
