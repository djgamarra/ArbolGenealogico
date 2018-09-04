package data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.util.ArrayList;

public class Helper {

    public final static int CLEAN_ALL = 0;
    public final static int CLEAN_EXTRA = 1;
    public final static int NO_CLEAN = -1;
    public final static int SELECTED_NODE = 0;
    public final static int SECONDARY_NODE = 1;
    private final static int WIDTH = 1200;
    private final static int HEIGHT = 389;
    private final static Tree TREE = new Tree();
    private static Node selectedNode;
    private static Node secondaryNode;
    private final static Color NORMAL = new Color(250, 250, 250);
    private final static Color SELECTED = new Color(204, 255, 204);
    private final static Color SECONDARY = new Color(204, 204, 255);
    private final static Color LINE = new Color(66, 66, 130);
    private final static Color BACKGROUND = new Color(255, 244, 193);
    private static Polygon indicator;
    private static Polygon halfL;
    private static Polygon halfR;

    /**
     *
     * @return Nodo seleccionado (X)
     */
    public static Node getSelectedNode() {
        return selectedNode;
    }

    /**
     *
     * @return Nodo secundario (Y)
     */
    public static Node getSecondaryNode() {
        return secondaryNode;
    }

    /**
     * Agrega un nodo hijo al nodo seleccionado (X)
     *
     * @param child Pariente a gregar
     * @param newTree Indica si es un arbol nuevo o si se agregará al actual
     */
    public static void addChild(Parent child, boolean newTree) {
        if (newTree) {
            TREE.clean();
        }
        TREE.addChild(selectedNode, child);
        if (newTree) {
            selectedNode = null;
            secondaryNode = null;
        }
    }

    /**
     * Asigna el nodo en la posición (x, y) a la variable que corresponda según
     * el botón del mouse que se presione (IZQUIERDO para nodo seleccionado (X)
     * ó DERECHO para nodo secundario (Y))
     *
     * @param x Posición en el eje x donde se pulsó el click
     * @param y Posición en el eje y donde se pulsó el click
     * @param node Nodo que se prentende seleccionar (botón presionado del
     * mouse)
     */
    public static void onClick(int x, int y, int node) {
        switch (node) {
            case SELECTED_NODE:
                selectedNode = TREE.nodeOn(x, y);
                secondaryNode = selectedNode == null ? null : secondaryNode;
                break;
            case SECONDARY_NODE:
                secondaryNode = TREE.nodeOn(x, y);
                break;
        }
    }

    /**
     * Establece las posiciones (x, y) en que se va a dibujar cada nodo
     */
    public static void setDrawingProps() {
        ArrayList<Node> level;
        int i = 0;
        int n = 1;
        int sizeX = 65;
        int sizeY = 25;
        int dy = 45;
        int y1 = dy;
        do {
            level = TREE.getLevel(i);
            int dx = WIDTH / n;
            int x1 = dx / 2;
            for (int j = 0; j < level.size(); j++) {
                Node node = level.get(j);
                if (node != null) {
                    x1 += node.pos * dx;
                    node.gInfo.set(x1, y1, x1 + sizeX, y1 + sizeY, i);
                }
                x1 = dx / 2;
            }
            i++;
            n *= 2;
            dy = 50;
            y1 += dy;
        } while (!level.isEmpty());
    }

    /**
     * Llama a dibujar el fondo y el árbol genealógico
     *
     * @param g Instancia de Graphics en la que se dibujará el árbol
     * @param type Tipo de dibujado que se hará, sólo cambia el qué de lo que ya
     * estaba se va a borrar
     */
    public static void drawTree(Graphics g, int type) {
        base(g, type);
        TREE.draw(g, SELECTED, SECONDARY, NORMAL, LINE, selectedNode, secondaryNode);
        g.dispose();
    }

    /**
     * Elimina el nodo seleccionado (X) y sus hijos
     */
    public static void removeSelected() {
        TREE.remove(selectedNode);
        selectedNode = null;
        secondaryNode = null;
    }

    /**
     * @return Verdadero si el nodo seleccionado (X) es la raíz de todo el árbol
     */
    public static boolean selectedIsRoot() {
        return TREE.isRoot(selectedNode);
    }

    /**
     *
     * @return Relación entre el nodo seleccionado (X) y el nodo secundario (Y)
     */
    public static String calcRelationship() {
        return TREE.calcRelationship(selectedNode, secondaryNode);
    }

    /**
     * Inicializa el indicador de relación y selección que se dibuja en la parte
     * superior del panel del árbol
     */
    public static void initIndicator() {
        int x1 = 10, x2 = 100, y1 = 10, y2 = 30, width = x2 - x1, medWidth = width / 2, d = 6;
        int[][] coord = new int[][]{
            {x1, x1 + 20, x1 + 20, x2 - 20, x2 - 20, x2, x2, x2 - 20, x2 - 20, x1 + 20, x1 + 20, x1},
            {y1, y1, y1 + 4, y1 + 4, y1, y1, y2, y2, y2 - 4, y2 - 4, y2, y2}
        };
        int[][] halfLeft = new int[][]{
            {x1, x1 + 20, x1 + 20, x1 + medWidth + d, x1 + medWidth - d, x1 + 20, x1 + 20, x1},
            {y1, y1, y1 + 4, y1 + 4, y2 - 4, y2 - 4, y2, y2}
        };
        int[][] halfRight = new int[][]{
            {x1 + medWidth + d, x2 - 20, x2 - 20, x2, x2, x2 - 20, x2 - 20, x1 + medWidth - d},
            {y1 + 4, y1 + 4, y1, y1, y2, y2, y2 - 4, y2 - 4}
        };
        indicator = new Polygon(coord[0], coord[1], 12);
        halfL = new Polygon(halfLeft[0], halfLeft[1], 8);
        halfR = new Polygon(halfRight[0], halfRight[1], 8);
    }

    /**
     * Dibuja el indicador de relación y selección
     *
     * @param g Instancia de Graphics en la que se dibujará
     */
    private static void drawIndicator(Graphics g) {
        int x1 = 10, x2 = 100, y1 = 10, y2 = 30, width = x2 - x1, medWidth = width / 2, d = 6;
        g.setColor(selectedNode == null ? NORMAL : SELECTED);
        g.fillPolygon(halfL);
        g.setColor(secondaryNode == null ? NORMAL : SECONDARY);
        g.fillPolygon(halfR);
        g.setColor(LINE);
        g.drawLine(x1 + 5, y1 + 5, x1 + 16, y2 - 5);
        g.drawLine(x1 + 5, y2 - 5, x1 + 16, y1 + 5);
        g.drawLine(x2 - 5, y1 + 5, x2 - 16, y2 - 5);
        g.drawLine(x2 - 11, y2 - 11, x2 - 16, y1 + 5);
        boolean hasRelation = selectedNode != null && secondaryNode != null && !calcRelationship().equals("...");
        if (selectedNode == null || secondaryNode == null || selectedNode == secondaryNode) {
            int[][] pos = new int[][]{
                {x1 + medWidth + d - 3, x1 + medWidth + d + 3, x1 + medWidth - d + 3, x1 + medWidth - d - 3},
                {y1 + 4, y1 + 4, y2 - 4, y2 - 4}
            };
            g.fillPolygon(pos[0], pos[1], 4);
        } else if (hasRelation) {
            g.setColor(LINE);
            g.drawString("Relación directa", 105, 26);
            for (int i = 1; i < width - 40 - d * 2; i++) {
                if (i % 2 == 0) {
                    g.setColor(SECONDARY);
                } else {
                    g.setColor(SELECTED);
                }
                g.drawLine(x1 + 20 + d * 2 + i, y1 + 4, x1 + 20 + i, y2 - 4);
            }
        } else if (!hasRelation) {
            g.setColor(LINE);
            g.drawString("Relación indirecta", 105, 26);
        }
        g.setColor(LINE);
        g.drawPolygon(indicator);
    }

    /**
     * Colorea la base donde se dibujará, borrando así sólo lo necesario de lo
     * que ya estaba dibujado dependiendo de que tipo de dibujado se hará,
     * además llama a drawIndicator y a drawFlag para que hagan el dibujado de
     * el indicador y de la bandera de generaciones
     *
     * @param g Instancia de Graphics en la que se dibujará
     * @param type Tipo de limpiado (TODO, NADA ó BAJO EL CUARTO NIVEL, en estos
     * dos últimos además se borra el área de la bandera de generaciones)
     */
    private static void base(Graphics g, int type) {
        g.setColor(BACKGROUND);
        g.fillRect(100, 0, WIDTH - 100, 40);
        switch (type) {
            case NO_CLEAN:
                g.fillRect(0, 0, 14, HEIGHT);
                break;
            case CLEAN_ALL:
                g.fillRect(0, 0, WIDTH, HEIGHT);
                break;
            case CLEAN_EXTRA:
                g.fillRect(0, 271, WIDTH, HEIGHT - 270);
                g.fillRect(0, 0, 14, HEIGHT);
                break;
        }
        drawIndicator(g);
        drawFlag(g);
    }

    /**
     * Genera un árbol genealógico aleatorio usando una lista predefinida de
     * nombres
     */
    public static void testTree() {
        String[] names = new String[]{
            "Juan Barros",
            "Jose Padilla",
            "Karla Salgado",
            "Marlon Piedrahita",
            "Andres Fontalvo",
            "Maria Gamarra",
            "Shelseen Susana",
            "Jesus Lozano",
            "Carolina Herrera",
            "Carlos Cuao",
            "Pancracia de los Andes",
            "Jonier Roca",
            "Pedro de la Hoz",
            "Fernando Meriño",
            "Carlos Arias",
            "Milena Arias",
            "Pedro Perez",
            "Estefani Tellez",
            "Maria Patricia"
        };
        int i = (int) (Math.random() * names.length);
        addChild(new Parent(names[i]), true);
        i++;
        i = i % names.length;
        int level = 0;
        ArrayList<Node> levelNodes = TREE.getLevel(level);
        do {
            for (Node node : levelNodes) {
                selectedNode = node;
                addChild(new Parent(names[i]), false);
                i++;
                i = i % names.length;
                addChild(new Parent(names[i]), false);
                i++;
                i = i % names.length;
            }
            level++;
            levelNodes = TREE.getLevel(level);
        } while (level < 4);
    }

    /**
     * Dibuja la bandera de las generaciones
     *
     * @param g Instancia de Graphics en la que se dibujará
     */
    private static void drawFlag(Graphics g) {
        if (selectedNode != null && secondaryNode != null) {
            Node up;
            Node down;
            if (selectedNode.gInfo.y1 < secondaryNode.gInfo.y1) {
                up = selectedNode;
                down = secondaryNode;
            } else {
                up = secondaryNode;
                down = selectedNode;
            }
            GraphicInfo g1 = up.gInfo;
            GraphicInfo g2 = down.gInfo;
            int y1 = g1.y1 + 1;
            int y2 = g2.y2 - 1;
            g.setColor(LINE);
            if (up != down) {
                g.fillRect(0, y1, 2, y2 - y1);
            }
            g.fillRect(0, y1, 14, 20);
            String diff = Integer.toString(TREE.difOfLevels(selectedNode, secondaryNode));
            g.setColor(NORMAL);
            g.drawString(diff, 3, y1 + 15);
        }
    }
}
