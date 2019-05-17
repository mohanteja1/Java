package contactsApplication;

import java.io.Serializable;

public class Contact implements Cloneable,Comparable<Contact>, Serializable {

    private String name;
    private String phoneNumber;
    private String personalEmail;
    private String workEmail;
    private String address;

    public Contact() {
    }

    public Contact(String name) {
        this.name = name;
    }

    //constructors
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String phoneNumber, String personalEmail) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.personalEmail = personalEmail;
    }

    public Contact(String name, String phoneNumber, String personalEmail, String workEmail, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.personalEmail = personalEmail;
        this.workEmail = workEmail;
        this.address = address;
    }

    //getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", personalEmail='" + personalEmail + '\'' +
                ", workEmail='" + workEmail + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

//comparisionFunction

    @Override
    public int compareTo(Contact o) {
        return this.name.compareTo(o.name);
    }






}
