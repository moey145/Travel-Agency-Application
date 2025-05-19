package controller;
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
import au.edu.uts.ap.javafx.*;

public class AgencyController extends Controller<Agency>{
    @FXML private Button ExploreFlightsBtn;
    @FXML private Button ExploreDestinationsBtn;
    @FXML private Button BookATripBtn;
    @FXML private Button exitBtn;

    public final Agency getAgency(){
        return model;
    }
    @FXML private void handleExploreFlights(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/image/flights_icon.png"));
        ViewLoader.showStage(getAgency(),"/view/Flights/ExploreFlightsView.fxml","Explore Flights",stage);
    }
 
    @FXML private void handleExploreDestinations(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/image/destinations_icon.png"));
        ViewLoader.showStage(getAgency(),"/view/Destinations/ExploreDestinationsView.fxml","Explore Destinations",stage);
    }
    @FXML private void handleBookATrip(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/image/trip_icon.png"));
        Trip trip = new Trip(model);
        ViewLoader.showStage(trip,"/view/Trip/BookTripView.fxml","Book a Trip",stage);
    }
    @FXML private void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
}
