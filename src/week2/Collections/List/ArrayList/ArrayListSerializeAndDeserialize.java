package week2.Collections.List.ArrayList;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ArrayListSerializeAndDeserialize {

public static void main(String ars[]){

    //create Array list and add elements
    ArrayList<Coordiantes> arrayList = new ArrayList<Coordiantes>();
    arrayList.add(new Coordiantes(1,2));
    arrayList.add(new Coordiantes(3,8));
    arrayList.add(new Coordiantes(3,9));
    arrayList.add(new Coordiantes(4,9));
    arrayList.add(new Coordiantes(5,8));
    arrayList.add(new Coordiantes(6,7));
    arrayList.add(new Coordiantes(7,6));
    arrayList.add(new Coordiantes(8,5));


    try{
        //Serialize this to a file

        //create file output stream and object output stream
        FileOutputStream fileOutputStream = new FileOutputStream("Coordinates.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(arrayList);
        fileOutputStream.close();
        objectOutputStream.close();


    // Deserialize the file contents

        //create file input stream read file connect this to Object inputstream and read objects from it
        // typecast the objects
        FileInputStream fileInputStream = new FileInputStream("Coordinates.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Coordiantes> backupList =(ArrayList<Coordiantes>)objectInputStream.readObject();

        Coordiantes.print(backupList);

    }
    catch (Exception e){
        e.printStackTrace();
    }

}






}
