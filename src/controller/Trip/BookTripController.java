package controller.Trip;

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
import model.Exceptions.DuplicateItemException;
import model.Exceptions.ErrorModel;
import model.Exceptions.InsufficientDestinationsException;
import au.edu.uts.ap.javafx.*;


public class BookTripController extends Controller<Trip>{
    @FXML private Button adddestinationBtn;
    @FXML private Button removedestinationBtn;
    @FXML private Button addconnectingflightsBtn;
    @FXML private Button removeflightBtn;
    @FXML private Button viewtripBtn;
    
    public final Trip getTrip(){
        return model;
    }
    @FXML private void handleAddDestination(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/image/destinations_icon.png"));
        ViewLoader.showStage(getTrip().getDestinations(),"/view/Destinations/AddDestinationView.fxml","Add Destination",stage);
    }   
    @FXML private void handleRemoveDestination(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/image/destinations_icon.png"));
        ViewLoader.showStage(getTrip().getDestinations(),"/view/Destinations/RemoveDestinationView.fxml","Remove Destination",stage);
    }  
    @FXML private void handleAddConnectingFlights(ActionEvent event) throws IOException{
         try{
          getTrip().addConnectingFlights();
         }
         catch(DuplicateItemException e){
            Stage stage = new Stage();
            ErrorModel duplicate = new ErrorModel(e, "There is a duplicate amount of destinations"); 
            stage.getIcons().add(new Image("/image/error_icon.png"));
            ViewLoader.showStage(duplicate, "/view/Error/ErrorView.fxml", "Error", stage);
         }
         catch(InsufficientDestinationsException e){
            Stage stage = new Stage();
            ErrorModel insufficient = new ErrorModel(e, "There is an insufficient amount of destinations"); 
            stage.getIcons().add(new Image("/image/error_icon.png"));
            ViewLoader.showStage(insufficient, "/view/Error/ErrorView.fxml", "Error", stage);
         }
    }   
    @FXML private void handleViewTrip(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/image/trip_icon.png"));
        getTrip().getItinery();
        ViewLoader.showStage(getTrip(),"/view/Trip/DisplayTripView.fxml","Display Trip",stage);
    }   
    @FXML private void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
}

