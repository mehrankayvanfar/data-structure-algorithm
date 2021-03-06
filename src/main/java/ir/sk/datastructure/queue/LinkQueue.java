package ir.sk.datastructure.queue;

import ir.sk.datastructure.fundamental.linklist.FirstLastList;

/**
 * 2-ended list
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class LinkQueue<T> implements Queue<T> {

    private FirstLastList<T> theList;

    public LinkQueue() {
        theList = new FirstLastList();
    }

    @Override
    public boolean isEmpty() {
        return theList.isEmpty();
    }

    /**
     * @param j
     */
    @Override
    public void enqueue(T j) {
        theList.insertLast(j);
    }

    /**
     * @return
     */
    @Override
    public T dequeue() {
        return theList.deleteFirst();
    }

    @Override
    public T peek() {
        return theList.peakFirst();
    }

    public void display() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }
}
