package controller.Destinations;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import model.*;
import model.Exceptions.*;
import au.edu.uts.ap.javafx.*;


public class ModifyDestinationsController extends Controller<Destinations>{
    @FXML private TextField nameTf;
    @FXML private TextField countryTf;
    @FXML private Button adddestinationBtn;
    @FXML private Button removedestinationBtn;

    @FXML private void initialize() {  
        nameTf.textProperty().addListener((o,oldText,newText) -> updateButtons());
        countryTf.textProperty().addListener((o,oldText,newText) -> updateButtons());
    }
    private void updateButtons() {
        if(adddestinationBtn != null){
        adddestinationBtn.setDisable(!(isNameValid() && isCountryValid()));
        }
        else{
        removedestinationBtn.setDisable(!(isNameValid() && isCountryValid()));
        }
    }
    private boolean isNameValid(){ return getName().length() >= 1;}
    private boolean isCountryValid(){return getCountry().length() >= 1;}
    private String getName(){return nameTf.getText();}
    private String getCountry(){return countryTf.getText();}
    public final Destinations getDestinations(){
        return model;
    }
    @FXML private void handleAddDestination(ActionEvent event) throws IOException{
        try{
        getDestinations().addDestination(new Destination(nameTf.getText(), countryTf.getText()));
        stage.close();
        }
        catch(DuplicateItemException e){
            Stage stage = new Stage();
            ErrorModel duplicate = new ErrorModel(e, "This destination already exists"); 
            stage.getIcons().add(new Image("/image/error_icon.png")); 
            ViewLoader.showStage(duplicate, "/view/Error/ErrorView.fxml", "Error", stage);
        }
    }   
    @FXML private void handleRemoveDestination(ActionEvent event) throws IOException{
        try{        
        getDestinations().removeDestination(getDestinations().destination(nameTf.getText(), countryTf.getText()));
        stage.close();
        }
        catch(ItemNotFoundException e){
            Stage stage = new Stage();
            ErrorModel item = new ErrorModel(e, "This destination has not been found"); 
            stage.getIcons().add(new Image("/image/error_icon.png")); 
            ViewLoader.showStage(item, "/view/Error/ErrorView.fxml", "Error", stage);
        }
    }   
    @FXML private void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }

}
