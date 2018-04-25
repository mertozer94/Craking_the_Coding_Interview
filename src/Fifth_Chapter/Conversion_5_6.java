package Fifth_Chapter;

/**
 * @author Mert Ozer
 * Conversion: Write a function to determine the number of bits you would need to flip to convert
integer A to integer B.
EXAMPLE
Input: 29 (or: lliei), 15 (or: eilll)
Output: 2
 */
public class Conversion_5_6 {
    public static void main(String[] args){
        System.out.println(conversion(29,15));
    }
    public static int conversion(int firstNumber, int secondNumber){
        return Integer.bitCount((firstNumber ^ secondNumber));
    }
}
