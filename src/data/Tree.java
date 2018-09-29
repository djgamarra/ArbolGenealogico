package data;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Tree {

    Node root;

    /**
     * Inicia el dibujado del árbol genealógico desde la raíz
     *
     * @param g Instancia de Graphics en la que se va a dibujar el árbol
     * @param colorPrimary Color primario
     * @param colorSecondary Color secundario
     * @param colorNormal Color normal
     * @param colorLine Color de líneas y bordes
     * @param selectedNode Nodo seleccionado (X)
     * @param secondaryNode Nodo secundario (Y)
     */
    public void draw(Graphics g, Color colorPrimary, Color colorSecondary, Color colorNormal, Color colorLine, Node selectedNode, Node secondaryNode) {
        this.draw(g, colorPrimary, colorSecondary, colorNormal, colorLine, this.root, selectedNode, secondaryNode);
    }

    /**
     * Método recursivo que dibuja todo el árbol genealógico
     *
     * @param g Instancia de Graphics en la que se va a dibujar el árbol
     * @param colorPrimary Color primario
     * @param colorSecondary Color secundario
     * @param colorNormal Color normal
     * @param colorLine Color de líneas y bordes
     * @param root Raíz actual
     * @param selectedNode Nodo seleccionado (X)
     * @param secondaryNode Nodo secundario (Y)
     */
    public void draw(Graphics g, Color colorPrimary, Color colorSecondary, Color colorNormal, Color colorLine, Node root, Node selectedNode, Node secondaryNode) {
        if (root != null) {
            if (root == selectedNode && root == secondaryNode) {
                root.draw(g, colorPrimary, colorSecondary, colorLine);
            } else if (root == selectedNode) {
                root.draw(g, colorPrimary, colorLine);
            } else if (root == secondaryNode) {
                root.draw(g, colorSecondary, colorLine);
            } else {
                root.draw(g, colorNormal, colorLine);
            }
            draw(g, colorPrimary, colorSecondary, colorNormal, colorLine, root.left, selectedNode, secondaryNode);
            draw(g, colorPrimary, colorSecondary, colorNormal, colorLine, root.right, selectedNode, secondaryNode);
        }
    }

    /**
     * Inicia la búsqueda de un nodo en una posición (x, y)
     *
     * @param x Posición en el eje x donde se pulsó el click
     * @param y Posición en el eje y donde se pulsó el click
     * @return Nodo en la posición (x, y) ó null si no hay uno en esa posición
     */
    public Node nodeOn(int x, int y) {
        return this.nodeOn(x, y, this.root);
    }

    /**
     * Función recursiva para buscar en el árbol genealógico un nodo específico
     * en una posición (x, y) basándose en las coordenadas donde se debe
     * encontrar
     *
     * @param x Posición en el eje x donde se pulsó el click
     * @param y Posición en el eje y donde se pulsó el click
     * @param root Raíz actual
     * @return Nodo en la posición (x, y) ó null si no hay uno en esa posición
     */
    private Node nodeOn(int x, int y, Node root) {
        if (root == null) {
            return null;
        }
        if (root.gInfo.isIn(x, y)) {
            return root;
        } else {
            return this.nodeOn(x, y, root.nextByPosition(x));
        }
    }

//    public boolean isSubtree(Node root, Node leaf) {
//        if (root != null) {
//            if (root.gInfo.isIn(leaf.gInfo)) {
//                return true;
//            } else {
//                return this.isSubtree(root.nextByPosition(leaf), leaf);
//            }
//        }
//        return false;
//    }
    /**
     * Agrega un nodo a un nodo padre ó inicializa la raíz del árbol si esta es
     * nula
     *
     * @param father Padre al que se le añadirá un nodo hijo
     * @param child Nodo hijo que se va a añadir
     */
    public void addChild(Node father, Parent child) {
        if (this.root == null) {
            this.root = new Node(child, 0);
        } else {
            father.addChild(child, 2 * father.pos);
        }
    }

    /**
     * Inicia la búsqueda de todos los nodos en un mismo nivel
     *
     * @param level Nivel a buscar
     * @return ArrayList con todos los nodos en un mismo nivel
     */
    public ArrayList<Node> getLevel(int level) {
        if (this.root == null) {
            return new ArrayList<>();
        }
        return this.getLevel(level, 0, this.root, new ArrayList<>());
    }

    /**
     * Inicia el calculo de la profundidad
     *
     * @return Profundidad del árbol
     */
    public int getDepth() {
        return this.getDepth(this.root, 1);
    }

    /**
     * Función recursiva para calcular la profundidad del árbol
     *
     * @param root Raíz actual
     * @param actualDepth Profundidad actual
     * @return Profundidad del árbol
     */
    private int getDepth(Node root, final int actualDepth) {
        if (root != null) {
            return Math.max(getDepth(root.left, actualDepth + 1), getDepth(root.right, actualDepth + 1));
        }
        return actualDepth - 1;
    }

    /**
     * Función recursiva que busca todos los nodos en un mismo nivel
     *
     * @param level Nivel a buscar
     * @param actual Nivel actual (nivel del llamado recursivo actual)
     * @param root Raíz actual
     * @param levelNodes Lista de nodos encontrados
     * @return Lista de nodos en el nivel
     */
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

    /**
     * Inicia la eliminación de un nodo
     *
     * @param node Nodo a eliminar
     */
    public void remove(Node node) {
        this.remove(this.root, node);
    }

    /**
     * Método recursivo para la búsqueda y eliminación de un nodo y todos sus
     * hijos
     *
     * @param root Raíz actual
     * @param node Nodo a eliminar
     */
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

    /**
     * @param node Nodo a analizar
     * @return Verdadero si el nodo es la raíz de todo
     */
    public boolean isRoot(Node node) {
        return node == this.root;
    }

    /**
     * Limpia el árbol, elimina la raíz y todos los hijos
     */
    public void clean() {
        this.root = null;
    }

    /**
     * @param node1 Supuesto nodo padre
     * @param node2 Supuesto nodo hijo
     * @return Verdadero si el nodo 1 es padre del nodo 2
     */
    public boolean isFather(Node node1, Node node2) {
        return node1.isFather(node2);
    }

    /**
     * @param node1 Supuesto nodo tío
     * @param node2 Supuesto nodo sobrino
     * @return Verdadero si el nodo 1 es hermano del padre del nodo 2, es decir,
     * si es tío del nodo 2
     */
    public boolean isUncle(Node node1, Node node2) {
        Node dad = this.fatherOf(node2);
        return this.areBrothers(node1, dad);
    }

    /**
     * @param node1 Supuesto primo1
     * @param node2 Supuesto primo2
     * @return Verdadero si los padres del nodo 1 y 2 son hermanos, es dcir, si
     * son primos
     */
    public boolean isCousin(Node node1, Node node2) {
        return this.areBrothers(this.fatherOf(node1), this.fatherOf(node2));
    }

    /**
     * @param node1 Supuesto nodo abuelo
     * @param node2 Supuesto nodo nieto
     * @return Verdadero si el nodo 1 es padre del padre del nodo 2, es decir,
     * si es el abuelo del nodo 2
     */
    public boolean isGrandFather(Node node1, Node node2) {
        Node dad = this.fatherOf(node2);
        return this.isFather(node1, dad);
    }

    /**
     * @param node1 Supuesto nodo hermano 1
     * @param node2 Supuesto nodo hermano 2
     * @return Verdadero si el nodo 1 es hermano del nodo 2
     */
    public boolean areBrothers(Node node1, Node node2) {
        return this.areBrothers(this.root, node1, node2);
    }

    /**
     * Función recursiva que determina si dos nodos son hijos del mismo padre
     *
     * @param root Raíz actual
     * @param node1 Supuesto nodo hermano 1
     * @param node2 Supuesto nodo hermano 2
     * @return Verdadero si los nodos 1 y 2 son hijos del mismo padre
     */
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

    /**
     * Inicia la búsqueda del padre de un nodo
     *
     * @param node Nodo hijo
     * @return Nodo padre del nodo hijo
     */
    public Node fatherOf(Node node) {
        return fatherOf(this.root, node);
    }

    /**
     * Función recursiva que retorna el padre de un nodo cualquiera
     *
     * @param root Raíz actual
     * @param node Nodo hijo
     * @return Nodo padre del nodo hijo
     */
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

    /**
     * @param node1 Nodo 1
     * @param node2 Nodo 2
     * @return Verdadero si la diferencia entre los niveles del nodo 1 y 2 es 3
     * ó mayor
     */
    public boolean outOfLevel(Node node1, Node node2) {
        return difOfLevels(node1, node2) >= 3;
    }

    /**
     * @param node1 Nodo 1
     * @param node2 Nodo 2
     * @return Diferencia entre los niveles del nodo 1 y 2
     */
    public int difOfLevels(Node node1, Node node2) {
        return Math.abs(levelOf(this.root, node1, 0) - levelOf(this.root, node2, 0));
    }

    /**
     * Función recursiva para determinar el nivel de un nodo
     *
     * @param root Raíz actual
     * @param node Nodo
     * @param level Nivel actual
     * @return Nivel del nodo ó -1 si no se le encuentra
     */
    private int levelOf(Node root, Node node, final int level) {
        if (root != null) {
            if (root == node) {
                return level;
            } else {
                return levelOf(root.nextByPosition(node), node, level + 1);
            }
        }
        return -1;
    }

    /**
     * Retorna un String listo para mostrar en un JLabel de el parentesco entre
     * los nodos 1 y 2
     *
     * @param node1 Nodo 1
     * @param node2 Nodo 2
     * @return Parentesco entre los nodos 1 y 2
     */
    public String calcRelationship(Node node1, Node node2) {
        if (node1 == node2) {
            return "Seleccione dos parientes diferentes";
        }
        if (this.outOfLevel(node1, node2)) {
            return "...";
        }
        if (this.isFather(node1, node2)) {
            return "Parentesco: Madre/Padre";
        }
        if (this.isFather(node2, node1)) {
            return "Parentesco: Hij@";
        }
        if (this.areBrothers(node1, node2)) {
            return "Parentesco: Herman@s";
        }
        if (this.isCousin(node1, node2)) {
            return "Parentesco: Prim@s";
        }
        if (this.isUncle(node2, node1)) {
            return "Parentesco: Sobrin@";
        }
        if (this.isUncle(node1, node2)) {
            return "Parentesco: Ti@";
        }
        if (this.isGrandFather(node1, node2)) {
            return "Parentesco: Abuel@";
        }
        if (this.isGrandFather(node2, node1)) {
            return "Parentesco: Niet@";
        }
        return "...";
    }

    /**
     * @return Verdadero si la raíz aún es nula
     */
    public boolean isVoid() {
        return this.root == null;
    }

}
