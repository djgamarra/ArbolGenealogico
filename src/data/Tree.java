package data;

import java.util.ArrayList;

public class Tree {

    Node root;

    public Node nodeOn(int x, int y) {
        return this.nodeOn(x, y, this.root);
    }

    private Node nodeOn(int x, int y, Node root) {
        if (root == null) {
            return null;
        }
        if (root.gInfo.isIn(x, y)) {
            return root;
        } else {
            return this.nodeOn(x, y, root.nextByPosition(x, y));
        }
    }

    public boolean addChild(Node father, Parent child) {
        if (this.root == null) {
            this.root = new Node(child, 0);
            return true;
        }
        return father.addChild(child, 2 * father.pos);
    }

    public ArrayList<Node> getLevel(int level) {
        if (this.root == null) {
            return new ArrayList<>();
        }
        return this.getLevel(level, 0, this.root, new ArrayList<>());
    }

    private ArrayList<Node> getLevel(int level, int actual, Node root, ArrayList<Node> levelNodes) {
        if (root != null) {
            if (level == actual) {
                levelNodes.add(root);
            } else {
                this.getLevel(level, actual + 1, root.left, levelNodes);
                this.getLevel(level, actual + 1, root.right, levelNodes);
            }
        }
        return levelNodes;
    }

    public void remove(Node node) {
        this.remove(this.root, node);
    }

    private void remove(Node root, Node node) {
        if (root == null) {
            return;
        }
        if (root.left == node) {
            root.left = null;
        } else if (root.right == node) {
            root.right = null;
        } else {
            this.remove(root.left, node);
            this.remove(root.right, node);
        }
    }

    public boolean isRoot(Node node) {
        return node == this.root;
    }

    public void clean() {
        this.root = null;
    }

    public boolean isFather(Node father, Node child) {
        return father.isFather(child);
    }

    public boolean isUncle(Node uncle, Node child) {
        Node dad = this.fatherOf(child);
        return this.areBrothers(uncle, dad);
    }

    public boolean isCousin(Node node1, Node node2) {
        return this.areBrothers(this.fatherOf(node1), this.fatherOf(node2));
    }

    public boolean isGrandFather(Node grand, Node grandChild) {
        Node dad = this.fatherOf(grandChild);
        return this.isFather(grand, dad);
    }

    public boolean areBrothers(Node node1, Node node2) {
        return this.areBrothers(this.root, node1, node2);
    }

    private boolean areBrothers(Node root, Node node1, Node node2) {
        if (root != null) {
            if (root.isFather(node1) && root.isFather(node2)) {
                return true;
            } else if (this.areBrothers(root.left, node1, node2)) {
                return true;
            } else if (this.areBrothers(root.right, node1, node2)) {
                return true;
            }
        }
        return false;
    }

    public Node fatherOf(Node node) {
        return this.fatherOf(this.root, node);
    }

    private Node fatherOf(Node root, Node node) {
        if (root != null) {
            if (root.isFather(node)) {
                return root;
            } else {
                Node dadl = fatherOf(root.left, node);
                Node dadr = fatherOf(root.right, node);
                if (dadl != null) {
                    return dadl;
                }
                if (dadr != null) {
                    return dadr;
                }
            }
        }
        return null;
    }

    public boolean outOfLevel(Node node1, Node node2) {
        return Math.abs(this.levelOf(this.root, node1, 0) - this.levelOf(this.root, node2, 0)) >= 3;
    }

    private int levelOf(Node root, Node node1, final int level) {
        if (root != null) {
            if (root == node1) {
                return level;
            } else {
                return this.levelOf(root.nextByPosition(node1), node1, level + 1);
            }
        }
        return -1;
    }

    public String calcRelationship(Node selectedNode, Node secondaryNode) {
        if (selectedNode == secondaryNode) {
            return "Seleccione dos parientes diferentes";
        }
        if (this.outOfLevel(selectedNode, secondaryNode)) {
            return "...";
        }
        if (this.isFather(selectedNode, secondaryNode)) {
            return "Parentesco: Madre/Padre";
        }
        if (this.isFather(secondaryNode, selectedNode)) {
            return "Parentesco: Hij@";
        }
        if (this.areBrothers(selectedNode, secondaryNode)) {
            return "Parentesco: Herman@s";
        }
        if (this.isCousin(selectedNode, secondaryNode)) {
            return "Parentesco: Prim@s";
        }
        if (this.isUncle(secondaryNode, selectedNode)) {
            return "Parentesco: Sobrin@";
        }
        if (this.isUncle(selectedNode, secondaryNode)) {
            return "Parentesco: Ti@";
        }
        if (this.isGrandFather(selectedNode, secondaryNode)) {
            return "Parentesco: Abuel@";
        }
        if (this.isGrandFather(secondaryNode, selectedNode)) {
            return "Parentesco: Niet@";
        }
        return "...";

    }

}
