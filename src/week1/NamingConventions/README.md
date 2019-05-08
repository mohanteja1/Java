## JAVA NAMING CONVENTIONS

CAMEL CASE

1. Class and Interface:
   1. class names should nouns 
   2. first letter capital , next follow camel case if required
   3. use whole words
   4. avoid acronyms and abbveriations (No shortcuts)
          
          Example :
          
          interface  Bicycle
          class MountainBike implements Bicyle
          
          interface Sport
          class Football implements Sport
2. Methods 
   1. use verbs
   2. first letter small case
   3. then follow camel case
           
           example:
           void changeGear(int newValue);
           void speedUp(int increment);
           void applyBrakes(int decrement);
           
           
           
3. Variables 
      1.short and meaningful
      2. not start with _ or $
      3.no one character variable names except for temporary variables
               
               examples:  
                // variables for MountainBike class
                   int speed = 0;
                   int gear = 1;

4. Constant variables 
      1. all uppercase letters
      2. seperate words with _
              
              examples:
              static final int MIN_WIDTH = 4;
              
              // Some  Constant variables used in predefined Float class
              public static final float POSITIVE_INFINITY = 1.0f / 0.0f;
              public static final float NEGATIVE_INFINITY = -1.0f / 0.0f;
              public static final float NaN = 0.0f / 0.0f;      
    
5. packages
   1.all lowercase ASCII letters
   2. top level domain names : com edu goc mil net org
            
            examples:
            com.sun.eng
            com.apple.quicktime.v2
            
            // java.lang packet in JDK
            java.lang  
                 