package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

  private int id = Integer.MAX_VALUE;
  private String first_name;
  private String last_name;
  private String user_address;
  private String user_phone;
  private String user_email;
  private String group;

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirst_name(String first_name) {

    this.first_name = first_name;
    return this;

  }

  public ContactData withLast_name(String last_name) {
    this.last_name = last_name;
    return this;

  }

  public ContactData withUser_address(String user_address) {
    this.user_address = user_address;
    return this;

  }

  public ContactData withUser_phone(String user_phone) {
    this.user_phone = user_phone;
    return this;

  }

  public ContactData withUser_email(String user_email) {
    this.user_email = user_email;
    return this;

  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;

  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", first_name='" + first_name + '\'' +
            ", last_name='" + last_name + '\'' +
            '}';
  }

  public int getId() { return id; }

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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(first_name, that.first_name) &&
            Objects.equals(last_name, that.last_name);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, first_name, last_name);
  }
}
