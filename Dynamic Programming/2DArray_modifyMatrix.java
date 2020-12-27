2D Array
Description
Write the code for this problem : Given an initialised array,  you need to modify the matrix in such a way that each element is the maximum of its neighbours, i.e. the cell above it and the cell to the left of it. 

Sample Input:
No input required as it is already hard coded in the stub.

Output:
0123
1123
2223
3333

Note that the first row and the first column cannot be modified as they are used as the base cases for further comparisons.
Execution Time Limit
============================= Solution ==========================



import java.lang.*;

class Source
{
    public static void main(String args[])
    {
      
      	int matrix[][];
		matrix = new int[4][4];
      
      	int i,j;
      
      	/* Updating first column */
      	for (i = 0; i < matrix.length; i++) {
      		matrix[i][0] = i;
      	}
      	
      	/* Updating first row */
      	for (j=0; j< matrix[0].length; j++) {
      		matrix[0][j] = j;
      	}
 		
      	/* Write your loop here to update the above matrix such that 
      	each cell is max of its neighbouring cell. 
      	Store your results in the matrix itself*/ 
      	for (i = 1; i < matrix.length; i++)
            for (j = 1; j < matrix[0].length; j++)
                matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
      
      	/* Printing 2D matrix. Don't change the code below*/
      	for (i = 0; i < matrix.length; i++){
            for (j = 0; j < matrix[0].length; j++)
          		System.out.print(matrix[i][j]);
            System.out.print('\n');
      	}       
    }
}
