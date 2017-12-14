package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeletionTests extends TestBase{


    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();

        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("first name", "middle namee", "last name", "\\9", "111", "222", "333", "email@email.com", "email2@email.com", "email3@email.com", "test1"), true);
        }
        List<ContactData> before = app.getContactHelper().getContactList();
        //int before = app.getContactHelper().getContactCount();

        app.getContactHelper().initContactModification(before.size() - 1);
        app.getContactHelper().deleteSelectedContacts();
        app.getNavigationHelper().gotoHomePage();

        List<ContactData> after = app.getContactHelper().getContactList();
        //int after = app.getContactHelper().getContactCount();
        Assert.assertEquals(after.size(), before.size() -1);

        before.remove(before.size() -1);
        Assert.assertEquals(before, after);
    }

}
