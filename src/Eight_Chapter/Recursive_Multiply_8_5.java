package Eight_Chapter;

/**
 * @author Mert Ozer
 * Write a recursive function to multiply two positive integers without using the
 * operator. You can use addition, subtraction, and bit shifting, but you should minimize the number
of those operations.
 */
public class Recursive_Multiply_8_5 {
    public static void main(String[] args){
        System.out.println(minProduct(115,711));
    }
    public static int minProduct(int a, int b) {
        int bigger = a < b ? b : a;
        int smaller = a < b ? a : b;
        return multiply(smaller, bigger);
    }
    public static int multiply(int smaller, int bigger){
        if (smaller == 0)
            return 0;
        else if (smaller == 1)
            return bigger;

        int result = multiply(smaller >> 1, bigger);

        if (smaller % 2 == 0)
            return result + result;

        return result + result + bigger;
    }
}
