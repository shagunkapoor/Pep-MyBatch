package AmazonQues.Leetcode;

import java.util.*;

public class ImpQues {
    public static void main(String[] args) {

        System.out.println("====Robot Bounded In Circle====");
        //On an infinite plane, a robot initially stands at (0, 0) and faces north.
        //The robot can receive one of three instructions:
        //  "G": go straight 1 unit;
        //  "L": turn 90 degrees to the left;
        //  "R": turn 90 degrees to the right.
        //The robot performs the instructions given in order, and repeats them forever.
        //Return true if and only if there exists a circle in the plane such that
        //the robot never leaves the circle.
        System.out.println(isRobotBounded("GGLLGG"));

        System.out.println("====Group Anagrams====");
        //An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
        //typically using all the original letters exactly once.
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));

        System.out.println("====Word Ladder====");
        //A transformation sequence from word beginWord to word endWord using a dictionary wordList
        // is a sequence of words beginWord -> s1 -> s2 -> ... -> sk such that:
        //- Every adjacent pair of words differs by a single letter.
        //- Every si for 1 <= i <= k is in wordList. Note that beginWord does not need to be in wordList.
        //- sk == endWord
        //Given two words, beginWord and endWord, and a dictionary wordList,
        // return the number of words in the shortest transformation sequence from beginWord to endWord, or 0 if no such sequence exists.
        System.out.println(wordLadder("hit", "cog", Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));


        System.out.println("====Consecutive Numbers Sum====");
        //Input: n = 9
        //Output: 3
        //Explanation: 9 = 4 + 5 = 2 + 3 + 4
        //Lets make some observation first.
        //
        //of length k only one consecutive sequence is possible.
        //eg: let say we want to make 18
        //3 4 5 6 sum:18
        //if we go left having length k sum will decrease(2 3 4 5)
        //if we go to right sum increase (4 5 6 7)
        //
        //So only one consecutive sequence of length k with specific sum is possible.
        //
        //So now i have to find all possible sequence that starts with x , having length k and sum equals to n.
        //
        //x+ (x+1) + (x+2) ..... (x+k-1)=n
        //kx + k(k-1)/2 = n
        //
        //K:unknown and also X:unknown
        //So try hit and trail
        //
        //kx=n - k*(k-1)/2
        //k>0 and x>0 so LHS always Positive
        //
        //n-k*(k-1)/2 > 0
        //n>k*(k-1)/2
        //n>k*(k)/2 // approximation
        //2n>k^2
        //sqrt(2n)>k
        //
        //now we have range for k . k>0 and k<sqrt(2n)
        //
        //kx= n - k*(k-1)/2
        //
        //left side is mutliple of k.
        //if right side (n-k*(k-1)/2) % k ==0 means right side is also a multiple of k.
        //So if this condition follows increase answer count 1.
        System.out.println(consecutiveNumbersSum(9));

        System.out.println("====K Sum====");
        System.out.println(fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));

        //There is a sliding window of size k which is moving from the very left of the array
        // to the very right.
        // You can only see the k numbers in the window.
        // Each time the sliding window moves right by one position.
        System.out.println("====Max Sliding Window====");
        System.out.println(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3));

        //Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
        //return the next greater number for every element in nums.
        System.out.println("====Next Greater Element====");
        System.out.println(nextGreaterElement(new int[]{1, 2, 3, 4, 3}));


        System.out.println("====Employee Free Time====");
        List<List<Interval>> input=new ArrayList<>();
        input.add(Arrays.asList(new Interval(1,2),new Interval(5,6)));
        input.add(Arrays.asList(new Interval(1,3)));
        input.add(Arrays.asList(new Interval(4,10)));
        List<List<Interval>> input2=new ArrayList<>();
        input2.add(Arrays.asList(new Interval(1,3),new Interval(6,7)));
        input2.add(Arrays.asList(new Interval(2,4)));
        input2.add(Arrays.asList(new Interval(2,5),new Interval(9,12)));
        List<Interval> freeTime=employeeFreeTime(input);
        freeTime.forEach(interval -> System.out.println(interval.start+" "+interval.end));
        System.out.println("=============");
        List<Interval> freeTime2=employeeFreeTime(input2);
        freeTime2.forEach(interval -> System.out.println(interval.start+" "+interval.end));
    }

    //O(n)
    //O(1)
    private static boolean isRobotBounded(String instructions) {
        //N-E-S-W
        int[][] directions = {
                {-1, 0},
                {0, 1},
                {1, 0},
                {0, -1}
        };
        int x = 0, y = 0;

        // Index denoting the direction
        // dir = 0 --> North/Up
        // dir = 1 --> East/Right
        // dir = 2 --> South/Down
        // dir = 3 --> West/Left
        int dir = 0; //North

        for (char ins : instructions.toCharArray()) {
            if (ins == 'L') {
                dir = (dir + 3) % 4;
            } else if (ins == 'R') {
                dir = (dir + 1) % 4;
            } else {
                x += directions[dir][0];
                y += directions[dir][1];
            }
        }

        return x == 0 && y == 0 || dir != 0;
    }

    //O(nlog(n))
    private static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> hmap = new HashMap<>();

        for (String anagram : strs) {
            char[] chars = anagram.toCharArray();
            Arrays.sort(chars);
            String sortedStr = String.valueOf(chars);

            if (!hmap.containsKey(sortedStr)) {
                hmap.put(sortedStr, new ArrayList<>());
            }

            hmap.get(sortedStr).add(anagram);

        }
        return new ArrayList<>(hmap.values());
    }

    //O(n*m)
    //O(n)
    private static int wordLadder(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word : wordList) {
            dict.add(word);
        }

        if (!dict.contains(endWord)) {
            return 0;
        }

        //BFS
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String currWord = q.poll();

                if (currWord.equals(endWord)) {
                    return level;
                }

                char[] chArr = currWord.toCharArray();
                for (int j = 0; j < chArr.length; j++) {
                    char ch = chArr[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (chArr[j] == k) {
                            continue;
                        }
                        chArr[j] = k;
                        String newWord = String.valueOf(chArr);

                        if (dict.contains(newWord)) {
                            q.offer(newWord);
                            dict.remove(newWord);
                        }
                    }
                    chArr[j] = ch;
                }
            }
            level++;
        }

        return 0;
    }

    //O(sqrt(n))
    private static int consecutiveNumbersSum(int n) {
        int count = 0;
        for (int k = 1; (k * k) < (2 * n); k++) {
            if ((n - (k * (k - 1)) / 2) % k == 0) {
                count++;
            }
        }

        return count;
    }

    // O(n^{k - 1}) or O(n^3)
    private static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    private static List<List<Integer>> kSum(int[] arr, int target, int start, int k) {

        int n = arr.length;

        if (start == n || n - start < k) {
            return new ArrayList<>();
        }

        //an average value used for early termination of the method when it's not possible to find a solution.
        //The maxVal is used to check if the smallest number in the array is greater than maxVal
        // or the largest number in the array is less than maxVal. If either of these conditions is true, then it's not possible to find k numbers in the array that sum up to the target, and the method returns an empty list.
        int maxVal = target / k;

        if (arr[n - 1] < maxVal || arr[start] > maxVal) {
            return new ArrayList<>();
        }

        if (k == 2) {
            return twoSum(arr, target, start);
        }

        List<List<Integer>> rs = new ArrayList<>();

        for (int i = start; i < n; i++) {
            if (i == start || arr[i - 1] != arr[i]) { //To avoid repetition of elts (Works only with first elt)
                List<List<Integer>> remainingSum = kSum(arr, target - arr[i], i + 1, k - 1);
                for (List<Integer> rem : remainingSum) {
                    rs.add(new ArrayList<>(Arrays.asList(arr[i])));
                    rs.get(rs.size() - 1).addAll(rem);
                }
            }
        }

        return rs;

    }

    private static List<List<Integer>> twoSum(int[] arr, int target, int start) {
        int lo = start, hi = arr.length - 1;
        List<List<Integer>> res = new ArrayList<>();

        while (lo < hi) {
            int sum = arr[lo] + arr[hi];
            if (sum < target || (lo > start && arr[lo] == arr[lo - 1])) {
                lo++;
            } else if (sum > target || (hi < arr.length - 1 && arr[hi] == arr[hi + 1])) {
                hi--;
            } else {
                res.add(Arrays.asList(arr[lo], arr[hi]));
                lo++;
                hi--;
            }
        }

        return res;
    }

    //O(n) => Stack
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        int r = 0;
        int windowStartPtr = 0, windowEndPtr = 0;

        ArrayDeque<Integer> q = new ArrayDeque<>();

        while (windowEndPtr < n) {

            while (q.size() > 0 && nums[q.peekLast()] <= nums[windowEndPtr]) {
                q.removeLast();
            }

            q.addLast(windowEndPtr);

            if (windowEndPtr - windowStartPtr == k - 1) { //for k elts
                int maxIndx = q.peekFirst();
                res[r] = nums[maxIndx]; //storing the max value of this particular window
                if (maxIndx == windowStartPtr) {//for next window to start
                    q.removeFirst();
                }
                windowStartPtr++;
                r++;
            }
            windowEndPtr++;
        }

        return res;
    }

    //O(n) => Stack
    public static int[] nextGreaterElement(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = nums.length;
        int[] res = new int[n];

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (stack.size() > 0 && nums[stack.peek()] <= nums[i % n]) {
                stack.removeFirst();
            }

            res[i % n] = stack.isEmpty() ? -1 : nums[stack.peek()];
            stack.addFirst(i % n);
        }

        return res;
    }

//    [[[1,2],[5,6]],[[1,3]],[[4,10]]]
    private static class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }
  }

    //O(nlog(n))
    public static List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<Interval> intervals = new ArrayList<>();
        for (List<Interval> interval : schedule) {
            intervals.addAll(interval);
        }

        intervals.sort((a, b) -> a.start - b.start);

        List<Interval> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervals.get(0));
        for (int i = 1; i < intervals.size(); i++) {
            Interval currInterval = intervals.get(i);
            Interval prevInterval = mergedIntervals.get(mergedIntervals.size() - 1);

            if (currInterval.start <= prevInterval.end) {
                prevInterval.end = Math.max(prevInterval.end, currInterval.end);
            } else {
                mergedIntervals.add(currInterval);
            }
        }

        List<Interval> freeTime = new ArrayList<>();
        for (int i = 0; i < mergedIntervals.size() - 1; i++) {
            freeTime.add(new Interval(mergedIntervals.get(i).end, mergedIntervals.get(i + 1).start));
        }

        return freeTime;
    }

    /*
    //METHOD 2
    public static List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> result = new ArrayList<>();
        List<Interval> timeLine = new ArrayList<>();
        avails.forEach(e -> timeLine.addAll(e));
        Collections.sort(timeLine, ((a, b) -> a.start - b.start));

        Interval temp = timeLine.get(0);
        for (Interval each : timeLine) {
            if (temp.end < each.start) {
                result.add(new Interval(temp.end, each.start));
                temp = each;
            } else {
                temp = temp.end < each.end ? each : temp;
            }
        }
        return result;
    }

     */
}
