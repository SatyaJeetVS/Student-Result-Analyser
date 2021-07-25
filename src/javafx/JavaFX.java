/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;
 
import javafx.FXMLresController;
import java.sql.*;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static javafx.FXMLresController.getStudentObj;
import static javafx.FXMLtoppersController.getToppersObj;
//import static javafx.FXMLtoppersController.getToppersObj;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javax.naming.spi.DirStateFactory.Result;

/**
 *
 * @author Satyajeet
 */
public class JavaFX extends Application {

    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root;
        root = (Parent)FXMLLoader.load(getClass().getResource("FXMLmain.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        
        launch(args);
    }
    
    
    public static ObservableList<Student> getAllRecords()throws ClassNotFoundException, SQLException{
        String sql = "select * from students";
        
        Connection connection = null;
        //Statement statement = null;
        try {         
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mypbl","root","mysqlpass");
            if(connection!=null)
            {
                System.out.println("connected");
            }
            ResultSet resSet = connection .createStatement().executeQuery(sql);
            ObservableList<Student> stulist = getStudentObj(resSet);
            
            return stulist;
           
            
           
        }catch(Exception e){
            System.out.println("not connected");
            throw e;
        }finally{
                
        }
    }
    /**
     *
     * @return
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static ObservableList<Student> getAllToppers()throws ClassNotFoundException, SQLException{
        String sql = "select * from students";
        
        Connection connection = null;
        //Statement statement = null;
        try {         
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mypbl","root","mysqlpass");
            if(connection!=null)
            {
                System.out.println("connected");
            }
            ResultSet resSet = connection .createStatement().executeQuery(sql);
            ObservableList<Student> topperList =getToppersObj(resSet);
            
            return topperList;
           
            
           
        }catch(Exception e){
            System.out.println("not connected");
            throw e;
        }finally{
                
        }
        
    
    
  }
   
}

