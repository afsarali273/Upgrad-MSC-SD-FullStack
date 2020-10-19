import java.util.Scanner;
class ExtendedFibonanci {
    static int fib(int n) {
        if(n> 3){
        /* Declare an array to store Fibonacci numbers */
        int array[]=new int[n+1];
        /* Assign the 0th, 1st, and 2nd numbers of the Fibonacci series to 0, 1, and 2 respectively */
         array[0]=0;
         array[1]=1;
         array[2]=2;
        /* Add the previous three numbers in the series, and store them */
        /* Return the nth element in the series */
         int i;
        for(i=3;i<=n;i++){
            array[i] = array[i - 1] + array[i - 2] + array[i-3];
        }
         return array[n-1]; 
        }else{
            return 0;
        }
    }
  
    public static void main(String args[])
    {
    	Scanner scan = new Scanner(System.in);
    	// Enter the number n
        int n = scan.nextInt();
        System.out.println(fib(n));
    	scan.close();
    }
}