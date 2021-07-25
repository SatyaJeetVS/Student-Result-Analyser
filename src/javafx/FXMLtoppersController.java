/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import javafx.Student;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.StringCharacterIterator;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Satyajeet
 */
public class FXMLtoppersController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Student> topperNames;

    @FXML
    private TableColumn<Student,String> topperN;

    @FXML
    private TableColumn<Student, String> topperAm3N;

    @FXML
    private TableColumn<Student,String> topperDstN;

    @FXML
    private TableColumn<Student, String> topperEccfN;

    @FXML
    private TableColumn<Student,String> topperDldaN;

    @FXML
    private TableColumn<Student, String> topperOopmN;

    @FXML
    private TableColumn<Student, String> topperDsN;

    @FXML
    private TableView<Student> topperNames1;

    @FXML
    private TableColumn<Student, Integer> topperN1;

    @FXML
    private TableColumn<Student, Integer> topperAm3N1;

    @FXML
    private TableColumn<Student, Integer> topperDstN1;

    @FXML
    private TableColumn<Student, Integer> topperEccfN1;

    @FXML
    private TableColumn<Student, Integer> topperDldaN1;

    @FXML
    private TableColumn<Student, Integer> topperOopmN1;

    @FXML
    private TableColumn<Student, Integer> topperDsN1;


    
    public void changeSceneButton(ActionEvent event) throws Exception {
        Parent root;
        root = (Parent)FXMLLoader.load(getClass().getResource("FXMLmain.fxml"));
        Scene root1 = new Scene(root);
        Stage window = (Stage)((Parent)event.getSource()).getScene().getWindow();
        window.setScene(root1);
        window.show();
    }
    @FXML
            
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
           
       try {
            
            topperN.setCellValueFactory(cellData -> cellData.getValue().gettopperTOTAL());
            topperEccfN.setCellValueFactory(cellData -> cellData.getValue().gettopperECCF());
            topperDldaN.setCellValueFactory(cellData -> cellData.getValue().gettopperDLDA());
            topperAm3N.setCellValueFactory(cellData -> cellData.getValue().gettopperAM3());
            topperDstN.setCellValueFactory(cellData -> cellData.getValue().gettopperDST());
            topperOopmN.setCellValueFactory(cellData -> cellData.getValue().gettopperOOPM());
            topperDsN.setCellValueFactory(cellData -> cellData.getValue().gettopperDS());
            
            topperN1.setCellValueFactory(cellData -> cellData.getValue().getTotalMax().asObject());
            topperEccfN1.setCellValueFactory(cellData -> cellData.getValue().getEccfMax().asObject());
            topperDldaN1.setCellValueFactory(cellData -> cellData.getValue().getDldaMax().asObject());
            topperAm3N1.setCellValueFactory(cellData -> cellData.getValue().getAm3Max().asObject());
            topperDstN1.setCellValueFactory(cellData -> cellData.getValue().getDstMax().asObject());
            topperOopmN1.setCellValueFactory(cellData -> cellData.getValue().getOopmMax().asObject());
            topperDsN1.setCellValueFactory(cellData -> cellData.getValue().getDsMax().asObject());
            ObservableList<Student> topperList = JavaFX.getAllToppers();
            populateTable(topperList);
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                throw ex;
            } catch (ClassNotFoundException | SQLException ex1) {
                Logger.getLogger(FXMLresController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }


    }  
     public static ObservableList<Student> getToppersObj(ResultSet resSet) throws SQLException {
         
         
            try{
                
              
                ObservableList<Student> topperList = FXCollections.observableArrayList();
            int OopmMax=0;
             int DsMax=0;
             int EccfMax=0;
             int DldaMax=0;
             int DstMax=0 ;
             int Am3Max=0;
             int TotalMax=0;
             String topperOOPM = null;
             String topperDS = null;
             String topperECCF = null;
             String topperDLDA = null;
             String topperDST = null;
             String topperAM3 = null;
             String topperTOTAL = null;
            Student topper = new Student();
             while(resSet.next())
            {   
                
                
              int AM3 = resSet.getInt("am3");
                 String NAME = resSet.getString("name");
                 if(AM3 > Am3Max){
                     Am3Max = AM3;
                     topperAM3 = NAME;
                     
                 }
                 int DST = resSet.getInt("dst");
                 if(DST > DstMax){
                     DstMax = DST;
                     topperDST = NAME;
                 }
                 
                 int OOPM = resSet.getInt("oopm");
                 if(OOPM > OopmMax){
                     OopmMax = OOPM;
                     topperOOPM = NAME;
                 }
                 
                 int DS = resSet.getInt("ds");
                 if(DS > DsMax){
                     DsMax = DS;
                     topperDS = NAME;
                 }
                 
                 int ECCF = resSet.getInt("eccf");
                 if(ECCF > EccfMax){
                     EccfMax = ECCF;
                     topperECCF = NAME;
                 }
                 
                 int DLDA = resSet.getInt("dlda");
                 if(DLDA > DldaMax){
                     DldaMax = DLDA;
                     topperDLDA = NAME;
                 }
                 
                 int TOTAL = resSet.getInt("total");
                 
                 if(TOTAL > TotalMax){
                     TotalMax = TOTAL;
                     topperTOTAL = NAME;
                 }
          
               
             }
             topper.setam3max(Am3Max);
             topper.setdstmax(DstMax);
             topper.setoopmmax(OopmMax);
             topper.setdsmax(DsMax);
             topper.seteccfmax(EccfMax);
             topper.setdldamax(DldaMax);
             topper.settotalmax(TotalMax);
             
             topper.setAM3topper(topperAM3);
             topper.setDSTtopper(topperDST);
             topper.setOOPMtopper(topperOOPM);
             topper.setDStopper(topperDS);
             topper.setDLDAtopper(topperDLDA);
             topper.setECCFtopper(topperECCF);
             topper.setTOTALtopper(topperTOTAL);
             topperList.add(topper);
             
            return topperList;
    
            }catch(SQLException e){
                throw e;
            }
    
  
    }
    
    @FXML
 
    
    public static void main(String[] args)
    {
       
        launch(args);
    }
    
    private void populateTable(ObservableList<Student> topperList) {
     
        
        topperNames.setItems(topperList);
        topperNames1.setItems(topperList);
    }
}
