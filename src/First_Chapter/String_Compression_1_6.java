package First_Chapter;

/**
 * @author Mert Ozer
 * Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed7'string would not become smaller than theoriginal string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
public class String_Compression_1_6 {
    public static void main(String[] args){
        System.out.println(compress("test"));
        System.out.println(compress("abcabacbabcabac"));
        System.out.println(compress("testttttttttt"));
        System.out.println(compress("ttt"));

    }

    public static String compress(String s){
        Character pre = s.charAt(0);
        int count = 0;
        StringBuilder string = new StringBuilder();
        for (Character c: s.toCharArray()){
            if (c != pre){
                string.append(pre);
                string.append(count);
                count = 0;
            }
            count ++;
            pre = c;
        }
        string.append(pre);
        string.append(count);

        if (string.length() < s.length())
            return string.toString();

        return s;
    }
}
