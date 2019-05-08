package week1.OOPsFundamentals;

public class Driver {

    public static void main(String args[]){

        Rectangle rectangle= new Rectangle(40,60);
        System.out.println("area of rectangle = " + rectangle.getAreaOfRectangle());

        Square square=new Square(44);
        System.out.println("area of square = " + square.getAreaOfSquare());

        Triangle triangle = new Triangle(2,4,5);
        System.out.println("area of triangle = " +triangle.getAreaOfTraingle());

        Circle circle =new Circle(9);
        System.out.println("area of circle = " + circle.getAreaOfcircle());

    }

}
