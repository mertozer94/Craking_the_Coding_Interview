package First_Chapter;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Mert Ozer
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0.
 */
public class Zero_Matrix_1_8 {
    public static void main(String[] args){

        int[][] arr = {{1,2,4,8},{0,1,2,0},{8,1,0,2},{7,1,14,6}};
        zeroMatrix(arr);

        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++)
               System.out.println(arr[i][j]);
    }

    public static void zeroMatrix(int [][] arr){

        Set<Integer> rows = new HashSet<>();
        Set<Integer> columns = new HashSet<>();
        int n = arr.length;
        int m = arr[0].length;
        int i, j;
        for (i = 0; i < n ; i++){
          for (j = 0; j < m ; j++){
            if (arr[i][j] == 0){
                rows.add(i);
                columns.add(j);
            }
          }
        }
        for (i = 0; i < n ; i++){
            for (j = 0; j < m ; j++){
                if (rows.contains(i) || columns.contains(j))
                    arr[i][j] = 0;
            }
        }
    }
}
