package tree;

import java.util.ArrayList;

public class TreeJava {

    String LABEL;
    int n;
    ArrayList<TreeJava> children;
    public TreeJava(String label, int n) {
        this.LABEL = label;
        this.n = n;
        this.children = new ArrayList<>(n);
    }

    private boolean addChild(TreeJava node) {
        if (children.size() < n) {
            return children.add(node);
        }
        return false;
    }

    public boolean addChild(String label) {
        return addChild(new TreeJava(label, n));
    }
    public ArrayList<TreeJava> getChildren() {
        return new ArrayList<>(this.children);
    }

    public TreeJava getChild(int index) {
        if (index < children.size()) {
            return children.get(index);
        }

        return null;
    }
    public static void main(String[] args) {

    }
}