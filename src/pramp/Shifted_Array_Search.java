package pramp;

/**
 * @author Mert Ozer
 * A sorted array of distinct integers shiftArr is shifted to the left by an unknown offset and you don’t have a pre-shifted copy of it. For instance, the sequence 1, 2, 3, 4, 5 becomes 3, 4, 5, 1, 2, after shifting it twice to the left.

Given shiftArr and an integer num, implement a function shiftedArrSearch that finds and returns the index of num in shiftArr. If num isn’t in shiftArr, return -1. Assume that the offset doesn’t equal to 0 (i.e. assume the array is shifted at least once) or to arr.length - 1 (i.e. assume the shifted array isn’t fully reversed).

Explain your solution and analyze its time and space complexities.

Example:

input:  shiftArr = [9, 12, 17, 2, 4, 5], num = 2 # shiftArr is the
# outcome of shifting
# [2, 4, 5, 9, 12, 17]
# three times to the left

output: 3 # since it’s the index of 2 in arr
Constraints:

[time limit] 5000ms
[input] array.integer arr
[input] integer num
[output] integer

 */
public class Shifted_Array_Search {
    static int shiftedArrSearch(int[] shiftArr, int num) {
        // your code goes here

        int lo = 0;
        int hi = shiftArr.length-1;
        int pivot = findPivot(shiftArr);
        int mid = lo + (hi - lo)/2;

        if(shiftArr[pivot] == num)
            return mid;
        else if(shiftArr[pivot] < num)
            return binarySearch(shiftArr, num, lo, pivot);
        else
            return binarySearch(shiftArr, num, pivot -1, hi);
    }
    static int findPivot(int[] arr){
        int lo = 0;
        int hi = arr.length-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(mid == 0 || arr[mid] < arr[mid-1])
                return mid;
            else if(arr[mid]> arr[0])
                lo = mid + 1;
            else
                hi = lo - 1;
        }
        return 0;
    }
    static int binarySearch(int[] arr, int num, int lo, int hi){
        //int lo = 0;
        //int hi = arr.length-1;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(arr[mid] == num)
                return mid;
            else if(arr[mid] < num)
                lo = mid + 1;
            else
                hi = mid - 1;
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] shiftArr = {12, 17, 2, 4, 5, 9};
        System.out.println(shiftedArrSearch(shiftArr, 4));
    }
}
