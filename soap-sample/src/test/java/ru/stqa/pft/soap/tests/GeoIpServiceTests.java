package ru.stqa.pft.soap.tests;

import com.buzzbuzhome.BBHLocation;
import com.buzzbuzhome.GeoIP;
import com.buzzbuzhome.GeoIPSoap;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {

  @Test
  public void testMyIp() {
    BBHLocation userLocation = new GeoIP().getGeoIPSoap12().getUserLocation("109.197.222.242");
    assertEquals(userLocation.getCountryCode(), "US");
  }


}

