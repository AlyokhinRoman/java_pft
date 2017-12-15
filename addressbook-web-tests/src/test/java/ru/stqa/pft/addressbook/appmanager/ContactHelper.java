package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.ArrayList;
import java.util.List;

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

  public void selectContact () {
    click(By.id("2"));
  }

  public void addNewContact () {
    click(By.linkText("add new"));
  }

  public void initContactModification (int index) {
    wd.findElements(By.cssSelector("img[src=\"icons/pencil.png\"]")).get(index).click();
  }

  public void updateContactModification () {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }

  public void createContact (ContactData contact, boolean creation) {
    addNewContact();
    fillContactForm(contact, true);
    submitContactCreation();
  }


  public boolean isThereAContact () {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

    public int getContactCount() {
      return wd.findElements(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img")).size();
    }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name=\"entry\"]"));
    for (WebElement element : elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
      ContactData contact = new ContactData(id, name, null, null, null, null, null, null, null, null,
              null, null);
      contacts.add(contact);
    }
    return contacts;
  }
}
