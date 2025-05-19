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

public class DisplayDestinationsController extends Controller<Destinations> {
    @FXML private TableView<Destination> destinationsTv;
    @FXML private TableColumn<Destination,String> nameClm;
    @FXML private TableColumn<Destination,String> countryClm;
    @FXML private TextField countryTf;

    public final Destinations getDestinations(){
        return model;
    }

    @FXML private void initialize(){  
        destinationsTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        if (countryTf != null){
            destinationsTv.setItems(getDestinations().getFilteredDestinations(getCountry()));
            countryTf.textProperty().addListener((o,oldText,newText) -> 
            destinationsTv.setItems(getDestinations().getFilteredDestinations(getCountry())));
            }
        }
    
    private String getCountry(){
        return countryTf.getText();
    }

    @FXML private void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }
    
}
