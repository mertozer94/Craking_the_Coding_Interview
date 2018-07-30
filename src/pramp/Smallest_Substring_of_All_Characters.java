package pramp;

import java.util.HashMap;

/**
 * @author Mert Ozer
 *
 * Given an array of unique characters arr and a string str, Implement a function getShortestUniqueSubstring that finds the smallest substring of str containing all the characters in arr. Return "" (empty string) if such a substring doesn’t exist.

Come up with an asymptotically optimal solution and analyze the time and space complexities.

Example:

input:  arr = ['x','y','z'], str = "xyyzyzyx"

output: "zyx"
Constraints:

[time limit] 5000ms

[input] array.character arr

1 ≤ arr.length ≤ 30
[input] string str

1 ≤ str.length ≤ 500
[output] string
 */
public class Smallest_Substring_of_All_Characters {
    static String getShortestUniqueSubstring(char[] arr, String str) {
        HashMap<Character, Integer> countMap = new HashMap();
        int headIndex = 0;
        String result = "";
        int uniqueCount = 0;

        for(char c: arr)
            countMap.put(c, 0);

        for(int tailIndex = 0; tailIndex < str.length(); tailIndex++){
            char tailChar = str.charAt(tailIndex);

            if(!countMap.containsKey(tailChar))
                continue;

            if(countMap.get(tailChar) == 0)
                uniqueCount++;

            countMap.put(tailChar, countMap.get(tailChar) + 1);

            while(uniqueCount == arr.length){

                if (str.substring(headIndex, tailIndex+1).length() == arr.length)
                    return str.substring(headIndex, tailIndex+1);

                else if(result == "" || result.length() < str.substring(headIndex, tailIndex+1).length()){
                    result = str.substring(headIndex, tailIndex+1);
                }
                char headChar = str.charAt(tailIndex);
                if(countMap.containsKey(headChar)){
                    if(countMap.get(headChar) == 0)
                        uniqueCount --;
                    countMap.put(headChar, countMap.get(headChar) - 1);
                }
                headIndex++;


            }

        }
        return result;


    }
}
