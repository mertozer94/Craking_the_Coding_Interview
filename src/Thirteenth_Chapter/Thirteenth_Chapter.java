package Thirteenth_Chapter;

/**
 * @author Mert Ozer
 */
public class Thirteenth_Chapter {
    /*
    Q1: In terms of inheritance, what is the effect of keeping a constructor private?
    S1:
    Declaring a constructor private on class A means that you can only access the (private) constructor if you
could also access A's private methods. Who, other than A, can access A's private methods and constructor?
A's inner classes can. Additionally, if A is an inner class of Q, then Q's other inner classes can.
This has direct implications for inheritance, since a subclass calls its parent's constructor. The class A can be
inherited, but only by its own or its parent's inner classes.

    Q2: In Java, does the finally block get executed if we insert a return  statement inside the try block of a try- catch -finally?
    S2: Yes, it will get executed. The finally block gets executed when the try block exits. Even when we
attempt to exit withinthe try block(via a ret urn statement a continue statement, a break statement
or any exception), the finally block will still be executed.

    Q3: What is the difference between final, finally, and finalize?
    S3: To speak in very general terms, final is used to control whether a variable, method, or class
'^'changeable." The finally keyword is used in a try/ catch block to ensure that a segment of code is always
executed. The finalize () method is called by the garbage collector once it determines that no more
references exist.

    Q5: Explain the differences between TreeMap, HashMap, and LinkedHashMap. Provide an example of when each one would be best.
    S5:
    • HashMap offers 0(1) lookup and insertion. If you iterate through the keys, though, the ordering of the
keys is essentially arbitrary. It is implemented by an array of linked lists.
    • TreeMap offers 0(log N) lookup and insertion. Keys are ordered, so if you need to iterate through
the keys in sorted order, you can. This means that keys must implement the Comparable interface.
TreeMap is implemented by a Red-Black Tree.
    • LinkedHashMap offers 0(1) lookup and insertion. Keys are ordered by their insertion order. It is
implemented by doubly-1 inked buckets.

    Q6: Explain what object reflection is in Java and why it is useful.
    S6: Object Reflection is a feature in Java that provides a way to get reflective information about Java classes and
objects, and perform operations such as:
    1. Getting information about the methods and fields present inside the class at runtime.
    2. Creating a new instance of a class.
    3. Getting and setting the object fields directly by getting field reference, regardless of what the access
    modifier is.

    */
}
