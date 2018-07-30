package pramp;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mert Ozer
 *
 * Given a package with a weight limit limit and an array arr of item weights, implement a function getIndicesOfItemWeights that finds two items whose sum of weights equals the weight limit limit. Your function should return a pair [i, j] of the indices of the item weights, ordered such that i > j. If such a pair doesn’t exist, return an empty array.

Analyze the time and space complexities of your solution.

Example:

input:  arr = [4, 6, 10, 15, 16],  lim = 21

output: [3, 1] # since these are the indices of the
# weights 6 and 15 whose sum equals to 21
Constraints:

[time limit] 5000ms

[input] array.integer arr

0 ≤ arr.length ≤ 100
[input] integer limit

[output] array.integer


 */
public class Merging_2_Packages {

    static int[] getIndicesOfItemWeights(int[] arr, int limit) {
        // your code goes here
        Map<Integer, Integer> map = new HashMap();
        int[] result = new int [2];
        for(int i = 0; i<arr.length; i++){
            if(map.containsKey(arr[i])){
                //int[] result = new int[2];
                result[0] = i;
                result[1] = map.get(arr[i]);
                return result;
            }
            else {
                map.put(limit-arr[i],i);
            }
        }
        int [] ret={};
        return ret;
    }
}
