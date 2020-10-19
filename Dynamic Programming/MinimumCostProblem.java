import java.util.*;
class MinimumCostProblem
{
       /* A utility function that returns minimum of 3 integers */
    private static int min(int x, int y, int z)
    {
        if (x < y)
            return (x < z)? x : z;
        else
            return (y < z)? y : z;
    }
 
    private static int minCost(int cost[][], int m, int n)
    {
        /* Initialize 2D array to store the minimum cost to reach a particular cell */
        int i, j;
        int minCost[][]=new int[m+1][n+1];
        minCost[0][0] = cost[0][0];
        
        /* Initialize first column of minimum cost(table) array */
        for (i = 1; i <= m; i++)
            minCost[i][0] = minCost[i-1][0] + cost[i][0];
            
        /* Initialize first row of table array */
        for (j = 1; j <= n; j++)
            minCost[0][j] = minCost[0][j-1] + cost[0][j];
            
        /* Construct rest of the table array from the recursion relation */
        for (i = 1; i <= m; i++)
            for (j = 1; j <= n; j++)
                minCost[i][j] = min(minCost[i-1][j-1], 
                               minCost[i-1][j],
                               minCost[i][j-1]) + cost[i][j];
        
        /* return [m][n] element of the minimum cost array */
        return minCost[m][n];
    }
 
 
    public static void main(String args[])
    {
        int cost[][]= {{1, 2, 3},
                       {4, 8, 2},
                       {1, 5, 3}};
        Scanner scan = new Scanner(System.in);
        int xCoordinate = scan.nextInt();
        int yCoordinate = scan.nextInt();
        System.out.println(minCost(cost,xCoordinate,yCoordinate));
    }
}
