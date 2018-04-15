package First_Chapter;

/**
 * @author Mert Ozer
 * Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
 */
public class isUnique_1_1 {
    // using asci
    public static void main(String[] args){
        String[] test = {"abca","de", ""};
        for (String s: test)
            System.out.println(isUnique(s));
    }

    public static boolean isUnique(String str){
        if (str.length() > 128)
            return false;

        int[] codes = new int[128];

        for (Character c:str.toCharArray()){

            if (codes[c] == 1)
                return false;
            codes[c] = 1;
        }
        return true;
    }

}
