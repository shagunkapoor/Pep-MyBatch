package Z_Interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimizeChapters {

//    public static List<List<Integer>> regroupChapters(List<List<Integer>> chapters, int limit) {
//        // Step 1: Flatten the input into a single list of sections
//        List<Integer> sections = new ArrayList<>();
//        for (List<Integer> chapter : chapters) {
//            sections.addAll(chapter);
//        }
//
//        // Step 2: Sort the sections in descending order (greedy approach)
//        Collections.sort(sections, Collections.reverseOrder());
//
//        // Step 3: Use a greedy approach to group sections into new chapters
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> currentChapter = new ArrayList<>();
//        int currentTotal = 0;
//
//        // Step 4: Go through the sorted sections and group them into chapters
//        for (int section : sections) {
//            // If adding the current section exceeds the limit, start a new chapter
//            if (currentTotal + section > limit) {
//                result.add(new ArrayList<>(currentChapter));
//                currentChapter.clear();
//                currentTotal = 0;
//            }
//
//            // Add the section to the current chapter
//            currentChapter.add(section);
//            currentTotal += section;
//        }
//
//        // Add the last chapter if it has any sections
//        if (!currentChapter.isEmpty()) {
//            result.add(new ArrayList<>(currentChapter));
//        }
//
//        return result;
//    }

//    public static List<List<Integer>> regroupChapters(List<List<Integer>> chapters, int limit) {
//        // Step 1: Flatten the input into a single list of sections
//        List<Integer> sections = new ArrayList<>();
//        for (List<Integer> chapter : chapters) {
//            sections.addAll(chapter);
//        }
//
//        // Step 2: Sort the sections in descending order (greedy approach)
//        Collections.sort(sections, Collections.reverseOrder());
//
//        // Step 3: Use a greedy approach to group sections into new chapters
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> currentChapter = new ArrayList<>();
//        int currentTotal = 0;
//
//        // Step 4: Go through the sorted sections and group them into chapters
//        for (int section : sections) {
//            // If adding the current section exceeds the limit, start a new chapter
//            if (currentTotal + section > limit) {
//                // Save the current chapter and start a new one
//                result.add(new ArrayList<>(currentChapter));
//                currentChapter.clear();
//                currentTotal = 0;
//            }
//
//            // Add the section to the current chapter
//            currentChapter.add(section);
//            currentTotal += section;
//        }
//
//        // Add the last chapter if it has any sections
//        if (!currentChapter.isEmpty()) {
//            result.add(new ArrayList<>(currentChapter));
//        }
//
//        return result;
//    }

//    public static List<List<Integer>> regroupChapters(List<List<Integer>> chapters, int limit) {
//        // Step 1: Flatten the input into a single list of sections
//        List<Integer> sections = new ArrayList<>();
//        for (List<Integer> chapter : chapters) {
//            sections.addAll(chapter);
//        }
//
//        // Step 2: Sort the sections in descending order (greedy approach)
//        Collections.sort(sections, Collections.reverseOrder());
//
//        // Step 3: Use a greedy approach to group sections into new chapters
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> currentChapter = new ArrayList<>();
//        int currentTotal = 0;
//
//        // Step 4: Try to pack sections into chapters
//        for (int section : sections) {
//            // If adding the current section exceeds the limit, start a new chapter
//            if (currentTotal + section > limit) {
//                // Save the current chapter and start a new one
//                result.add(new ArrayList<>(currentChapter));
//                currentChapter.clear();
//                currentTotal = 0;
//            }
//
//            // Add the section to the current chapter
//            currentChapter.add(section);
//            currentTotal += section;
//        }
//
//        // Add the last chapter if it has any sections
//        if (!currentChapter.isEmpty()) {
//            result.add(new ArrayList<>(currentChapter));
//        }
//
//        return result;
//    }

//    public static List<List<Integer>> regroupChapters(List<List<Integer>> chapters, int limit) {
//        // Step 1: Flatten the input into a single list of sections
//        List<Integer> sections = new ArrayList<>();
//        for (List<Integer> chapter : chapters) {
//            sections.addAll(chapter);
//        }
//
//        // Step 2: Sort the sections in descending order (greedy approach)
//        Collections.sort(sections, Collections.reverseOrder());
//
//        // Step 3: Use a greedy approach to group sections into new chapters
//        List<List<Integer>> result = new ArrayList<>();
//        List<Integer> currentChapter = new ArrayList<>();
//        int currentTotal = 0;
//
//        // Step 4: Try to pack sections into chapters
//        for (int section : sections) {
//            // If adding the current section exceeds the limit, start a new chapter
//            if (currentTotal + section > limit) {
//                // Save the current chapter and start a new one
//                result.add(new ArrayList<>(currentChapter));
//                currentChapter.clear();
//                currentTotal = 0;
//            }
//
//            // Add the section to the current chapter
//            currentChapter.add(section);
//            currentTotal += section;
//        }
//
//        // Add the last chapter if it has any sections
//        if (!currentChapter.isEmpty()) {
//            result.add(new ArrayList<>(currentChapter));
//        }
//
//        return result;
//    }

//    public static List<List<Integer>> regroupChapters(List<List<Integer>> chapters, int limit) {
//        // Step 1: Flatten the input into a single list of sections
//        List<Integer> sections = new ArrayList<>();
//        for (List<Integer> chapter : chapters) {
//            sections.addAll(chapter);
//        }
//
//        // Step 2: Sort the sections in descending order (greedy approach)
//        Collections.sort(sections, Collections.reverseOrder());
//
//        // Step 3: Use a priority queue to group sections into new chapters
//        PriorityQueue<Chapter> pq = new PriorityQueue<>();
//        for (int section : sections) {
//            if (!pq.isEmpty() && pq.peek().total + section <= limit) {
//                Chapter current = pq.poll();
//                current.sections.add(section);
//                current.total += section;
//                pq.offer(current);
//            } else {
//                Chapter newChapter = new Chapter();
//                newChapter.sections.add(section);
//                newChapter.total = section;
//                pq.offer(newChapter);
//            }
//        }
//
//        // Step 4: Collect the results from the priority queue
//        List<List<Integer>> result = new ArrayList<>();
//        while (!pq.isEmpty()) {
//            result.add(pq.poll().sections);
//        }
//
//        return result;
//    }

    //*******DP*********
//    public static List<List<Integer>> regroupChapters(List<List<Integer>> chapters, int limit) {
//        // Step 1: Flatten the input into a single list of sections
//        List<Integer> sections = new ArrayList<>();
//        for (List<Integer> chapter : chapters) {
//            sections.addAll(chapter);
//        }
//
//        // Step 2: Initialize DP table
//        int n = sections.size();
//        int[][] dp = new int[n + 1][limit + 1];
//        boolean[][] keep = new boolean[n + 1][limit + 1];
//
//        // Step 3: Fill DP table
//        for (int i = 1; i <= n; i++) {
//            int section = sections.get(i - 1);
//            for (int w = 0; w <= limit; w++) {
//                if (section <= w && dp[i - 1][w - section] + section > dp[i - 1][w]) {
//                    dp[i][w] = dp[i - 1][w - section] + section;
//                    keep[i][w] = true;
//                } else {
//                    dp[i][w] = dp[i - 1][w];
//                }
//            }
//        }
//
//        // Step 4: Reconstruct the solution
//        List<List<Integer>> result = new ArrayList<>();
//        int w = limit;
//        List<Integer> currentChapter = new ArrayList<>();
//        for (int i = n; i > 0; i--) {
//            if (keep[i][w]) {
//                currentChapter.add(sections.get(i - 1));
//                w -= sections.get(i - 1);
//            } else {
//                if (!currentChapter.isEmpty()) {
//                    result.add(new ArrayList<>(currentChapter));
//                    currentChapter.clear();
//                }
//                w = limit;
//                i++;
//            }
//        }
//        if (!currentChapter.isEmpty()) {
//            result.add(new ArrayList<>(currentChapter));
//        }
//
//        return result;
//    }

    public static List<List<Integer>> regroupChapters(List<List<Integer>> chapters, int limit) {
        // Step 1: Flatten the input into a single list of sections
        List<Integer> sections = new ArrayList<>();
        for (List<Integer> chapter : chapters) {
            sections.addAll(chapter);
        }

        // Step 2: Initialize DP table
        int n = sections.size();
        int[] dp = new int[limit + 1];
        int[] lastSection = new int[limit + 1];

        // Step 3: Fill DP table
        for (int i = 0; i < n; i++) {
            int section = sections.get(i);
            for (int w = limit; w >= section; w--) {
                if (dp[w - section] + section > dp[w]) {
                    dp[w] = dp[w - section] + section;
                    lastSection[w] = i;
                }
            }
        }

        // Step 4: Reconstruct the solution
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[n];
        int w = limit;
        while (w > 0) {
            List<Integer> currentChapter = new ArrayList<>();
            while (w > 0 && !used[lastSection[w]]) {
                int sectionIndex = lastSection[w];
                currentChapter.add(sections.get(sectionIndex));
                used[sectionIndex] = true;
                w -= sections.get(sectionIndex);
            }
            if (!currentChapter.isEmpty()) {
                result.add(currentChapter);
            }
            w = limit;
        }

        return result;
    }

    private static class Chapter implements Comparable<Chapter> {
        List<Integer> sections = new ArrayList<>();
        int total = 0;

        @Override
        public int compareTo(Chapter other) {
            return Integer.compare(this.total, other.total);
        }
    }

    public static void main(String[] args) {
        // Input: List of chapters where each chapter is a list of section question counts
        List<List<Integer>> input = Arrays.asList(
                Arrays.asList(40),
                Arrays.asList(4),
                Arrays.asList(42),
                Arrays.asList(8),
                Arrays.asList(43),
                Arrays.asList(4),
                Arrays.asList(3),
                Arrays.asList(19),
                Arrays.asList(30),
                Arrays.asList(6)
        );

        // Define the limit of questions per chapter
        int limit = 50;

        // Get the result after regrouping chapters
        List<List<Integer>> output = regroupChapters(input, limit);

        // Print the output
        System.out.println(output);
    }
}
