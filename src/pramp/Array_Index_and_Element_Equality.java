package pramp;

/**
 * @author Mert Ozer
 *
 * Given a sorted array arr of distinct integers, write a function indexEqualsValueSearch that returns the lowest index i for which arr[i] == i. Return -1 if there is no such index. Analyze the time and space complexities of your solution and explain its correctness.

Examples:

input: arr = [-8,0,2,5]
output: 2 # since arr[2] == 2

input: arr = [-1,0,3,6]
output: -1 # since no index in arr satisfies arr[i] == i.
Constraints:

[time limit] 5000ms

[input] array.integer arr

1 ≤ arr.length ≤ 100
[output] integer
 */
public class Array_Index_and_Element_Equality {

    static int indexEqualsValueSearch(int[] arr) {
        // your code goes here

        // [0,11,22,33,54,66]

        // index > value of it right?

        // index < left

        // arr = [-1,0,3,6]
        // index > value right\
        // index < vlue of left

        int left = 0;
        int right = arr.length-1;


        while(left <= right){

            int mid = left + (right-left)/2;

            // int mid = (left+right)/2
            if(arr[mid] == mid)
                return mid;

            else if(mid > arr[mid])
                left = mid + 1;

            else
                right = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        // -1, 1, 2, 3, 6

        int[] arr = {-8,0,2,5};
        int[] arr2 = {-1,0,3,6};
        System.out.println(indexEqualsValueSearch(arr));
        System.out.println(indexEqualsValueSearch(arr2));
    }
}
