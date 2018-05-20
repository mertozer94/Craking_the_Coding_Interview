package Third_Chapter;

import java.util.Stack;

/**
 * @author Mert Ozer
 * Write a program to sort a stack such that the smallest items are on the top. You can use
an additional temporary stack, but you may not copy the elements into any other data structure
(such as an array). The stack supports the following operations: push, pop, peek, and is Empty.
 */
public class Sort_Stack_3_5 {

    public void sort(Stack<Integer> s){
        Stack<Integer> r = new Stack<>();

        while (!s.isEmpty()){
            int temp = s.pop();
            while (!r.isEmpty() && r.peek() > temp){
                s.push(r.pop());
            }
            r.push(temp);
        }
        while (!r.isEmpty()) {
            s.push(r.pop());
        }
    }

}
