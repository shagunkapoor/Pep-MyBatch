package DSA_Udemy.Strings;

//Given 'n' strings containing numbers and spaces
//Each consisting of equal no. of spaces
//Spaces are used to divide the string into columns
//Implement a variation of sort command

//Parameters:
//Key: Column used in comparison
//reversed: reverse the comparison result
//comparison-type: lexicographic/ numeric

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

import static java.lang.Integer.parseInt;

public class BStringKeySort {
    public static void main(String[] args) {
        int n = 3;
        String s1 = "92 022";
        String s2 = "82 12";
        String s3 = "77 13";
        String[] str = {s1, s2, s3};
        int key = 2;
        boolean reversal = false;
        String ordering = "numeric";

        //1. Extract out the keys and sore them (Str | Str at Key)
        HashMap<String, String> elementsMap = new HashMap<>();

        for (int row = 0; row < n; row++) {
            elementsMap.put(str[row], extractStrAtKey(str[row], key));
        }

        //2. Sorting
        if (ordering.equals("numeric")) {
//            Arrays.sort(str, 0, 1, numericSort());
        }

        if (ordering.equals("lexicographic")) {
//            Arrays.sort(str, 0, 1, lexicographicSort());
        }


    }

//    private static Comparator<Integer> numericSort(HashMap<String, String> elementsMap, HashMap<String, String> elementsMap2) {
//        return new Comparator<>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return Integer.compare(parseInt(o1), parseInt(o2));
//            }
//        }
//        String elt1=elementsMap.get(0);
//    }

    private static String extractStrAtKey(String s, int key) {
        String[] splittedStr = s.split(" ");
        return splittedStr[key - 1];
    }
}
