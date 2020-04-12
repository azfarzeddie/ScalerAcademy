package Tests;

public class RemovingChocolates {
    private static int res = 0;
    private static int currentSum = 0;
    public static int solve(int n) {
        int toAdd = 1;
        recur(n, toAdd);
        currentSum = currentSum - 1;
        toAdd = 3;
        recur(n, toAdd);
        return res;
    }

    public static void recur(int n, int toAdd) {
        currentSum = currentSum + toAdd;
        if(currentSum > n)
            return;
        if(currentSum == n) {
            res = res + 1;
            return;
        }

        recur(n, 1);
        currentSum = currentSum - 1;
        recur(n, 3);
        currentSum = currentSum - 3;
    }

    public static void main(String[] args) {
        int input = 5;
        System.out.println("Result = " + solve(input));
    }
}
