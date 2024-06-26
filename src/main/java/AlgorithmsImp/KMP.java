package AlgorithmsImp;

import java.util.Arrays;
import java.util.HashMap;

public class KMP {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String m = "abdcaabraakadaabraaaabdceabcdaabdcefabghiaa";

        String pat = "abdcefab";

        int[] lps = pitable(pat); // longest prefix which is same as some suffix
        // (lps)

        int startindx = findpattern(m, pat, lps);
        System.out.println(startindx);

        //OR using HashMap
        smallestSubstringWithUniqueChars(m);

    }

    public static int[] pitable(String pat) {
        int[] lps = new int[pat.length()];

        lps[0] = 0;
        int length = 0;
        for (int i = 1; i < pat.length(); ) {
            char ch = pat.charAt(i);
            if (ch == pat.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {
                if (length != 0) {
                    length = lps[length - 1]; // to reach to a location where
                    // there is the index of the
                    // longest possible prefix same
                    // as suffix ( like if we have
                    // checked for 5 matched
                    // characters, and the 6th char
                    // is mismatch, then, if any of
                    // the previous continuous
                    // patterns exists before, then
                    // we wont have to check those
                    // matched chars again

                    // aabcaabdaabcad
                    // here, on checking for aabcad, aabca is a match
                    // but d is not a match, then for d, we dont have to match
                    // from 0th indx (a)
                    // we can start from the 1st indx (a) as first a is already
                    // a match at indx 12
                } else {
                    lps[i] = length;
                    i++;
                }
            }
        }

        return lps;

    }

    public static int findpattern(String str, String pat, int[] lps) {

        int si = 0, j = -1;
        for (int i = 0; i < str.length(); ) {

            if (str.charAt(i) == pat.charAt(j + 1)) {
                i++;
                j++;
            } else {
                if (j >= 0) {
                    j = lps[j] - 1;
                } else
                    i++;
            }

            if (j == (lps.length) - 1) {
                si = i - j;
                break;
            }

        }
        return si;
    }

    public static void smallestSubstringWithUniqueChars(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        HashMap<Character, Integer> temphmap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hmap.put(ch, hmap.containsKey(ch) ? hmap.get(ch) + 1 : 1);
        }
        int csp = 0;
        int cep = 0;
        String shortest = s;

        while (csp < s.length() && cep < s.length()) {

            if (temphmap.size() < hmap.size()) {
                temphmap.put(s.charAt(cep), temphmap.containsKey(s.charAt(cep)) ? temphmap.get(s.charAt(cep)) + 1 : 1);
                cep++;
            } else {
                temphmap.put(s.charAt(csp), temphmap.get(s.charAt(csp)) - 1);

                if (temphmap.get(s.charAt(csp)) == 0) {
                    temphmap.remove(s.charAt(csp));
                }
                csp++;
            }
            if (temphmap.size() == hmap.size()) {
                String ans = s.substring(csp, cep);
                if (shortest.length() > ans.length()) {
                    shortest = ans;
                }
            }
        }

        System.out.println(shortest);

    }

}
