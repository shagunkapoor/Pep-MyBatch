import java.util.ArrayList;

class Scratch {
    public static void main(String[] args) {

        Node root = null;
        transform(root);
    }

    private static Node transform(Node root) {
        if (root == null) {
            return null;
        }

        ArrayList<Node> children = root.children;
        for (Node child : children) {
            transform(child);
        }

        if (children.size() == 4) {
            Node firstDiagonalChild = children.get(0);
            Node secondDiagonalChild = children.get(3);
            if (firstDiagonalChild.val == secondDiagonalChild.val) {
                if (firstDiagonalChild.val == 'B') {
                    root.val = 'B';
                    removeLeaves(root);
                } else if (firstDiagonalChild.val == 'W') {
                    root.val = 'W';
                    removeLeaves(root);
                }
            }
        }
        return root;
    }

    private static void removeLeaves(Node root) {
        if (root.children.size() > 0) {
            root.children = new ArrayList<>();
        }
    }

    static class Node {
        char val;
        ArrayList<Node> children;

        Node(char val) {
            this.val = val;
            this.children = new ArrayList<>();
        }
    }
}
