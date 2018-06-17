package Eight_Chapter;

/**
 * @author Mert Ozer
 *
 * Fill: Implement the "paint fill"function that one might see on many image editing programs.
That is, given a screen (represented by a two-dimensional array of colors), a point, and a new color,
fill in the surrounding area until the color changes from the original color.
 */
public class Paint_Fill_8_10 {
    public static void paintFill(int[][] matrix, int i, int j, int color){
        if (matrix[i][j] == color)
            System.out.println("nothing to do");
        else
            helper(matrix, i, j, color);
    }
    public static boolean helper(int[][] matrix, int i, int j, int color){
        if (i < 0 || i >= matrix.length || j >= matrix[0].length || j < 0)
            return false;

        else if (matrix[i][j] != color)
            matrix[i][j] = color;

        else {
            helper(matrix, i+1, j, color);
            helper(matrix, i-1, j, color);
            helper(matrix, i, j+1, color);
            helper(matrix, i, j-1, color);
        }
        return true;
    }
}
