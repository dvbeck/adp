package nl.han.adp.assignments.datastructures.stack;

public class Stack<T> implements IStack<T> {
    private static final int DEFAULT_SIZE = 10;
    private int top;
    private final T[] array;

    public Stack() {
        this(DEFAULT_SIZE);
    }

    @SuppressWarnings("unchecked")
    public Stack(int size) {
        array = (T[]) new Object[size];
        top = 0;
    }

    @Override
    public boolean push(T item) {
        int topAfterPush = top + 1;
        if(topAfterPush == array.length) return false;
        array[top] = item;
        top = topAfterPush;
        return true;
    }

    @Override
    public T pop() {
        if(isEmpty()) return null;
        var val = array[--top];
        array[top] = null; // to allow for gc
        return val;
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }

    @Override
    public int size() {
        return top;
    }

    @Override
    public void clear() {
        for(int i = 0; i < top; i++)
            array[i] = null; // to allow for gc

        top = 0;
    }
}
