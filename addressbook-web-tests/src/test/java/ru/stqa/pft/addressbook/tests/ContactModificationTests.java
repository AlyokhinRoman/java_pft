package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{
  
  @Test
  
  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();

    if (! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("first name", "middle name", "last name",
              "nick", "111", "222", "333", "email@email.com", "email2@email.com", "email3@email.com", "test1"), true);
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    //int before = app.getContactHelper().getContactCount();

    app.getContactHelper().initContactModification(before.size() - 1);

    ContactData contact = new ContactData(before.get(before.size() -1).getId(),"first name", "middle name", "last name",
            "nick", "111", "222", "333", "email@email.com", "email2@email.com", "email3@email.com", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().updateContactModification();
    app.getNavigationHelper().gotoHomePage();

    List<ContactData> after = app.getContactHelper().getContactList();
    //int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size() -1);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }
    
}
