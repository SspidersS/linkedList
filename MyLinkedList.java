class MyLinkedList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size;

    private static class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        Node(E value, Node<E> next, Node<E> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(E value) {
        Node<E> newNode = new Node<>(value, null, tail);
        if (tail != null) {
            tail.next = newNode;
        } else {
            head = newNode;
        }
        tail = newNode;
        size++;
    }

    public E remove(int index) {
        checkElementIndex(index);
        Node<E> current = node(index);
        E value = current.value;
        Node<E> prevNode = current.prev;
        Node<E> nextNode = current.next;

        if (prevNode == null) {
            head = nextNode;
        } else {
            prevNode.next = nextNode;
        }

        if (nextNode == null) {
            tail = prevNode;
        } else {
            nextNode.prev = prevNode;
        }

        size--;
        return value;
    }

    public void clear() {
        Node<E> current = head;
        while (current != null) {
            Node<E> next = current.next;
            current.next = null;
            current.prev = null;
            current.value = null;
            current = next;
        }
        head = tail = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public E get(int index) {
        checkElementIndex(index);
        return node(index).value;
    }

    private void checkElementIndex(int index) {
        if (!isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < size;
    }

    private Node<E> node(int index) {
        if (index < (size >> 1)) {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        } else {
            Node<E> current = tail;
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
            return current;
        }
    }
}
