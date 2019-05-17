package contactsApplication;

import java.io.*;
import java.util.List;
import java.util.Scanner;

public class ContactsApplication {

    private List<Contact> contacts;

    private Contact getInputDetails(Contact oldContact,Integer[] optionArray){

        //get the details for new contact

        //Ask for details
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        //name :
        System.out.println("Enter the details: ");
        System.out.println("name:");
        contact.setName(scanner.nextLine());
        System.out.println("phone");
        contact.setPhoneNumber(scanner.nextLine());
        System.out.println("personal email");
        contact.setPersonalEmail(scanner.nextLine());
        System.out.println("address");
        contact.setAddress(scanner.nextLine());
        System.out.println("workEmail");
        contact.setWorkEmail(scanner.nextLine());

        return contact;

    }


    private boolean addContact(){

        //1. getdetails
        // 2. create a new contact
        Contact contact = getInputDetails(null,null);
        //3. add it to the list
        contacts.add(contact);

        return true;
    }

    private void updateContact(Contact oldContact ){

        //1. recieve old contact
            //show details of old contact
        System.out.println("current contact details :");
        showSingleContact(oldContact);

        //2. getDetails

        
        //3. update the contact


        //3. show that particular contact


        return ;
    }

    private void removeContact(){

        //1. getContactId

        //2. search contact

        //3. show contact

        //4 ask for confirmation

        //5. delete




    }

    private void searchContact(String identifier,int identifierType){





    }

    private void showSingleContact(Contact contact){
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
        System.out.println("|" + contact.getName() + "|"+contact.getPhoneNumber()+"|"+contact.getPersonalEmail()+"|"+contact.getWorkEmail()+"|"+contact.getAddress());
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------");


    }

    private void showAllContacts(List<Contact> contacts){
          // print all contacts

        contacts.forEach(contact -> {showSingleContact(contact);});

    }

    private void exit(){

        //check for closing files and stream readers and writers if any
        // and close


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

    private void deserializePreviousData(String fileName){

        try{

            //check if file exists else return;
            File file = new File(fileName);

            file.createNewFile();


            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this.contacts = (List<Contact>) objectInputStream.readObject();


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

    private void menuDisplay(){

        System.out.println("Hello user Welcome to the Contacts Application");
        System.out.println("----------------------Options-------------------------");
        System.out.println("\t 1.Add Contact");
        System.out.println("\t 2.Update a Contact");
        System.out.println("\t 3.Remove an existing Contact");
        System.out.println("\t 4.Search Contacts");
        System.out.println("\t 5.Show all existing contacts");
        System.out.println("\t 6.Exit");
        System.out.println("please enter your choice :");
    }



    public void runApplication(){

        // variables
        boolean donotExitVariable = true;
        int optionInput=0;




        //create object list from file using thread
        Thread thread = new Thread(()->{
           deserializePreviousData("contacts.txt");
        });
        thread.start();

        //run loop

        while(donotExitVariable){
            Scanner scanner = new Scanner(System.in);
            menuDisplay();
            optionInput = scanner.nextInt();
            //wait till deserialize completes
            try {
                if(thread.isAlive()) {
                    thread.join(1000);
                }
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
                case 5: this.showAllContacts();
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
