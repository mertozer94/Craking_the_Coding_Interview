package pramp;

import java.util.PriorityQueue;

/**
 * @author Mert Ozer
 * Given an array of integers arr where each element is at most k places away from its sorted position, code an efficient function sortKMessedArray that sorts arr. For instance, for an input array of size 10 and k = 2, an element belonging to index 6 in the sorted array will be located at either index 4, 5, 6, 7 or 8 in the input array.

Analyze the time and space complexities of your solution.

Example:

input:  arr = [1, 4, 5, 2, 3, 7, 8, 6, 10, 9], k = 2

output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
Constraints:

[time limit] 5000ms

[input] array.integer arr

1 ≤ arr.length ≤ 100
[input] integer k

1 ≤ k ≤ 20
[output] array.integer
 */
public class K_Messed_Array_Sort {

    static int[] sortKMessedArray(int[] arr, int k) {
    /*
   for(int i=1; i < arr.length; i++){
     int el = arr[i];
     int j = i-1;
     while(j >= 0 && arr[j] > el){
       arr[j+1] = arr[j];
       j--;
     }
     arr[j+1] = el;
   }
    return arr;
  }
  */
        int n = arr.length;
        PriorityQueue<Integer> q = new PriorityQueue();
        for(int i=0; i< k+1; i++)
            q.add(arr[i]);

        for(int i=k+1; i <n; i++){
            arr[i-k-1] = q.poll();
            q.add(i);
        }
        for(int i =0; i <k+1; i++){
            arr[n-k-1+i] = q.poll();
        }
        return arr;
    }
}
