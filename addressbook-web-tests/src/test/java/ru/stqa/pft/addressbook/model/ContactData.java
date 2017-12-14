package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String homephone;
  private final String mobilephone;
  private final String workphone;
  private final String email_1;
  private final String email_2;
  private final String email_3;
  private String group;

  public ContactData (String firstname, String middlename, String lastname, String nickname, String homephone, String mobilephone,
                      String workphone, String email_1, String email_2, String email_3, String group) {
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.homephone = homephone;
    this.mobilephone = mobilephone;
    this.workphone = workphone;
    this.email_1 = email_1;
    this.email_2 = email_2;
    this.email_3 = email_3;
    this.group = group;
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

  public String getGroup () {
    return group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstname, that.firstname) &&
            Objects.equals(middlename, that.middlename);
  }

  @Override
  public int hashCode() {

    return Objects.hash(firstname, middlename);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "firstname='" + firstname + '\'' +
            '}';
  }
}
