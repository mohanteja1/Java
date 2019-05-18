package contactsApplication2;

import org.omg.CORBA.Object;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Contact implements Comparable<Contact>, Serializable {
    private String name;
    private String mobile;
    private String email;

    public Contact(String name, String mobile, String email) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public int compareTo(Contact o) {
        return this.getName().compareTo(o.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobile, email);
    }
}


class ContactsApplication {

    boolean debugSwitch = true;

    String namesHashStoreFileName = "names.txt";
    String emailHashStoreFileName = "emails.txt";
    String phoneNumberHashStoreFileName = "phoneNumbers.txt";
    String totalContactsHashStoreFileName = "contactsHash.txt";
    //hashmaps

    HashMap<Integer, Contact> contacts;//=new HashMap<Integer, Contact>();
    HashMap<Integer, String> names;
    HashMap<Integer, String> emails;
    HashMap<Integer, String> phoneNumbers;

    class DeserializationRunnable implements Runnable {
        int task;

        @Override
        public void run() {
            deserializePreviousData(task);
        }

        public DeserializationRunnable(int task) {
            this.task = task;
        }

        private void deserializePreviousData(int task) {

            try {
                //create files if not found
                //create file,object streams
                if (task == 1 || task == 5) {
                    File contactsFile = new File(totalContactsHashStoreFileName);
                    contactsFile.createNewFile();
                    ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream(contactsFile));
                    contacts = (HashMap<Integer, Contact>) objectInputStream1.readObject();
                    objectInputStream1.close();

                }

                if (task == 2 || task == 5) {
                    File nameFile = new File(namesHashStoreFileName);
                    nameFile.createNewFile();
                    ObjectInputStream objectInputStream2 = new ObjectInputStream(new FileInputStream(nameFile));
                    names = (HashMap<Integer, String>) objectInputStream2.readObject();
                    objectInputStream2.close();
                }

                if (task == 3 || task == 5) {
                    File emailFile = new File(emailHashStoreFileName);
                    emailFile.createNewFile();
                    ObjectInputStream objectInputStream3 = new ObjectInputStream(new FileInputStream(emailFile));
                    emails = (HashMap<Integer, String>) objectInputStream3.readObject();
                    objectInputStream3.close();
                }


                if (task == 4 || task == 5) {
                    File phoneNumbersFile = new File(phoneNumberHashStoreFileName);
                    phoneNumbersFile.createNewFile();
                    ObjectInputStream objectInputStream4 = new ObjectInputStream(new FileInputStream(phoneNumbersFile));
                    phoneNumbers = (HashMap<Integer, String>) objectInputStream4.readObject();
                    objectInputStream4.close();
                }

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }


        }
    }

    private void menuDisplay() {
        //displays menu or options available
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


    private void runApplication() {

        // variables
        boolean doNotExitVariable = true;
        int optionInput = 0;
        final int NO_OF_THREADS = 4;

        // deserialize data on boot/start

        ExecutorService deserializaionService = Executors.newFixedThreadPool(NO_OF_THREADS);

        for (int i = 1; i < 5; i++) {
            Runnable task = new DeserializationRunnable(i);
            deserializaionService.submit(task);
        }

        deserializaionService.shutdown();
        while(!deserializaionService.isTerminated()){

        }

        

        // menu display


        //call respective options

        // add Contact

        //update contact

        //remove contact

        //search contact

        //list contacts

        //exit application


    }


}


class DriverApplication {
    public static void main(String args[]) {

        // Contact contact = new Contact("mohanteja","995122733","mt@gmail.com");
        // System.out.println(contact.hashCode());

        //21685669 195824996


    }

}