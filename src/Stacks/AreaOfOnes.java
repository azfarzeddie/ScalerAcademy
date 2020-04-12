package Stacks;

public class AreaOfOnes {
    public static int area(int[][] A) {
        RectangleHistogram rectangleHistogram = new RectangleHistogram();
        int result = rectangleHistogram.largestArea(A[0]);
        for(int i=1;i<A.length;i++) {
            for(int j=0;j<A[0].length;j++) {
                if(A[i][j]==1) {
                    A[i][j] += A[i-1][j];
                }
            }
            result = Math.max(result, rectangleHistogram.largestArea(A[i]));
        }
        return result;
    }

    public static void main(String[] args) {
        int A[][] = { {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0},
        };
        System.out.println("Area of max rectangle is "+area(A));
    }
}
