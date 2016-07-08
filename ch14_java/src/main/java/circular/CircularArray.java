package circular;

import java.util.Iterator;

/**
 * Created by ilyarudyak on 7/8/16.
 */
public class CircularArray<T> implements Iterable<T> {

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
    public void rotateLeft(int shift) {
        head = convert(shift);
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularIterator<>(this);
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
            index = index + items.length;
        }
        return (head + index) % items.length;
    }

    // iterator class
    class CircularIterator<E> implements Iterator<E> {

        private int _current = -1;
        private E[] _items;

        public CircularIterator(CircularArray<E> circularArray) {
            _items = circularArray.items;
        }

        @Override
        public boolean hasNext() {
            return _current < items.length - 1;
        }

        @Override
        public E next() {
            _current++;
            E item = _items[convert(_current)];
            return item;
        }
    }


    public static void main(String[] args) {
        int size = 5;
        CircularArray<String> a = new CircularArray<>(size);
        for (int i = 0; i < size; i++) {
            a.set(i, String.valueOf(i * 10));
        }
        System.out.println(a);

        System.out.println();
        a.rotateLeft(1);
        System.out.println(a);
        System.out.println( a.get(2) );

        System.out.println();
        a.rotateLeft(2);
        System.out.println(a);
        System.out.println( a.get(2) );

        System.out.println();
        Iterator<String> iterator = a.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }


}




















