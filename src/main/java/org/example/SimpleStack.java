package org.example;

import java.util.ArrayList;
import java.util.List;

public class SimpleStack<T> implements Stack<T> {

    private final List<T> items;

    public SimpleStack() {
        this.items = new ArrayList<>();
    }

    /**
     * Tests if this stack is empty
     */
    @Override
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Returns the number of items in this stack.
     */
    @Override
    public int getSize() {
        return items.size();
    }

    /**
     * Pushes an item onto the top of this stack.
     * null item is allowed.
     *
     * @param item an item of the stack
     */
    @Override
    public void push(T item) {
        items.add(item);
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     */
    @Override
    public Item peek() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (Item) items.get(getSize() - 1);
    }

    /**
     * Removes the object at the top of this stack and returns
     * that object as the value of this function.
     *
     * @throws EmptyStackException if this stack is empty.
     */
    @Override
    public Item pop() throws EmptyStackException {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return (Item) items.remove(getSize() - 1);
    }
}