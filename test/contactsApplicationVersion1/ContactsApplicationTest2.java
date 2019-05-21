package contactsApplicationVersion1;

import static org.junit.Assert.*;

public class ContactsApplicationTest2 {

    @org.junit.Test
    public void testContactClassMethods(){

        Contact contact = new Contact("mt","43449845982309428","jkgjsl@gmail.com");
        assertEquals(contact.getAddress(),null);
        assertEquals(contact.getName(),"mt");
        assertEquals(contact.getAddress(),null);


    }

}