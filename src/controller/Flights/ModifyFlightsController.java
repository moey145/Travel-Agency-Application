package controller.Flights;

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

public class ModifyFlightsController extends Controller<Flights>{

    @FXML private TextField airlineTf;
    @FXML private TextField flightnumberTf;
    @FXML private TextField takeoffTf;
    @FXML private TextField landingTf;
    @FXML private TextField costTf;
    @FXML private Button addflightBtn;
    @FXML private Button removeflightBtn;
    public final Flights getFlights(){
        return model;
    }
 

    @FXML private void initialize() {  
        if(addflightBtn != null){
        airlineTf.textProperty().addListener((o,oldText,newText) -> updateButtons());
        flightnumberTf.textProperty().addListener((o,oldText,newText) -> updateButtons());
        takeoffTf.textProperty().addListener((o,oldText,newText) -> updateButtons());
        landingTf.textProperty().addListener((o,oldText,newText) -> updateButtons());
        costTf.textProperty().addListener((o,oldText,newText) -> updateButtons());
        }
        else{
            takeoffTf.textProperty().addListener((o,oldText,newText) -> updateButtons());
            landingTf.textProperty().addListener((o,oldText,newText) -> updateButtons());
        }
    }
	private void updateButtons() {
        if(addflightBtn != null){
        addflightBtn.setDisable(!(isAirlineValid() && isTakeoffValid() && isLandingValid() && isCostValid() && isFlightNumberValid()));
        }
        else{
        removeflightBtn.setDisable(!(isTakeoffValid() && isLandingValid()));
        }
    }
	private boolean isAirlineValid() {return getAirline().length() >= 1;}	
    private boolean isFlightNumberValid(){return getFlightNumber().length() >= 1;}	
    private boolean isTakeoffValid() {return getTakeoff().length() >= 1;}	
    private boolean isLandingValid() { return getLanding().length() >= 1;}	
    private boolean isCostValid() {return getStringCost().length() >= 1;}
    private String getAirline() { return airlineTf.getText(); }
    private String getFlightNumber() { return flightnumberTf.getText(); }
    private String getTakeoff() { return takeoffTf.getText(); }
    private String getLanding() { return landingTf.getText(); }
    private String getStringCost() { return costTf.getText(); }


    private int getFlightNo(){
        return Integer.parseInt(flightnumberTf.getText());
    }
    private double getCost() {
		return Double.parseDouble(costTf.getText());
	}

    @FXML private void handleAddFlight(ActionEvent event) throws IOException{
        try{
    getFlights().addFlight(new Flight(airlineTf.getText(),getFlightNo(),takeoffTf.getText(),landingTf.getText(),getCost()));
    stage.close();
        }
        catch(NumberFormatException e){
            Stage stage = new Stage();
            ErrorModel number = new ErrorModel(e, "Enter a number"); 
            stage.getIcons().add(new Image("/image/error_icon.png"));
            ViewLoader.showStage(number, "/view/Error/ErrorView.fxml", "Error", stage);
        }
        catch(DuplicateItemException e){
            Stage stage = new Stage();
            ErrorModel duplicate = new ErrorModel(e, "This flight is a duplicate"); 
            stage.getIcons().add(new Image("/image/error_icon.png"));
            ViewLoader.showStage(duplicate, "/view/Error/ErrorView.fxml", "Error", stage);
        }
    }   
    @FXML private void handleRemoveFlight(ActionEvent event) throws IOException{
        try{
        getFlights().removeFlight(getFlights().getFlight(takeoffTf.getText(),landingTf.getText()));
        stage.close();
        }
        catch(ItemNotFoundException e){
            Stage stage = new Stage();
            ErrorModel item = new ErrorModel(e, "This flight has not been found"); 
            stage.getIcons().add(new Image("/image/error_icon.png")); 
            ViewLoader.showStage(item, "/view/Error/ErrorView.fxml", "Error", stage);
        }
   }

    @FXML private void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
}
