/**
 * Created by alexanderhughes on 2/16/16.
 */
package theironyard;

import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Contact {
    String name;
    String phone;
    String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }


    @Override
    public String toString() {
        return String.format("%s, %s, %s", name, phone, email);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
