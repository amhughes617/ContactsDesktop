package theironyard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ObservableList<Contact> contacts = FXCollections.observableArrayList();//creates new arraylist observable thingy

    @FXML       //connects it to interface
    ListView list;

    @FXML
    TextField textName;
    @FXML
    TextField textPhone;
    @FXML
    TextField textEmail;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        list.setItems(contacts);
    }

    public void addContact() {
        if (!textName.getText().isEmpty() && !textPhone.getText().isEmpty() && !textEmail.getText().isEmpty()) {
            contacts.add(new Contact(textName.getText(), textPhone.getText(), textEmail.getText()));
        }
        textName.setText("");
        textPhone.setText("");
        textEmail.setText("");
    }

    public void removeContact() {
        Contact contact = (Contact) list.getSelectionModel().getSelectedItem();
        contacts.remove(contact);
    }

}