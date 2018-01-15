package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactCreationTests extends TestBase{

    @DataProvider
    public Iterator<Object[]> validContacts(){
        File photo = new File("src/test/resources/badge.png");
        List<Object[]> list = new ArrayList<Object[]>();
        list.add(new Object[]{new ContactData().withFirstname("firstname1").withLastname("lastname1").withGroup("test1").withPhoto(photo)});
        list.add(new Object[]{new ContactData().withFirstname("firstname2").withLastname("lastname2").withGroup("test1").withPhoto(photo)});
        list.add(new Object[]{new ContactData().withFirstname("firstname3").withLastname("lastname3").withGroup("test1").withPhoto(photo)});
        return list.iterator();
    }
    @Test(dataProvider = "validContacts")
    public void testContactCreation(ContactData contact) {
            app.goTo().gotoHomePage();
            Contacts before = app.contact().all();
            app.contact().create(contact, true);
            assertThat(app.contact().count(), equalTo(before.size() +1));
            Contacts after = app.contact().all();
            assertThat(after, equalTo(
                    before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));

    }

    @Test(enabled = false)
    public void testCurrentDir(){
        File currentDir = new File(".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/Makaka_01.jpg");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
    }

    @Test(enabled = false)
    public void testBadContactCreation() {
        app.goTo().gotoHomePage();
        Contacts before = app.contact().all();
        ContactData contact = new ContactData().withFirstname("firstname'").withGroup("test1");
        app.contact().create(contact, true);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(before));

    }
}
