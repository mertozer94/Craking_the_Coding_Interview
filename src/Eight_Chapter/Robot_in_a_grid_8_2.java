package Eight_Chapter;

import java.util.ArrayList;

/**
 * @author Mert Ozer
 *
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
The robot can only move in two directions, right and down, but certain cells a re "off limits" such that
the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
the bottom right.
 */

public class Robot_in_a_grid_8_2 {
    public static void main(String[] args){
        int[][] arr = {{1,-1,4,8},{0,1,2,0},{8,1,0,2},{-1,1,14,6}};
        String path = pFinder(arr);
        System.out.println(path);
    }
    public static String pFinder(int[][] matrix){
        Point p = new Point();
        Point found = helper(matrix, 0, 0, matrix[0].length, matrix.length, p);
        if (found.found)
            return found.path;
        else return "";
    }
    public static Point helper(int[][] matrix, int i, int j, int r, int c, Point p){
        if (i == r-1 && j == c-1){
            p.found = true;
            return p;
        }
        else if (i >= r || j >= c || matrix[i][j] == -1) {
            p.found = false;
            return p;
        }
        else {
            Point p1 = helper(matrix, i+1, j, r, c, new Point(p.path + "d"));
            Point p2 = helper(matrix, i, j+1, r, c, new Point(p.path + "r"));
            if (p1.found)
                return p1;
            else if (p2.found)
                return p2;
            else return new Point("");

        }
    }
    public static class Point {
        public Point () {this.path = "";}
        public Point (String path) {this.path = path;}
        public String path;
        public boolean found;
    }
}
