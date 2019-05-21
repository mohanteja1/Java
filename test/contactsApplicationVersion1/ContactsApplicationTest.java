package contactsApplicationVersion1;

import static org.junit.Assert.*;

public class ContactsApplicationTest {


    @org.junit.Test
    public void testSearchContact() {

        Contact contact = new Contact("mohanteja","1111111","im@gmail.com","skdjkthjl","ap");

        ContactsApplication contactsApplication= new ContactsApplication();
        contactsApplication.initialieApplication();


        //since search is a private method we have to use reflection to test private methods
        int value1=0,value2=0,value3=0;

//        try {
//            Method searchContact = contactsApplicationVersion1.getClass().getMethod("searchContact", String.class, int.class);
//            searchContact.setAccessible(true);
//            value1=(Integer)searchContact.invoke("mohanteja",1);     //since mohanteja is the first contact
//            value2=(Integer)searchContact.invoke("randomName",1);   //since there is no name with random name so it will return -1
//            System.out.println(value1+ "" + value2);
//
//        }
//        catch (Exception e) {
//        }
//
//         assertEquals(0,value1);
//         assertEquals(-1,value2);


        //just make searchConatact public for the test case sake
        assertEquals(-1,contactsApplication.searchContact("Randomguy" ,1)); //since it is doesnt exit in contactlist it should return -1
        assertEquals(-1,contactsApplication.searchContact(null,-4)); // returns -1
        assertEquals(-1,contactsApplication.searchContact("ggggg@gmail.com",4));





    }
}