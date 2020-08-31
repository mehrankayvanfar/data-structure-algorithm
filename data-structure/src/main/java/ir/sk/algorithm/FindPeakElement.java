package ir.sk.algorithm;

import ir.sk.helper.SpaceComplexity;
import ir.sk.helper.TimeComplexity;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sad.keyvanfar on 6/27/2020.
 */
public class FindPeakElement {

    /**
     * to find peak element by linear traverse and iterative
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    public static boolean findPeakByLoop(int array[], int low, int high) {
        // first or last element is peak element
        if (array.length == 1)
            return true;
        if (array[0] >= array[1])
            return true;
        if (array[array.length - 1] >= array[array.length - 2])
            return true;

        // check for every other element
        for (int i = 1; i < array.length - 1; i++) {
            // check if the neighbors are smaller
            if (array[i] >= array[i - 1] && array[i] >= array[i + 1])
                return true;
        }
        return false;
    }

    /**
     * to find peak element by decrease-and-conquer (Divide-and-conquer algorithm) and recursive
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    @TimeComplexity("O(log n)")
    @SpaceComplexity("O(1)")
    public static boolean findPeakByRecursive(int array[], int low, int high) {
        if (low > high)
            return false;
        int mid = (low + high) / 2;
        if (array[mid] >= array[mid - 1] && array[mid] >= array[mid + 1])
            return true;
        else if (array[mid] < array[mid - 1])
            return findPeakByRecursive(array, low, mid - 1);
        else
            return findPeakByRecursive(array, mid + 1, high);
    }

    /**
     *
     * @param array
     * @param low
     * @param high
     * @return
     */
    @TimeComplexity("O(mn)")
    public static boolean findPeakIn2DArrayByLoop(int array[][], int low, int high) {
        // first or last element is peak element
        if (array.length == 1)
            return true;
        if (array[0][0] >= array[0][1] && array[0][0] >= array[1][0])
            return true;
        if (array[array.length - 1][array.length - 1] >= array[array.length - 1][array.length - 2]
                && array[array.length - 1][array.length - 1] >= array[array.length - 2][array.length - 1])
            return true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][0] >= array[i][1] && array[i][0] >= array[i - 1][0] && array[i][0] >= array[i + 1][0]
                        && array[i][array.length - 1] >= array[i][array.length - 2] && array[i][array.length - 1] >= array[i - 1][array.length - 1] && array[i][array.length - 1] >= array[i + 1][array.length - 1])
                    return true;
            }
        }

        // check for every other element
        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 0; j < array[i].length; j++) {
                // check if the neighbors are smaller
                if (array[i][j] >= array[i][j - 1] && array[i][j] >= array[i][j + 1]
                        && array[i][j] >= array[i - 1][j] && array[i][j] >= array[i + 1][j])
                    return true;
            }
        }
        return false;
    }

    /**
     * Greedy Ascent Algorithm works on the principle, that it selects a particular element to start with.
     * Then it begins traversing across the array, by selecting the neighbour with higher value.
     * If there is no neighbour with a higher value than the current element, it just returns the current element.
     *
     * @param array
     * @param i
     * @param j
     * @return
     */
    @TimeComplexity("O(mn)")
    public static int greedyAscentAlgorithmByRecursive(int[][] array, int i, int j) {
        if (i > 0 && array[i - 1][j] > array[i][j]) return greedyAscentAlgorithmByRecursive(array, i - 1, j);
        else if (i < array.length - 1 && array[i + 1][j] > array[i][j])
            return greedyAscentAlgorithmByRecursive(array, i + 1, j);
        else if (j > 0 && array[i][j - 1] > array[i][j]) return greedyAscentAlgorithmByRecursive(array, i, j - 1);
        else if (j < array.length - 1 && array[i][j + 1] > array[i][j])
            return greedyAscentAlgorithmByRecursive(array, i, j + 1);
        else return array[i][j];
    }

    /**
     *
     * @param array
     * @param col1
     * @param col2
     * @return
     */
    @TimeComplexity("O(rows * log(columns))")
    @SpaceComplexity("O(columns/2) for Recursion Call Stack")
    public static int decreaseAndConquerByRecursive(int[][] array, int col1, int col2) {
        int mid = (col1 + col2) / 2;
        int max = findMaxIndex(array, mid);
        if (col1 == col2)
            return array[max][mid];
        if (array[max][mid] < array[max][mid+1])
            return decreaseAndConquerByRecursive(array, mid + 1, col2);
        else if (array[max][mid] > array[max][mid-1])
            return decreaseAndConquerByRecursive(array, col1, mid + 1);
        else
            return array[max][mid];
    }

    private static int findMaxIndex(int[][] array, int col) {
        List<Integer> integers = Arrays.stream(array).map(ints -> ints[col]).collect(Collectors.toList());
        return integers.indexOf(integers.stream().max(Integer::compareTo).get());
    }

    /**
     * @param array
     * @param row1
     * @param col1
     * @param row2
     * @param col2
     * @return
     */
    public static int decreaseAndConquerBestByRecursive(int[][] array, int row1, int col1, int row2, int col2) {
        int midRow = (row1 + row2) / 2;
        int midCol = (col1 + col2) / 2;
        int max = findMaxIndex(array, midRow);
   //    int max = array[]
        /*if (col1 == col2)
            return array[max][mid];
        if (array[max][mid] < array[max][mid+1])
            return decreaseAndConquerByRecursive(array, mid + 1, col2);
        else if (array[max][mid] > array[max][mid-1])
            return decreaseAndConquerByRecursive(array, col1, mid + 1);
        else
            return array[max][mid];*/
        return 0;
    }

    private static int findMaxIndex(int[][] array, int row, int col) {
        List<Integer> integers = Arrays.stream(array).map(ints -> ints[col]).collect(Collectors.toList());
        return integers.indexOf(integers.stream().max(Integer::compareTo).get());
    }

}
