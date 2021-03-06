package ir.sk.datastructure.fundamental.linklist;

import ir.sk.datastructure.ListIterator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 1/31/2020.
 */
public class SinglyLinkListTest {

    SinglyLinkList<Integer> theList;

    @Before
    public void setUp() throws Exception {
        theList = new SinglyLinkList<>(); // make new list
        theList.insertFirst(4); // insert four items
        theList.insertFirst(3);
        theList.insertFirst(2);
        theList.insertFirst(1);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void isEmpty() {
    }

    @Test
    public void insertFirst() {
        theList.displayList();
        theList.insertFirst(45);
        theList.displayList();
    }

    @Test
    public void displayList() {
        theList.displayList(); // display list
    }

    @Test
    public void delete() {
        theList.displayList();
        theList.delete(66); // display list
        theList.displayList();
    }

    @Test
    public void find() {
        SinglyLink singlyLink = theList.find(44);
        if (singlyLink != null)
            System.out.println("Found link with key " + singlyLink.data);
        else
            System.out.println("Can't find link");
    }

    @Test
    public void getIterator() {
        ListIterator listIterator = theList.getIterator();
        while (listIterator.getCurrent() != null) {
            System.out.println(listIterator.getCurrent().data);
            listIterator.nextLink();
        }
    }

    @Test
    public void traverseIterative() {
        theList.traverseIterative();
    }

    @Test
    public void traverseTailRecursive() {
        theList.traverseTailRecursive(theList.getHead());
    }

    @Test
    public void traverseHeadRecursive() {
        theList.traverseHeadRecursive(theList.getHead());
    }
}