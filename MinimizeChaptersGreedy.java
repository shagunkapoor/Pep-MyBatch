package Z_Interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimizeChaptersGreedy {

    private static class Chapter implements Comparable<Chapter> {
        List<Integer> sections = new ArrayList<>();
        int total = 0;

        @Override
        public int compareTo(Chapter other) {
            return Integer.compare(this.total, other.total);
        }
    }

    public static List<List<Integer>> regroupChapters(List<List<Integer>> chapters, int limit) {
        // Step 1: Flatten the input into a single list of sections
        List<Integer> sections = new ArrayList<>();
        for (List<Integer> chapter : chapters) {
            sections.addAll(chapter);
        }

        // Step 2: Sort the sections in descending order (greedy approach)
        sections.sort((a, b) -> b - a);

        // Step 3: Use a priority queue to group sections into new chapters
        PriorityQueue<Chapter> pq = new PriorityQueue<>();
        for (int section : sections) {
            if (!pq.isEmpty() && pq.peek().total + section <= limit) {
                Chapter current = pq.poll();
                current.sections.add(section);
                current.total += section;
                pq.offer(current);
            } else {
                Chapter newChapter = new Chapter();
                newChapter.sections.add(section);
                newChapter.total = section;
                pq.offer(newChapter);
            }
        }

        // Step 4: Collect the results from the priority queue
        List<List<Integer>> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            result.add(pq.poll().sections);
        }

        return result;
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