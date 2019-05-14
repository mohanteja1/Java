package week1.StringsStringBuffersStringBuilders;

public class StringBufferMethods {

    public static void main(String args[]){

        StringBuffer stringBuffer = new StringBuffer("this is leading to nowhere");
        int length = stringBuffer.length();
        stringBuffer.append(". practice opens all doors");
        System.out.println(stringBuffer);


        System.out.println("all the methods of the StringBuffer are similar to the string builder");

        stringBuffer.delete(length,stringBuffer.length());

        System.out.println(stringBuffer);
        stringBuffer.delete(0,stringBuffer.length());
        System.out.println(stringBuffer);


    }


}
