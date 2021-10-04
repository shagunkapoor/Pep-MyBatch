package DSA_Interview;

import java.util.ArrayList;
import java.util.HashMap;

//Max no. of intersections possible of any vertical line with given N horizontal segments
public class MaxIntersectingLines {
    public static void main(String[] args) {
        int[][] lines = {
                {1, 3},
                {2, 3},
                {1, 2},
                {4, 4}};
        //o/p=3 => A vertical line (X=2), passes through {1,3}, {2,3}, {1,2}, i.e. 3 horizontal lines

        //Difference Array approach O(1)
        //update(l, r, x) : Run a loop from l to r and add x to all elements from A[l] to A[r]

        HashMap<Integer, Integer> diffArray = new HashMap<>();
        for (int[] segment : lines) {
            diffArray.put(segment[0], diffArray.containsKey(segment[0]) ? diffArray.get(segment[0]) + 1 : 1);
            diffArray.put(segment[1] + 1, diffArray.containsKey(segment[1] + 1) ? diffArray.get(segment[1] + 1) - 1 : -1);
        }

        //Prefix Sum
        //run through index 1 to last
        //and keep on adding the present element with the previous value in the prefix sum array
        int count = 0;
        ArrayList<Integer> keys = new ArrayList<>(diffArray.keySet());
        for (int elt : keys) {
//            count+=
        }

    }
}
