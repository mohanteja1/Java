### Exception handling

#### Exceptions Errors and Throwable class

Exception : it is an event that disrupts the normal flow of the program
            it is an object that is thrown at runtime .
            
            
java.lang.Throwable

Error

types of exception:
 1. checked exception : inherit Throwable except RuntimeExeption and Error
       ex:IO,SQL etc.., thrown at compile time
 2. unchecked exception:                   
            inherit RuntimeException
            checked at Runtime
 3. error :
     1. it is irrecoverable ex OutOfMemory etc..,
 
 
 
     


1. try catch block
          
          print description of Exception,Stack trace 
       
              try{    
              //code that may throw an exception    
              }catch(Exception_class_Name ref){}    

1. Multiple Catch block
                 
                1. order of blocks is from child class to parent class
                2. only catch block is executed
               
                try{    
                               int a[]=new int[5];    
                               a[5]=30/0;    
                              }    
                              catch(ArithmeticException e)  
                                 {  
                                  System.out.println("Arithmetic Exception occurs");  
                                 }    
                              catch(ArrayIndexOutOfBoundsException e)  
                                 {  
                                  System.out.println("ArrayIndexOutOfBounds Exception occurs");  
                                 }    
                              catch(Exception e)  
                                 {  
                                  System.out.println("Parent Exception occurs");  
                                 }                  
             

1. Nested try
                   
                    try{  
                       try{  
                        System.out.println("going to divide");  
                        int b =39/0;  
                       }catch(ArithmeticException e){System.out.println(e);}  
                      
                       try{  
                       int a[]=new int[5];  
                       a[5]=4;  
                       }catch(ArrayIndexOutOfBoundsException e){System.out.println(e);}  
                        
                       System.out.println("other statement);  
                     }catch(Exception e){System.out.println("handeled");}  
                     
                     System.out.println("normal flow..");  
                    }  




1. Finally block : contains cleanup code 
          
          used to execute important code such as closing connection , stream etc..,
          always executed where exception is not handled
          follows after try catch block
                 
  

1. throw 
                       
                       
                       public class TestThrow1{  
                          static void validate(int age){  
                            if(age<18)  
                             throw new ArithmeticException("not valid");  
                            else  
                             System.out.println("welcome to vote");  
                          }  
                          public static void main(String args[]){  
                             validate(13);  
                             System.out.println("rest of the code...");  
                         }  
                       }
                       
                       
                       
1. Exception propagation

        checked exceptions are not propagated in backing from a function
    [why?](https://stackoverflow.com/questions/31227721/checked-exceptions-are-not-propagated-in-the-chain)

   


1. throws 

         1. throws is used to declare that a method throws some checked exceptions so that programmer 
           using the method can handle them in his code.
         1. declare only checked exceptions mainly because unchecked exceptions are your code problem correct them in your code
           
         1. we can throw exception from catch block also after catching
    
   
                       return_type method_name() throws exception_class_name{  
                       //method code  
                       }  
                       
               
              
1. Finalize
           Finalize is used to perform clean up processing just before object is garbage collected. 
           
              



1. Method overloading while exception handling
     two rules:
        


1. Custome exceptions

    [useful link](https://www.baeldung.com/java-new-custom-exception)


