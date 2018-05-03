package ru.stqa.pft.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactData {

  private int id = Integer.MAX_VALUE;
  private String first_name;
  private String last_name;
  private String user_address;
  private String user_phone;
  private String user_email;
  private String group;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String email2;
  private String email3;
  private String allPhones;
  private String allEmails;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  private File photo;

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public String getAllEmails() {

    return allEmails;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getAllPhones() {

    return allPhones;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public String getEmail2() {

    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

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

  public int getId() {
    return id; }

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
