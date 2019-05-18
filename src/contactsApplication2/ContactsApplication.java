package contactsApplication2;

import org.omg.CORBA.Object;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
//-----------------------------------------------------------contact class------------------------------------------------
class Contact implements Comparable<Contact>, Serializable {
    private String name;
    private String mobile;
    private String email;

    public Contact() {
    }

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
//-----------------------------------------------------------contact class------------------------------------------------







class ContactsApplication {

    boolean debugSwitch = true;

    String namesHashStoreFileName = "names.txt";
    String emailHashStoreFileName = "emails.txt";
    String phoneNumberHashStoreFileName = "phoneNumbers.txt";
    String totalContactsHashStoreFileName = "contactsHash.txt";
    //hashmaps

    HashMap<Integer, Contact> contacts;//=new HashMap<Integer, Contact>();
    HashMap<String, Integer> names;
    HashMap<String, Integer> emails;
    HashMap<String,Integer> phoneNumbers;

    //----------------------------------------------printingPart------------------------------------------------
    private boolean showSingleContact(Contact contact,int index) {

        if (contact == null) {
            System.out.println("no details to show ,! empty contact");
            return false;
        }

        //adjust tables size if possible ?

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("| " + index +"| "+ contact.getName() + " | " + contact.getMobile() + " | " + contact.getEmail() + " | " );
        System.out.println("---------------------------------------------------------------------------------");

        return true;

    }

    private boolean showAllContacts() {
        // print all contacts

        try {
            if (contacts == null) {
                System.out.println("no contacts available please add one");
                return false;
            }
            if (contacts.isEmpty())
                System.out.print("no contacts to show");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        if (debugSwitch) System.out.println("contacts size" + contacts.size());


        contacts.forEach((hashcode,contact)->{
            showSingleContact(contact,hashcode);
        });


        return true;

    }

    private void menuDisplay(boolean needWelcome) {
        //displays menu or options available
        if(needWelcome)
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


    //----------------------------------------------printingPart------------------------------------------------



    //--------------------------------------------Inner Class don't cross------------------------------------------
    class MemoryStorage implements Runnable {
        int task;
        boolean serialize;
        boolean deserialize;
        String filename;

        public int getTask() {
            return task;
        }

        public void setTask(int task) {
            this.task = task;
        }

        public boolean isSerialize() {
            return serialize;
        }

        public void setSerialize(boolean serialize) {
            this.serialize = serialize;
        }

        public boolean isDeserialize() {
            return deserialize;
        }

        public void setDeserialize(boolean deserialize) {
            this.deserialize = deserialize;
        }

        @Override
        public void run() {
            if(deserialize)
                deserializePreviousData(task,filename);

            if(serialize)
                serializeCurrentData(contacts,filename);
        }

        public MemoryStorage(int task,boolean serialize,boolean deserialize,String filename) {
            this.task = task;
            this.serialize=serialize;
            this.deserialize=deserialize;
            this.filename=filename;
        }

        private void serializeCurrentData(HashMap<Integer,Contact> contacts, String fileName) {

            try {
                FileOutputStream outputStream = new FileOutputStream(fileName);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(contacts);

                objectOutputStream.close();
                outputStream.close();

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();

            }

        }

        private void deserializePreviousData(int task,String filename) {

            try {
                //create files if not found
                //create file,object streams
                if (task == 1 || task == 3) {
                    File contactsFile = new File(totalContactsHashStoreFileName);
                    contactsFile.createNewFile();
                    ObjectInputStream objectInputStream1 = new ObjectInputStream(new FileInputStream(filename));
                    contacts = (HashMap<Integer, Contact>) objectInputStream1.readObject();
                    objectInputStream1.close();

                }

                if (task == 2 || task == 3) {

                    names = new HashMap<String, Integer>();
                    emails= new HashMap<String, Integer>();
                    phoneNumbers= new HashMap<String, Integer>();
                    contacts.forEach((hashcode,contact)->{
                        names.put(contact.getName(),hashcode);
                        emails.put(contact.getEmail(),hashcode);
                        phoneNumbers.put(contact.getMobile(),hashcode);

                    });

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
    //---------------------------------------------------InnerClass don't cross----------------------------------------------------------------


    private boolean addContact(Contact contact, int index) {

        //get new contact and index where it should add
        //check for empty array
        // check for negative index
        // add contact

        try {
            if (contacts == null) {
                contacts = new HashMap<Integer, Contact>();
            }
            if(names==null){
                names = new HashMap<String, Integer>();
            }
            if(emails==null){
                emails=new HashMap<String, Integer>();
            }
            if(phoneNumbers==null){
                phoneNumbers= new HashMap<String, Integer>();
            }

        } catch (NullPointerException e) {
            System.out.println("cannot initialize hash Maps");
            System.out.println(e);
            e.printStackTrace();
            return false;
        }


        int hashcode =contact.hashCode();
        contacts.put(hashcode,contact);
        names.put(contact.getName(),hashcode);
        emails.put(contact.getEmail(),hashcode);
        phoneNumbers.put(contact.getMobile(),hashcode);
        if (debugSwitch) System.out.println("added contact :" + contacts);

        serialize();
        return true;
    }

    private Contact getInputDetails(Contact oldContact, Integer[] optionArray) {

        //get the details for new contact
        //Ask for details
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        //name :
        System.out.println("Enter the details: ");
        System.out.println("name:");
        contact.setName(scanner.nextLine());
        System.out.println("phone");
        contact.setMobile(scanner.nextLine());
        System.out.println("personal email");
        contact.setEmail(scanner.nextLine());

        if (debugSwitch)
            System.out.println("current contact : " + contact.toString());

        return contact;

    }

    //----------------------------------------------update contact---------------------------------------

    private void updateContact(Contact oldContact) {

        //1. recieve old contact
        //show details of old contact
        System.out.println("current contact details :");
        showSingleContact(oldContact,oldContact.hashCode());
        //2. getDetails

        Contact contact = getInputDetails(null,null);

        //3. update the contact

        if(contact!=null){

            contacts.remove(oldContact.hashCode());
            contacts.put(contact.hashCode(),contact);

        }

        serialize();
        //3. show that particular contact
        System.out.println("the contact is updated as :");
        showSingleContact(contact,contact.hashCode());
        return;

    }

    //----------------------------------------------update contact---------------------------------------

    //---------------------------------------------select and search implementation------------------------------

    private Contact selectContact() {
        int optionOfSelectContact,hashcode;
        String identifier;
        System.out.println("Please choose the contact from following option: \n\t 1. search contact \n\t 2. select from table \n\t press any other key to return to main menu");
        Scanner scanner = new Scanner(System.in);
        optionOfSelectContact = scanner.nextInt();

        switch (optionOfSelectContact) {
            case 1:
                //return contact through Search function
                System.out.println("select the variable you want to search for the contact\n\t 1. name \n\t 2. phone number \n\t 3. Email ");
                int identifierType = scanner.nextInt();
                while (identifierType < 1 || identifierType > 3) {
                    System.out.println("invalid input , please select between [1-5] ");
                    identifierType = scanner.nextInt();
                }
                System.out.println("please enter key word for the choosen type");
                identifier=scanner.next();
                hashcode =searchContact(identifier,identifierType);
                if(debugSwitch)System.out.println("index :" + hashcode);
                if(hashcode==-1)return null;
                return contacts.get(hashcode);
            case 2:
                // return contact from table index
                showAllContacts();
                System.out.println("please select the index of the required contact from above table");
                int tableIndex= Integer.parseInt(scanner.next());
                hashcode=(int)contacts.keySet().toArray()[tableIndex];
                return contacts.get(hashcode);
            default:
                System.out.println("returning to main menu");
                return null;
        }
    }


                                  //-------------search-----------------------

    private int searchContact(String identifier, int identifierType) {
        //failure cases
        if (contacts == null) {
            return -1;
        }
        if (contacts.size() == 0) {
            return -1;
        }
        if (identifier == null || identifierType == -1) {
            return -1;
        }

        int hashcode;
        //actual search
        switch(identifierType){

            case 1:
                  if(names.containsKey(identifier))
                      return names.get(identifier).hashCode();
                  break;
            case 2:
                if(phoneNumbers.containsKey(identifier))
                  return phoneNumbers.get(identifier).hashCode();
                else break;
            case 3:
                if(emails.containsKey(identifier))
                  return emails.get(identifier).hashCode();
                else break;
        }


        //actual search


        return -1;
    }


    //---------------------------------------------select and search implementation------------------------------

   //----------------------------------------------remove contact----------------------------------------------

    private boolean removeContact(Contact contact) {

        //1. get Contact

        //2. show contact

        System.out.println("the contact you selected :");
        showSingleContact(contact,contact.hashCode());

        //4 ask for confirmation

        System.out.println("sure you want to remove this contact press Y to confirm or N to abort");
        Scanner scanner = new Scanner(System.in);
        String confirmation = scanner.nextLine();

        //5. delete
        if(confirmation.equalsIgnoreCase("y")) {
            contacts.remove(contact.hashCode());
            System.out.println("contact removed");
            serialize();
            return true;

        }
        else{
            System.out.println("Remove operation aborted");
            return false;
        }

    }

    //----------------------------------------------remove contact----------------------------------------------
    //---------------------------------------------exit--------------------------------------------------

    private void serialize(){
        Runnable task = new MemoryStorage(1,true,false,totalContactsHashStoreFileName);
        ExecutorService serializeService = Executors.newSingleThreadExecutor();
        serializeService.submit(task);
        serializeService.shutdown();
        while(!serializeService.isTerminated()){

        }
    }

    private void exit() {

        //check for closing files and stream readers and writers if any
        // and close


        serialize();
        //serializeCurrentData(contacts, null);
        System.gc();
        //Runtime.getRuntime().runFinalization();
        System.exit(0);


    }

    //---------------------------------------------exit--------------------------------------------------


    public void runApplication() {

        // variables
        boolean doNotExitVariable = true;
        int optionInput = 0;
        final int NO_OF_THREADS = 4;

        // deserialize data on boot/start

        ExecutorService deserializaionService = Executors.newSingleThreadExecutor();

        Runnable task = new MemoryStorage(3,false,true,totalContactsHashStoreFileName);
        deserializaionService.submit(task);


        deserializaionService.shutdown();


        while (doNotExitVariable) {
            Scanner scanner = new Scanner(System.in);
            menuDisplay(true);
            optionInput = scanner.nextInt();

            //wait for the threads to close
            while(!deserializaionService.isTerminated()){

            }
            //menu selection

            switch (optionInput) {
                case 1:
                    // add Contact

                    addContact(getInputDetails(null, null), -1);
                    break;
                case 2:
                    //update contact

                    System.out.println("update contact");
                    updateContact(selectContact());
                    break;
                case 3:
                    //remove contact

                   removeContact(selectContact());
                    break;
                case 4:
                    //search contact

                    Contact contact=selectContact();
                    if(contact==null){ System.out.println("not found"); break;}
                    System.out.println("Results of your search :");
                    showSingleContact(contact,contact.hashCode());
                    break;
                case 5:
                    //list contacts
                    showAllContacts();
                    break;
                case 6:
                    //exit application

                    exit();

                    break;
                default:
                    System.out.println("please enter valid input [1-6]");
                    break;

            }
            if (optionInput == 0) continue;


        }


    }


}



class DriverApplication {
    public static void main(String args[]) {

        ContactsApplication contactsApplication =new ContactsApplication();
        contactsApplication.runApplication();

    }

}