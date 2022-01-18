package nl.han.adp.algorithms.searching.avl;

public class AVLTreeUtils {
    public static int getHeightOfNode(Node node) {
        int height = -1;
        if(node != null) height = node.getHeight();
        return height;
    }

    public static void printTree(Node node, boolean right) {
        var indent = "";
        if (node != null) {
            System.out.print(indent);
            if (right) {
                System.out.print("R----");
                indent += "   ";
            } else {
                System.out.print("L----");
                indent += "|  ";
            }
            System.out.println(node.getItem());
            printTree(node.getLeft(), false);
            printTree(node.getRight(), true);
        }
    }
}
