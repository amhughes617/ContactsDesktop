package theironyard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import jodd.json.JsonParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {

    ObservableList<Contact> contacts = FXCollections.observableArrayList();//creates new arraylist observable thingy

    @FXML
    ListView list;

    @FXML
    TextField textName;
    @FXML
    TextField textPhone;
    @FXML
    TextField textEmail;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            contacts = readFile();
        }
        catch (Exception e) {

        }
        list.setItems(contacts);
    }

    public void addContact() throws IOException {
        if (!textName.getText().isEmpty() && !textPhone.getText().isEmpty() && !textEmail.getText().isEmpty()) {
            contacts.add(new Contact(textName.getText(), textPhone.getText(), textEmail.getText()));
        }
        textName.setText("");
        textPhone.setText("");
        textEmail.setText("");
        writeFile(contacts);
    }

    public void removeContact() throws IOException {
        Contact contact = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
        writeFile(contacts);
    }

    public void writeFile(ObservableList<Contact> contacts) throws IOException {
        File f = new File("contacts.txt");
        FileWriter fw = new FileWriter(f);
        ArrayList<Contact> listS = new ArrayList<>(contacts);
        ArrayList<String> contactsStr = new ArrayList<>();
        for (int i = 0; i < listS.size(); i++) {
            contactsStr.add(listS.get(i).getName());
            contactsStr.add(listS.get(i).getPhone());
            contactsStr.add(listS.get(i).getEmail());
        }
        for (String info : contactsStr) {
            fw.append(info + "\n");
        }
        fw.close();
    }

    public ObservableList<Contact> readFile() throws FileNotFoundException {
        File f = new File("contacts.txt");
        Scanner s = new Scanner(f);
        ArrayList<String> contactsStr = new ArrayList<>();
        while (s.hasNext()) {
            String line = s.nextLine();
            contactsStr.add(line);
        }
        ArrayList<Contact> tempContacts = new ArrayList<>();
        for (int i = 0; i < contactsStr.size(); i+=3) {
            tempContacts.add(new Contact(contactsStr.get(i), contactsStr.get(i+1), contactsStr.get(i+2)));
        }
        return FXCollections.observableArrayList(tempContacts);
    }

}