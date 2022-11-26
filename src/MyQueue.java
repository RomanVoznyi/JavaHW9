import java.util.Arrays;
import java.util.EmptyStackException;

public class MyQueue<T> {
    private Object[] arr;

    MyQueue() {
        this.arr = new Object[0];
    }

    public void add(T item) {
        this.arr = Arrays.copyOf(this.arr, this.size() + 1);
        arr[arr.length - 1] = item;
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
            return arr[0];
        }
    }

    public Object poll() {
        if (size() == 0) {
            throw new EmptyStackException();
        } else {
            Object tempEl = arr[0];
            this.arr = Arrays.copyOfRange(arr, 1, arr.length);
            return tempEl;
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(arr);
    }
}