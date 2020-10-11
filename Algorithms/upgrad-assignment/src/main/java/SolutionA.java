import java.util.Scanner;

public class SolutionA {

//    Given
//    With a known length N
//    The array is sorted in an ascending order
//    The array holds distinct integers (i.e. there are no repeating numbers)
//    The array is 1-indexed, i.e. the first element is stored in A[1] (not A[0])

//    Then
//    [find the first positive integer M where M is both a user’s ID and its index in the array of user ids.]


// ====   Test:1 =====
//    Sample Input:
//            5
//            0 1 3 4 5
//    Sample Output:
//            3
// =======================

// ====   Test :2 =====
//    Input :
//            7
//            0 1 2 4 5 6 7
//    Output :
//            4
// =======================

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int arraySize = sc.nextInt();

        int[] inputArray = new int[arraySize + 1]; // Added N+1 Size to make sure it can start from index 1

        for (int i = 1; i <= arraySize; i++) {
            inputArray[i] = sc.nextInt();     //Storing elements at index 1 onwards
        }


        int index = binarySearch(inputArray, 1, inputArray.length - 1);
        if (index != -1) {
            System.out.println(index);//Here we print the index of Array where A[M]=M in an array of size N such that 1<=M<=N
        } else {
            System.out.println("NOT_FOUND");//Here print message for A[M]=M  not found
        }

    }


    /**
     * @return number that satisfies the condition A[M]=M
     * @Auther :Afsar Ali
     * @date 11 Oct 2020
     */

    public static int binarySearch(int[] sortedArray, int start, int end) {

        while (start <= end) {

            int mid = (start + end) / 2;

            if (sortedArray[1] == 1) {
                return 1;                          //Here first cases satisfies
            } else if (sortedArray[mid] == mid) {  //If mid element satisfies the condition
                return mid;
            } else if (sortedArray[mid] == mid && sortedArray[mid - 1] == (mid - 1)) {
                return mid - 1;                    //returns M-1 when A[M]=M && A[M-1]=M-1
            } else if (mid < sortedArray[mid]) {
                return binarySearch(sortedArray, start, mid - 1);
            } else {
                return binarySearch(sortedArray, mid + 1, end);
            }
        }
        return -1;
    }
}
