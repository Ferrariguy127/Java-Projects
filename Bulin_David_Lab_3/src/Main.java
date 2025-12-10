import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Shape> shapes = new ArrayList<Shape>();

        //Create an object of each type
        Shape square = new Square(3);
        Shape rectangle = new Rectangle(2, 5);
        Shape circle = new Circle(5);
        //ensure values for triangle have side1 and side2 equaling < side3 otherwise
        Shape triangle = new Triangle(3, 4, 5);

        //Add each object to the ArrayList
        shapes.add(square);
        shapes.add(rectangle);
        shapes.add(circle);
        shapes.add(triangle);

        System.out.println("Area of a square is " + square.area());
        System.out.println("Rectangle before resizing is " + rectangle.area());
        System.out.println();
        //Iterate through the ArrayList and print the area of each object
        for(Shape shape : shapes){
            //Resize if the object implements the resizable interface
            if(shape instanceof Resizable){
                ((Resizable) shape).resize(3);
            }

            //System.out.println(shape.area());
            //System.out.println("The area of a square the square is "+square.area());
        }
        System.out.println("Area of a square is " + square.area());
        System.out.println("Area of the rectangle after resizing is " + rectangle.area());
        System.out.println("Area of a Circle is " + circle.area());
        System.out.println("Area of a triangle is " + triangle.area());


    }
}
