package First_Chapter;

/**
 * @author Mert Ozer
 * There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
palej pie -> true
pales, pale -> true
pale, bale -> true
pale, bae -> false
 */
public class One_Away_1_5 {
    public static void main(String[] args){
        System.out.println(oneAway("pale","ple"));
        System.out.println(oneAway("pales","pale"));
        System.out.println(oneAway("pale","bale"));
        System.out.println(oneAway("pale","bae"));
        System.out.println(oneAway("pale","pbae"));
    }
    public static boolean oneAway(String s, String t){
        if (Math.abs(s.length() - t.length()) > 1)
            return false;

        int min = Math.min(s.length(), t.length());

        for (int i = 0; i < min; i++){

            if (s.charAt(i) != t.charAt(i)){
                if (s.length() > t.length()){
                    return s.substring(i + 1,s.length()).equals(t.substring(i,t.length()));
                }
                else if (s.length() < t.length()){
                    return t.substring(i + 1,t.length()).equals(s.substring(i,s.length()));
                }
                return s.substring(i + 1,s.length()).equals(t.substring(i + 1,t.length()));

            }
        }
        return true;
    }
}
