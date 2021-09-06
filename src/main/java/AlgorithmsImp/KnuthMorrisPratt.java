package AlgorithmsImp;

//Find the starting index of pattern in string
public class KnuthMorrisPratt {

    public static void main(String[] args) {

        String str = "aabraakaadaabraabcdtrefgh";
        String s1 = "kaa";
        String s2 = "trefg";
        String s3 = "braab";

        str = removeMatchedStrings(str, s1);
        str = removeMatchedStrings(str, s2);
        str = removeMatchedStrings(str, s3);

        System.out.println(str);

    }

    public static int kmpstartindx(String str, String pattern) {
        // String str = "ababcabcabababd";
        // String pattern = "ababd";

        int[] lps = new int[pattern.length()];

        lps[0] = 0;
        int length = 0;
        for (int i = 1; i < pattern.length(); ) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {

                if (length != 0) {
                    length = lps[length - 1];
                } else {
                    lps[i] = length;
                    i++;
                }
            }
        }

//		for (int i = 0; i < lps.length; i++) {
//			System.out.println(lps[i]);
//		}

        int si = 0, j = 0;
        for (int i = 0; i < str.length(); ) {
            if (str.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                }
                if (j == 0 && str.charAt(i) != pattern.charAt(j)) {
                    i++;
                }
            }

            if (j == lps.length) {
                si = i - j;
                break;
            }
        }
        return si;
    }

    public static String removeMatchedStrings(String str, String input1) {
        int si = kmpstartindx(str, input1);
        str = str.substring(0, si) + str.substring(si + input1.length());
        return str;
    }

    public static void removeRepeatingPatterns() {

    }

}
