### **JRE , JDK ,JVM**



1. compilation process:
   1. javac converts java code to class
   1. jvm resides on the ram ,class loader loads the classes into ram
   1. Byte code verifier the verifies the code for security
   1. execution engine contain JIT converts the bytecode into machine code
   
 

**JVM**


###### JVM architecture
     
  ![jvm architecture](jvm-architecture.png)
  
  1. Classloader
      
       1. Bootstrap ClassLoader
       1. Extension ClassLoader
       1. System/Application ClassLoader
       1. create your own class loaders[ link 1 ](https://www.baeldung.com/java-classloaders
)          [link 2](https://www.journaldev.com/349/java-classloader
)                   
 
  1. Class(Method) Area
  1. Heap
  1. Stack
  1. Program counter
  1. Native Method Stack
  1. Execution Engine
       1. A virtual processor
       2. Interpreter
       3. Just in Time compiler
  1. Java Native Interface
              
              JNI is a framework which provides an interface to communicate with 
              another app writtern in another language like c++ c assembly
              ex java and console interaction is done through JNI
              
              implement your own JNI connections with native apps
               links:
               https://www.baeldung.com/jni
         
       
       
  
     Specification , implementation , Runtime instance
      
**JRE**
     
     JRE =JVM + library class
     
**JDK**
    
    JDK= JRE + Development tools
    
   ## links 
   
   jre,jvm,jdk:
   
   https://www.geeksforgeeks.org/differences-jdk-jre-jvm/
   
   https://www.youtube.com/watch?v=7tndaxgk1E8&feature=player_embedded
  
  https://www.youtube.com/watch?v=7tndaxgk1E8&feature=player_embedded 
   
   non class functions or functions outside the class domain:
   
   https://softwareengineering.stackexchange.com/questions/185109/why-java-does-not-allow-function-definitions-to-be-present-outside-of-the-class
   
   https://stackoverflow.com/questions/6497165/non-class-functions-in-java
   
   library class:
   
   http://mrbool.com/describing-java-classes-library/29340
   
   JDK development tools :
   https://www.cs.mun.ca/java-api-1.5/tooldocs/index.htmls
   
   JDK and JRE File Structure
   
   https://www.cs.mun.ca/java-api-1.5/tooldocs/windows/jdkfiles.html
   
   getting java version in runtime
   
   https://stackoverflow.com/questions/2591083/getting-java-version-at-runtime
   
   system properties
   
   https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html  
   
   
non class functions or functions outside the class domain:

https://softwareengineering.stackexchange.com/questions/185109/why-java-does-not-allow-function-definitions-to-be-present-outside-of-the-class

https://stackoverflow.com/questions/6497165/non-class-functions-in-java

library class:

http://mrbool.com/describing-java-classes-library/29340

JDK development tools :
https://www.cs.mun.ca/java-api-1.5/tooldocs/index.htmls

JDK and JRE File Structure

https://www.cs.mun.ca/java-api-1.5/tooldocs/windows/jdkfiles.html

getting java version in runtime

https://stackoverflow.com/questions/2591083/getting-java-version-at-runtime

system properties

https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html   