package Third_Chapter;

import java.util.Stack;

/**
 * @author Mert Ozer
 * Queue via Stacks: Implement a MyQueue class which implements a queue using two stacks.
 */
public class MyQueue_3_4 <T> {
    public Stack<T> newStack;
    public Stack<T> oldStack;

    public MyQueue_3_4(){
        newStack = new Stack<>();
        oldStack = new Stack<>();
    }
    public void add(T value){
        newStack.push(value);
    }
    public void shiftItems(){
        if (oldStack.isEmpty()){
            while (!newStack.isEmpty()){
                oldStack.push(newStack.pop());
            }
        }
    }
    public T peek(){
        shiftItems();
        return oldStack.peek();
    }
    public T remove(){
        shiftItems();
        return oldStack.pop();
    }
}
