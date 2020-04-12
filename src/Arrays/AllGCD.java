package Arrays;

public class AllGCD {
    public static void main(String[] args) {

    }
    public static int[] solve(int[] A) {
        int[][] GCDMatrix = new int[1000][1000];
        for(int i=0;i<A.length;i++) {
            GCDMatrix[i][i] = i;
        }
        for(int i=0, j=1; j<A.length;i++, j++) {
            
        }
        return GCDMatrix[0];
    }
}
