package steps;

import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.ContactsPage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class ContactsSteps {

    private ContactsPage contactsPage;

    @Before
    public void setUp() throws URISyntaxException, MalformedURLException {
        DriverManager.setUp("com.google.android.contacts", "com.android.contacts.activities.PeopleActivity");
        contactsPage = new ContactsPage(DriverManager.getDriver());
    }

    @After
    public void tearDown() {
        DriverManager.tearDown();
    }

    @Dado("que o aplicativo Contatos está aberto")
    public void openContacts() {
        contactsPage.openContacts();
    }

    @Quando("adiciono um novo contato com nome {string} e telefone {string}")
    public void addContact(String name, String phone) {
        contactsPage.clickAddContactsButton();
        contactsPage.enterContactInfo(name, phone);
    }

    @Entao("salvo o contato")
    public void saveContact() {
        contactsPage.saveContact();
    }

    @Entao("o contato com nome {string} deve ser encontrado na lista de contatos")
    public void findContact(String name) {
        contactsPage.findContact(name);
    }

}
