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
import au.edu.uts.ap.javafx.*;


public class ExploreFlightsController extends Controller<Agency>{
    @FXML private Button viewallflightsBtn;
    @FXML private Button filteredflightsBtn;
    @FXML private Button addflightBtn;
    @FXML private Button removeflightBtn;
    @FXML private Button exitBtn;   

    public final Agency getAgency(){
        return model;
    }
    @FXML private void handleViewAllFlights(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/image/flights_icon.png"));
        ViewLoader.showStage(getAgency().getFlights(),"/view/Flights/DisplayFlightsView.fxml","Display Flights",stage);

    }   
    @FXML private void handleFilteredFlights(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/image/flights_icon.png"));
        ViewLoader.showStage(getAgency().getFlights(),"/view/Flights/DisplayFilteredFlightsView.fxml","Display Flights Filtered",stage);
    }  
    @FXML private void handleAddFlight(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/image/flights_icon.png"));
        ViewLoader.showStage(getAgency().getFlights(),"/view/Flights/AddFlightView.fxml","Add Flight",stage);
    }   
    @FXML private void handleRemoveFlight(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/image/flights_icon.png"));
        ViewLoader.showStage(getAgency().getFlights(),"/view/Flights/RemoveFlightView.fxml","Remove Flight",stage);
    }   
    @FXML private void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
}
