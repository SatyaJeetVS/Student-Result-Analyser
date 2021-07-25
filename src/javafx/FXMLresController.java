/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Satyajeet
 */
public class FXMLresController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private TableColumn<Student, Integer> colRoll;
    @FXML
    private TableColumn<Student, String> colName;
    @FXML
    private TableColumn<Student, Integer> colEccf;
    @FXML
    private TableColumn<Student, Integer> colDlda;
    @FXML
    private TableColumn<Student, Integer> colDs;
    @FXML
    private TableColumn<Student, Integer> colOopm;
    @FXML
    private TableColumn<Student, Integer> colDst;
    @FXML
    private TableColumn<Student, Integer> colAm3;
    @FXML
    private TableColumn<Student, Integer> colTotal;
    
    @FXML
    private TableView studentTable;
   
   

    
    
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
    public void initialize(URL url, ResourceBundle rb){
      
        try {
            
            colName.setCellValueFactory(cellData -> cellData.getValue().getStuName());
            colRoll.setCellValueFactory(cellData -> cellData.getValue().getStuRoll().asObject());
            colEccf.setCellValueFactory(cellData -> cellData.getValue().getStuEccf().asObject());
            colDlda.setCellValueFactory(cellData -> cellData.getValue().getStuDlda().asObject());
            colAm3.setCellValueFactory(cellData -> cellData.getValue().getStuAm3().asObject());
            colDst.setCellValueFactory(cellData -> cellData.getValue().getStuDst().asObject());
            colDs.setCellValueFactory(cellData -> cellData.getValue().getStuDs().asObject());
            colOopm.setCellValueFactory(cellData -> cellData.getValue().getStuOopm().asObject());
            colTotal.setCellValueFactory(cellData -> cellData.getValue().getStuTotal().asObject());
            ObservableList<Student> stulist = JavaFX.getAllRecords();
            populateTable(stulist);
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                throw ex;
            } catch (ClassNotFoundException | SQLException ex1) {
                Logger.getLogger(FXMLresController.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }

        
    }   
    
   

  
    public static ObservableList<Student> getStudentObj(ResultSet resSet) throws SQLException {
         
           int count=0,j=0,flag=0;
            try{
                
              
                ObservableList<Student> stulist = FXCollections.observableArrayList();
            
            while(resSet.next())
            {   
                
                Student stu = new Student();
              
                stu.setName(resSet.getString("name"));
                
                stu.setam3(resSet.getInt("am3"));
                 
                stu.setdst(resSet.getInt("dst"));
                
                stu.setoopm(resSet.getInt("oopm"));
                
                stu.setds(resSet.getInt("ds"));
                
                stu.seteccf(resSet.getInt("eccf"));
                
                stu.setdlda(resSet.getInt("dlda"));
                
                stu.settotal(resSet.getInt("total"));
                
                stu.setRoll(resSet.getInt("roll"));
                
                stulist.add(stu);
                int AM3 = resSet.getInt("am3");
               if(AM3<40){
                  count++;
                   j=1;    
                }
                int DST = resSet.getInt("dst");
                if(DST<40&&j==0){
                   count++;
                    j=1;
                }
               
                 int OOPM = resSet.getInt("oopm");
               if(OOPM<40&&j==0){
                    count++;
                    j=1;
                }
                
             int DS = resSet.getInt("ds");
               if(DS<40&&j==0){
                    count++;
                    j=1;
                }
                
              int ECCF = resSet.getInt("eccf");
                if(ECCF<40&&j==0){
                    count++;
                    j=1;
               }
          
               int DLDA = resSet.getInt("dlda");
               if(DLDA<40&&j==0){
                   count++;
                    j=1;
               }
               System.out.println(count);
               
            
}           
            //if(flag==0){
                   JOptionPane.showMessageDialog(null, "Number of students failed are : " +count);
                  
              //     flag = 1;
               //}
            return stulist;
    
            }catch(SQLException e){
                throw e;
            }
    
  
    }
    public static void main(String[] args)
    {   
        
        launch(args);
    }

    private void populateTable(ObservableList<Student> stulist) {
     
        
        studentTable.setItems(stulist);
    }
    
}
/*
  try {
             String sql = "select * from students";
             
             Connection connection = null;
             //Statement statement = null;
             
             connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mypbl","root","mysqlpass");
             if(connection!=null)
             {
                 System.out.println("toppers connected");
             }
             ResultSet resSet = connection .createStatement().executeQuery(sql);
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
             
             
             
             
             while(resSet.next())
             {
                 
                 String NAME = resSet.getString("name");
                 
                 
                 int AM3 = resSet.getInt("am3");
                 System.out.println(AM3);
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
           
         } catch (SQLException ex) {
             Logger.getLogger(FXMLtoppersController.class.getName()).log(Level.SEVERE, null, ex);
         }
            

*/