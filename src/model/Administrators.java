package model;

import javafx.collections.*;
import model.Exceptions.*;

public class Administrators {
    ObservableList<Administrator> administrators;

    public Administrators() {
        administrators = FXCollections.<Administrator>observableArrayList();
    }

    public ObservableList<Administrator> getAdministrators() {
        return this.administrators;
    }

    public boolean hasAdministrator(String username, String password) throws InvalidCredentialsException {
        for (Administrator a : this.administrators) {
            if (a.getLogin().equals(username) && a.getPassword().equals(password)) { return true; }
        }
        throw new InvalidCredentialsException();
    }

    public Administrator getAdministrator(String username, String password) throws InvalidCredentialsException {
        for (Administrator a : this.administrators) {
            if (a.getLogin().equals(username) && a.getPassword().equals(password)) { return a; }
        }
        throw new InvalidCredentialsException();
    }

    //add way more
    public void insertDummyData() {
        administrators.add(new Administrator("Mohamad", "Mohamad", "password"));
        administrators.add(new Administrator("test", "test", "test"));

    }
}
