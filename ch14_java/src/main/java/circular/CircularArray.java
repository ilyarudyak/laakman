package circular;

/**
 * Created by ilyarudyak on 7/8/16.
 */
public class CircularArray<T> {

    private T[] items;
    private int head = 0;

    public CircularArray(int size) {
        items = (T[]) new Object[size];
    }

    public T get(int i) {
//        if (i < 0 || i >= items.length) {
//            throw new java.lang.IndexOutOfBoundsException("Index " + i + " is out of bounds");
//        }
        return items[convert(i)];
    }

    public void set(int i, T item) {
        items[convert(i)] = item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.length; i++) {
            sb.append(get(i) + " ");
        }
        return sb.toString();
    }

    // helper method
    private int convert(int index) {
        if (index < 0) {
            index += items.length;
        }
        return (head + index) % items.length;
    }
    public void rotate(int shiftRight) {
        head = convert(shiftRight);
    }

    public static void main(String[] args) {
        int size = 10;
        CircularArray<String> array = new CircularArray<>(size);
        for (int i = 0; i < size; i++) {
            array.set(i, String.valueOf(i));
        }
        System.out.println(array);

        array.rotate(3);
        System.out.println(array);

        array.rotate(2);
        System.out.println(array);
    }
}




















