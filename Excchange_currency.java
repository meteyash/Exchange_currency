//Exchange The Indian Currency Application Using Java With Minimum Number Of Coins/Notes
import java.util.*;

public class Exchange {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter The Amount For Exchange: ");
        int V = sc.nextInt();
        exchanger(V);

        sc.close();

    }

    public static void exchanger(int V) {
        int[] coins = { 1, 2, 5, 10, 20, 50, 100, 200, 500, 2000 };
        int[] minCoins = new int[V + 1];
        int[] lastCoin = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            minCoins[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i && minCoins[i - coins[j]] + 1 < minCoins[i]) {
                    minCoins[i] = minCoins[i - coins[j]] + 1;
                    lastCoin[i] = coins[j];
                }
            }
        }

        System.out.println("Minimum Number Of Coins/Notes Required For Exchange: " + minCoins[V]);
        System.out.print("This Coins/Notes We Required For Exchange: ");
        while (V > 0) {
            System.out.print(lastCoin[V] + " ");
            V -= lastCoin[V];
        }
        System.out.println();
    }
}