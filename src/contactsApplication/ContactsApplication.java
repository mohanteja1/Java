package contactsApplication;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ContactsApplication {

    private List<Contact> contacts = null;
    private boolean debugVariable = true;
    private String filename = "contacts.txt";

    private Contact selectContact() {
        int optionOfSelectCOntact;
        System.out.println("Please choose the contact from following option: \n\t 1. search contact \n\t 2.select from table \n\t press any other key to return to main menu");
        Scanner scanner = new Scanner(System.in);
        optionOfSelectCOntact = scanner.nextInt();

        switch (optionOfSelectCOntact) {
            case 1:
                //return contact through Search function
                System.out.println("select the variable you want to search for the contact\n\t 1. name \n\t 2. phone number \n\t 3. personal Email \n\t 4.work email \n\t 4. address");
                int identifierType = scanner.nextInt();
                while (identifierType < 1 || identifierType > 6) {
                    System.out.println("invalid input , please select between [1-6] ");
                    identifierType = scanner.nextInt();
                }
                System.out.println("please enter a key word for the choosen type");
                String identifier = scanner.nextLine();
                return contacts.get(searchContact(identifier, identifierType));
            case 2:
                // return contact from table index
                showAllContacts();
                System.out.println("please select the index of the required contact from above table");
                return contacts.get(scanner.nextInt() - 1);
            default:
                System.out.println("returning to main menu");
                return null;
        }
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
        contact.setPhoneNumber(scanner.nextLine());
        System.out.println("personal email");
        contact.setPersonalEmail(scanner.nextLine());
        System.out.println("address");
        contact.setAddress(scanner.nextLine());
        System.out.println("workEmail");
        contact.setWorkEmail(scanner.nextLine());
        if (debugVariable)
            System.out.println("current contact : " + contact.toString());

        return contact;

    }


    private boolean addContact(Contact contact, int index) {

        //get new contact and index where it should add
        //check for empty array
        // check for negative index
        // add contact
        try {
            if (contacts == null) {
                contacts = new ArrayList<Contact>();
            }
        } catch (NullPointerException e) {
            System.out.println(e);
            e.printStackTrace();
        }

        if (index == -1) {
            index = contacts.size();
        }

        contacts.add(index, contact);

        //sort the list according to the name
        contacts.sort(new Comparator<Contact>() {
            @Override
            public int compare(Contact o1, Contact o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        if (debugVariable) System.out.println("added contact :" + contacts);

        return true;
    }


    private void updateContact(Contact oldContact) {

        //1. recieve old contact
        //show details of old contact
        System.out.println("current contact details :");
        showSingleContact(oldContact);
        //2. getDetails

        Contact contact = getInputDetails(null,null);

        //3. update the contact

        if(contact!=null){
            int index= contacts.indexOf(oldContact);
            contacts.remove(oldContact);
            contacts.add(index,contact);
            contacts.sort(new Comparator<Contact>() {
                @Override
                public int compare(Contact o1, Contact o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });

        }

        //3. show that particular contact
        showAllContacts();
        return;
    }

    private boolean removeContact(Contact contact) {

        //1. getContactId

        //2. search contact

        //3. show contact

        //4 ask for confirmation

        //5. delete


        return true;
    }

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

        String methodName;
        if (identifierType == 1) methodName = "getName";
        else if (identifierType == 2) methodName = "getPhoneNumber";
        else if (identifierType == 3) methodName = "getPersonalEmail";
        else if (identifierType == 4) methodName = "getWorkEmail";
        else if (identifierType == 5) methodName = "getAddress";
        else methodName = "";
        try {
            Method method = contacts.get(0).getClass().getMethod(methodName);

            int i = 0;

            for (Contact contact : contacts) {
                try {
                    if (method.invoke(contact).toString().contains(identifier)) {
                        return i;
                    }

                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        //actual search


        return -1;
    }

    private boolean showSingleContact(Contact contact) {

        if (contact == null) {
            System.out.println("no details to show ,! empty contact");
            return false;
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("| " + contact.getName() + " | " + contact.getPhoneNumber() + " | " + contact.getPersonalEmail() + " | " + contact.getWorkEmail() + " | " + contact.getAddress());
        System.out.println("--------------------------------------------------------------------------------------------------------");

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


        if (debugVariable) System.out.println("contacts size" + contacts.size());

        contacts.forEach(contact -> {
            showSingleContact(contact);
        });

        return true;


    }

    private void exit() {

        //check for closing files and stream readers and writers if any
        // and close

        serializeCurrentData(contacts, filename);
        System.gc();
        //Runtime.getRuntime().runFinalization();
        System.exit(0);


    }

    private void serializeCurrentData(List<Contact> contacts, String fileName) {

        try {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(contacts);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();

        }

    }

    private void deserializePreviousData(String fileName) {

        try {

            //check if file exists else return;
            File file = new File(fileName);
            file.createNewFile();

            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            this.contacts = (List<Contact>) objectInputStream.readObject();


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


    public void runApplication() {

        // variables
        boolean donotExitVariable = true;
        int optionInput = 0;


        //create object list from file using thread----------------------------------------
        Thread thread = new Thread(() -> {
            deserializePreviousData("contacts.txt");
        });
        thread.start();


        //run loop------------------------------------------------------------------------------------------

        while (donotExitVariable) {
            Scanner scanner = new Scanner(System.in);
            menuDisplay();
            optionInput = scanner.nextInt();

            //wait till deserialize completes------------------------------------------------------
            try {
                if (thread.isAlive()) {
                    thread.join(1000);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

            //options selected---------------------------------------------------------------------

            switch (optionInput) {
                case 1:
                    this.addContact(getInputDetails(null, null), -1);
                    break;
                case 2:
                    System.out.println("update contact");
                    this.updateContact(selectContact());
                    break;
                case 3:
                    this.removeContact(selectContact());
                    break;
                case 4:
                    this.searchContact(null, 0);
                    break;
                case 5:
                    this.showAllContacts();
                    break;
                case 6:
                    this.exit();
                    break;
                default:
                    System.out.println("please enter valid input [1-6]");
                    break;

            }
            if (optionInput == 0) continue;


        }


    }


}
