package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")

  private int id = Integer.MAX_VALUE;
  @Expose
  @Column(name = "firstname")
  private  String firstname;

  private  String middlename;
  @Expose

  @Column(name = "lastname")
  private  String lastname;

  private  String nickname;

  @Column(name = "home")
  @Type(type = "text")
  private  String homephone;

  @Column(name = "mobile")
  @Type(type = "text")
  private  String mobilephone;

  @Column(name = "work")
  @Type(type = "text")
  private  String workphone;

  @Transient
  private  String email_1;

  @Transient
  private  String email_2;

  @Transient
  private  String email_3;

  @Transient
  private  String group;

  @Transient
  private  String allPhones;

  @Transient
  private String address;

  @Transient
  private String allEmails;

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public File getPhoto() {return new File(photo);
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

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

}
