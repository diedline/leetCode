package com.diedline.leetcode.stack;

import java.util.Stack;

public class Test232 {
}
/**
 * 使用栈实现队列的下列操作：
 *
 * push(x) -- 将一个元素放入队列的尾部。
 * pop() -- 从队列首部移除元素。
 * peek() -- 返回队列首部的元素。
 * empty() -- 返回队列是否为空。
 * 示例:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // 返回 1
 * queue.pop();   // 返回 1
 * queue.empty(); // 返回 false
 * */
class MyQueue {
    private Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> tempStack = new Stack<>();
        /** 每次将栈尾部值推出并存入新的队列中，通过新的队列来pop就能实现队列的效果*/
        while (!stack.empty()){
            tempStack.push(stack.pop());
        }
        int result = tempStack.pop();
        while (!tempStack.empty()){
            stack.push(tempStack.pop());
        }
        return result;
    }

    /** Get the front element. */
    public int peek() {
        Stack<Integer> tempStack = new Stack<>();
        while (!stack.empty()){
            tempStack.push(stack.pop());
        }
        int result = tempStack.peek();
        while (!tempStack.empty()){
            stack.push(tempStack.pop());
        }
        return result;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.empty();
    }
}