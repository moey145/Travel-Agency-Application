package controller;
import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import model.Exceptions.ErrorModel;
import model.Exceptions.InvalidCredentialsException;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import javax.swing.text.View;

import model.*;
import au.edu.uts.ap.javafx.*;


public class LoginController extends Controller<Agency>{

    @FXML private TextField usernameTf;
    @FXML private PasswordField passwordTf;
    @FXML private Button loginBtn;
    @FXML private Button exitBtn;
    public final Agency getAgency(){
        return model;
    }
	@FXML private void initialize() {
        usernameTf.textProperty().addListener((o,oldText,newText) -> updateButtons());
        passwordTf.textProperty().addListener((o,oldText,newText) -> updateButtons());
        // loginBtn.disableProperty().bind(Bindings.isEmpty(usernameTf.textProperty()).or(Bindings.isEmpty(passwordTf.textProperty())));

    }
    private void updateButtons(){
        loginBtn.setDisable(!(isUsernameValid() && isPasswordValid()));
    }
    private boolean isUsernameValid(){
        return getUsername().length() >= 1;
    }
    private boolean isPasswordValid(){
        return getPassword().length() >= 1;
    }
    private final String getUsername(){
        return usernameTf.getText();
    }
    private final String getPassword(){
        return passwordTf.getText();
    }

    @FXML private void handleLogin(ActionEvent event) throws IOException{
        String username = getUsername();
        String password = getPassword();
        try{
        if (getAgency().getAdministrators().hasAdministrator(username, password)){
                Administrator user = getAgency().getAdministrators().getAdministrator(username, password);
                getAgency().setLoggedInUser(user);
                stage.close();
                Stage stage = new Stage();
                stage.getIcons().add(new Image("/image/agency_icon.png"));
                ViewLoader.showStage(getAgency(),"/view/AgencyView.fxml","Prog2 Travel Agency",stage);
                }
        }
             catch (InvalidCredentialsException e) {
                Stage stage = new Stage();
                stage.getIcons().add(new Image("/image/error_icon.png"));
                ErrorModel cred = new ErrorModel(e, "Incorrect login details");
                ViewLoader.showStage(cred, "/view/Error/ErrorView.fxml", "Error", stage);
            }   
        }
    @FXML private void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }



    } 
