package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;


import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation () {
    app.goTo().GroupPage();
    Groups before = (Groups) app.group().all();
    GroupData group = new GroupData().withName("test1");
    //int before = app.getGroupHelper().getGroupCount();
    app.group().create(group);
    Groups after = (Groups) app.group().all();
    //int after = app.getGroupHelper().getGroupCount();
    //Assert.assertEquals(after, before +1);
    assertThat(after.size(), equalTo(before.size() +1));

    assertThat(after, equalTo(
            before.withAdded(group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

}
