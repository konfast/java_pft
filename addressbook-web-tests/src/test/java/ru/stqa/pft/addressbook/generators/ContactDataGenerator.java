package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.ContactData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  @Parameter(names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);
    if (format.equals("csv")) {
      saveAsCsv(contacts, new File(file));
    } else if (format.equals("json")){
      saveAsJson(contacts, new File(file));
    } else {
      System.out.println("Unrecognized format");
    }
  }

  private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
    Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
    String json = gson.toJson(contacts);
    try(Writer writer = new FileWriter(file)) {
      writer.write(json);
    }
  }

  private void saveAsCsv(List<ContactData> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsoluteFile());
    try(Writer writer = new FileWriter(file)) {
      for (ContactData contact : contacts) {
        writer.write(String.format("%s;%s;%s;%s;%s\n", contact.getFirst_name(), contact.getLast_name(), contact.getUser_address(), contact.getUser_phone(), contact.getUser_email()));
      }
    }
  }

  private List<ContactData> generateContacts(int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirst_name(String.format("Svetlana %s", i)).withLast_name(String.format("Ivanova %s", i)).
      withUser_address(String.format("Ukraine %s", i)).withUser_phone(String.format("111-11-11 %s", i)).
              withMobilePhone(String.format("222-22-22 %s", i)).withWorkPhone(String.format("33-33-33 %s", i)).
              withUser_email(String.format("ivanova@localhost.com %s", i)).
              withEmail2(String.format("iva@localhost.com %s", i)).withEmail3(String.format("iv@localhost.com %s", i)));
    }
    return contacts;
  }
}
