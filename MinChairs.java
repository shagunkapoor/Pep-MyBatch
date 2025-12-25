package DSA_Udemy.Arrays;

import java.util.Arrays;

//Input: S = [1, 2, 6, 5, 3], E = [5, 5, 7, 6, 8]
//Output: 3
//Explanation:
//There are five guests attending the party.
//The 1st guest will arrive at time 1. We need one chair at time 1.
//The 2nd guest will arrive at time 2. There are now two guests at the party, so we need two chairs at time 2.
//The 5th guest will arrive at time 3. There are now three guests at the party, so we need three chairs at time 3.
//The 4th guest will arrive at time 5 and, at the same moment, the 1st and 2nd guests will leave the party.
//There are now two (the 4th and 5th) guests at the party, so we need two chairs at time 5.
//The 3rd guest will arrive at time 6, and the 4th guest will leave the party at the same time.
//There are now two (the 3rd and 5th) guests at the party, so we need two chairs at time 6.
//So we need at least 3 chairs.
//O(nlogn)
public class MinChairs {
    public static void main(String[] args) {
        int arrival[] = {1, 2, 6, 5, 3};
        int departure[] = {5, 5, 7, 6, 8};

        Arrays.sort(arrival);
        Arrays.sort(departure);

        int i = 0, j = 0;
        int chairCount = 0, maxChairRequired = 0;
        int n = arrival.length;

        while (i < n && j < n) {
            if (arrival[i] < departure[j]) {
                chairCount++;
                i++;

                if (maxChairRequired < chairCount) {
                    maxChairRequired = chairCount;
                }
            } else {
                chairCount--;
                j++;
            }
        }

        //OR
//        public int solve(ArrayList<ArrayList<Integer>> A) {
//            int start[] = new int[A.size()];
//            int end[] = new int[A.size()];
//            for(int i=0; i<A.size(); i++) {
//                start[i] = A.get(i).get(0);
//                end[i] = A.get(i).get(1);
//            }
//            Arrays.sort(start);
//            Arrays.sort(end);
//            int idx = 0;
//            for(int i=0; i<start.length; i++) {
//                if(start[i]>=end[idx]) {
//                    idx++;
//                }
//            }
//            return end.length-idx;
//        }

        System.out.println(maxChairRequired);
    }
}
