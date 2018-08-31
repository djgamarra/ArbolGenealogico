package data;

import java.awt.Color;
import java.awt.Graphics;

public class Node {

    final Parent parent;
    final GraphicInfo gInfo;
    final int pos;
    Node left;
    Node right;

    public Parent getParent() {
        return parent;
    }

    public Node(Parent parent, int pos) {
        this.parent = parent;
        this.gInfo = new GraphicInfo();
        this.pos = pos;
    }

    public boolean addChild(Parent parent, int pos) {
        if (this.left == null) {
            this.left = new Node(parent, pos);
        } else if (this.right == null) {
            this.right = new Node(parent, pos + 1);
        } else {
            return false;
        }
        return true;
    }

    public Node nextByPosition(int x, int y) {
        if (x < this.gInfo.centerX) {
            return this.left;
        } else {
            return this.right;
        }
    }

    public Node nextByPosition(Node node) {
        return this.nextByPosition(node.gInfo.x1 + 1, node.gInfo.x1 + 1);
    }

    public void draw(Graphics g, Color base, Color line) {
        this.gInfo.draw(g, base, line);
        this.gInfo.drawText(g, this.parent.getShortName().toCharArray(), line);
        this.gInfo.drawConnections(g, this, line);
    }

    public void draw(Graphics g, Color base, Color secondary, Color line) {
        this.gInfo.draw(g, base, secondary, line);
        this.gInfo.drawText(g, this.parent.getShortName().toCharArray(), line);
        this.gInfo.drawConnections(g, this, line);
    }

    public void setName(String name) {
        this.parent.name = name;
    }

    public boolean isFather(Node node) {
        return node == this.left || node == this.right;
    }
}
