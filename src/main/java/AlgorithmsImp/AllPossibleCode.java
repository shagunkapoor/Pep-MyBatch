package AlgorithmsImp;

public class AllPossibleCode {

    public static void main(String[] args) {

        // String s = "11234";
        // String s="012";
        String s = "2611055971756562";
        //
        printCode(s, "");
        printCount(s);

    }

    public static void printCode(String ques, String ans) {
        if (ques.length() == 0) {
            System.out.println(ans);
            return;
        }

        String ch1 = ques.substring(0, 1);
        String ros1 = ques.substring(1);

        char c1 = (char) (Integer.parseInt(ch1) + 'a' - 1);
        if (Integer.parseInt(ch1) > 0)
            printCode(ros1, ans + c1);

        if (Integer.parseInt(ch1) == 0)
            printCode(ros1, ans);

        if (ques.length() >= 2) {

            String ch2 = ques.substring(0, 2);
            String ros2 = ques.substring(2);

            char c2 = (char) (Integer.parseInt(ch2) + 'a' - 1);

            if (Integer.parseInt(ch2) <= 26) {
                printCode(ros2, ans + c2);
            }
        }
    }

    public static void printCount(String str) {

        if (str.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        char[] digits = str.toCharArray();
        int n = digits.length;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 0;


            if (digits[i - 1] > '0') {
                dp[i] = dp[i - 1];
            }

            if (digits[i - 2] == '1' || digits[i - 2] == '2') {
                if ((digits[i - 2] - '0') * 10 + (digits[i - 1] - '0') <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }

        System.out.println(dp[n]);

    }

}
