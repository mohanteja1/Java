##### CONTACT APPLICATION:

###### Structure:

                    _ _ _ _ _ _ _ _          _ _ _ _ _ _ _ _ _ _ _    
                   | addContact()  |<-----> | getContactDetails() |                  
                    - - - - - - - -          - - - - - - - - - - -
                                                         ^ 
                                                         |
                     _ _ _ _ _ _ _ _ _                   |     
                    | updateContact() |<--------------.  |
                     - - - - - - - - -                |  |
                                                      |  |
                        _ _ _ _ _ _ __                |_ | 
                      | removeContact()| <---------->selectContact() <----. -------> SelectContactFromTable;
                       - - - - - - - -                    ^             |
                                                          |             | 
                                                          |              --> searchContact();
                                                          |
                    _ _ _ _ _ _ __                        |
                  |  updateContact() |<-------------------.
                    - - - - - - - 
                    
                    
