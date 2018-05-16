package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;
import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {

  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Expose
  @Column(name = "firstname")
  private String first_name;

  @Expose
  @Column(name = "lastname")
  private String last_name;

  @Expose
  @Column(name = "address")
  @Type(type = "text")
  private String user_address;

  @Expose
  @Column(name = "home")
  @Type(type = "text")
  private String user_phone;

  @Expose
  @Column(name = "email")
  @Type(type = "text")
  private String user_email;

  //@Transient
  //private String group;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @Expose
  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Expose
  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;

  @Expose
  @Column(name = "email2")
  @Type(type = "text")
  private String email2;

  @Expose
  @Column(name = "email3")
  @Type(type = "text")
  private String email3;

  @Transient
  private String allPhones;

  @Transient
  private String allEmails;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "address_in_groups",
          joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  public Groups getGroups() {
    return new Groups(groups);
  }

  public File getPhoto() {
    if (photo == null) {
      return null;
    } else {
      return new File(photo);
    }

  }

  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

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

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", first_name='" + first_name + '\'' +
            ", last_name='" + last_name + '\'' +
            ", user_address='" + user_address + '\'' +
            ", user_phone='" + user_phone + '\'' +
            ", user_email='" + user_email + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", email2='" + email2 + '\'' +
            ", email3='" + email3 + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(first_name, that.first_name) &&
            Objects.equals(last_name, that.last_name) &&
            Objects.equals(user_address, that.user_address) &&
            Objects.equals(user_phone, that.user_phone) &&
            Objects.equals(user_email, that.user_email) &&
            Objects.equals(mobilePhone, that.mobilePhone) &&
            Objects.equals(workPhone, that.workPhone) &&
            Objects.equals(email2, that.email2) &&
            Objects.equals(email3, that.email3);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, first_name, last_name, user_address, user_phone, user_email, mobilePhone, workPhone, email2, email3);
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
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

  /*public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }*/

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

  public ContactData inGroup(GroupData group) {
    groups.add(group);
    return this;

  }

  /*public String getGroup() {
    return group;
  }*/

}
