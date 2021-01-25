public class ArrayDeque<Item> {

    private Item[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (Item[]) new Object[16];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }

    public void resize(int capacity) {
        Item[] p = (Item[]) new Object[capacity];
        //TODO: make sure to copy the items to p such that p will get elements properly.
    }


    //TODO: I need to consider usage ratio, 25%.

    private void rotate(int index) {
        if (index == nextFirst) {
            if (nextFirst == 0) {
                nextFirst = items.length - 1;
            } else {
                nextFirst -= 1;
            }
        } else {
            if (nextLast + 1 == items.length) {
                nextLast = 0;
            } else {
                nextLast += 1;
            }
        }
    }

    public void addFirst(Item x) {
        items[nextFirst] = x;
        rotate(nextFirst);
        size += 1;
    }

    public void addLast(Item x) {
        items[nextLast] = x;
        rotate(nextLast);
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }
}
