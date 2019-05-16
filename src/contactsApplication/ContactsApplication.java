package contactsApplication;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ContactsApplication {


    private boolean addContact(Contact contact){



        return true;
    }

    private void updateContact( ){


        return ;
    }

    private void removeContact(){

    }

    private void searchContact(){

    }
    private void showContacts(){

    }
    private void exit(){

    }

    private void serializeCurrentData(List<Contact> contacts ,String fileName){

        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(contacts);

        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();

        }

    }

    private void deserializePreviousData( String fileName){

        try{
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            List<Contact> contacts = (List<Contact>) objectInputStream.readObject();

        }
        catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }



    }

    public void runApplication(){

        // variables
        boolean donotExitVariable = true;
        int optionInput=0;



        //create object list from file using thread
        Thread thread = new Thread(()->{
           this.deserializePreviousData("contacts.txt");
        });
        thread.start();

        //run loop

        while(donotExitVariable){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Hello user Welcome to the Contacts Application");
            System.out.println("----------------------Options-------------------------");
            System.out.println("\t 1.Add Contact");
            System.out.println("\t 2.Update a Contact");
            System.out.println("\t 3.Remove an existing Contact");
            System.out.println("\t 4.Search Contacts");
            System.out.println("\t 5.Show all existing contacts");
            System.out.println("\t 6.Exit");
            System.out.println("please enter your choice :");
            optionInput=scanner.nextInt();


            //wait till deserialize completes
            try {
                thread.join(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            //options selected

            switch(optionInput)
            {
                case 1: this.addContact();
                break;
                case 2: this.updateContact();
                break;
                case 3: this.removeContact();
                break;
                case 4: this.searchContact();
                break;
                case 5: this.showContacts();
                break;
                case 6: this.exit();
                break;
                default:
                    System.out.println("please enter valid input [1-6]");
                    break;

            }
            if(optionInput==0) continue;


        }




    }



}
