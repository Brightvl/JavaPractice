package unit_test.lesson5.hw5;

import java.util.ArrayList;
import java.util.List;

public class Contact {

    private String name;
    private String mail;
    private String number;

    public Contact(String name, String mail, String number) {
        this.name = name;
        this.mail = mail;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

