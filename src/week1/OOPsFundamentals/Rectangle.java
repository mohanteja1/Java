package week1.OOPsFundamentals;

class Rectangle extends AbstractUse {
    int length,width;

    Rectangle(){
        this.length=0;
        this.width=0;
    }

    Rectangle(int length,int width){
        this.length=length;
        this.width=width;
    }

    public int getAreaOfRectangle() {
        return length*width;
    }
}
