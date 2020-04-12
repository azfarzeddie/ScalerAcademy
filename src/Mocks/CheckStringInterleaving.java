package Mocks;

public class CheckStringInterleaving {
    public static boolean solve(String s1, String s2, String s3) {
        int idx1=0, idx2=0;
        while(idx1<s1.length() && idx2<s2.length()) {
            if(s1.charAt(idx1) == s3.charAt(idx1+idx2)) {
                idx1++;
            } else if(s2.charAt(idx2) == s3.charAt(idx1+idx2)) {
                idx2++;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
        System.out.println(solve(s1, s2, s3));
    }
}
