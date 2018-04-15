package First_Chapter;

/**
 * @author Mert Ozer
 * String Rotation: Assumeyou have a method isSubst ring which checks if one word is a substring
of another. Given two strings, si and s2, write code to check if s2 is a rotation of si using only one
call to isSubstring (e.g., "waterbottle" is a rotation of'erbottlewat").
 */
public class Rotated_String_1_9 {
    public static void main(String[] args){
        System.out.println(isRotatedString("waterbottle","erbottlewat"));
    }
    public static boolean isRotatedString(String s, String t){
        if (s.length() == t.length() && s.length() > 0)
            return isSubstring(s+s,t);
        return false;
    }
    public static boolean isSubstring(String s, String t){
        return s.contains(t);
    }
}
