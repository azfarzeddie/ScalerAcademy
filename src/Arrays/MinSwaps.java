package Arrays;

public class MinSwaps {
    public static void main(String[] args) {
        int[] arr = {1, 12, 10, 3, 14, 10, 5};
        System.out.println( solve( arr, 8 ) );
    }

    public static int solve(int[] A, int B){
        int count = 0;
        for(int i=0;i<A.length;i++) {
            if(A[i]<=B)
                count++;
        }
        int unwanted = 0;
        for(int i=0;i<count;i++) {
            if(A[i]>B)
                unwanted++;
        }
        int res = unwanted;
        for(int i=0, j=count;j<A.length;i++, j++) {
            if(A[i]>B)
                unwanted--;
            if(A[j]>B)
                unwanted++;

            res = Math.min( res, unwanted);
        }

        return res;
    }
}
