package pramp;

/**
 * @author Mert Ozer
 *
 * A string of brackets is considered correctly matched if every opening bracket in the string can be paired up with a later closing bracket, and vice versa. For instance, “(())()” is correctly matched, whereas “)(“ and “((” aren’t. For instance, “((” could become correctly matched by adding two closing brackets at the end, so you’d return 2.

Given a string that consists of brackets, write a function bracketMatch that takes a bracket string as an input and returns the minimum number of brackets you’d need to add to the input in order to make it correctly matched.

Explain the correctness of your code, and analyze its time and space complexities.
 */
public class BracketMatch {
    static int bracketMatch(String text) {

        int difCount = 0;
        int answer = 0;
        for (Character c: text.toCharArray()){
            if (c == '(')
                difCount +=1;

            else if ( c == ')')
                difCount -= 1;

            if ( difCount < 0 ) {
                difCount = 0;
                answer += 1;
            }
        }
        return answer + difCount;
    }

    public static void main(String[] args) {
        System.out.println(bracketMatch("(()"));
        System.out.println(bracketMatch("(())"));
        System.out.println(bracketMatch("())("));

    }
}
