public class Line {
    private double slope = 0;
    private double b = 0;

    public Line(double slope, double b) {
        this.slope = slope;
        this.b = b;
    }

    public Line(double x1, double y1, double x2, double y2) {
        this.slope = (y2-y1)/(x2-x1);
        this.b = -(this.slope*x1) + y1;
    }

    public double getSlope() {
        return this.slope;
    }

    public double getIntercept() {
        return this.b;
    }

    public double getY(double x) {
        return this.slope*x + this.b;
    }

    public double getX(double y) {
        return (y - b)/this.slope;
    }

    public String toString() {
        return "y = " + this.slope + "x + " + this.b;
    }

    public double[] getIntersection(Line other) {
        double[] output = {-(this.b - other.b)/(this.slope-other.slope), this.getY(-(this.b - other.b)/(this.slope-other.slope))};
        output[0] = round(output[0], 4);
        output[1] = round(output[1], 4);
        return output;
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
    
        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }
}
