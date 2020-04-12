package Tests;

import Util.ScalerUtils;

public class PackPurchaseLocation {
    public static void main(String[] args) {
        String sid = "'15F0105274011D7A03'";
        ScalerUtils scalerUtils = new ScalerUtils();
        scalerUtils.printArray(getLocation(sid));
    }

    public static String[] getLocation(String sid) {
        sid = sid.substring(1,sid.length()-1);
        String s1 = sid.substring(0,6);
        String s2 = sid.substring(6,10);
        String s3 = sid.substring(10);
        String network = "";
        String[] part1 = {s1.substring(0,2), s1.substring(2,4), s1.substring(4)};
        for(int i=0;i<part1.length;i++) {
            StringBuilder sb = new StringBuilder(part1[i]);
            String temp = sb.reverse().toString();
            if(temp.equals("0F"))
                temp = "0";
            network += temp;

        }
        String lac = String.valueOf(Integer.parseInt(s2,16));
        String ci = String.valueOf(Integer.parseInt(s3,16));
        String[] res = new String[3];
        res[0] = network;
        res[1] = lac;
        res[2] = ci;
        return res;
    }
}
