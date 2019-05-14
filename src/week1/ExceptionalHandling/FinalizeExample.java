package week1.ExceptionalHandling;

class FinalizeExample{
    public void finalize(){System.out.println("finalize called");}

    public static void main(String[] args){
        FinalizeExample f1=new FinalizeExample();
        FinalizeExample f2=new FinalizeExample();

        //un reference the objects created
        f1=null;
        f2=null;

        //perform garbage collection
        System.gc();
    }

}