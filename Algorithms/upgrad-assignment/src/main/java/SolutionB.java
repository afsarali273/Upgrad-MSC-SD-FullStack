import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SolutionB {

//    We must enter the value we are looking to search for as an input.
//    Also, you are not supposed to use the size of the array to apply binary search.

// =========  Test 1 ===============
//    Input :
//            10 -  This corresponds to the size of the array.
//            6 -  This corresponds to the key you are searching for
//            1 2 3 5 6 7 8 9 10 11 - These are the elements of the array
//    Output :
//            5 - Output should be the index at which the key is present. In this case, key 6 is present at index 5 of 1-INDEXED array. So the output is 5.


// ============  Test 2 =============
//    Input:
//            20
//            20
//            1 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
//    Output :
//            19
// ==================================

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter size of the array");
        int size = scan.nextInt();
        System.out.println("Enter element to search");
        int key=scan.nextInt();
        System.out.println("Enter "+size+" elements in ascending order");
        int[] inputArray = new int[size + 1];
        for (int i = 1; i <= size; i++) {
            inputArray[i] = scan.nextInt();
        }
        IntStream numbersFromInputArray= Arrays.stream(inputArray);
        int Length=(int)numbersFromInputArray.count()-1;//counts the elements in the stream
        int index = binarySearch(inputArray,key,Length);
        if (index != -1) {
            System.out.println(index); // Found the element at the index
        } else {
            System.out.println("NOT_FOUND");
        }
    }
    public static int binarySearch(int[] sortedArray,int key,int length) {
        int start=1;
        int end=length;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (key==sortedArray[mid]) {
                return mid;  // if we find element at first cases itself
            } else if (key < sortedArray[mid]) {
                end=mid-1;
            } else {
                start=mid+1;
            }
        }
        return -1;
    }
}
