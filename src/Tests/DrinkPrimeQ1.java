package Tests;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class DrinkPrimeQ1 {
    static int minEnergy = Integer.MAX_VALUE;
    public static void main(String args[] ) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        System.out.println(getLeastEnergySum(N));
    }

    public static int getLeastEnergySum(int N) {
        for (int i = 1; i <= N; i++) {
            int energy = getEnergies(i, N - i);
            if (energy <= minEnergy)
                minEnergy = energy;
        }
        return minEnergy;
    }

    public static int getEnergies(int a, int b) {
        int sum = 0;
        while(a != 0) {
            sum += a%10;
            a = a/10;
        }
        while(b != 0) {
            sum += b%10;
            b = b/10;
        }
        return sum;
    }
}
