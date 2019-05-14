package week1.StringsStringBuffersStringBuilders;

public class StringBuildrerMethods {

    public static void main(String arg[]){

        StringBuilder stringBuilder = new StringBuilder("Hai my name is  mohanteja");

        stringBuilder.append(" I am learning java");
        System.out.println(stringBuilder);
        System.out.println(stringBuilder.toString());

        System.out.println(stringBuilder.length());
        System.out.println();

        int length=stringBuilder.length();

        stringBuilder.insert(length," from scratch");

        System.out.println(stringBuilder);

        //rest of the methods are similar to String
        String string ="some-thing";


        stringBuilder.replace(15,15+string.length(),string);
        System.out.println(stringBuilder);

        stringBuilder.reverse();

        System.out.println(stringBuilder);





    }


}
