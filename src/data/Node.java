package data;

import java.awt.Color;
import java.awt.Graphics;

public class Node {

    final Parent parent;
    final GraphicInfo gInfo;
    final int pos;
    Node left;
    Node right;

    /**
     * Constructor para un nodo
     *
     * @param parent Pariente al que representará el nodo
     * @param pos Posición ó índice en el que se encuentra el nodo en el nivel
     */
    public Node(Parent parent, int pos) {
        this.parent = parent;
        this.gInfo = new GraphicInfo();
        this.pos = pos;
    }

    /**
     * @return Pariente que representa el nodo
     */
    public Parent getParent() {
        return parent;
    }

    /**
     * @return Nivel del nodo
     */
    public int getLevel() {
        return gInfo.level;
    }

    /**
     * @return Verdadero si tiene dos hijos
     */
    public boolean isBusy() {
        return left != null && right != null;
    }

    /**
     * Agrega un nodo hijo dependiendo de si el nodo actual es hijo izquierdo ó
     * hijo derecho y de si tiene ya o no hijo izquierdo ó derecho
     *
     * @param parent Pariente a agregar
     * @param pos Posición base del nodo a agregar, es decir, posición que
     * ocuparía en caso de ser el hijo izquierdo
     */
    public void addChild(Parent parent, int pos) {
        if (this.isLeftChild()) {
            if (this.left == null) {
                this.left = new Node(parent, pos);
            } else if (this.right == null) {
                this.right = new Node(parent, pos + 1);
            }
        } else {
            if (this.right == null) {
                this.right = new Node(parent, pos + 1);
            } else if (this.left == null) {
                this.left = new Node(parent, pos);
            }
        }
    }

    /**
     * @return Verdadero si la posición relativa al nivel es par
     */
    public boolean isLeftChild() {
        return this.pos % 2 == 0;
    }

    /**
     * @param x Coordenada x
     * @return Hijo derecho si la coordenada x es menor que el centro del nodo
     * actual
     */
    public Node nextByPosition(int x) {
        if (x < this.gInfo.centerX) {
            return this.left;
        } else {
            return this.right;
        }
    }

    /**
     * @param node Nodo
     * @return Hijo derecho si el nodo está hacia la derecha del nodo actual
     */
    public Node nextByPosition(Node node) {
        return this.nextByPosition(node.gInfo.centerX);
    }

    /**
     * Dibuja el nodo, sus conexiones y el texto
     *
     * @param g Instancia de Graphics en la que se va a dibujar
     * @param color Color de fondo
     * @param line Color de bordes
     */
    public void draw(Graphics g, Color color, Color line) {
        this.gInfo.draw(g, color, line);
        this.gInfo.drawText(g, this.parent.getShortName(), line);
        this.gInfo.drawConnections(g, this, line);
    }

    /**
     * Dibuja el nodo en dos colores, sus conexiones y el texto
     *
     * @param g Instancia de Graphics en la que se va a dibujar
     * @param base Color 1
     * @param secondary Color 2
     * @param line Color de bordes
     */
    public void draw(Graphics g, Color base, Color secondary, Color line) {
        this.gInfo.draw(g, base, secondary, line);
        this.gInfo.drawText(g, this.parent.getShortName(), line);
        this.gInfo.drawConnections(g, this, line);
    }

    /**
     * Establece el nombre del pariente
     *
     * @param name Nombre nuevo
     */
    public void setName(String name) {
        this.parent.setName(name);
    }

    /**
     * @param node Nodo
     * @return Verdadero si el nodo es hijo derecho ó hijo izquierdo
     */
    public boolean isFather(Node node) {
        return (this.left != null && node == this.left) || (this.right != null && node == this.right);
    }
}
