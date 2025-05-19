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
import au.edu.uts.ap.javafx.*;
public class ExploreDestinationsController extends Controller<Agency>{
    @FXML private Button viewalldestinationsBtn;
    @FXML private Button filtereddestinationsBtn;
    @FXML private Button adddestinationBtn;
    @FXML private Button removedestinationBtn;
    @FXML private Button exitBtn;

    public final Agency getAgency(){
        return model;
    }
    @FXML private void handleViewAllDestinations(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/image/destinations_icon.png"));
        ViewLoader.showStage(getAgency().getDestinations(),"/view/Destinations/DisplayDestinationsView.fxml","Display Destinations",stage);
    }   
    @FXML private void handleFilteredDestinations(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/image/destinations_icon.png"));
        ViewLoader.showStage(getAgency().getDestinations(),"/view/Destinations/DisplayFilteredDestinationsView.fxml","Display Destinations Filtered",stage);
    }  
    @FXML private void handleAddDestination(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/image/destinations_icon.png"));
        ViewLoader.showStage(getAgency().getDestinations(),"/view/Destinations/AddDestinationView.fxml","Add Destination",stage);
    }   
    @FXML private void handleRemoveDestination(ActionEvent event) throws Exception{
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/image/destinations_icon.png"));
        ViewLoader.showStage(getAgency().getDestinations(),"/view/Destinations/RemoveDestinationView.fxml","Remove Destination",stage);
        
    }   
    @FXML private void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
   
}
