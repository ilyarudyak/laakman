package solutions;

/**
 * Created by ilyarudyak on 5/29/16.
 */
public class Coins {

    public static int[][] map;

    public static int makeChange1(int n) {
        int[] coins = {25, 10, 5, 1};
        return makeChange1("", n, coins, 0);
    }

    // differences from my solution:
    // (1) int vs void (2) int[] instead of string
    // (3) no solution printing
    public static int makeChange1(String acc, int amount, int[] coins, int coinIndex) {

        // one coin remaining -> one way to do it
        if (coinIndex >= coins.length - 1) {
//            System.out.println(acc + "-" + amount);
            return 1;
        }

        int coinValue = coins[coinIndex];
        int ways = 0;
//        for (int i = 0; i * coinValue <= amount; i++) {
        for (int i = amount / coinValue; i >= 0; --i) {
            int amountRemaining = amount - i * coinValue;

            // go to next coin
            ways += makeChange1(acc + "-" + i, amountRemaining, coins, coinIndex + 1);
        }
        return ways;
    }

    // ------------------- 2nd approach -------------------

    public static int makeChange2(int n) {
        int[] denoms = {25, 10, 5, 1};
        map = new int[n + 1][denoms.length];
        return makeChange2(n, denoms, 0);
    }
    public static int makeChange2(int amount, int[] denoms, int index) {
        if (map[amount][index] > 0) { // retrieve value
            System.out.println("from map: " + amount + " " + index);
            return map[amount][index];
        }
        if (index >= denoms.length - 1) return 1; // one denom remaining -> one way to do it
        int denomAmount = denoms[index];
        int ways = 0;
        for (int i = 0; i * denomAmount <= amount; i++) {
            // go to next denom, assuming i coins of denomAmount
            int amountRemaining = amount - i * denomAmount;
            ways += makeChange2(amountRemaining, denoms, index + 1);
        }
        map[amount][index] = ways;
        return ways;
    }

    public static int makeChange(int n) {
        int x = makeChange1(n);
        int y = makeChange2(n);
        if (x != y) {
            System.out.println("Error: " + x + " " + y);
        }
        return x;
    }

    public static void main(String[] args) {

        System.out.println(makeChange(100));
//        for (int i = 0; i <= 100; i++) {
//            System.out.println("makeChange(" + i + ") = " + makeChange(i));
//        }
    }

}
