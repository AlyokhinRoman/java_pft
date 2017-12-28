package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().gotoHomePage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withFirstname("firstname"), true);
        }
    }

  @Test
  
  public void testContactModification(){

    Contacts before = app.contact().all();
      ContactData modifiedContact = before.iterator().next();
    int index = before.size() - 1;
    //int before = app.getContactHelper().getContactCount();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("first name");

     app.contact().modify(contact);
     Contacts after = app.contact().all();
    //int after = app.getContactHelper().getContactCount();
    assertEquals(after.size(), before.size());

    assertThat(after, CoreMatchers.equalTo(before.without(modifiedContact).withAdded(contact)));
  }



}
