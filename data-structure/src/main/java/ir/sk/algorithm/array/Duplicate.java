package ir.sk.algorithm.array;

import ir.sk.algorithm.basic.RotationShift;
import ir.sk.algorithm.basic.Utils;
import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.MultipleLoopsPattern;
import ir.sk.helper.pattern.MultiplePointerPattern;
import ir.sk.helper.technique.BruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Remove duplicates from an array
 *
 * @author <a href="kayvanfar.sj@gmail.com">Saeed Kayvanfar</a> on 2/10/2021.
 */
public class Duplicate {

    /**
     * unsorted array
     * Brute Force approach I: Using 3 nested loops
     * To remove duplicates, first, we need to find them.
     * The idea is to iterate over array A[] till the end, find the duplicates and remove it.
     *
     * @param nums
     * @return
     */
    @TimeComplexity("O(n^3)")
    @SpaceComplexity("O(n)")
    @MultipleLoopsPattern
    @BruteForce
    public static int[] deleteDuplicatesNaive(int[] nums) {
        int newLength = nums.length;
        for (int i = 0; i < newLength; i++) {
            for (int j = i + 1; j < newLength; j++) {
                if (nums[i] == nums[j]) {
                    // shift
                    for (int k = j; k < newLength - 1; k++)
                        nums[k] = nums[k + 1];
                    newLength--;
                }
            }
        }
        return Arrays.copyOf(nums, newLength);
    }

    /**
     * with the standard Java Collections Framework
     *
     * @param array
     */
    public static List<Integer> deleteDuplicatesWithPlainJava(List<Integer> array) {
        return new ArrayList<>(new HashSet<>(array));
    }

    /**
     * use the distinct() method from the Stream API
     *
     * @param array
     * @return
     */
    public static List<Integer> deleteDuplicatesWithJava8(List<Integer> array) {
        return array.stream().distinct().collect(Collectors.toList());
    }

    /**
     * Given an array of sorted numbers, remove all duplicates from it (set it zero). You should not use any extra space;
     *
     * @param arr
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @MultiplePointerPattern
    @Difficulty(type = DifficultyType.EASY)
    public static void deleteDuplicates(int[] arr) {
        int start = 0, end = 1;

        while (end < arr.length) {
            if (arr[start] == arr[end])
                arr[end] = 0;
            else
                start = end;
            end++;
        }
    }


    /**
     * Given an array of sorted numbers, remove all duplicates from it.
     * You should not use any extra space;
     * after removing the duplicates in-place return the new length of the array.
     * <p>
     * In this problem, we need to remove the duplicates in-place such that the resultant length of the array remains sorted.
     * As the input array is sorted, therefore, one way to do this is to shift the elements left whenever we encounter duplicates. In other words,
     * we will keep one pointer for iterating the array and one pointer for placing the next non-duplicate number.
     * So our algorithm will be to iterate the array and whenever we see a non-duplicate number we move it next to the last non-duplicate number we’ve seen.
     * TODO: 1/7/2021 need more attention
     *
     * @param arr
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @MultiplePointerPattern
    @Difficulty(type = DifficultyType.EASY)
    public static void deleteDuplicatesAndShift(int[] arr) {
        int nextNonDuplicate = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
    }

    /**
     * Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.
     * <p>
     * // TODO: 1/16/2021 need more attention
     *
     * @param arr
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @MultiplePointerPattern
    public static int deleteDuplicatesAll(int[] arr, int key) {
        int nextElement = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }
        return nextElement;
    }
}
