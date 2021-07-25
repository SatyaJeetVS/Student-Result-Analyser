/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import javafx.JavaFX;
/**
 * FXML Controller class
 *
 * @author Satyajeet
 */
public class FXMLaddController extends JavaFX implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    

    @FXML
    private TextField SNAME;

    @FXML
    private TextField AM3M;

    @FXML
    private TextField DSTM;

    @FXML
    private TextField DLDAM;

    @FXML
    private TextField DSM;

    @FXML
    private TextField ECCFM;

    @FXML
    private TextField OOPMM;

    @FXML
    private TextField ROLL;
        Connection connection = null;
        public void InsertButton(ActionEvent event) throws SQLException {
            
            
            try {
                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mypbl","root","mysqlpass");
                Statement stmt = connection.createStatement();
                String sql = "INSERT INTO `mypbl`.`students` (`name`, `roll`, `eccf`, `dlda`, `dst`, `am3`, `oopm`, `ds`) VALUES ('"+SNAME.getText()+"','"+ROLL.getText()+"','"+ECCFM.getText()+"','"+DLDAM.getText()+"','"+DSTM.getText()+"','"+AM3M.getText()+"','"+OOPMM.getText()+"','"+DSM.getText()+"')";
                int am3 = Integer.parseInt(AM3M.getText());
                int dst = Integer.parseInt(DSTM.getText());
                int oopm = Integer.parseInt(OOPMM.getText());
                int ds = Integer.parseInt(DSM.getText());
                int eccf = Integer.parseInt(ECCFM.getText());
                int dlda = Integer.parseInt(DLDAM.getText());
                
                try{
                if(am3<0||am3>100||dst<0||dst>100||oopm<0||oopm>100||ds<0||ds>100||eccf<0||eccf>100||dlda<0||dlda>100)
                {  JOptionPane.showMessageDialog(null,"Please Enter marks between 0 and 100");
                
                
                }
                else{
                    stmt.executeUpdate(sql); 
                    JOptionPane.showMessageDialog(null,"Inserted");
                }
                }catch(Exception e)
                {
                    throw e;
                }
                
   
                }catch(SQLException e){
                    throw e;
                }
                
        }


    
    public void changeSceneButton(ActionEvent event) throws Exception {
        Parent root;
        root = (Parent)FXMLLoader.load(getClass().getResource("FXMLmain.fxml"));
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
