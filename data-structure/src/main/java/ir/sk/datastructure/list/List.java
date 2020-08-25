package ir.sk.datastructure.list;

/**
 * an ordered collection of items of some element type E. Note that this doesn't mean that the objects are in sorted order,
 * it just means that each object has a position in the List, starting with position zero.
 *
 * In some ways, a List is similar to an array: both Lists and arrays are ordered collections of objects and in both cases
 * you can add or access items at a particular position (and in both cases we consider the first position to be position zero).
 * You can also find out how many items are in a List (using its size method), and how large an array is (using its length field).
 *
 * The main advantage of a List compared to an array is that, whereas the size of an array is fixed when it is created
 *
 * Created by sad.keyvanfar on 8/25/2020.
 */
public interface List<T> {
    /**
     * Add item to the end of the List
     *
     * @param item
     */
    void add(T item);

    /**
     * Add item to the List in position pos (moving items over to the right to make room).
     * @param pos
     * @param item
     */
    void add(int pos, T item);

    T get(int pos);

    T remove(int pos);
}
