package DSA_Udemy.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

//Given an array of intervals where intervals[i] = [starti, endi],
// merge all overlapping intervals, and
// return an array of the non-overlapping intervals that cover all the intervals in the input.
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge(intervals);

        for (int i = 0; i < res.length; i++) {
            System.out.println("[" + res[i][0] + "," + res[i][1] + "]");
        }
    }

    //O(n*logn)
    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);  //O(Logn)
//        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));  //O(Logn)

        ArrayList<int[]> result = new ArrayList<>();

        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] prevInterval = result.get(result.size() - 1);
            int[] currInterval = intervals[i];

            if (currInterval[0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(currInterval[1], prevInterval[1]);
            } else {
                result.add(currInterval);
            }
        }

        return result.toArray(new int[result.size()][2]);
    }

}
