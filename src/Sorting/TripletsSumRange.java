package Sorting;

import java.util.ArrayList;

public class TripletsSumRange {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("0.6");
        list.add("0.7");
        list.add("0.8");
        list.add("1.2");
        list.add("0.4");
        System.out.println(sumRange(list));
    }

    public static int sumRange(ArrayList<String> A) {
        Double Xmax1 = 0.0;
        Double Xmax2 = 0.0;
        Double Xmax3 = 0.0;
        Double Xmin1 = 1.0;
        Double Xmin2 = 1.0;
        Double Ymin1 = 2.0;
        Double Ymin2 = 2.0;
        Double Ymax1 = 0.0;
        Double Zmin1 = 2.0;
        int X = 0, Y = 0, Z = 0;
        for (int i = 0; i < A.size(); i++) {
            Double n = Double.valueOf(A.get(i));
            if (n < (2.0 / 3.0)) {
                X++;
                if (n > Xmax3 && n < Xmax2 && n < Xmax1) {
                    Xmax3 = n;
                } else if (n > Xmax2 && n < Xmax1) {
                    Xmax3 = Xmax2;
                    Xmax2 = n;
                } else if (n > Xmax1) {
                    Xmax3 = Xmax2;
                    Xmax2 = Xmax1;
                    Xmax1 = n;
                }
                if (n < Xmin2 && n > Xmin1) {
                    Xmin2 = n;
                } else if (n < Xmin1) {
                    Xmin2 = Xmin1;
                    Xmin1 = n;
                }
            } else if (n <= 1) {
                Y++;
                if (n > Ymax1) {
                    Ymax1 = n;
                }
                if (n < Ymin2 && n > Ymin1) {
                    Ymin2 = n;
                } else if (n < Ymin1) {
                    Ymin2 = Ymin1;
                    Ymin1 = n;
                }
            } else if (n < 2) {
                Z++;
                if (n < Zmin1) {
                    Zmin1 = n;
                }
            }
        }
        if (X >= 3) {
            if (Xmax1 + Xmax2 + Xmax3 > 1) {
                return 1;
            }
        }
        if (X >= 2 && Z >= 1) {
            if (Xmin1 + Xmin2 + Zmin1 < 2) {
                return 1;
            }
        }
        if (X >= 1 && Y >= 2) {
            if (Xmin1 + Ymin1 + Ymin2 < 2) {
                return 1;
            }
        }
        if (X >= 1 && Y >= 1 && Z >= 1) {
            if (Xmin1 + Ymin1 + Zmin1 < 2) {
                return 1;
            }
        }
        if (X >= 2 && Y >= 1) {
            if (Xmax1 >= 0.5 && Xmax1 + Xmax2 + Ymin1 < 2) {
                return 1;
            }
            if (Xmin2 < 0.5 && Xmin1 + Xmin2 + Ymax1 > 1) {
                return 1;
            }
        }
        return 0;
    }
}
