package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String first_name;
  private final String last_name;
  private final String user_address;
  private final String user_phone;
  private final String user_email;

  public ContactData(String first_name, String last_name, String user_address, String user_phone, String user_email) {
    this.first_name = first_name;
    this.last_name = last_name;
    this.user_address = user_address;
    this.user_phone = user_phone;
    this.user_email = user_email;
  }

  public String getFirst_name() {
    return first_name;
  }

  public String getLast_name() {
    return last_name;
  }

  public String getUser_address() {
    return user_address;
  }

  public String getUser_phone() {
    return user_phone;
  }

  public String getUser_email() {
    return user_email;
  }
}
