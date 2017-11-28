package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  public void testDistance(){
    Point p1 = new Point(0, 0);
    Point p2 = new Point(20, 30);
    Assert.assertEquals(p1.distance(p2), 36.05551275463989);
  }

  @Test
  public void testDistance2(){
    Point p1 = new Point(10, 20);
    Point p2 = new Point(40, 50);
    Assert.assertEquals(p1.distance(p2), 42.42640687119285);
  }
}
