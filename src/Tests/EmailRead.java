package Tests;

public class EmailRead {
    public static int solve(int[] arr) {
        int len = arr.length;
        int i = 0, j = 1, sum =0;
        int g = 0;
        while(arr[g++]==0){
                continue;
        }
        i = g-1;
        j = i+1;
        while(i < len && j < len) {
            while(i<len && j<len && arr[i] == 1 && arr[j] == 1) {
                i = j;
                j = j+1;
            }
            while(i<len && j<len && arr[i]==1 && arr[j]==0) {
                j++;
            }
            if(i<len && j<len && arr[i]==1 && arr[j]==1) {
                i = j;
                j = j+1;
                sum++;
            }
        }
        for(int k=0;k<len;k++) {
            if(arr[k] == 1)
                sum++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0,0,1,1,1,1,0,0,1,0};
        System.out.println(solve(arr));
    }
}
