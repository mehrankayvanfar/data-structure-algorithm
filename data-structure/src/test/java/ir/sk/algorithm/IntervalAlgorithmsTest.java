package ir.sk.algorithm;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by sad.kayvanfar on 2/1/2021.
 */
public class IntervalAlgorithmsTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void mergeIntervals() {
        List<Interval> input = new ArrayList<>();;
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : IntervalAlgorithms.mergeIntervals(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

    @Test
    public void hasOverlapIntervals() {
        List<Interval> input = new ArrayList<>();;
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.println(IntervalAlgorithms.hasOverlapIntervals(input));
    }
}