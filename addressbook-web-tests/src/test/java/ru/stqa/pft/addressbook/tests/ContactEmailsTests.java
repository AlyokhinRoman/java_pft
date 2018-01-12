package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailsTests extends TestBase {

    @Test
    public void testContactEmails(){
        app.goTo().gotoHomePage();
        ContactData contact = app.contact().all().iterator().next();
        ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

        assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

    }

    private String mergeEmails(ContactData contact) {
        return Arrays.asList(contact.getEmail_1(), contact.getEmail_2(),contact.getEmail_3())
                .stream().filter((s) -> ! s.equals(""))
                .map(ContactEmailsTests::cleaned)
                .collect(Collectors.joining("\n"));
    }


    public static String cleaned(String email){
        return email.replaceAll("\\s", "").replaceAll("[-()]", "");
    }
}

