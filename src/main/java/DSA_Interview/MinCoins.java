package DSA_Interview;

//Min coins needed to fulfill a give amount
public class MinCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        //11 can be paid by min 3 coins=> 5,5,1

        //O(1)
        int minCoins = minCoins(coins, amount);
        System.out.println(minCoins);

    }

    private static int minCoins(int[] coins, int amount) {
        int coin = coins.length - 1;
        int res = 0;
        while (amount > 0) {
            if (amount < coins[coin] || coin <= 0) {
                return -1;
            }
            res += amount / coins[coin];
            amount %= coins[coin];
            coin--;
        }

        return res;
    }
}
