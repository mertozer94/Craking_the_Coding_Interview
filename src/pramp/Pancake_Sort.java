package pramp;

/**
 * @author Mert Ozer
 *
 * Given an array of integers arr:

Write a function flip(arr, k) that reverses the order of the first k elements in the array arr.
Write a function pancakeSort(arr) that sorts and returns the input array. You are allowed to use only the function flip you wrote in the first step in order to make changes in the array.
Example:

input:  arr = [1, 5, 4, 3, 2]

output: [1, 2, 3, 4, 5] # to clarify, this is pancakeSort's output
Analyze the time and space complexities of your solution.

Note: it’s called pancake sort because it resembles sorting pancakes on a plate with a spatula, where you can only use the spatula to flip some of the top pancakes in the plate. To read more about the problem, see the Pancake Sorting Wikipedia page.

Constraints:

[time limit] 5000ms

[input] array.integer arr

[input] integer k

0 ≤ k
[output] array.integer
 */
public class Pancake_Sort {
    static void flip(int[] arr, int k) {
        for(int i=0; i < k/2; i++){
            int swap = arr[i];
            arr[i] = arr[k-i-1]; //k = 2
            arr[k-i-1] = swap;
        }
    }
    static int[] pancakeSort(int[] arr) {
        // your code goes here

        int n = arr.length-1;

        for(int i = 0; i < n; i++){
            int biggest = Integer.MIN_VALUE;
            int biggestIndex = Integer.MIN_VALUE;
            for(int j = 0; j < n-i+1; j++){
                if(arr[j] > biggest){
                    biggest = arr[j];
                    biggestIndex = j;
                }
            }
            flip(arr, biggestIndex+1);
            flip(arr, n-i+1);
        }
        return arr;
    }


}
