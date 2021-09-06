package June25;

import java.util.ArrayList;

public class AGetSubSequence {

    public static void main(String[] args) {

        String s = "abc";
        subsequence(s); //Without Recursion
        ArrayList<String> sub = subsequenceWithRecursion(s); //With Recursion
        System.out.println(sub);
        ArrayList<String> res = new ArrayList<>();
        res = getSS(s);
        System.out.println(res);
    }

    public static ArrayList<String> getSS(String str) {
        if (str.equals("")) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        char ch = str.charAt(0);        //a
        String rem = str.substring(1);  //bc

        ArrayList<String> list = getSS(rem);
        ArrayList<String> result = new ArrayList<>();
        for (String s : list) {
            result.add("_" + s);
            result.add(ch + s);
        }

        return result;
    }

    public static ArrayList<String> subsequence(String str) {
        ArrayList<String> res = new ArrayList<>();
        for (int i = 0; i < (1 << str.length()); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = str.length() - 1; j >= 0; j--) {
                int mask = 1 << j;
                int val = mask & i;
                if (val == 0) {
                    sb.append("-");
                } else {
                    sb.append(str.charAt(str.length() - 1 - j));
                }
            }
            System.out.println(sb);
        }

        return res;
    }

    public static ArrayList<String> subsequenceWithRecursion(String str) {
        if (str.length() == 0) {
            ArrayList<String> base = new ArrayList<>();
            base.add("");
            return base;
        }

        ArrayList<String> res = new ArrayList<>();
        char ch = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> restSubSequences = subsequenceWithRecursion(ros);
        for (String subSeq : restSubSequences) {
            res.add("_" + subSeq);
            res.add(ch + subSeq);
        }

        return res;
    }
}
