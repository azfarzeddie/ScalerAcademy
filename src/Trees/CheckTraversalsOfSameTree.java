package Trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CheckTraversalsOfSameTree {
    public static void main(String[] args) {
        Integer[] pre = {13, 33, 41, 11, 49, 48, 23};
        Integer[] in = {41, 33, 11, 13, 48, 49, 23};
        Integer[] post = {41, 11, 33, 48, 23, 49, 13};
        ArrayList<Integer> preorder = new ArrayList<>(Arrays.asList(pre));
        ArrayList<Integer> inorder = new ArrayList<>(Arrays.asList(in));
        ArrayList<Integer> postorder = new ArrayList<>(Arrays.asList(post));
        System.out.println(isSameTree(preorder, inorder, postorder));
    }

    public static int isSameTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.size(); i++) {
            map.put(inorder.get(i), i);
        }
        System.out.println(map);
        int lenPre = preorder.size();
        int lenIn = inorder.size();
        int lenPost = postorder.size();
        //System.out.println("lenpre=" + lenPre + " lenin=" + lenIn + " lenpost=" + lenPost);
        if (lenIn != lenPost || lenPost != lenPre || lenIn != lenPre)
            return 0;
        return checkTree(preorder, 0, inorder, 0, postorder, 0, map, lenIn) ? 1 : 0;
    }

    public static boolean checkTree(ArrayList<Integer> preorder, int preStart, ArrayList<Integer> inorder, int inStart, ArrayList<Integer> postorder, int postStart, Map<Integer, Integer> map, int len) {

        if (len == 0)
            return true;
        else if (len == 1)
            return (preorder.get(preStart) == inorder.get(inStart) && inorder.get(inStart) == postorder.get(postStart));

        int index = -1;
        index = map.get(preorder.get(preStart));
        System.out.println("index=" + index);
        if (index == -1)
            return false;
        boolean res1 = checkTree(preorder, preStart + 1, inorder, inStart, postorder, postStart, map, index);
        boolean res2 = checkTree(preorder, preStart + index + 1, inorder, inStart + index + 1, postorder, postStart + index, map, len - index - 1);
        //System.out.println("res1=" + res1 + " res2=" + res2);
        return res1 && res2;
    }
}
