package pramp;

import java.util.ArrayList;

/**
 * @author Mert Ozer
 * Given two sorted arrays arr1 and arr2 of passport numbers, implement a function findDuplicates that returns an array of all passport numbers that are both in arr1 and arr2. Note that the output array should be sorted in an ascending order.

Let N and M be the lengths of arr1 and arr2, respectively. Solve for two cases and analyze the time & space complexities of your solutions: M ≈ N - the array lengths are approximately the same M ≫ N - arr2 is much bigger than arr1.

Example:

input:  arr1 = [1, 2, 3, 5, 6, 7], arr2 = [3, 6, 7, 8, 20]

output: [3, 6, 7] # since only these three values are both in arr1 and arr2
Constraints:

[time limit] 5000ms

[input] array.integer arr1

1 ≤ arr1.length ≤ 100
[input] array.integer arr2

1 ≤ arr2.length ≤ 100
[output] array.integer
 */
public class Find_The_Duplicates {

    static int[] findDuplicates(int[] arr1, int[] arr2) {
        // your code goes here
        ArrayList<Integer> r = new ArrayList();
        int resultIndex = 0;
        int index1 = 0;
        int index2 = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;

        while(index1 < n1 && index2 < n2){
            if(arr1[index1] == arr2[index2]){
                //result[resultIndex] = arr1[index1];
                r.add(arr1[index1]);
                index1++;
                index2++;
                //resultIndex++;
            }
            else if(arr1[index1] > arr2[index2])
                index2 ++;
            else
                index1++;
        }
        int[] result = new int[r.size()];
        for(int i: r){
            result[resultIndex] = i;
            resultIndex++;
        }
        return result;
    }
}
