public class LinkedListDeque<Item> {
    private class Node {
        Item item;
        Node prev;
        Node next;

        public Node(Item x, Node p, Node n) {
            item = x;
            prev = p;
            next = n;
        }
    }

    public Node sentinel;
    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        size = 0;
    }

    public void addFirst(Item x) {
        if (isEmpty()) {
            sentinel.next = new Node(x, sentinel, sentinel);
            sentinel.prev = sentinel.next;
        } else {
            sentinel.next = new Node(x, sentinel, sentinel.next);
            sentinel.next.next.prev = sentinel.next;
        }
        size += 1;
    }

    public void addLast(Item x) {
        if (isEmpty()) {
            sentinel.prev = new Node(x, sentinel, sentinel);
            sentinel.next = sentinel.prev;
        } else {
            sentinel.prev = new Node(x, sentinel.prev, sentinel);
            sentinel.prev.prev.next = sentinel.prev;
        }
        size += 1;
    }


    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (p != sentinel) {
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }

    public Item removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node target = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return target.item;
    }

    public Item removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node target = sentinel.prev;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        size -= 1;
        return target.item;
    }

    private Node get(Node n, int index) {
        if (index == 0) {
            return n;
        }
        return get(n.next, index - 1);
    }

    /** Returns the Item at the index, using iteration. */
    public Item get(int index) {
        if (index < size) {
            return get(sentinel.next, index).item;
        }
        return null;
    }

    /** Returns the Item at the index, using recursion. */
    public Item getRecursive(int index) {
        if (index < size) {
            return get(sentinel.next, index).item;
        }
        return null;
    }
}
