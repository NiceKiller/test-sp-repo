package model;

public class CustomerBuilder {
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

    public CustomerBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public CustomerBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public CustomerBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public CustomerBuilder setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
        return this;
    }

    public CustomerBuilder setClaimsNumber(String claimsNumber) {
        this.claimsNumber = claimsNumber;
        return this;
    }

    public CustomerBuilder setPhoneNUmber(String phoneNUmber) {
        this.phoneNUmber = phoneNUmber;
        return this;
    }

    public CustomerBuilder setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
        return this;
    }

    public CustomerBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public CustomerBuilder setCity(String city) {
        this.city = city;
        return this;
    }

    public CustomerBuilder setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    public CustomerBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public Customer createCustomer() {
        return new Customer(title, surname, firstName, policyNumber, claimsNumber, phoneNUmber, cellPhoneNumber, address, city, zipCode, email);
    }
}