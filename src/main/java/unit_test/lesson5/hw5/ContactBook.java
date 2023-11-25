package unit_test.lesson5.hw5;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {

    List<Contact> contactBook = new ArrayList<>();

    public void addContact(Contact contact) {
        contactBook.add(contact);
    }

    public List<Contact> getContactBook() {
        return contactBook;
    }

    public Contact getContact(String name) {
        for (Contact contact : contactBook) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void editNameContact(Contact contact, String newName) {
        contact.setName(newName);
    }
}
