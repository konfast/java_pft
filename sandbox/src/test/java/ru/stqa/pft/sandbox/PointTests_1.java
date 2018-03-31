package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests_1 {

  @Test
    public void testDistance() {
      Point p1 = new Point(45, 13);
      Point p2 = new Point(67, 43);
      Assert.assertEquals(p1.distance(p2), 56.32736547);
    }
  }

