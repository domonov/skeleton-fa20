public class ArrayDeque<Item> {

    private Item[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (Item[]) new Object[16];
        nextFirst = 7;
        nextLast = 8;
        size = 0;
    }

    public void resize(int capacity) {
        Item[] p = (Item[]) new Object[capacity];
        //TODO: make sure to copy the items to p such that p will get elements properly.


    }


    public void addFirst(Item x) {
        if (size * 4 > items.length) {
            resize(items.length * 2);
        }
        items[nextFirst] = x;
        nextFirst -= 1;
        size += 1;
    }

    public void addLast(Item x) {
        if (size * 4 > items.length) {
            resize(items.length * 2);
        }
        items[nextLast] = x;
        nextLast += 1;
        size += 1;
    }

    public Item removeFirst() {
        if (size * 4 < items.length) {
            resize(items.length / 2);
        }
        //TODO: logic needs to be stated
        return null;
    }

    public Item removeLast() {
        if (size * 4 < items.length) {
            resize(items.length / 2);
        }
        //TODO: logic needs to be stated
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
