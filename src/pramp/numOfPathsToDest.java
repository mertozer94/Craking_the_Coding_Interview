package pramp;

/**
 * @author Mert Ozer
 *
 * You’re testing a new driverless car that is located at the Southwest (bottom-left) corner of an n×n grid. The car is supposed to get to the opposite, Northeast (top-right), corner of the grid. Given n, the size of the grid’s axes, write a function numOfPathsToDest that returns the number of the possible paths the driverless car can take.

alt the car may move only in the white squares

For convenience, let’s represent every square in the grid as a pair (i,j). The first coordinate in the pair denotes the east-to-west axis, and the second coordinate denotes the south-to-north axis. The initial state of the car is (0,0), and the destination is (n-1,n-1).

The car must abide by the following two rules: it cannot cross the diagonal border. In other words, in every step the position (i,j) needs to maintain i >= j. See the illustration above for n = 5. In every step, it may go one square North (up), or one square East (right), but not both. E.g. if the car is at (3,1), it may go to (3,2) or (4,1).

Explain the correctness of your function, and analyze its time and space complexities.
 */
class numOfPathsToDest {

    static int numOfPathsToDest(int n) {
        int[][] matrix = new int[n][n];

        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                matrix[i][j] = -1;
            }
        }
        return helper(0,0,n, matrix);

    }
    static int helper(int i, int j, int n, int[][] matrix){
        if (i < j){
            return 0;
        }

        else if (i == n-1 && i == j){
            return 1;
        }

        else if (i >= n || j >= n){
            return 0;
        }

        if (matrix[i][j] != -1)
            return matrix[i][j];
        else
            return  matrix[i][j] = helper(i,j+1,n, matrix) + helper(i+1,j,n, matrix);

    }
        // 0,0
        // 1,0 - > 2,0 1,1
        // 2 , 0        ->    2,1
        //1 , 1        -> 2,1    1,2
        // 0,1 - > false

//0,0  = 1,0 + 0,1

    public static void main(String[] args) {
            System.out.println(numOfPathsToDest(4));
    }

}