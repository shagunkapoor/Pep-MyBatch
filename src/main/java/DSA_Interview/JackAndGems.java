package DSA_Interview;

//Jack is collecting gems on his way down from level 'N'
//At any moment, if Jack has gems whose total value becomes divisible by 'M', they cause an explosion and Jack may die
//Jack can decide whether to pick a gem or not,
//but he can skip at-most 'K' gems consecutively
//height is from 1 to N

//Determine max value of gems he can collect, if not possible, suggest its unsafe(-1)
public class JackAndGems {
    public static void main(String[] args) {
        int testCases = 5;
        int N = 2, K = 3, M = 2;
        int[] arr = {2, 6};
//        10 5 4
//        4 6 10 6 8 10 2 7 6 7
//        9 4 10
//        7 10 8 2 3 5 5 8 8
//        8 5 4
//        8 3 7 7 2 4 10 3
//        4 1 6
//        7 7 2 1

        int gems = getGems(N, K, M, arr);
        System.out.println(gems);
    }

    static int maxCount = Integer.MIN_VALUE;
    static int skipCount = Integer.MIN_VALUE;

    private static int getGems(int N, int K, int M, int[] arr) {
        skipCount = K;
        getMaxGems(N, K, M, arr, 0);

        if (maxCount == 0) {
            return -1;
        }
        return maxCount;
    }

    private static void getMaxGems(int N, int K, int M, int[] arr, int csf) {
        if (N == 0) {
            maxCount = Math.max(maxCount, csf);
            return;
        }

        //Check if gems count is divisible by M
        int div = (csf + arr[N - 1]) % M;

        //Take gems at level N
        if (div != 0)
            getMaxGems(N - 1, skipCount, M, arr, csf + arr[N - 1]);
        //Leave gems at level N
        if (K > 0)
            getMaxGems(N - 1, K - 1, M, arr, csf);
    }

}
