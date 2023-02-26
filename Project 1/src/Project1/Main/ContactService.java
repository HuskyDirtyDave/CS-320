package Project1.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {

    private String uniqueId;
    // Generate unique ID when the ContactService is created
    private List<Contact> contactList = new ArrayList<>();
    {
        uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
    }

    // Create a new contact with a unique ID and add to the contact list
    public void newContact() {
        Contact contact = new Contact(newUniqueId());
        contactList.add(contact);
    }

    // Create a new contact with a first name, unique ID and add to the contact list
    public void newContact(String firstname) {
        Contact contact = new Contact(newUniqueId(), firstname);
        contactList.add(contact);
    }

    // Create a new contact with a first name, last name, unique ID and add to the contact list
    public void newContact(String firstname, String lastname) {
        Contact contact = new Contact(newUniqueId(), firstname, lastname);
        contactList.add(contact);
    }

    // Create a new contact with a first name, last name, phone number, unique ID and add to the contact list
    public void newContact(String firstname, String lastname, String phonenumber) {
        Contact contact = new Contact(newUniqueId(), firstname, lastname, phonenumber);
        contactList.add(contact);
    }

    // Create a new contact with a first name, last name, phone number, address, unique ID and add to the contact list
    public void newContact(String firstname, String lastname, String phonenumber, String address) {
        Contact contact = new Contact(newUniqueId(), firstname, lastname, phonenumber, address);
        contactList.add(contact);
    }

    // Remove contact with the specified ID from the contact list
    public void deleteContact(String id) throws Exception {
        contactList.remove(searchForContact(id));
    }

    // Update the first name of the contact with the specified ID
    public void updateFirstName(String id, String firstName) throws Exception {
        searchForContact(id).updateFirstName(firstName);
    }

    // Update the last name of the contact with the specified ID
    public void updateLastName(String id, String lastName) throws Exception {
        searchForContact(id).updateLastName(lastName);
    }

    // Update the phone number of the contact with the specified ID
    public void updatePhoneNumber(String id, String phoneNumber) throws Exception {
        searchForContact(id).updatePhoneNumber(phoneNumber);
    }

    // Update the address of the contact with the specified ID
    public void updateAddress(String id, String address) throws Exception {
        searchForContact(id).updateAddress(address);
    }

    // Get the list of contacts
    public List<Contact> getContactList() {
        return contactList;
    }

    // Generate a unique ID
    private String newUniqueId() {
        return uniqueId = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
    }

    // Search for a contact with the specified ID in the contact list
    private Contact searchForContact(String id) throws Exception {
        for (Contact contact : contactList) {
            if (id.equals(contact.getContactId())) {
                return contact;
            }
        }
        throw new Exception("The Contact does not exist!");
    }
}