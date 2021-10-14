package LAug07;

import java.util.Arrays;

public class DP {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        int n = 43;
        // long start=System.currentTimeMillis();
        // System.out.println(fibonacci(n));
        // System.out.println(fibM(n,new int[n+1]));
        // System.out.println(fibT(n));
        // long end=System.currentTimeMillis();
        // System.out.println(end-start);

        // System.out.println(countBoardPathM(0, 10, new int[10+1])); //
        // qb_size=dest-src+1
        // System.out.println(countBoardPathT(0, 10));
        // Maze Path
        // System.out.println(count2DBoardPathT(3, 3));
        // System.out.println(countMazePath(0, 0, 3, 3, new int[3][3]));
        // int[][] arr = { { 1, 8, 0, 5, 3 }, { 2, 8, 5, 2, 2 }, { 3, 0, 4, 8, 7
        // }, { 0, 5, 0, 0, 1 }, { 6, 0, 9, 6, 2 } };
        // System.out.println(minCostPath(4, 4, arr));

        // Aug 08

        // int[][] gold = { { 2, 2, 5, 8, 2 }, { 5, 3, 0, 0, 4 }, { 3, 4, 6, 7,
        // 7 }, { 4, 1, 0, 0, 0 },
        // { 0, 8, 8, 5, 5 } };
        //
        // System.out.println(Goldmine(gold));
        // System.out.println(countPalindromicSubstring("abccbc"));

        // int[] jumps = { 4, 0, 5, 2, 0, 3, 1, 0, 2, 1, 0 };
        // System.out.println(minJumps(jumps));

        // int[] lis = { 10, 22, 9, 33, 21, 50, 41, 60, 40, 1 };
        // System.out.println(longestIncreasingSubseq(lis));

        // int[] lbs = { 10, 22, 9, 33, 21, 50, 41, 60, 40, 1 };
        // System.out.println(longestBitonicSubseq(lbs));

//        int[] arr = {4, 2, 7, 1, 3};
//        int target = 10;
//        System.out.println(targetSumSubset(arr, target));
        // int[] coins = { 2, 3, 5, 6 };
        // System.out.println(coinChangePermutation(coins, 10));
        // System.out.println(coinChangeCombination(coins, 10));

        // Aug 10
//		String s = "abccbc";
//		int[] dims = { 10, 20, 30, 40, 50, 60 };
        // System.out.println(minCutPalindrome(s, 0, 5, new
        // int[s.length()][s.length()]));
        // System.out.println(matrixChainMultiplication(dims, 0, dims.length -
        // 1, new int[dims.length][dims.length]));
        // System.out.println(maxsubseq("abcabc"));

        // Aug 12
        // int egg = 2;
        // int floor = 100;
        // System.out.println(eggDrop(egg, floor, new int[egg + 1][floor + 1]));
//		 System.out.println(eggDropTab(2, 10));

        // int[][] arr = { { 1, 0, 1, 0, 1, 1 }, { 1, 0, 1, 0, 1, 1 }, { 1, 0,
        // 1, 1, 1, 1 }, { 0, 0, 1, 1, 1, 0 },
        // { 0, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 1, 0 }, { 1, 1, 1, 0, 0, 1 } };
        // System.out.println(maxSquareOfOnes(arr));

//		int[]wt={1,3,4,5};
//		int[] price={10,40,50,70};
//		int bag_cap=8;
        int bag_cap = 387;
        int[] wt = {78, 16, 94, 36, 87, 93, 50, 22, 63, 28, 91, 60, 64, 27, 41, 27, 73, 37, 12, 69, 68, 30, 83, 31, 63, 24, 68, 36, 30, 3, 23, 59, 70, 68};
        int[] price = {94, 57, 12, 43, 30, 74, 22, 20, 85, 38, 99, 25, 16, 71, 14, 27, 92, 81, 57, 74, 63, 71, 97, 82, 6, 26, 85, 28, 37, 6, 47, 30, 14, 58};

        System.out.println(unboundedKnapSack(wt, price, bag_cap));


        // System.out.println(mpcT("abccbc"));

//		 int[] rod = { 0, 3, 5, 6, 15, 10, 25, 12, 24 };
//		 System.out.println(rodCutting(8, rod));
    }

    //O(2^n)
    public static int fibonacci(int n) { // 2^n
        if (n == 0 || n == 1) {
            return n;
        }

        int fibnm1 = fibonacci(n - 1);
        int fibnm2 = fibonacci(n - 2);
        int fibn = fibnm1 + fibnm2;

        return fibn;

    }

    // O(n)
    public static int fibM(int n, int[] qb) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (qb[n] != 0) {
            return qb[n];
        }
        int fibnm1 = fibM(n - 1, qb);
        int fibnm2 = fibM(n - 2, qb);
        int fibn = fibnm1 + fibnm2;

        qb[n] = fibn;

        return fibn;
    }

    // O(n)
    public static int fibT(int n) {
        int[] fib = new int[n + 1];

        fib[0] = 0;
        fib[1] = 1;

        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        return fib[n];
    }

    public static int countBoardPathM(int src, int dest, int[] qb) {
        if (src == dest) {
            return 1;
        }

        int cbpstd = 0;
        if (qb[src] != 0) {
            return qb[src];
        }
        for (int dice = 1; dice <= 6; dice++) {
            int inter = src + dice;
            if (inter <= dest) {
                int cbpitd = countBoardPathM(inter, dest, qb);
                cbpstd += cbpitd;
            }
        }
        qb[src] = cbpstd;

        return cbpstd;
    }

    // O(n)
    public static int countBoardPathT(int src, int dest) {

        int[] f = new int[dest + 1];
        f[dest] = 1;

        for (int i = f.length - 1; i >= 0; i--) {
            for (int dice = 1; dice <= 6; dice++) {
                if (i + dice <= dest) {
                    f[i] += f[i + dice];
                }
            }
        }
        return f[0];
    }

    public static int countMazePath(int sr, int sc, int dr, int dc, int[][] qb) { //Memoise
        if (sr == dr || sc == dc) {
            return 1;
        }
        if (qb[sr][sc] != 0) {
            return qb[sr][sc];
        }

        int r = countMazePath(sr, sc + 1, dr, dc, qb);
        int d = countMazePath(sr + 1, sc, dr, dc, qb);

        qb[sr][sc] = d + r;
        return qb[sr][sc];
    }

    public static int count2DBoardPathT(int dr, int dc) { // Maze Path
        int[][] f = new int[dr + 1][dc + 1];

        for (int r = dr; r >= 0; r--) {
            for (int c = dc; c >= 0; c--) {
                // if (r == dr && c == dc) {
                // f[r][c] = 1;
                // } else if (r == dr) {
                // f[r][c] += f[r][c + 1];
                // } else if (c == dc) {
                // f[r][c] += f[r + 1][c];
                // } else {
                // f[r][c] += f[r + 1][c] + f[r][c + 1];
                // }
                // }
                // }
                // return f[0][0];
                //
                // }
                // OR

                f[dr][dc] = 1;
                if (r == dr || c == dc) {
                    f[r][c] = 1;
                } else {
                    f[r][c] += f[r + 1][c] + f[r][c + 1];
                }
            }
        }
        return f[0][0];

    }

    // O(n^2)
    public static int minCostPath(int dr, int dc, int[][] arr) {

        int[][] f = new int[dr + 1][dc + 1];
        for (int r = dr; r >= 0; r--) {
            for (int c = dc; c >= 0; c--) {
                if (r == dr && c == dc) {
                    f[r][c] = arr[r][c];
                } else if (r == dr) {
                    f[r][c] = arr[r][c] + f[r][c + 1];
                } else if (c == dc) {
                    f[r][c] = arr[r][c] + f[r + 1][c];
                } else {
                    f[r][c] = arr[r][c] + Math.min(f[r][c + 1], f[r + 1][c]);
                }
            }
        }
        return f[0][0];
    }

    // Aug 08

    // O(n^2)
    public static int Goldmine(int[][] gold) {
        int dc = gold[0].length - 1;
        int dr = gold.length - 1;
        int[][] f = new int[gold.length][gold[0].length];

        for (int r = 0; r < gold.length; r++) {
            f[r][dc] = gold[r][dc];
        }

        for (int c = dc - 1; c >= 0; c--) {
            for (int r = dr; r >= 0; r--) {
                if (r == 0) {
                    f[r][c] = gold[r][c] + Math.max(f[r][c + 1], f[r + 1][c + 1]);
                } else if (r == dr) {
                    f[r][c] = gold[r][c] + Math.max(f[r][c + 1], f[r - 1][c + 1]);
                } else {
                    f[r][c] = gold[r][c] + Math.max(f[r][c + 1], Math.max(f[r - 1][c + 1], f[r + 1][c + 1]));
                }
            }
        }
        int max = f[0][0];
        for (int i = 0; i <= dr; i++) {
            if (max < f[i][0]) {
                max = f[i][0];
            }
        }
        return max;
    }

    public static int countPalindromicSubstring(String str) {
        boolean[][] arr = new boolean[str.length()][str.length()];
        int count = 0;
        // for(int gap=0;gap<=str.length()-1;gap++){ // 0-5
        // for(int sp=0;sp<=str.length()-1-gap;sp++){ //0 to len-gap
        // int ep=sp+gap;
        //
        // if(gap==0){ //len=1
        // arr[sp][ep]=true;
        // }else if(gap==1){ //len=2
        // arr[sp][ep]=str.charAt(sp)==str.charAt(ep);
        // }else{
        // arr[sp][ep]=str.charAt(sp)==str.charAt(ep) && arr[sp+1][ep-1];
        // }
        //
        // if(arr[sp][ep]==true){
        // count++;
        // }
        // }
        // }
        // return count;
        // }

        // OR
        for (int len = 1; len <= str.length(); len++) {
            for (int sp = 0; sp <= str.length() - len; sp++) {
                int ep = sp + len - 1;

                if (len == 1) {
                    arr[sp][ep] = true;
                } else if (len == 2) {
                    arr[sp][ep] = str.charAt(sp) == str.charAt(ep);
                } else {
                    arr[sp][ep] = str.charAt(sp) == str.charAt(ep) && arr[sp + 1][ep - 1];
                }

                if (arr[sp][ep] == true) {
                    count++;
                }
            }
        }
        return count;
    }

    public static Integer minJumps(int[] arr) {
        Integer[] minjumpcount = new Integer[arr.length];

        minjumpcount[arr.length - 1] = 0;

        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = i + 1; j <= i + arr[i] && j < arr.length; j++) {
                if (minjumpcount[j] == null) { // position on which it is
                    // looking for min jump=null
                    continue;
                } else {
                    if (minjumpcount[i] == null) { // initialise the value with
                        // its first nearest min
                        // jump +1 for its own jump
                        minjumpcount[i] = minjumpcount[j] + 1;
                    } else {
                        minjumpcount[i] = Math.min(minjumpcount[i], minjumpcount[j] + 1);
                    }
                }
            }
        }
        return minjumpcount[0];
    }

    // Aug 09

    public static int longestIncreasingSubseq(int[] arr) {
        int[] countlis = new int[arr.length];

        countlis[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {

                if (arr[i] > arr[j]) { // increasing
                    int newcount = countlis[j] + 1;
                    int oldcount = countlis[i];
                    if (newcount > oldcount) {
                        countlis[i] = newcount;
                    }
                }
            }
        }
        int maxcount = countlis[0];
        for (int i = 1; i < arr.length; i++) {
            if (maxcount < countlis[i]) {
                maxcount = countlis[i];
            }
        }
        return maxcount;
    }

    public static int longestBitonicSubseq(int[] arr) {

        Integer[] lis = new Integer[arr.length];
        Integer[] lds = new Integer[arr.length];

        lis[0] = 1;
        lds[arr.length - 1] = 1;

        // lis
        for (int i = 1; i < arr.length; i++) {
            lis[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j])
                    lis[i] = Math.max(lis[i], lis[j] + 1);
            }
        }
        // lds
        for (int i = arr.length - 1; i >= 0; i--) {
            lds[i] = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        int lbscount = 0;
        for (int i = 0; i < arr.length; i++) {
            lbscount = Math.max(lis[i] + lds[i] - 1, lbscount);
        }

        return lbscount;
    }

    //Subsets with

    //Limited amount of elts (can be used only once)
    // O(n * target)
    public static boolean targetSumSubset(int[] arr, int target) {
        boolean[][] subsetSum = new boolean[arr.length + 1][target + 1];
        //Array elts start from index 1 in subsetSum, first row is kept blank
        for (int i = 0; i < subsetSum.length; i++) { //Array elts as row
            for (int sum = 0; sum < subsetSum[0].length; sum++) { //Sum of subsets till given row
//                if (i == 0 && sum == 0) {
//                    subsetSum[i][sum] = true;
//                } else if (i == 0) {
//                    subsetSum[i][sum] = false;
//                } else
                if (sum == 0) {// All elts can sum up to 0, as every subset has [] in it
                    subsetSum[i][sum] = true;
                } else {
                    int elt = arr[i - 1];
                    if (subsetSum[i - 1][sum] == true) {//Target achieved by not contributing the elt
                        subsetSum[i][sum] = true;
                    } else if (sum >= elt) {//Elt gives sum=elt & previous elts gives remaining sum (sum-elt)
                        subsetSum[i][sum] = subsetSum[i - 1][sum - elt];
                    }
                }
            }
        }
        return subsetSum[subsetSum.length - 1][target];
    }

    //Given weights array and their price
    //We have a bag with capacity C (weight)
    //Make the price of the bag maximum
    //int[] weights={2,5,1,3,4};
    //int[] prices={15,14,10,45,30};
    //int capacity=7;
    //O(n * Capacity)
    public static int ZeroOneKnapsack(int[] weights, int[] prices, int capacity) {
        int[][] maxPrice = new int[weights.length + 1][capacity + 1];

        for (int weight = 1; weight < maxPrice.length; weight++) {
            for (int cap = 1; cap <= maxPrice[0].length; cap++) {
                int currentWeight = weights[weight - 1];
                if (currentWeight <= cap) {//Only then current weight can be used
                    int currentPrice = prices[weight - 1];
                    int remainingCap = cap - currentWeight;
                    int maxPriceUsingCurrentWeight = currentPrice + maxPrice[weight - 1][remainingCap];
                    maxPrice[weight][cap] = Math.max(maxPrice[weight - 1][cap], maxPriceUsingCurrentWeight);
                } else {
                    maxPrice[weight][cap] = maxPrice[weight - 1][cap];//If current weight is not  used (prev max weight)
                }
            }
        }
        return maxPrice[maxPrice.length - 1][capacity];
    }

    //Unlimited amount of elts (can be used infinitely)

    //O(n * Capacity) ~ Permutations
    public static int unboundedKnapSack(int[] weights, int[] price, int capacity) {
        int[] maxPrice = new int[capacity + 1];

        for (int cap = 0; cap <= capacity; cap++) {
            for (int w = 0; w < weights.length; w++) {
                if (weights[w] <= cap) {
                    int priceForCurrentWeight = maxPrice[cap - weights[w]] + price[w];
                    maxPrice[cap] = Math.max(maxPrice[cap], priceForCurrentWeight);
                }
            }
        }

        return maxPrice[capacity];
    }

    //O(n * Amount)
    public static int coinChangePermutation(int[] coins, int amnt) {
        int[] permutationsCount = new int[amnt + 1];

        permutationsCount[0] = 1;
        for (int i = 1; i < permutationsCount.length; i++) {
            for (int c = 0; c < coins.length; c++) {
                if ((i - coins[c]) >= 0) {
                    permutationsCount[i] += permutationsCount[i - coins[c]];
                }
            }
        }
        return permutationsCount[amnt];
    }

    //O(n * Amount)
    public static int coinChangeCombination(int[] coins, int amnt) {
        //Combinations
        int[] combinationsCount = new int[amnt + 1];

        combinationsCount[0] = 1;

        for (int c = 0; c < coins.length; c++) {
            for (int i = coins[c]; i < combinationsCount.length; i++) { //Starting from current coin(as amnt < coin can't be paid by the current coin)
                if ((i - coins[c]) >= 0) {
                    combinationsCount[i] += combinationsCount[i - coins[c]];
                }
            }
        }
        return combinationsCount[amnt];
    }

    // Aug 10

    public static int minCutPalindrome(String str, int si, int ei, int[][] qb) {
        if (isPalindrome(str, si, ei)) {
            return 0;
        }
        if (qb[si][ei] != 0) {
            return qb[si][ei];
        }

        int totalcount = Integer.MAX_VALUE;
        for (int cutpnt = si; cutpnt < ei; cutpnt++) {
            int lres = minCutPalindrome(str, si, cutpnt, qb);
            int rres = minCutPalindrome(str, cutpnt + 1, ei, qb);
            totalcount = Math.min(totalcount, lres + rres + 1);
        }

        qb[si][ei] = totalcount;

        return totalcount;
    }

    public static int mpcT(String str) { // Min Cut Palindrome (Tabulation)
        int[][] f = new int[str.length()][str.length()];

        for (int gap = 0; gap < f.length; gap++) {
            for (int sp = 0; sp <= f.length - 1 - gap; sp++) {
                int ep = sp + gap;

                if (gap == 0) {
                    f[sp][ep] = 0; // Palindrome
                } else if (gap == 1) {
                    f[sp][ep] = str.charAt(sp) == str.charAt(ep) ? 0 : 1;
                } else {
                    if (str.charAt(sp) == str.charAt(ep)) {
                        if (f[sp + 1][ep - 1] == 0)
                            f[sp][ep] = 0; // Palindrome
                        else
                            f[sp][ep] = 1;
                    } else {
                        f[sp][ep] = gap;
                        for (int k = sp, j = sp + k + 1; k <= ep - 1 && j <= ep; k++, j++) {
                            f[sp][ep] = Math.min(f[sp][ep], f[sp][k] + f[j][ep] + 1);
                        }
                    }
                }
            }
        }

        return f[0][f.length - 1];
    }


    public static boolean isPalindrome(String str, int si, int ei) {
        int left = si;
        int right = ei;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // static char[] ch={'A','B','C','D','E'};
    public static int matrixChainMultiplication(int[] dims, int si, int ei, int[][] qb) {
        if (ei - si == 1) {
            return 0;
        }

        if (qb[si][ei] != 0) {
            return qb[si][ei];
        }
        int totalcost = Integer.MAX_VALUE;
        for (int cp = si + 1; cp <= ei - 1; cp++) {
            int lcost = matrixChainMultiplication(dims, si, cp, qb);
            int rcost = matrixChainMultiplication(dims, cp, ei, qb);
            int realcost = dims[si] * dims[ei] * dims[cp];
            totalcost = Math.min(totalcost, lcost + rcost + realcost);

        }
        qb[si][ei] = totalcost;

        return totalcost;
    }

    public static int maxsubseq(String str) {
        int acount = 0, bcount = 0, ccount = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'a') {
                acount = 1 + 2 * (acount);
            } else if (str.charAt(i) == 'b') {
                bcount = acount + 2 * (bcount);
            } else if (str.charAt(i) == 'c') {
                ccount = bcount + 2 * (ccount);
            }
        }
        return ccount;
    }

    // Aug 12
    // Min no. of trials so that we can find the  critical floor in a guaranteed way
    //Critical Floor= floor where egg breaks such that f < cf = egg safe & f > cf = egg breaks
    public static int eggDrop(int eggs, int floors, int[][] qb) {
        if (eggs == 1 || eggs == 0) {
            return floors;
        }
        if (floors == 0) {
            return 0;
        }
        if (floors == 1) {
            return 1;
        }
        if (qb[eggs][floors] != 0) {
            return qb[eggs][floors];
        }

        int minTrial = Integer.MAX_VALUE;
        for (int k = 1; k <= floors; k++) {
            int mintrialeggbreak = eggDrop(eggs - 1, k - 1, qb);
            int mintrialeggsafe = eggDrop(eggs, floors - k, qb);
            int worstcase = Math.max(mintrialeggbreak, mintrialeggsafe);

            if (worstcase < minTrial) {
                minTrial = worstcase;
            }
        }
        qb[eggs][floors] = minTrial + 1;
        return minTrial + 1;
    }

    public static int eggDropTab(int eggs, int floors) {
        int[][] arr = new int[eggs + 1][floors + 1];

        for (int e = 1; e <= eggs; e++) {
            for (int f = 1; f <= floors; f++) {
                if (f == 1) {// Min Trails=1 from 1 floor
                    arr[e][f] = 1;
                } else if (e == 1) {// 1 egg can be dropped from all floors
                    arr[e][f] = f;
                } else { // for kth floor
                    int mintrial = Integer.MAX_VALUE;
                    for (int k = 1; k <= f; k++) {
                        int mteggbreak = arr[e - 1][k - 1];
                        int mteggsafe = arr[e][f - k];

                        if (Math.max(mteggbreak, mteggsafe) < mintrial) {
                            mintrial = Math.max(mteggbreak, mteggsafe);
                        }

                    }
                    arr[e][f] = mintrial + 1;

                }
            }
        }

        return arr[eggs][floors];

    }

    public static int maxSquareOfOnes(int[][] arr) {
        int[][] f = new int[arr.length][arr[0].length];

        for (int x = 0; x < arr[0].length; x++) {

            f[arr.length - 1][x] = arr[arr.length - 1][x];
        }
        for (int x = 0; x < arr.length; x++) {
            f[x][arr[0].length - 1] = arr[x][arr[0].length - 1];
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            for (int j = arr[0].length - 2; j >= 0; j--) {
                if (arr[i][j] == 0) {
                    f[i][j] = 0;
                } else {
                    f[i][j] = Math.min(Math.min(f[i][j + 1], f[i + 1][j + 1]), f[i + 1][j]) + 1;
                }
            }
        }

        int max = f[0][0];
        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                if (f[r][c] > max) {
                    max = f[r][c];
                }
            }
        }

        return max;
    }

    public static int rodCutting(int n, int[] arr) {
        if (n == 0) {
            return 0;
        }

        int[] MaxSP = new int[arr.length];
        String[] parts = new String[arr.length];

        MaxSP[0] = 0;
        parts[0] = "";

        MaxSP[1] = arr[1];
        parts[1] = "1";

        for (int i = 2; i < arr.length; i++) {
            MaxSP[i] = arr[i];
            parts[i] = i + "";
            for (int j = i - 1, k = 1; j >= k; j--, k++) {
                if (MaxSP[j] + MaxSP[k] > MaxSP[i]) {
                    MaxSP[i] = MaxSP[j] + MaxSP[k];
                    parts[i] = parts[j] + parts[k];
                }

            }
        }

        System.out.println("Parts: " + parts[n]);
        return MaxSP[n];
    }

    //Max count of strings of length n having no consecutive 1s
    //O(n)
    public static int binaryString(int n) {
        int zeroCount = 1;
        int oneCount = 1;

        for (int i = 2; i <= n; i++) {
            int newZeroCount = zeroCount + oneCount;
            int newOneCount = zeroCount;

            zeroCount = newZeroCount;
            oneCount = newOneCount;
        }

        return zeroCount + oneCount;
    }

    //Ways to decode a string: 1123
    //O(n)
    public static int allPossibleCode(String str) {
        int[] decodeCount = new int[str.length() + 1];

        decodeCount[0] = 1;
        for (int i = 1; i < decodeCount.length; i++) {

            if (str.charAt(i - 1) == '0' && str.charAt(i) == '0') {// 0-0
                decodeCount[i] = 0;
            } else if (str.charAt(i - 1) == '0' && str.charAt(i) != '0') {// 0-!0
                decodeCount[i] = decodeCount[i - 1];
            } else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0') {// !0-0
                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
                    decodeCount[i] = decodeCount[i - 2];
                }
            } else {// !0-!0
                decodeCount[i] = decodeCount[i - 1];
                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
                    decodeCount[i] += decodeCount[i - 2];
                }
            }
        }

        return decodeCount[decodeCount.length - 1];
    }

    public static String allPossibleCodeStrings(String str) {
        String[] decodeCount = new String[str.length() + 1];

//        decodeCount[0] = 1;
//        for (int i = 1; i < decodeCount.length; i++) {
//
//            if (str.charAt(i - 1) == '0' && str.charAt(i) == '0') {// 0-0
//                decodeCount[i] = 0;
//            } else if (str.charAt(i - 1) == '0' && str.charAt(i) != '0') {// 0-!0
//                decodeCount[i] = decodeCount[i - 1];
//            } else if (str.charAt(i - 1) != '0' && str.charAt(i) == '0') {// !0-0
//                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
//                    decodeCount[i] = decodeCount[i - 2];
//                }
//            } else {// !0-!0
//                decodeCount[i] = decodeCount[i - 1];
//                if (Integer.parseInt(str.substring(i - 1, i + 1)) <= 26) {
//                    decodeCount[i] += decodeCount[i - 2];
//                }
//            }
//        }

        return "";//decodeCount[decodeCount.length - 1];
    }
}
