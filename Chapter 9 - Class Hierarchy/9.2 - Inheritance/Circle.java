public class Circle extends Shape {
    private double r;

    public Circle(String color, double radius) {
        super("Circle", color);
        r = radius;
    }

    public double calcArea() {
        return r * r * Math.PI;
    }

    public double calcPerimeter() {
        return 2 * r * Math.PI;
    }
}
