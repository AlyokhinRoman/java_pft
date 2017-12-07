package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{
  
  @Test
  
  public void testContactModification(){
    app.getNavigationHelper().gotoHomePage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("first name", "middle namee", "last name", "\\9", "111", "222", "333", "email@email.com", "email2@email.com", "email3@email.com", null), false);
    app.getContactHelper().updateContactModification();
    app.getNavigationHelper().gotoHomePage();
  }
    
}
