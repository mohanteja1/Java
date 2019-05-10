package week1.OOPsFundamentals.objectsandclasses;

import java.lang.reflect.InvocationTargetException;

public class WaysToCreateObject {

   public static void main(String args[]) throws CloneNotSupportedException{

    // creating object of class Cartoon using new keyword
    Cartoon cartoon = new Cartoon("micky",4,40);

     System.out.println(cartoon.getEpisodeToSeasonRatio());


    // creating object using forName().newInstance

        Cartoon cartoon2;

    {
        try {
            cartoon2 = (Cartoon) Class.forName("week1.OOPsFundamentals.objectsandclasses.Cartoon").getConstructor().newInstance("nemo",4,50);
            cartoon2.getEpisodeToSeasonRatio();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

   // creating object using clone() method
       Cartoon cartoon3 = (Cartoon)cartoon.clone();
       cartoon3.setNofSeasons(6);

       System.out.println(cartoon.toString());
       System.out.println(cartoon3.toString());


    //








}

}
