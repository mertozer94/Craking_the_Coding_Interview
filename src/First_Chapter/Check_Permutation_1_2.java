package First_Chapter;

/**
 * @author Mert Ozer
 * Given two strings, write a method to decide if one is a permutation of the
other.
 */
public class Check_Permutation_1_2 {
    public static void main(String[] args){
        System.out.println(checkPermutation("abc","cba"));
        System.out.println(checkPermutation("eeee","dddd"));
        System.out.println(checkPermutation("qwe","qwe"));
        System.out.println(checkPermutation("eee","eeer"));
    }

    public static boolean checkPermutation(String s, String t){
        if (s.length() != t.length())
            return false;

        int[] chars = new int[128];

        for (Character c: s.toCharArray()){
            chars[c - 'a'] += 1;
        }
        for (Character m: t.toCharArray()){
            chars[m - 'a'] -= 1;
            if (chars[m - 'a'] < 0)
                return false;
        }
        return true;
    }
}
