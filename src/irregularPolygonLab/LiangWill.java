package irregularPolygonLab;

import java.awt.geom.*;
import java.util.ArrayList;
import gpdraw.*;

public class LiangWill implements Polygon {
    private ArrayList<Point2D.Double> polygon;
    public LiangWill() {
        polygon = new ArrayList<>();
    }
    public LiangWill(ArrayList<Point2D.Double> a) {
        polygon = a;
    }
    public void add(Point2D.Double a) {
        polygon.add(a);
    }
    public void draw() {
        DrawingTool dt = new DrawingTool();
        dt.up();
        dt.move(polygon.get(0).x, polygon.get(0).y);
        dt.down();
        dt.setWidth(5);
        for (int i = 1; i < polygon.size(); i++) {
            dt.move(polygon.get(i).x, polygon.get(i).y);
        }
        dt.move(polygon.get(0).x, polygon.get(0).y);
    }
    public double perimeter() {
        double ret = 0;
        for (int i = 0; i < polygon.size(); i++) {
            ret += Math.sqrt(Math.pow(polygon.get(i).getX() - polygon.get((i + 1) % polygon.size()).getX(), 2) + Math.pow(polygon.get(i).getY() - polygon.get((i + 1) % polygon.size()).getY(), 2));
        }
        return ret;
    }
    public double area() {
        double a = 0, b = 0;
        for (int i = 0; i < polygon.size(); i++) {
            a += polygon.get(i).getX() * polygon.get((i + 1) % polygon.size()).getY();
            b += polygon.get(i).getY() * polygon.get((i + 1) % polygon.size()).getX();
        }
        return Math.abs(.5 * (a - b));
    }
    public String getName() {
        return "Will Liang";
    }
}
