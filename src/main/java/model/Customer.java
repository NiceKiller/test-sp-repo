package model;

/**
 * Created by bzawa on 2/14/2017.
 */
public class Customer {

    private String title;
    private String surname;
    private String firstName;
    private String policyNumber;
    private String claimsNumber;
    private String phoneNUmber;
    private String cellPhoneNumber;
    private String address;
    private String city;
    private String zipCode;
    private String email;

    public Customer(String title, String surname, String firstName, String policyNumber, String claimsNumber, String phoneNUmber, String cellPhoneNumber, String address, String city, String zipCode, String email) {
        this.title = title;
        this.surname = surname;
        this.firstName = firstName;
        this.policyNumber = policyNumber;
        this.claimsNumber = claimsNumber;
        this.phoneNUmber = phoneNUmber;
        this.cellPhoneNumber = cellPhoneNumber;
        this.address = address;
        this.city = city;
        this.zipCode = zipCode;
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getClaimsNumber() {
        return claimsNumber;
    }

    public void setClaimsNumber(String claimsNumber) {
        this.claimsNumber = claimsNumber;
    }

    public String getPhoneNUmber() {
        return phoneNUmber;
    }

    public void setPhoneNUmber(String phoneNUmber) {
        this.phoneNUmber = phoneNUmber;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
