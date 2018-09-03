package data;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class GraphicInfo {

    int x1, y1, x2, y2, width, height, centerX, centerY, level;
    Polygon halfLeft;
    Polygon halfRight;
    Polygon polygon;

    /**
     * Establece las coordenadas y la vista grafica del nodo (el poligono que se
     * dibujará) basandose en dos puntos (x1, y1) y (x2, y2) y el rectangulo
     * formado por los puntos { (x1, y1), (x2, y1), (x2, y2), (x1, y2) }
     *
     * @param x1 Coordenada x del primer punto
     * @param y1 Coordenada y del primer punto
     * @param x2 Coordenada x del segundo punto
     * @param y2 Coordenada y del segundo punto
     * @param level
     */
    public void set(int x1, int y1, int x2, int y2, int level) {
        if (this.polygon == null) {
            this.level = level;
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
            this.width = x2 - x1;
            this.height = y2 - y1;
            int dx = width / 2;
            this.x1 -= dx;
            this.x2 -= dx;
            this.centerX = this.x1 + (width / 2);
            this.centerY = this.y1 + (height / 2);
            int[][] pos = generateCoordinates();
            int[][] halfL = halfCoordinates(true);
            int[][] halfR = halfCoordinates(false);
            this.halfLeft = new Polygon(halfL[0], halfL[1], 7);
            this.halfRight = new Polygon(halfR[0], halfR[1], 7);
            this.polygon = new Polygon(pos[0], pos[1], 10);
        }
    }

    /**
     * @param x Coordenada x
     * @param y Coordenada y
     * @return Verdadeo si el punto (x, y) está dentro del poligono
     */
    public boolean isIn(int x, int y) {
        return this.polygon.contains(x, y);
    }

//    public boolean isIn(GraphicInfo gInfo) {
//        return this.polygon.contains(gInfo.centerX, gInfo.centerY);
//    }
    /**
     * Genera una matriz de puntos (x, y) en los que se dibujará el poligono que
     * representa gráficamente el nodo
     *
     * @return Matriz de puntos (x, y) x = [0], y = [1]
     */
    private int[][] generateCoordinates() {
        return new int[][]{
            {x1 - (level < 4 ? 15 : 2), x1 - 2, x1 + 2, x2 - 2, x2 + 2, x2 + (level < 4 ? 15 : 2), x2 + 2, x2 - 2, x1 + 2, x1 - 2},
            {centerY, y1 + 2, y1, y1, y1 + 2, centerY, y2 - 2, y2, y2, y2 - 2}
        };
    }

    /**
     * Genera una matriz de puntos (x, y) en los que se dibujará medio poligono
     * que se usará en caso de tener que dibujar medio poligono de un color y
     * medio de otro
     *
     * @param left Verdadero si se generará los puntos para el lado izquierdo
     * @return Matriz de puntos (x, y) x = [0], y = [1]
     */
    private int[][] halfCoordinates(boolean left) {
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

    /**
     * Dibuja el poligono
     *
     * @param g Instancia de Graphics en la que se va a dibujar
     * @param color Color base
     * @param line Color de bordes
     */
    public void draw(Graphics g, Color color, Color line) {
        g.setColor(color);
        g.fillPolygon(this.polygon);
        g.setColor(line);
        g.drawPolygon(this.polygon);
    }

    /**
     * Dibuja el poligono
     *
     * @param g Instancia de Graphics en la que se va a dibujar
     * @param color Color de la mitad izquierda
     * @param secondary Color de la mitad derecha
     * @param line Color de bordes
     */
    public void draw(Graphics g, Color color, Color secondary, Color line) {
        g.setColor(color);
        g.fillPolygon(this.halfLeft);
        g.setColor(secondary);
        g.fillPolygon(this.halfRight);
        g.setColor(line);
        g.drawPolygon(this.polygon);
    }

    /**
     * Dibuja las conexiones del poligono
     *
     * @param g Instancia de Graphics en la que se va a dibujar
     * @param node Nodo al que pertenece ésta instancia de GraphicInfo
     * @param color Color de las líneas
     */
    public void drawConnections(Graphics g, Node node, Color color) {
        g.setColor(color);
        if (node.left != null) {
            GraphicInfo info = node.left.gInfo;
            g.drawLine(centerX - 10, y2, info.centerX, info.y1);
        }
        if (node.right != null) {
            GraphicInfo info = node.right.gInfo;
            g.drawLine(centerX + 10, y2, info.centerX, info.y1);
        }
    }

    /**
     * Dibuja el texto del nodo
     *
     * @param g Instancia de Graphics en la que se va a dibujar
     * @param name Nombre del pariente convertido a array
     * @param color Color del texto
     */
    public void drawText(Graphics g, char[] name, Color color) {
        g.setColor(color);
        g.drawChars(name, 0, name.length, x1 + 5, y1 + 20);
    }
}
