import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> {
    private Object[] arr;

    MyStack() {
        this.arr = new Object[0];
    }

    public void push(T item) {
        this.arr = Arrays.copyOf(this.arr, this.size() + 1);
        arr[arr.length - 1] = item;
    }

    public void remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        if (index > arr.length - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (index == 0) {
            this.arr = Arrays.copyOfRange(arr, 1, arr.length);
        } else if (index == arr.length - 1) {
            this.arr = Arrays.copyOfRange(arr, 0, arr.length - 1);
        } else {
            Object[] result = new Object[arr.length - 1];
            System.arraycopy(arr, 0, result, 0, index);
            System.arraycopy(arr, index + 1, result, index, arr.length - (index + 1));
            this.arr = result;
        }
    }

    public void clear() {
        this.arr = new Object[0];
    }

    public int size() {
        return arr.length;
    }

    public Object peek() {
        if (size() == 0) {
            throw new EmptyStackException();
        } else {
            return arr[arr.length - 1];
        }
    }

    public Object pop() {
        if (size() == 0) {
            throw new EmptyStackException();
        } else {
            Object tempEl = arr[arr.length - 1];
            this.arr = Arrays.copyOfRange(arr, 0, arr.length - 1);
            return tempEl;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}