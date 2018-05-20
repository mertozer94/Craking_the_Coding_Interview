package pramp;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Mert Ozer
 *
 * You are given an array of characters arr that consists of sequences of characters separated by space characters. Each space-delimited sequence of characters defines a word.

Implement a function reverseWords that reverses the order of the words in the array in the most efficient manner.

Explain your solution and analyze its time and space complexities.

 */
public class Sentence_Reverse {
    static char[] reverseWords(char[] arr) {
        Stack<Character> stack = new Stack<>();
        int lenght = arr.length -1 ;
        char[] result = new char[lenght+1];
        int j = 0;

        for (int i = lenght; i >= 0 ; i--){
            if (arr[i] == ' '){
                while(!stack.isEmpty()){
                    result[j] = stack.pop();
                    j++;
                }
                result[j] = ' ';
                j++;
            }
            else
                stack.push(arr[i]);
        }
        while(!stack.isEmpty()){
            result[j] = stack.pop();
            j++;
        }

        return result;
    }


    public static void main(String[] args) {
        char[] arr = {'p', 'e', 'r', 'f', 'e', 'c', 't', ' ',
                'm', 'a', 'k', 'e', 's', ' ',
                'p', 'r', 'a', 'c', 't', 'i', 'c', 'e'};
        char[] arr2;
        arr2 = reverseWords(arr);

        System.out.println(Arrays.toString(arr2));
    }

}
