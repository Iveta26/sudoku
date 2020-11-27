package uk.ac.aber.cs21120.solution;

import java.util.NoSuchElementException;

class ArrayStack<E> {

    private E[] data;
    private int top;
    //ArrayList<E> myArray;

    public ArrayStack(int capacity) {
        this.data = (E[]) new Object[capacity];
        top = 0;
    }


    public void push(E element) throws ArrayIndexOutOfBoundsException {
        if (this.data.length < top + 1) {
            throw new ArrayIndexOutOfBoundsException("Stack full");
        } else {
            this.data[this.top] = element;
            this.data[top] = element;
            top++;
        }
    }

    public E pop() throws NoSuchElementException {
        if (this.getSize() == 0) {
            throw new NoSuchElementException("Stack is Empty");
        } else {

            E popped = this.data[this.top - 1];
            this.data[this.top - 1] = null;
            top--;
            return popped;
        }
    }


    public E peek() throws NoSuchElementException {
        if (getSize() == 0) {
            throw new NoSuchElementException("Empty Stack");
        } else {
            return this.data[this.top - 1];
        }
    }


    public boolean isEmpty() throws NoSuchElementException {
        if (top == 0) {
            return true;
        }
        return false;
    }


    public int getSize() {
        return this.top;
    }

}