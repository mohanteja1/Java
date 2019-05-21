package contactApplicationVersion3;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//-----------------------------------------------------------contact class -----------------------------------------------------
class Contact implements Comparable<Contact>, Serializable {
    private String name;
    private String mobile;
    private String email;
    private String randomString;

    public Contact() {
    }

    public Contact(String name, String mobile, String email) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }

    public String getRandomString() {
        return randomString;
    }

    public void setRandomString(String randomString) {
        this.randomString = randomString;
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
//-------------------------------------------------------------contact class------------------------------------------------//




//-------------------------------------------------------------contacts application------------------------------------------//


class ContactsApplication {

    boolean debugSwitch = false;

    String totalContactsHashStoreFileName = "contactsHash.txt";

    // data structures : multimap and hashmap

    Multimap<String,String> searchMap ;
    LinkedHashMap<String,Contact> contacts ;

    // --------------------------------randomString generation method---------------------

    public String randomStringGenerator(int lengthOfString){

        String alphabetsAndNumbers = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz!@#$%^&*()_+=?" ;
        StringBuilder randomString = new StringBuilder();
        int randomNumber;
       // System.out.println(alphabetsAndNumbers.length());
        for(int i=0;i<lengthOfString;i++){
            randomNumber = (int)(alphabetsAndNumbers.length()* Math.random());
            //System.out.println(randomNumber);
            randomString.append(alphabetsAndNumbers.charAt(randomNumber));
        }
        return randomString.toString();

    }
  //---------------------------------randomString generation method--------------------------//




    //--------------------------------------------------------------printingPart---------------------------------------------------------------------------------//

    private boolean showSingleContact(Contact contact,String index,boolean indexing) {

        if (contact == null) {
            System.out.println("no details to show ,! empty contact");
            return false;
        }

        //adjust tables size if possible ?

        if(!indexing) index="";

        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("| " + index +"| "+ contact.getName() + " | " + contact.getMobile() + " | " + contact.getEmail() + " | " );
        System.out.println("---------------------------------------------------------------------------------");

        return true;

    }

    private boolean showAllContacts(boolean indexing) {
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

        int i=1;
        for ( Map.Entry<String,Contact> contact: contacts.entrySet()) {
            showSingleContact(contact.getValue(),Integer.toString(i++),indexing);
        }

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


    //------------------------------------------------------------------------------printingPart-------------------------------------------------------------//



    //-----------------------------------------------------------------------------Inner Class don't cross-------------------------------------------------//
    //this inner class handles the memory writings and readings
    // create an instance and pass your data and filename parameters
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

        private void serializeCurrentData(HashMap<String,Contact> contacts, String fileName) {

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
                    contacts = (LinkedHashMap<String, Contact>) objectInputStream1.readObject();
                    objectInputStream1.close();

                }

                if (task == 2 || task == 3) {

                    searchMap =ArrayListMultimap.create();

                    contacts.forEach((randomKey,contact)->{
                       searchMap.put(contact.getName(),randomKey);
                       searchMap.put(contact.getEmail(),randomKey);
                       searchMap.put(contact.getMobile(),randomKey);

                    });

                }

            } catch(EOFException e){
                contacts = new LinkedHashMap<String, Contact>();
                e.printStackTrace();
            }catch (FileNotFoundException e) {
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
    //----------------------------------------------------------------------------InnerClass don't cross----------------------------------------------------------------//


    private boolean addContact(Contact contact, int index) {

        //get new contact and index where it should add
        //check for empty array
        // check for negative index
        // add contact

        try {
            if (contacts == null) {
                contacts = new LinkedHashMap<String, Contact>();
            }
            if (searchMap==null){
                searchMap =ArrayListMultimap.create();
            }


        } catch (NullPointerException e) {
            System.out.println("cannot initialize hash Maps");
            System.out.println(e);
            e.printStackTrace();
            return false;
        }

        String randomString =contact.getRandomString();

        contacts.put(randomString,contact);

        searchMap.put(contact.getName(),randomString);
        searchMap.put(contact.getMobile(),randomString);
        searchMap.put(contact.getEmail(),randomString);


        if (debugSwitch) System.out.println("added contact :" + contacts);
        serialize();
        return true;
    }

    private Contact getInputDetails(Contact oldContact, Integer[] optionArray,boolean setRandomString) {

        //get the details for new contact
        //Ask for details
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        System.out.println("Enter the details: ");
        System.out.println("name:");
        contact.setName(scanner.nextLine());
        System.out.println("phone");
        contact.setMobile(scanner.nextLine());
        System.out.println("personal email");
        contact.setEmail(scanner.nextLine());
        String randomString;
        if(setRandomString) {
            if(contacts==null||contacts.size()==0){
                randomString = randomStringGenerator(7);
            }
            else{
            while (true) {
                randomString = randomStringGenerator(7);
                if (!contacts.containsKey(randomString)) {
                    break;
                }

            }
            }

            contact.setRandomString(randomString);
        }

        if (debugSwitch)
            System.out.println("current contact : " + contact.toString());


        return contact;

    }

    //----------------------------------------------update contact---------------------------------------

    private void updateContact(Contact oldContact) {

        //1. recieve old contact
        //show details of old contact
        if(oldContact==null){
            System.out.println("no such contact found");
            return;
        }
        System.out.println("current contact details :");
        showSingleContact(oldContact,"1" ,true);
        //2. getDetails

        Contact contact = getInputDetails(oldContact,null,false);

        //3. update the contact

        if(contact!=null){

            //remove the old contact and add the new modified contact
            contacts.remove(oldContact.getRandomString());
            contacts.put(contact.getRandomString(),contact);

        }

        //serialize once so that data cannot be lost on unnecessary closing and de-serializing again
        serialize();
        deserialize();
        //3. show that particular contact
        System.out.println("the contact is updated as :");
        showSingleContact(contact,"1",true);
        return;

    }

    //----------------------------------------------------------------update contact---------------------------------------//

    //------------------------------------------------------------select and search implementation------------------------------------------------------//

    private Contact selectContact(int optionOfSelection) {
        //working
        // 1. user selects the contact through : 1. inputing the index selected by displaying all the contacts
        //                                       2. by searching the contact


        int optionOfSelectContact,tableIndex;
        String identifier;
        ArrayList<String> searchResults;
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

                searchResults= new ArrayList<String>(searchContact(identifier,identifierType));

                if(debugSwitch)System.out.println("results :" + searchResults);

                if(searchResults == null){ System.out.println("no results found matching "); return null;}

                if(searchResults.size()==1)return contacts.get(searchResults.get(0));

                int i=1;
                for (String randomString : searchResults) {
                    if(contacts.containsKey(randomString)){
                        showSingleContact(contacts.get(randomString),Integer.toString(i++),true);
                    }
                }
                System.out.println("select a contact from the multiple results");

                tableIndex=Integer.parseInt(scanner.next());
                return contacts.get(searchResults.get(tableIndex-1));
            case 2:
                // return contact from table index
                showAllContacts(true);
                System.out.println("please select the index of the required contact from above table");
                tableIndex= Integer.parseInt(scanner.next());
                searchResults=new ArrayList<String>(contacts.keySet());
                return contacts.get(searchResults.get(tableIndex-1));
            default:
                System.out.println("returning to main menu");
                return null;
        }
    }


    //------------------------------------------------------------------------------------search-------------------------------------------//

    private Collection<String> searchContact(String identifier, int identifierType) {
        //failure cases
        if (contacts == null) {
            return null;
        }
        if (contacts.size() == 0) {
            return null;
        }
        if (identifier == null || identifierType == -1) {
            return null;
        }

        int hashcode;
        //actual search
        if(searchMap.containsKey(identifier)){
            return searchMap.get(identifier);
        }

        //actual search
        return null;
    }


    //----------------------------------------------------------------------------------------select and search implementation-----------------------------------------//

    //---------------------------------------------------------------------------------------remove contact------------------------------------------------------------//

    private boolean removeContact(Contact contact) {

        //1. get Contact

        //2. show contact

        System.out.println("the contact you selected :");
        showSingleContact(contact,"1",true);

        //4 ask for confirmation

        System.out.println("sure you want to remove this contact press Y to confirm or N to abort");
        Scanner scanner = new Scanner(System.in);
        String confirmation = scanner.nextLine();

        //5. delete
        if(confirmation.equalsIgnoreCase("y")) {
            contacts.remove(contact.getRandomString());
            System.out.println("contact removed");
            serialize();
            return true;

        }
        else{
            System.out.println("Remove operation aborted");
            return false;
        }

    }

    //------------------------------------------------------------------------------------remove contact--------------------------------------------------------------//


    //----------------------------------------------------------------------exit------------------------------------------------------------------//

    private void serialize(){
        Runnable task = new MemoryStorage(1,true,false,totalContactsHashStoreFileName);
        ExecutorService serializeService = Executors.newSingleThreadExecutor();
        serializeService.submit(task);
        serializeService.shutdown();
        while(!serializeService.isTerminated()){

        }
    }

    private void deserialize(){
        ExecutorService deserializaionService = Executors.newSingleThreadExecutor();
        Runnable task = new MemoryStorage(3,false,true,totalContactsHashStoreFileName);
        deserializaionService.submit(task);
        deserializaionService.shutdown();
        //wait for the threads to close
        while(!deserializaionService.isTerminated()){

        }

    }
    private void exit() {

        //check for closing files and stream readers and writers if any
        // and close
        //serialize the data once before closing
        serialize();
        System.gc();

        //Runtime.getRuntime().runFinalization();
        System.exit(0);


    }

    //---------------------------------------------exit--------------------------------------------------


    public void runApplication() {

        // variables
        boolean doNotExitVariable = true;
        int optionInput = 0;
        final int NO_OF_THREADS = 1;

        // deserialize data on boot/start

        deserialize();

        while (doNotExitVariable) {
            Scanner scanner = new Scanner(System.in);
            menuDisplay(true);
            optionInput = scanner.nextInt();


            //menu selection

            switch (optionInput) {
                case 1:
                    // add Contact

                    addContact(getInputDetails(null, null,true), -1);
                    break;
                case 2:
                    //update contact

                    System.out.println("update contact");
                    updateContact(selectContact(0));
                    break;
                case 3:
                    //remove contact

                    removeContact(selectContact(0));
                    break;
                case 4:
                    //search contact

                    Contact contact=selectContact(0);
                    if(contact==null){ System.out.println("not found"); break;}
                    System.out.println("Results of your search :");
                    showSingleContact(contact,"1",false);
                    break;
                case 5:
                    //list contacts
                    showAllContacts(true);
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



//--------------------------------------------------------------Driver--------------------------------------------------------------------//

class DriverApplication {
    public static void main(String args[]) {

        ContactsApplication contactsApplication =new ContactsApplication();
        contactsApplication.runApplication();

       // System.out.println(contactsApplication.randomStringGenerator(7));


    }

}