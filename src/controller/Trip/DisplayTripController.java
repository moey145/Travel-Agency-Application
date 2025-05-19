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
import java.util.InputMismatchException;

import model.*;
import model.Exceptions.ErrorModel;
import au.edu.uts.ap.javafx.*;

public class DisplayTripController extends Controller<Trip> {
    @FXML private ListView<Itinery> tripsLv;

    public Trip getTrips(){
        return model;
    }

    @FXML private void initialize(){
        tripsLv.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        tripsLv.setItems(getTrips().getItinery());
    }

    private ObservableList<Itinery> getSelectedItinery(){
        return tripsLv.getSelectionModel().getSelectedItems();
    }
    @FXML private void handleViewIndividual(ActionEvent event) throws IOException{
            try{
            if(getTrips().getFlights().getFlights().containsAll(getSelectedItinery())){
                Stage stage = new Stage();
                stage.getIcons().add(new Image("/image/flights_icon.png"));
                ViewLoader.showStage(new Flights(getSelectedItinery()),"/view/Flights/DisplayFlightsView.fxml","Display Flights",stage);
            }
            else {
                Stage stage = new Stage();
                stage.getIcons().add(new Image("/image/destinations_icon.png"));
                ViewLoader.showStage(new Destinations(getSelectedItinery()),"/view/Destinations/DisplayDestinationsView.fxml","Display Destinations",stage);
            }
            }
            catch(ClassCastException e){
                Stage stage = new Stage();
                ErrorModel number = new ErrorModel(new NumberFormatException(), "A destination and flight cannot be displayed at the same time"); 
                stage.getIcons().add(new Image("/image/error_icon.png"));
                ViewLoader.showStage(number, "/view/Error/ErrorView.fxml", "Error", stage);
            }

        }


    @FXML private void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
}
