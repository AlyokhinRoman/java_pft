package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.goTo().gotoHomePage();

        Set<ContactData> before = app.contact().all();

        ContactData contact = new ContactData().withFirstname("firstname").withGroup("test1");
        //int before = app.getContactHelper().getContactCount();
        app.contact().create(contact, true);
        Set<ContactData> after = app.contact().all();

        //int after = app.getContactHelper().getContactCount();
        //Assert.assertEquals(after, before +1);
        Assert.assertEquals(after.size(), before.size() +1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);
        Assert.assertEquals(before, after);
    }

}
