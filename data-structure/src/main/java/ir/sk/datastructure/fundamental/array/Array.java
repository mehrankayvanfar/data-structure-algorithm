package ir.sk.datastructure.fundamental.array;

import ir.sk.algorithm.basic.RotationShift;
import ir.sk.helper.TimeComplexity;
import ir.sk.helper.recursiontype.HeadRecursion;
import ir.sk.helper.recursiontype.TailRecursion;

/**
 * Unordered array data structure like ArrayList in java without using index. Duplicate is allowed.
 * When duplicate is not allowed, It's like Set in java
 * <p>
 * Unordered arrays offer fast insertion but slow searching and deletion.
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 12/7/2017.
 */
public class Array {

    private int[] array;
    private int size;                        // number of data items

    public Array(int max) {
        array = new int[max];
        size = 0;
    }

    /**
     * @param searchKey
     * @return
     */
    @TimeComplexity("O(n)")
    public boolean find(int searchKey) {
        int j;
        for (j = 0; j < size; j++)
            if (array[j] == searchKey)
                break;
        if (j == size)
            return false;
        else
            return true;
    }

    /**
     * put element into array
     *
     * @param value
     */
    @TimeComplexity("O(1)")
    public void insert(int value) {
        array[size] = value;
        size++;
    }

    /**
     * @param index
     * @param value
     */
    @TimeComplexity("O(n)")
    public void insert(int index, int value) {
        RotationShift.rightShift(array, index, size);
        array[index] = value;
        size++;
    }

    /**
     * after delete element, move all elements after index location (shift)
     *
     * @param value
     * @return
     */
    @TimeComplexity("O(n)")
    public boolean delete(int value) {
        int j;
        for (j = 0; j < size; j++)
            if (value == array[j])
                break;
        if (j == size)
            return false;
        else {
            RotationShift.leftShift(array, j, size);
            return true;
        }
    }

    /**
     * displays array contents
     */
    public void display() {
        for (int j = 0; j < size; j++)
            System.out.print(array[j] + " ");
        System.out.println("");
    }

    ////////////////////////////////////////////// traverse
    /**
     *
     */
    @TimeComplexity("O(n)")
    public void traverseIterative() {
        for (int i = 0; i < size; i++)
            System.out.println(array[i]);
    }

    /**
     * @param index
     */
    @TimeComplexity("O(n)")
    @TailRecursion
    public void traverseTailRecursive(int index) {
        if (index == size)
            return;
        System.out.println(array[index]);
        traverseTailRecursive(index + 1);
    }

    /**
     * @param index
     */
    @TimeComplexity("O(n)")
    @HeadRecursion
    public void traverseHeadRecursive(int index) {
        if (index == size)
            return;
        traverseHeadRecursive(index + 1);
        System.out.println(array[index]);
    }
}
