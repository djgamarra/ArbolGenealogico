package data;

import java.awt.Color;
import java.awt.Graphics;

public class GraphicInfo {

    int x1, y1, x2, y2, width, height, centerX, centerY;

    public void set(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        width = x2 - x1;
        height = y2 - y1;
        int dx = width / 2;
        this.x1 -= dx;
        this.x2 -= dx;
        centerX = this.x1 + (width / 2);
        centerY = this.y1 + (height / 2);
    }

    public boolean isIn(int x, int y) {
        return (x >= x1 && x <= x2) && (y >= y1 && y <= y2);
    }

    private int[][] generateCoordinates(int level) {
        return new int[][]{
            {x1 - (level < 4 ? 15 : 2), x1 - 2, x1 + 2, x2 - 2, x2 + 2, x2 + (level < 4 ? 15 : 2), x2 + 2, x2 - 2, x1 + 2, x1 - 2},
            {centerY, y1 + 2, y1, y1, y1 + 2, centerY, y2 - 2, y2, y2, y2 - 2}
        };
    }

    private int[][] halfCoordinates(int level, boolean left) {
        int medWidth = width / 2;
        int desp = 11;
        if (left) {
            return new int[][]{
                {x1 - (level < 4 ? 15 : 2), x1 - 2, x1 + 2, x1 + medWidth + desp, x1 + medWidth - desp, x1 + 2, x1 - 2},
                {centerY, y1 + 2, y1, y1, y2, y2, y2 - 2}
            };
        } else {
            return new int[][]{
                {x1 + medWidth + desp, x2 - 2, x2 + 2, x2 + (level < 4 ? 15 : 2), x2 + 2, x2 - 2, x1 + medWidth - desp},
                {y1, y1, y1 + 2, centerY, y2 - 2, y2, y2}
            };
        }
    }

    public void draw(Graphics g, Color color, Color line, int level) {
        int[][] coord = generateCoordinates(level);
        g.setColor(color);
        g.fillPolygon(coord[0], coord[1], 10);
        g.setColor(line);
        g.drawPolygon(coord[0], coord[1], 10);
    }

    public void draw(Graphics g, Color color, Color secondary, Color line, int level) {
        int medWidth = width / 2;
        int desp = 11;
        int[][] coord = generateCoordinates(level);
        int[][] halfLeft = halfCoordinates(level, true);
        int[][] halfRight = halfCoordinates(level, false);
        g.setColor(color);
        g.fillPolygon(halfLeft[0], halfLeft[1], 7);
        g.setColor(secondary);
        g.fillPolygon(halfRight[0], halfRight[1], 7);
        g.setColor(line);
        g.drawPolygon(coord[0], coord[1], 10);
    }

    public void drawConnections(Graphics g, Node node, Color color) {
        g.setColor(color);
        if (node.left != null) {
            GraphicInfo info = node.left.gInfo;
            g.drawLine(centerX, y2, info.centerX, info.y1);
        }
        if (node.right != null) {
            GraphicInfo info = node.right.gInfo;
            g.drawLine(centerX, y2, info.centerX, info.y1);
        }
    }

    public void drawText(Graphics g, char[] name, Color color) {
        g.setColor(color);
        g.drawChars(name, 0, name.length, x1 + 5, y1 + 20);
    }
}
