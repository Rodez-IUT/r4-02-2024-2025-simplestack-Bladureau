package org.example;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class SimpleStackTest<T> {

    @Test
    @DisplayName("Test the state of a newly created slack")
    public void testCreateEmptyStack() { // Test case

        // Given an empty stack, When is created it's empty
        Stack<T> stack = new SimpleStack<T>();

        // Then we look if the stack is empty
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals( 0, stack.getSize(), "A new stack has no element");
    }

    @Test
    @DisplayName("Test limit when trying to peek an empty stack")
    public void testPeekOnEmptyStack() throws EmptyStackException {
        // Given an empty stack
        Stack<T> stack = new SimpleStack<T>();

        // When we "pop" the stack, should throw an EmptyStackException.
        //assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::peek, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test the push of items")
    public void testPush() throws EmptyStackException {

        // Given an empty stack and an item
        Stack<T> stack = new SimpleStack<T>();
        T item = (T) new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(),"The stack must contain 1 item");
        assertSame( item, stack.peek(),"The pushed item must be is on top of the stack");

        // Given a new item to add
        T item2 = (T) new SimpleItem();

        // When we add the new item
        stack.push(item2);

        // Then...
        assertFalse(stack.isEmpty(), "The stack must be not empty");
        assertEquals(2, stack.getSize(),"The stack must contain 2 items");
        assertSame( item2, stack.peek(),"The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStack()  {
        // Given an empty stack
        Stack<T> stack = new SimpleStack<T>();

        // When we "pop" the stack, should throw an EmptyStackException.
        //assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test when tring to pop a stack with an item inside")
    public void testPop() throws EmptyStackException {
        // Given an empty stack and an item
        Stack<T> stack = new SimpleStack<T>();
        T item = (T) new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(),"The stack must contain 1 item");
        assertSame( item, stack.peek(),"The pushed item must be is on top of the stack");

        // When the item is removed
        stack.pop();

        // Then we verified if the stack is empty.
        assertTrue(stack.isEmpty(), "The stack is empty");
    }
}
