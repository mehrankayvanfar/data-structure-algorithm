package ir.sk.datastructure.queue;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/10/2017.
 */
public class Queue {

    private int maxSize;
    private long[] queArray;
    private int front;
    private int rear;

    public Queue(int s) {
        maxSize = s+1; // array is 1 cell larger
        queArray = new long[maxSize]; // than requested
        front = 0;
        rear = -1;
    }

    public void insert(long j) { // put item at rear of queue
        if(rear == maxSize-1) // deal with wraparound
            rear = -1;
        queArray[++rear] = j; // increment rear and insert
    }

    public long remove() { // take item from front of queue
        long temp = queArray[front++]; // get value and incr front
        if(front == maxSize) // deal with wraparound
            front = 0;
        return temp;
    }

    public long peekFront() { // peek at front of queue
        return queArray[front];
    }

    public boolean isEmpty() { // true if queue is empty
        return ( rear+1==front || (front+maxSize-1==rear) );
    }

    public boolean isFull() { // true if queue is full

        return ( rear+2==front || (front+maxSize-2==rear) );
    }

    public int size() { // (assumes queue not empty)
        if(rear >= front) // contiguous sequence
            return rear-front+1;
        else // broken sequence
            return (maxSize-front) + (rear+1);
    }
}