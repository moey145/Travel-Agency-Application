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


public class DisplayFlightsController extends Controller<Flights>{
    @FXML private TableView<Flight> flightsTv;
    @FXML private TableColumn<Flight,String> airlineClm;
    @FXML private TableColumn<Flight,String> flightNoClm;
    @FXML private TableColumn<Flight,String> takeoffClm;
    @FXML private TableColumn<Flight,String> landingClm;
    @FXML private TableColumn<Flight,String> costClm;
    @FXML private TextField countryTf;

    @FXML private void initialize(){  
        flightsTv.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        if (countryTf != null){
            flightsTv.setItems(getFlights().getFilteredFlights(getCountry()));
            countryTf.textProperty().addListener((o,oldText,newText) -> 
            flightsTv.setItems(getFlights().getFilteredFlights(getCountry())));
            }
        }
    public final Flights getFlights(){
        return model;
    }


    private String getCountry(){
        return countryTf.getText();
    }

    @FXML private void handleExit(ActionEvent event) throws Exception{
        stage.close();
    }

}
