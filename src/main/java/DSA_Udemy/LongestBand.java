package DSA_Udemy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//Subsequence which contains max integers
//that can be re-ordered to form consecutive elements
public class LongestBand {
    public static void main(String[] args) {
        int[] arr = {1, 9, 3, 0, 18, 5, 2, 4, 10, 7, 12, 6};
        //Ans: 0,1,2,3,4,5,6,7 => 8 elts

        //O(n)
        int longestBandViaSet = getLongestBandViaSet(arr);
        System.out.println(longestBandViaSet);

        //O(n)
        int longestBand = getLongestBand(arr);
        System.out.println(longestBand);
    }

    private static int getLongestBand(int[] arr) {
        HashMap<Integer, Boolean> hmap = new HashMap<>();
        int maxCount = 0;

        for (int val : arr) {
            hmap.put(val, true);
        }

        for (int val : arr) {
            if (hmap.containsKey(val - 1)) {
                hmap.put(val, false);
            }
        }

        ArrayList<Integer> keys = new ArrayList<>(hmap.keySet());
        for (int key : keys) {
            if (hmap.get(key)) {
                int count = 1;
                int nextNum = key + 1;
                while (hmap.containsKey(nextNum)) {
                    count++;
                    nextNum++;
                }
                if (maxCount < count) {
                    maxCount = count;
                }
            }
        }
        return maxCount;
    }

    private static int getLongestBandViaSet(int[] arr) {
        HashSet<Integer> hs = new HashSet<>();
        int maxCount = 0;

        for (int i = 0; i < arr.length; i++) {
            hs.add(arr[i]);
        }

        for (int val : arr) {
            int parent = val - 1;
            if (!hs.contains(parent)) {
                int count = 1;
                int nextNum = val + 1;
                while (hs.contains(nextNum)) {
                    count++;
                    nextNum++;
                }

                if (maxCount < count) {
                    maxCount = count;
                }
            }
        }

        return maxCount;
    }
}
