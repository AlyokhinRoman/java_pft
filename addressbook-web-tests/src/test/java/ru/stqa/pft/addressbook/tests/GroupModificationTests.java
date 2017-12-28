package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase{

  @BeforeMethod

  public void ensurePreconditions(){
      app.goTo().GroupPage();
      if(app.group().all().size() == 0){
          app.group().create(new GroupData().withName("test2"));
      }
  }
    @Test

  public void testGroupModification(){

    Groups before = app.group().all();
      GroupData modifiedGroup = before.iterator().next();

    GroupData group = new GroupData()
            .withId(modifiedGroup.getId()).withName("test1").withHeader("test2").withFooter("test3");
    //int before = app.getGroupHelper().getGroupCount();
    app.group().modify(group);

    Groups after = app.group().all();
    //int after = app.getGroupHelper().getGroupCount();
    assertEquals(after.size(), before.size());

    assertThat(after, CoreMatchers.equalTo(before.without(modifiedGroup).withAdded(group)));
  }


}
