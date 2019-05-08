package week1.OOPsFundamentals;

public class Square extends AbstractUse {

    int side;
    Square(){
        side= 0;
    }

    Square(int side){

        this.side=side;
    }
    public int getAreaOfSquare() {
        return side*side ;
    }
}
