package dataStructures.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class _2_MinStack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-3);
        minStack.push(-2);
        minStack.push(-3);
        System.out.printf("Get min : %d\n", minStack.getMin());
        minStack.pop();
        System.out.printf("Get top : %d\n", minStack.top());
        System.out.printf("Get min : %d\n", minStack.getMin());
    }
}

class MinStack {

    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */