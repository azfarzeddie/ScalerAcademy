package Greedy;

public class BinaryString {
    public static void main (String[] args) {
        String str = "011";
        int k = 3;
        System.out.println(str);
        System.out.println("Number of switches required :: " + getNumSwitches(str, k));
    }

    public static int getNumSwitches (String A, int B) {
        StringBuffer sb = new StringBuffer(A);
        int count = 0;
        for (int i = 0; i < A.length(); i++) {
            if (sb.charAt(i) == '0') {
                count++;
                if(A.length()-i < B)
                    return -1;
                for (int j = 0; j < B; j++) {
                    sb.replace(j, j + 1, String.valueOf(1-Character.getNumericValue(sb.charAt(j))));
                }
            }
        }
        return count;
    }
}
