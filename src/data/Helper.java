package data;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Helper {

    private final static int WIDTH = 1200;
    private final static int HEIGHT = 389;
    private final static Tree TREE = new Tree();
    private static Node selectedNode;
    private static Node secondaryNode;
    private final static Color NORMAL = new Color(250, 250, 250);
    private final static Color SELECTED = new Color(204, 255, 204);
    private final static Color SECONDARY = new Color(204, 204, 255);
    private final static Color LINE = new Color(66, 66, 66);
    private final static Color BACKGROUND = new Color(255, 244, 193);

    public static Node getSelectedNode() {
        return selectedNode;
    }

    public static Node getSecondaryNode() {
        return secondaryNode;
    }

    public static boolean addChild(Parent child, boolean newTree) {
        if (newTree) {
            TREE.clean();
        }
        boolean okay = TREE.addChild(selectedNode, child);
        if (newTree) {
            selectedNode = null;
            secondaryNode = null;
        }
        return okay;
    }

    public static void onClick(int x, int y, boolean isPrincipal) {
        if (isPrincipal) {
            selectedNode = TREE.nodeOn(x, y);
            secondaryNode = selectedNode == null ? null : secondaryNode;
        } else {
            secondaryNode = TREE.nodeOn(x, y);
        }
    }

    public static void setDrawingProps() {
        ArrayList<Node> level;
        int i = 0;
        int n = 1;
        int sizeX = 70;
        int sizeY = 25;
        int dy = 45;
        int y1 = dy;
        do {
            level = TREE.getLevel(i);
            int dx = WIDTH / n;
            int x1 = dx / 2;
            for (int j = 1; j <= level.size(); j++) {
                Node node = level.get(j - 1);
                if (node != null) {
                    x1 += node.pos * dx;
                    node.gInfo.set(x1, y1, x1 + sizeX, y1 + sizeY);
                }
                x1 = dx / 2;
            }
            i++;
            n *= 2;
            dy = 50;
            y1 += dy;
        } while (!level.isEmpty());
    }

    public static void drawTree(Graphics g, boolean all) {
        ArrayList<Node> level;
        base(g, all);
        int i = 0;
        do {
            level = TREE.getLevel(i);
            for (Node node : level) {
                if (node == selectedNode && node == secondaryNode) {
                    node.draw(g, SELECTED, SECONDARY, LINE);
                } else if (node == selectedNode) {
                    node.draw(g, SELECTED, LINE);
                } else if (node == secondaryNode) {
                    node.draw(g, SECONDARY, LINE);
                } else {
                    node.draw(g, NORMAL, LINE);
                }
            }
            i++;
        } while (!level.isEmpty());
        g.dispose();
    }

    public static void removeSelected() {
        TREE.remove(selectedNode);
        selectedNode = null;
    }

    public static boolean selectedIsRoot() {
        return TREE.isRoot(selectedNode);
    }

    public static String calcRelationship() {
        return TREE.calcRelationship(selectedNode, secondaryNode);
    }

    private static void drawIndicator(Graphics g) {
        int x1 = 10, x2 = 100, y1 = 10, y2 = 30, width = x2 - x1, height = y2 - y1, medWidth = width / 2, d = 9;
        g.setColor(selectedNode == null ? Color.WHITE : SELECTED);
        g.fillPolygon(new int[]{x1, x1 + medWidth + d, x1 + medWidth - d, x1}, new int[]{y1, y1, y2, y2}, 4);
        g.setColor(secondaryNode == null ? Color.WHITE : SECONDARY);
        g.fillPolygon(new int[]{x1 + medWidth + d, x2, x2, x1 + medWidth - d}, new int[]{y1, y1, y2, y2}, 4);
        g.setColor(LINE);
        g.drawLine(x1 + 5, y1 + 5, x1 + 16, y2 - 5);
        g.drawLine(x1 + 5, y2 - 5, x1 + 16, y1 + 5);
        g.drawLine(x2 - 5, y1 + 5, x2 - 16, y2 - 5);
        g.drawLine(x2 - 11, y2 - 11, x2 - 16, y1 + 5);
        g.drawRect(x1, y1, width, height);
    }

    private static void base(Graphics g, boolean all) {
        g.setColor(BACKGROUND);
        if (all) {
            g.fillRect(0, 0, WIDTH + 1, HEIGHT + 1);
        } else {
            g.fillRect(0, 0, 200, 80);
        }
        drawIndicator(g);
    }

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
            "Maria Patricia",
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
}
