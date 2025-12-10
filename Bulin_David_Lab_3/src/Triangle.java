public class Triangle implements Shape {
    private double side1;
    private double side2;
    private double side3;

    //creates a triangle assigning a value to each side to be called in main
    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    //This code will return a double value for s by taking the square root of the total area/2
    public double area() {
        double s = (side1 + side2 + side3) / 2;
        return Math.sqrt(s * (s - side1) * (s - side2) * (s - side3));
    }
    //adds all the sides for the value of the perimeter
    public double perimeter() {
        return side1 + side2 + side3;
    }
    //adds all the interior angles to produce the sum
    public double sumOfInteriorAngles() {
        return 180;
    }
}
