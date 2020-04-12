package LinkedList;

import Util.ListNodeDown;
import Util.ScalerUtils;

public class FlattenLinkedList {
    static ScalerUtils scalerUtils = new ScalerUtils();

    public static void main(String[] args) {
        ListNodeDown node1 = new ListNodeDown( 3 );
        ListNodeDown node2 = new ListNodeDown( 4 );
        ListNodeDown node3 = new ListNodeDown( 20 );
        ListNodeDown node4 = new ListNodeDown( 20 );
        ListNodeDown node5 = new ListNodeDown( 30 );
        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        ListNodeDown node11 = new ListNodeDown( 7 );
        ListNodeDown node12 = new ListNodeDown( 7 );
        ListNodeDown node13 = new ListNodeDown( 8 );
        ListNodeDown node21 = new ListNodeDown( 11 );
        ListNodeDown node31 = new ListNodeDown( 22 );
        ListNodeDown node41 = new ListNodeDown( 20 );
        ListNodeDown node42 = new ListNodeDown( 28 );
        ListNodeDown node43 = new ListNodeDown( 39 );
        ListNodeDown node51 = new ListNodeDown( 31 );
        ListNodeDown node52 = new ListNodeDown( 39 );
        node1.down = node11;
        node11.down = node12;
        node12.down = node13;
        node2.down = node21;
        node3.down = node31;
        node4.down = node41;
        node41.down = node42;
        node42.down = node43;
        node5.down = node51;
        node51.down = node52;
        scalerUtils.printLinkedList( flatten( node1 ) );
    }

    public static ListNodeDown flatten(ListNodeDown root) {
        if(root==null||root.right==null)
            return root;
        return mergeSortedLists( root,flatten( root.right ) );
    }

    public static ListNodeDown mergeSortedLists(ListNodeDown a, ListNodeDown b) {
        if (a == null)
            return b;
        if (b == null)
            return a;
        ListNodeDown res;
        if (a.val <= b.val) {
            res = a;
            res.down = mergeSortedLists( a.down, b );
        } else {
            res = b;
            res.down = mergeSortedLists( a, b.down );
        }
        return res;
    }
}
