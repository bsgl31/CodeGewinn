/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package probekurzarbeit;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author bsigl
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnGo;
    @FXML
    private TextField btnCode;
    @FXML
    private Button btnDel;
    @FXML
    private ListView<Ticket> lstCodes;
    @FXML
    private Label lbPoints;
    @FXML
    private Label lbMessage;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lstCodes.setItems(FXCollections.observableList(new ArrayList<>()));
        
        lstCodes.getItems().addListener((ListChangeListener.Change<? extends Ticket> c) -> {
            List<Ticket> tickets = lstCodes.getItems();
            int sum = 0;
            for(Ticket t : tickets) {
                sum += t.getPoints();
            }
            lbPoints.setText(sum + "");
            if(sum == 21) {
                lbPoints.setStyle("-fx-text-fill: green;");
            } else if (sum < 21) {
                lbPoints.setStyle("-fx-text-fill: black;");
            } else {
                lbPoints.setStyle("-fx-text-fill: red;");
            }
        });
        
        btnGo.setOnAction((ActionEvent event) -> {
            String code = btnCode.getText();
            
            try {
                PunkteRechner.pruefeCode(code, lstCodes.getItems().size());
            } catch (PruefeException ex) {
                lbMessage.setText(ex.getMessage() + " " + new SimpleDateFormat("HH:mm 'Uhr'").format(ex.getTime()));
                return;
            }
            
            lstCodes.getItems().add(new Ticket(code));
            lbMessage.setText("Code eingefügt");
        });
        
        btnDel.setOnAction(e -> {
            lstCodes.getItems().clear();
            lbMessage.setText("Liste gelöscht");
        });
    }
    
}
