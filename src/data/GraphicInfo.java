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

    public void draw(Graphics g, Color color, Color line) {
        g.setColor(color);
        g.fillRect(x1, y1, width, height);
        g.setColor(line);
        g.drawRect(x1, y1, width, height);
    }

    public void draw(Graphics g, Color color, Color secondary, Color line) {
        int medWidth = width / 2;
        int desp = 11;
        g.setColor(color);
        g.fillPolygon(new int[]{x1, x1 + medWidth + desp, x1 + medWidth - desp, x1}, new int[]{y1, y1, y1 + height, y1 + height}, 4);
        g.setColor(secondary);
        g.fillPolygon(new int[]{x1 + medWidth + desp, x2, x2, x1 + medWidth - desp}, new int[]{y1, y1, y1 + height, y1 + height}, 4);
        g.setColor(line);
        g.drawRect(x1, y1, width, height);
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
