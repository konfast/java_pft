package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests_2 {

  @Test
  public void testDistance() {
    Point p1 = new Point(32.9, 13);
    Point p2 = new Point(67, 43);
    Assert.assertEquals(p1.distance(p2), 45.41816817089831);

  }
}
