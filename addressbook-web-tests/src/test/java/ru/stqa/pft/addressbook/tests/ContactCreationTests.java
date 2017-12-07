package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase{

    @Test
    public void testContactCreation() {
        app.getContactHelper().addNewContact();
        app.getContactHelper().fillContactForm(new ContactData("first name", "middle namee", "last name", "\\9", "111", "222", "333", "email@email.com", "email2@email.com", "email3@email.com", "test1"), true);
        app.getContactHelper().submitContactCreation();
    }

}
