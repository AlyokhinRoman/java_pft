package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase{

  public ContactHelper (FirefoxDriver wd) {
    super(wd);
  }

  public void submitContactCreation () {
    click(By.name("submit"));
  }

  public void fillContactForm (ContactData contactData) {
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("middlename"), contactData.getMiddlename());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("home"), contactData.getHomephone());
    type(By.name("mobile"), contactData.getMobilephone());
    type(By.name("work"), contactData.getWorkphone());
    type(By.name("email"), contactData.getEmail_1());
    type(By.name("email2"), contactData.getEmail_2());
    type(By.name("email3"), contactData.getEmail_3());
  }

  public void deleteSelectedContacts () {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void selectContact () {
    click(By.id("2"));
  }

  public void addNewContact () {
    click(By.linkText("add new"));
  }
}
