package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase{


    @Test
    public void testContactDeletion() {
        app.getNavigationHelper().gotoHomePage();
        if (! app.getContactHelper().isThereAContact()){
            app.getContactHelper().createContact(new ContactData("first name", "middle namee", "last name", "\\9", "111", "222", "333", "email@email.com", "email2@email.com", "email3@email.com", "test1"), true);
        }
        app.getContactHelper().initContactModification();
        app.getContactHelper().deleteSelectedContacts();
    }

}
