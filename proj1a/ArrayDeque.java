public class ArrayDeque<Item> {

    private Item[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    public ArrayDeque() {
        items = (Item[]) new Object[8];
        nextFirst = 3;
        nextLast = 4;
        size = 0;
    }

    public void resize(int capacity) {
        Item[] p = (Item[]) new Object[capacity];

        System.arraycopy(items, nextFirst + 1, p, (capacity - size) / 2, size);
        nextFirst = ((capacity - size) / 2) - 1;
        nextLast = nextFirst + size + 1;
        items = p;
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
        Item returnItem = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst += 1;
        size -= 1;
        return returnItem;
    }

    public Item removeLast() {
        if (size * 4 < items.length) {
            resize(items.length / 2);
        }
        //TODO: logic needs to be stated
        Item returnItem = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast -= 1;
        size -= 1;
        return returnItem;
    }

    public void printDeque() {
        for (int i = nextFirst + 1; i < nextLast; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public Item get(int i) {
        return items[nextFirst + i + 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        ArrayDeque<String> adeque = new ArrayDeque<>();
        int size = adeque.size();
        boolean empty = adeque.isEmpty();
        adeque.addFirst("Davron");
        adeque.addFirst("Nelly");
        int size2 = adeque.size();
        adeque.addLast("Guba");
        adeque.addLast("Raul");
        int size3 = adeque.size();
        boolean empty2 = adeque.isEmpty();
        String firstItem = adeque.get(1);
        String firstRemoved = adeque.removeFirst();
        String lastRemoved = adeque.removeLast();
        int size4 = adeque.size();
    }
}
