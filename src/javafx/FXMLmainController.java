/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.net.URL;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Satyajeet
 */
public class FXMLmainController implements Initializable {

    /**
     * Initializes the controller class.
     */
    public void changeSceneButton1(ActionEvent event) throws Exception {
        Parent root;
        root = (Parent)FXMLLoader.load(getClass().getResource("FXMLadd.fxml"));
        Scene root1 = new Scene(root);
        Stage window = (Stage)((Parent)event.getSource()).getScene().getWindow();
        window.setScene(root1);
        window.show();
    }
    public void changeSceneButton2(ActionEvent event) throws Exception {
        Parent root;
        root = (Parent)FXMLLoader.load(getClass().getResource("FXMLres.fxml"));
        Scene root1 = new Scene(root);
        Stage window = (Stage)((Parent)event.getSource()).getScene().getWindow();
        window.setScene(root1);
        window.show();
    }
    public void changeSceneButton3(ActionEvent event) throws Exception {
        Parent root;
        root = (Parent)FXMLLoader.load(getClass().getResource("FXMLtoppers.fxml"));
        Scene root1 = new Scene(root);
        Stage window = (Stage)((Parent)event.getSource()).getScene().getWindow();
        window.setScene(root1);
        window.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    public static void main(String[] args)
    {
        launch(args);
    }
}
