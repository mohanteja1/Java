#### ABSTRACTION
 
 Abstraction is the process of hiding the implementation details and showing only
 functionality to the user, hides internal details .
  ex SMS sending

1. Abstract class : (0 to 100%)
       1. abstract keyword 
       1. can have abstract methods and non abstract methods
       1. can have constructor
       1. can have non abstract static methods 
       1. cannot have abstract static methods since it class cannot be initiated makes it something to be implemented but
          static methods doesn't require class initialization
       1. can have final methods
       
       
1. Interface (100%)
      1. blueprint of a class
      1. has static constants ,only abstract methods 
      1. also represents Is a relationship
      1. since jdk8 can have default and static methods , can have private methods
       
             Rules to define private methods in java
                1. 