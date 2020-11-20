import java.util.*;

public class Source{
    public static void main(String arg[]) {
        Stack<Character> s = new Stack<Character>();
        Scanner in = new Scanner(System.in);
        String data = in.nextLine();
        
        char[] ch = data.toCharArray();
		for (int i = 0; i < data.length(); i++)
			s.push(ch[i]);
	// start from index 0
		int k = 0;
		// pop characters from the stack until it is empty
		while (!s.isEmpty())
		{
			// assign each popped character back to the character array
			ch[k++] = s.pop();
		}
		// convert the character array into string and return it
	String reversed = 	String.copyValueOf(ch);	
	
	System.out.println(reversed);
    }
}
