package week1.OOPsFundamentals;

public class Triangle extends AbstractUse{

    int side1,side2,side3;

    public Triangle() {
        this.side1 = 0;
        this.side2 = 0;
        this.side3 = 0;
    }

    public Triangle(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public int getAreaOfTraingle() {
        int s= (side1+side2+side3)/2;
        return (int) Math.round(Math.sqrt(s*(s-side1)*(s-side3)*(s-side2)));


    }
}
