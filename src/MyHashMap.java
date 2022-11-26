public class MyHashMap<K, V> {
    public Node<K, V> first;

    public MyHashMap() {
    }

    public void put(K key, V value) {
        if (first == null) {
            first = new Node<K, V>(key, value, null);
        } else if (first.next == null) {
            Node<K, V> newItem = new Node<K, V>(key, value, null);
            first.next = newItem;
        } else {
            Node<K, V> newItem = new Node<K, V>(key, value, null);
            Node<K, V> tempLast = first.next;
            while (tempLast.next != null) {
                tempLast = tempLast.next;
            }
            tempLast.next = newItem;
        }
    }

    public V remove(K key) {
        V tempValue = null;
        int size = size();
        if (size == 0) {
            return null;
        } else if (size == 1) {
            if (first.key == key) {
                tempValue = first.value;
                first = null;
            } else {
                return null;
            }
        } else {
            if (first.key == key) {
                tempValue = first.value;
                first = first.next;
            } else {
                Node<K, V> temp = first;
                while (temp.next != null) {
                    if (temp.next.key == key) {
                        tempValue = temp.next.value;
                        temp.next = temp.next.next;
                        break;
                    }
                    temp = temp.next;
                }
            }
        }
        return tempValue;
    }

    public void clear() {
        first = null;
    }

    public V get(K key) {
        Node<K, V> temp = first;
        while (temp.next != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }
        if (temp.key == key) {
            return temp.value;
        }
        return null;
    }

    public int size() {
        if (first == null) {
            return 0;
        } else if (first.next == null) {
            return 1;
        } else {
            int count = 1;
            Node<K, V> temp = first.next;
            while (temp.next != null) {
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
            strB.append("[").append(first).append("]");
        } else {
            strB.append("[").append(first).append(", ");
            Node<K, V> temp = first.next;
            while (temp.next != null) {
                strB.append(temp).append(", ");
                temp = temp.next;
            }
            strB.append(temp);
            strB.append("]");
        }
        return strB.toString();
    }

    private static class Node<K, V> {
        final K key;
        V value;
        Node<K, V> next;

        Node(K key, V value, Node<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" + key + ", " + value + "}";
        }
    }
}