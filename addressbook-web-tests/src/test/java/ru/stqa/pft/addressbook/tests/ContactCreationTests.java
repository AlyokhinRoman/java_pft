package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getNavigationHelper().gotoHomePage();

        List<ContactData> before = app.getContactHelper().getContactList();

        ContactData contact = new ContactData("first name", "middle namee", "last name",
                "\\9", "111", "222", "333", "email@email.com", "email2@email.com", "email3@email.com", "test1");
        //int before = app.getContactHelper().getContactCount();
        app.getContactHelper().addNewContact();
        app.getContactHelper().createContact(contact, true);
        app.getNavigationHelper().gotoHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();

        //int after = app.getContactHelper().getContactCount();
        //Assert.assertEquals(after, before +1);
        Assert.assertEquals(after.size(), before.size() +1);

        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
    }

}
