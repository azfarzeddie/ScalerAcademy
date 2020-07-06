package Greedy;

public class StackCubes {
    public static void main (String[] args) {
        int A = 6;
        System.out.println("No of possible arrangements :: "+countArrangements(A));
    }

    public static int countArrangements(int A) {
        int count = 0;
        for (int i=1;i<A;i++) {
            int P = i;
            if((A - P)%P == 0)
                count++;
        }
        return count;
    }
}
