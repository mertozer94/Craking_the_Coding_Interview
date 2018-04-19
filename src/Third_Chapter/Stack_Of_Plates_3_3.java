package Third_Chapter;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Stack;

/**
 * @author Mert Ozer
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple.
Therefore, in real life, we would likely start a new stack when the previous stack exceeds some
threshold Implement a data structure SetOiStacks that mimics this, setofstacks should be
composed of several stacks and should create a new stack once the previous one exceeds capacity.
SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single stack
(that is, pop () should return the same values as it would if there were just a single stack).
FOLLOW UP
Implement a function popAt (int index) which performs a pop operation on a specific sub-stack.
 */
public class Stack_Of_Plates_3_3 {
    public static void main(String[] args){
        SetOfStacks stacks = new SetOfStacks();
        for(int i = 0; i < 16; i++)
            stacks.push(i);
        for(int i = 0; i < 16; i++)
            System.out.println(stacks.pop());

    }
    public static class SetOfStacks{
        public List<Stack<Integer>> stacks;
        public int maxStackSize = 3;
        public Stack<Integer> lastStack;

        public SetOfStacks(){
            stacks = new ArrayList<Stack<Integer>>();
            lastStack = new Stack<Integer>();
        }
        public void push(int el){

            if (lastStack.size() == maxStackSize){
                Stack<Integer> newStack = new Stack<>();
                newStack.add(el);
                stacks.add(lastStack);
                lastStack = newStack;
            }
            else {
                lastStack.push(el);
            }
            return;
        }
        public int pop(){
            if (lastStack.isEmpty()){
                if (stacks.isEmpty()){
                    return -1;
                }
                else{
                    lastStack = stacks.get(stacks.size()-1);
                    stacks.remove(stacks.size()-1);
                }

            }
            return lastStack.pop();
        }

    }
}
