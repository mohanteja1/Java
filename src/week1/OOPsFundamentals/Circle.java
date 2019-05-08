package week1.OOPsFundamentals;

public class Circle extends AbstractUse {

    int radius;
     Circle(){
         radius=0;
     }
    Circle(int radius){
         this.radius=radius;

    }

    public int getAreaOfcircle() {
        return (int) Math.round(radius*2*3.13);
    }
}
