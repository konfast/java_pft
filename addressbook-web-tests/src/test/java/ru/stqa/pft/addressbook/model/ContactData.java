package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private final String id;
  private final String first_name;
  private final String last_name;
  private final String user_address;
  private final String user_phone;
  private final String user_email;
  private String group;


  public ContactData(String first_name, String last_name, String user_address, String user_phone, String user_email, String group) {
    this.id = null;
    this.first_name = first_name;
    this.last_name = last_name;
    this.user_address = user_address;
    this.user_phone = user_phone;
    this.user_email = user_email;
    this.group = group;
  }

  public ContactData(String id, String first_name, String last_name, String user_address, String user_phone, String user_email, String group) {
    this.id = id;
    this.first_name = first_name;
    this.last_name = last_name;
    this.user_address = user_address;
    this.user_phone = user_phone;
    this.user_email = user_email;
    this.group = group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(id, that.id) &&
            Objects.equals(first_name, that.first_name) &&
            Objects.equals(last_name, that.last_name);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, first_name, last_name);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", first_name='" + first_name + '\'' +
            ", last_name='" + last_name + '\'' +
            '}';
  }

  public String getId() { return id; }

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

  public String getGroup() {
    return group;
  }
}
