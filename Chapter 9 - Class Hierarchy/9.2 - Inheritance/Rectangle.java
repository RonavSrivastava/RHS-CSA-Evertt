public class Rectangle extends Shape {
    private double l;
    private double w;

    public Rectangle(String color, double length, double width) {
        super("Rectangle", color);
        l = length;
        w = width;
    }

    public Rectangle(String name, String color, double length, double width) {
        super(name, color);
        l = length;
        w = width;
    }

    public double calcArea() {
        return l * w;
    }

    public double calcPerimeter() {
        return 2 * (l + w);
    }
}
