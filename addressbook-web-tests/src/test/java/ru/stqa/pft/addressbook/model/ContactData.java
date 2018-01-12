package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private  String firstname;
  private  String middlename;
  private  String lastname;
  private  String nickname;
  private  String homephone;
  private  String mobilephone;
  private  String workphone;
  private  String email_1;
  private  String email_2;
  private  String email_3;
  private  String group;
  private  String allPhones;
  private String address;
  private String allEmails;

  public String getAllEmails() {
    return allEmails;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAddress() {
    return address;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public int getId() {
    return id;
  }

  public ContactData withId(int id) {

    this.id = id;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname = firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withHomephone(String homephone) {
    this.homephone = homephone;
    return this;
  }

  public ContactData withMobilephone(String mobilephone) {
    this.mobilephone = mobilephone;
    return this;
  }

  public ContactData withWorkphone(String workphone) {
    this.workphone = workphone;
    return this;
  }

  public ContactData withEmail_1(String email_1) {
    this.email_1 = email_1;
    return this;
  }

  public ContactData withEmail_2(String email_2) {
    this.email_2 = email_2;
    return this;
  }

  public ContactData withEmail_3(String email_3) {
    this.email_3 = email_3;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public String getFirstname () {
    return firstname;
  }

  public String getMiddlename () {
    return middlename;
  }

  public String getLastname () {
    return lastname;
  }

  public String getNickname () {
    return nickname;
  }

  public String getHomephone () {
    return homephone;
  }

  public String getMobilephone () {
    return mobilephone;
  }

  public String getWorkphone () {
    return workphone;
  }

  public String getEmail_1 () {
    return email_1;
  }

  public String getEmail_2 () {
    return email_2;
  }

  public String getEmail_3 () {
    return email_3;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstname, that.firstname) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, firstname, lastname);
  }

  public String getGroup () { return group;  }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

}
