package June21;

public class EPrintAllPermutationsOfAString {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "abc";
        int n = s.length();
//        int totalpermut = fact(n);
        // System.out.println(totalpermut);
//        printpermutations(s, totalpermut);
        permutations(s, "");

    }

    public static int fact(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public static void permutations(String q, String a) {
        if (q.length() == 0) {
            System.out.println(a);
        }

        for (int i = 0; i < q.length(); i++) {
            char ch = q.charAt(i);
            String ros = q.substring(0, i) + q.substring(i + 1);
            permutations(ros, a + ch);
        }

    }

}
