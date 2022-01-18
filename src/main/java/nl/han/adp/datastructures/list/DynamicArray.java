package nl.han.adp.datastructures.list;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class DynamicArray<T> implements IList<T> {
    private static final int DEFAULT_SIZE = 10;
    private static final int GROW_FACTOR = 2;
    private static final int SHRINK_FACTOR = 2;
    private static final int SHRINK_THRESHOLD_RATIO = 4;

    private T[] elements;
    private int nextIndex;
    private int currentIndex;

    public DynamicArray() {
        clear();
    }

    @Override
    public void clear() {
        elements = newArray(DEFAULT_SIZE);
        nextIndex = 0;
    }

    @SuppressWarnings("unchecked")
    private T[] newArray(int size) {
        return (T[]) new Object[size];
    }

    @Override
    public void insert(T item) {
        if(isAtEnd()) append(item);
        if(needToGrow()) growArray();
        System.arraycopy(elements, currentIndex, elements, currentIndex + 1, nextIndex - currentIndex);
    }

    @Override
    public void append(T item) {
        if(needToGrow()) growArray();
        elements[nextIndex] = item;
        nextIndex++;
    }

    private boolean needToGrow() {
        int lastUsedIndex = nextIndex - 1;
        int lastIndexOfArray = elements.length - 1;
        return lastUsedIndex == lastIndexOfArray;
    }

    private void growArray() {
        int newSize = elements.length * GROW_FACTOR;
        elements = Arrays.copyOf(elements, newSize);
    }


    @Override
    public T remove() throws NoSuchElementException {
        return remove(currentIndex);
    }

    @Override
    public T remove(int i) throws NoSuchElementException {
        if(indexOutOfBounds(i)) throw new NoSuchElementException();
        
        T val = elements[i];
        boolean isNotLastElement = i != nextIndex - 1;
        if(isNotLastElement) {
            int elementsToCopy = nextIndex - (i + 1);
            System.arraycopy(elements, i + 1, elements, i, elementsToCopy);
        }

        nextIndex--;
        elements[nextIndex] = null;
        if(currentIndex == nextIndex && nextIndex > 0) currentIndex--;
        if(shouldShrink()) shrink();
        return val;
    }

    private void shrink() {
        int newSize = elements.length / SHRINK_FACTOR;
        if(newSize < DEFAULT_SIZE) newSize = DEFAULT_SIZE;
        elements = Arrays.copyOf(elements, newSize);
    }

    private boolean shouldShrink() {
        int shrinkThreshold = elements.length / SHRINK_THRESHOLD_RATIO;
        return (elements.length > DEFAULT_SIZE) && (length() <= shrinkThreshold);
    }

    private boolean indexOutOfBounds(int i) {
        return i >= nextIndex || i < 0;
    }

    @Override
    public void moveToStart() {
        currentIndex = 0;
    }

    @Override
    public void moveToEnd() {
        currentIndex = nextIndex -1;
    }

    @Override
    public void prev() {
        if(currentIndex > 0) currentIndex--;
    }

    @Override
    public void next() {
        if(currentIndex < nextIndex) currentIndex++;
    }

    @Override
    public int length() {
        return nextIndex;
    }


    @Override
    public int currPos() {
        return currentIndex;
    }

    @Override
    public void moveToPos(int pos) {
        if(indexOutOfBounds(pos)) throw new NoSuchElementException();
        currentIndex = pos;
    }

    @Override
    public boolean isAtEnd() {
        return nextIndex == currentIndex;
    }

    @Override
    public T getValue() throws NoSuchElementException {
        return getValue(currentIndex);
    }

    @Override
    public T getValue(int i) throws NoSuchElementException {
        if(indexOutOfBounds(i)) throw new NoSuchElementException();
        return elements[i];
    }

    @Override
    public boolean isEmpty() {
        return nextIndex == 0;
    }

    public int getCapacity() {
        return elements.length;
    }
}
