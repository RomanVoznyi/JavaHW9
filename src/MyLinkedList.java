public class MyLinkedList<T> {
    public Node<T> first;
    public Node<T> last;

    public MyLinkedList() {
    }

    public void add(T item) {
        if (first == null) {
            first = new Node<T>(item, null, null);
        } else if (first.next == null) {
            Node<T> newItem = new Node<T>(item, first, null);
            first.next = newItem;
            last = newItem;
        } else {
            Node<T> newItem = new Node<T>(item, last, null);
            last.next = newItem;
            last = newItem;
        }
    }

    public void remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        if (index > size() - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size() == 1) {
            clear();
        } else {
            if (index == 0) {
                Node tempFirst = first.next;
                tempFirst.prev = null;
                first = tempFirst;
            } else if (index == size() - 1) {
                Node tempLast = last.prev;
                tempLast.next = null;
                last = tempLast;
            } else {
                int count = 1;
                Node temp = first.next;
                while (count != index) {
                    count++;
                    temp = temp.next;
                }
                Node tempPrev = temp.prev;
                Node tempNext = temp.next;
                tempPrev.next = tempNext;
                tempPrev.prev = tempPrev;
            }
        }
    }

    public void clear() {
        first = null;
        last = null;
    }

    public Node<T> get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException();
        }
        if (index > size() - 1) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size() == 1) {
            return first;
        } else {
            if (index == 0) {
                return first;
            } else if (index == size() - 1) {
                return last;
            } else {
                int count = 1;
                Node temp = first.next;
                while (count != index) {
                    count++;
                    temp = temp.next;
                }
                return temp;
            }
        }
    }

    public int size() {
        if (first == null) {
            return 0;
        } else if (first.next == null) {
            return 1;
        } else {
            int count = 1;
            Node temp = first.next;
            while (!temp.equals(last)) {
                count++;
                temp = temp.next;
            }
            count += 1;
            return count;
        }
    }

    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        if (first == null) {
            strB.append("[]");
        } else if (first.next == null) {
            strB.append("[").append(first.item).append("]");
        } else if (first.next.equals(last)) {
            strB.append("[").append(first.item).append(", ").append(last.item).append("]");
        } else {
            strB.append("[").append(first.item).append(", ");
            Node temp = first.next;
            while (!temp.equals(last)) {
                strB.append(temp.item).append(", ");
                temp = temp.next;
            }
            strB.append(last.item);
            strB.append("]");
        }
        return strB.toString();
    }

    private static class Node<T> {
        T item;
        Node<T> prev;
        Node<T> next;

        Node(T item, Node<T> prev, Node<T> next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node with item '"+item+"'.";
        }
    }
}