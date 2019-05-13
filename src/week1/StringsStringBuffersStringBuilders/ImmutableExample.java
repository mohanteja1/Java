package week1.StringsStringBuffersStringBuilders;

final class Color{

    final String name;
    final String hexValue;

    public Color(String name, String hexValue) {
        this.name = name;
        this.hexValue = hexValue;
    }

    public String getName() {
        return name;
    }

    public String getHexValue() {
        return hexValue;
    }

    //since there is no setter method there is no option to change the value of final variables;


}

public class ImmutableExample {

public static void main(String arg[]){

    Color color = new Color("red","ffff00000000");
     //color.hexValue="8988009"; //gives compile error

}



}
