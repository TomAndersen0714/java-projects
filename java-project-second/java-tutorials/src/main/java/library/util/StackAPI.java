package library.util;

import java.util.Stack;

/**
 * @author TomAndersen
 */
public class StackAPI {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();

        // Stack.push()
        // Pushes an item onto the top of this stack.
        stack.push("Tom");
        stack.push("Jim");
        stack.push("Alise");
        System.out.println("stack = " + stack);

        // Stack.peek()
        // Retrieves at the object at the top of this stack without removing it from the stack.
        // Throws EmptyStackException if this stack is empty.
        System.out.println("stack.peek() = " + stack.peek());


        // Stack.pop()
        // Removes the object at the top of this stack and returns that object as the value of
        // this function.
        // Throws EmptyStackException if this stack is empty.
        System.out.println("stack.pop() = " + stack.pop());
        System.out.println("stack.pop() = " + stack.pop());


        // Stack.empty()
        System.out.println("stack.empty() = " + stack.empty());


        // Stack.toString()
        System.out.println("stack = " + stack);
    }
}
