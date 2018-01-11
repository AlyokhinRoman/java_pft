package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase{

  public ContactHelper (WebDriver wd) {
    super(wd);
  }

  public void submitContactCreation () {
    click(By.name("submit"));
  }

  public void fillContactForm (ContactData contactData, boolean creation) {
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

    if (creation){
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else{
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
   }

  public void deleteSelectedContacts () {
    click(By.xpath("//div[@id='content']/form[2]/input[2]"));
  }


  public void addNewContact () {
    click(By.linkText("add new"));
  }


  public void initContactModificationById (int id) {
      wd.findElement(By.xpath("//a[@href='edit.php?id="+ id +"']/img[@title='Edit']")).click();
  }

  public void updateContactModification () {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void create(ContactData contact, boolean creation) {
    addNewContact();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCache = null;
    returntoHomePage();
  }

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactForm(contact, false);
        updateContactModification();
        contactCache = null;
        returntoHomePage();
    }

    private void returntoHomePage() {
        click(By.linkText("home"));
    }


  public void delete(ContactData contact) {
    initContactModificationById(contact.getId());
    deleteSelectedContacts();
    contactCache = null;
    returntoHomePage();
  }

  public boolean isThereAContact () {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

    public int count() {
      return wd.findElements(By.xpath("//img[@alt='Edit']")).size();
    }


    private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null){
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.tagName("td"));
    for (WebElement element : elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.xpath("//input[contains(@name,'selected[]')]")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirstname(name));
    }
    return new Contacts(contactCache);
  }


}
