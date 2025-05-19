package controller.Error;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import model.*;
import model.Exceptions.ErrorModel;
import au.edu.uts.ap.javafx.*;

public class ErrorController extends Controller<ErrorModel>{
    
    public final ErrorModel getException(){
        return model;
    } 
    public String getName(){
        return getException().getException().getClass().getSimpleName();
    }
    
    @FXML private void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
}
