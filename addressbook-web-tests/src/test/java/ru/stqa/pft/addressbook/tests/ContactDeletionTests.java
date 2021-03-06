package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions(){
        app.goTo().gotoHomePage();
        if (app.contact().all().size() == 0){
            app.contact().create(new ContactData().withFirstname("firstname"), true);
        }
    }
    @Test
    public void testContactDeletion() {

        Contacts before = app.contact().all();
        ContactData deletedContact = before.iterator().next();
        //int before = app.getContactHelper().getContactCount();

        app.contact().delete(deletedContact);

        assertThat(app.contact().count(), equalTo(before.size() -1));
        Contacts after = app.contact().all();

        //int after = app.getContactHelper().getContactCount();

        assertThat(after, equalTo(before.without(deletedContact)));
    }



}
