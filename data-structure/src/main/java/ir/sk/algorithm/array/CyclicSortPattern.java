package ir.sk.algorithm.array;

import ir.sk.algorithm.basic.Utils;
import ir.sk.datastructure.fundamental.linklist.SinglyLink;
import ir.sk.helper.Difficulty;
import ir.sk.helper.DifficultyType;
import ir.sk.helper.complexity.SpaceComplexity;
import ir.sk.helper.complexity.TimeComplexity;
import ir.sk.helper.pattern.RunnerPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sad.kayvanfar on 2/13/2021.
 */
public class CyclicSortPattern {

    /**
     * We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’.
     * Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.
     * <p>
     * This problem follows the Cyclic Sort pattern. Since the input array contains unique numbers from the range 0 to ‘n’,
     * we can use a similar strategy as discussed in Cyclic Sort to place the numbers on their correct index. Once we have every number in its correct place,
     * we can iterate the array to find the index which does not have the correct number, and that index will be our missing number.
     * <p>
     * See also {@link ir.sk.algorithm.Sort#cyclicSort(int[])}
     *
     * @param nums
     * @return
     */
    @TimeComplexity("O(n) + O(n-1) + O(n) = O(n)")
    @SpaceComplexity("O(1)")
    @Difficulty(type = DifficultyType.EASY)
    public static int findMissingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            if (nums[i] < nums.length && nums[i] == nums[j])
                Utils.swapInArray(nums, i, nums[i]);
            else
                i++;
        }

        // find the first number missing from its index, that will be our required number
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i)
                return i;

        return nums.length;
    }

    /**
     * We are given an unsorted array containing numbers taken from the range 1 to ‘n’.
     * The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.
     * <p>
     * This problem follows the Cyclic Sort pattern and shares similarities with Find the Missing Number with one difference.
     * In this problem, there can be many duplicates whereas in ‘Find the Missing Number’ there were no duplicates and the range was greater than the length of the array.
     * <p>
     * See also {@link #findMissingNumber(int[])}
     *
     * @param nums
     * @return
     */
    @TimeComplexity("O(n) + O(n-1) + O(n) = O(n)")
    @SpaceComplexity("O(n)")
    @Difficulty(type = DifficultyType.EASY)
    public static List<Integer> findAllMissingNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                Utils.swapInArray(nums, i, nums[i] - 1);
            else
                i++;
        }

        List<Integer> missingNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++)
            if (nums[i] != i + 1)
                missingNumbers.add(i + 1);

        return missingNumbers;
    }

    /**
     * We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’.
     * The array has only one duplicate but it can be repeated multiple times.
     * Find that duplicate number without using any extra space.
     * You are, however, allowed to modify the input array.
     * <p>
     * This problem follows the Cyclic Sort pattern and shares similarities with Find the Missing Number.
     * Following a similar approach, we will try to place each number on its correct index. Since there is only one duplicate,
     * if while swapping the number with its index both the numbers being swapped are same, we have found our duplicate!
     * <p>
     * See also {@link ir.sk.algorithm.Sort#cyclicSort(int[])}
     *
     * @param nums
     * @return
     */
    @TimeComplexity("O(n) + O(n-1) = O(n)")
    @SpaceComplexity("O(1)")
    @Difficulty(type = DifficultyType.EASY)
    public static int findDuplicateNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1])
                    Utils.swapInArray(nums, i, nums[i] - 1);
                else // we have found the duplicate
                    return nums[i];
            } else
                i++;
        }
        return -1;
    }

    /**
     * above problem in O(1) space and without modifying the input array.
     * While doing the cyclic sort, we realized that the array will have a cycle due to the duplicate number and that the start of the cycle will always point to the duplicate number.
     * This means that we can use the fast & the slow pointer method to find the duplicate number or the start of the cycle similar to Start of LinkedList Cycle.
     * <p>
     * See also {@link ir.sk.algorithm.linklist.LinkListAlgorithms#hasCycleByRunner(SinglyLink)}
     *
     * @param arr
     * @return
     */
    @TimeComplexity("O(n)")
    @SpaceComplexity("O(1)")
    @RunnerPattern
    public static int findDuplicateByFastAndSlow(int[] arr) {
        int slow = 0, fast = 0;
        do {
            slow = arr[slow];
            fast = arr[arr[fast]];
        } while (slow != fast);

        // find cycle length
        int current = arr[slow];
        int cycleLength = 0;
        do {
            current = arr[current];
            cycleLength++;
        } while (current != arr[slow]);

        return findStart(arr, cycleLength);
    }

    private static int findStart(int[] arr, int cycleLength) {
        int pointer1 = arr[0], pointer2 = arr[0];
        // move pointer2 ahead 'cycleLength' steps
        while (cycleLength > 0) {
            pointer2 = arr[pointer2];
            cycleLength--;
        }

        // increment both pointers untill they meet at the start of cycle
        while (pointer1 != pointer2) {
            pointer1 = arr[pointer1];
            pointer2 = arr[pointer2];
        }

        return pointer1;
    }

    /**
     * We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’.
     * The array has some duplicates, find all the duplicate numbers without using any extra space.
     *
     * This problem follows the Cyclic Sort pattern and shares similarities with Find the Duplicate Number.
     * Following a similar approach, we will place each number at its correct index. After that,
     * we will iterate through the array to find all numbers that are not at the correct indices.
     * All these numbers are duplicates.
     *
     * @param nums
     * @return
     */
    @TimeComplexity("O(n) + O(n-1) = O(n)")
    @SpaceComplexity("O(1)")
    @Difficulty(type = DifficultyType.EASY)
    public static List<Integer> findAllDuplicates(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1])
                Utils.swapInArray(nums, i, nums[i] - 1);
            else
                i++;
        }

        List<Integer> duplicateNumbers = new ArrayList<>();
        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1)
                duplicateNumbers.add(nums[i]);
        }

        return duplicateNumbers;
    }
}
