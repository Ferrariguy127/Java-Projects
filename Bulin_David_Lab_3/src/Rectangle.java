public class Rectangle implements Shape, Resizable {

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    public double area() {
        return length * width;
    }

    public double perimeter() {
        return 2 * (length + width);
    }

    public double sumOfInteriorAngles() {
        return 360;
    }

    public void resize(float factor) {
        length *= factor;
        width *= factor;
    }

}