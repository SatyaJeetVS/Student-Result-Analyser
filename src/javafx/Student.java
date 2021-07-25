/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafx;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Satyajeet
 */
public class Student {
    private IntegerProperty rollProp;
    private StringProperty nameProp;
    private IntegerProperty dsProp;
    private IntegerProperty eccfProp;
    private IntegerProperty dldaProp;
    private IntegerProperty oopmProp;
    private IntegerProperty am3Prop;
    private IntegerProperty dstProp;
    private IntegerProperty totalProp;
            
    
    private StringProperty topperECCF;
    private StringProperty topperDLDA;
    private StringProperty topperDS;
    private StringProperty topperOOPM;
    private StringProperty topperDST;
    private StringProperty topperAM3;
    private StringProperty topperTOTAL; 
    
    
    private IntegerProperty Am3Max;
    private IntegerProperty OopmMax;
    private IntegerProperty DsMax;
    private IntegerProperty DstMax;
    private IntegerProperty DldaMax;
    private IntegerProperty EccfMax;
    private IntegerProperty TotalMax;
          
    
    public Student(){
        this.am3Prop = new SimpleIntegerProperty();
        this.dsProp = new SimpleIntegerProperty();
        this.dldaProp = new SimpleIntegerProperty();
        this.eccfProp = new SimpleIntegerProperty();
        this.dstProp = new SimpleIntegerProperty();
        this.totalProp = new SimpleIntegerProperty();
        this.oopmProp = new SimpleIntegerProperty();
        this.rollProp = new SimpleIntegerProperty();
        this.nameProp = new SimpleStringProperty(); 
        
        this.Am3Max = new SimpleIntegerProperty();
        this.DstMax = new SimpleIntegerProperty();
        this.OopmMax = new SimpleIntegerProperty();
        this.DsMax = new SimpleIntegerProperty();
        this.DldaMax = new SimpleIntegerProperty();
        this.EccfMax = new SimpleIntegerProperty();
        this.TotalMax = new SimpleIntegerProperty();
         
        this.topperDST = new SimpleStringProperty();
        this.topperAM3 = new SimpleStringProperty();
        this.topperOOPM = new SimpleStringProperty();
        this.topperDS = new SimpleStringProperty();
        this.topperDLDA = new SimpleStringProperty();
        this.topperECCF = new SimpleStringProperty();
        this.topperTOTAL = new SimpleStringProperty();
    
    }
    
    
    
    
    
    public String getTopperDST(){
        return topperDST.get();
    }
    public String getTopperAM3(){
        return topperAM3.get();
    }
    public String getTopperECCF(){
        return topperECCF.get();
    }
    public String getTopperDLDA(){
        return topperDLDA.get();
    }
    public String getTopperOOPM(){
        return topperOOPM.get();
    }
    public String getTopperDS(){
        return topperDS.get();
    }
    public String getTotal(){
        return topperTOTAL.get();
    }
    public String getName(){
        return nameProp.get();
    }
    
    
    
    
    public int getRoll(){
        return rollProp.get();   
    }
    public int getam3(){
        return am3Prop.get();
    }
    public int getds(){
        return dsProp.get();
    }
    public int getoopm(){
        return oopmProp.get();
    }    
    public int getdlda(){
        return dldaProp.get();
    }
    public int geteccf(){
        return eccfProp.get();
    }
    public int getdst(){
        return dstProp.get();
    }
    public int gettotal(){
        return totalProp.get();
    }
    
    
    
    
    
    
    public StringProperty getStuName(){
    return nameProp;
    }   
    public IntegerProperty getStuRoll(){
    return rollProp;
    }
    public IntegerProperty getStuEccf(){
    return eccfProp;
    }   
    public IntegerProperty getStuDlda(){
    return dldaProp;
    }  
    public IntegerProperty getStuOopm(){
    return oopmProp;
    }  
    public IntegerProperty getStuDs(){
    return dsProp;
    }  
    public IntegerProperty getStuAm3(){
    return am3Prop;
    }  
    public IntegerProperty getStuDst(){
    return dstProp;
    }  
    public IntegerProperty getStuTotal(){
    return totalProp;
    }
    public IntegerProperty getAm3Max(){
    return Am3Max;
    }
    public IntegerProperty getDstMax(){
    return DstMax;
    }
    public IntegerProperty getOopmMax(){
    return OopmMax;
    }
    public IntegerProperty getDsMax(){
    return DsMax;
    }
    public IntegerProperty getDldaMax(){
    return DldaMax;
    }
    public IntegerProperty getEccfMax(){
    return EccfMax;
    }
    public IntegerProperty getTotalMax(){
    return TotalMax;
    }
    public StringProperty gettopperAM3(){
    return topperAM3;
    }public StringProperty gettopperDST(){
    return topperDST;
    }public StringProperty gettopperDLDA(){
    return topperDLDA;
    }public StringProperty gettopperDS(){
    return topperDS;
    }public StringProperty gettopperOOPM(){
    return topperOOPM;
    }public StringProperty gettopperECCF(){
    return topperECCF;
    }public StringProperty gettopperTOTAL(){
    return topperTOTAL;
    }
       
    
    
    public void setName(String name){
        this.nameProp.set(name);
    }
    public void setRoll(int roll)
    {
        this.rollProp.set(roll);
    }
    public void setam3(int am3){
        this.am3Prop.set(am3);
    }
    public void setds(int ds){
        this.dsProp.set(ds);
    }
    public void setoopm(int oopm){
        this.oopmProp.set(oopm);
    }    
    public void setdlda(int dlda){
        this.dldaProp.set(dlda);
    }
    public void seteccf(int eccf){
        this.eccfProp.set(eccf);
    }
    public void setdst(int dst){
        this.dstProp.set(dst);
    }
    public void settotal(int total){
        this.totalProp.set(total);
    }
    public void setam3max(int am3){
       this.Am3Max.set(am3);
    }
    public void setdstmax(int dst){
        this.DstMax.set(dst);
    }
    public void setoopmmax(int oopm){
        this.OopmMax.set(oopm);
    }
    public void setdsmax(int ds){
        this.DsMax.set(ds);
    }
    public void setdldamax(int dlda){
        this.DldaMax.set(dlda);
    }
    public void seteccfmax(int eccf){
        this.EccfMax.set(eccf);
    }
    public void settotalmax(int total){
        this.TotalMax.set(total);
    }
    public void setTOTALtopper(String name){
        this.topperTOTAL.set(name);
    }
    public void setDLDAtopper(String name){
        this.topperDLDA.set(name);
    }
    public void setECCFtopper(String name){
        this.topperECCF.set(name);
    }
    public void setDStopper(String name){
        this.topperDS.set(name);
    }
    public void setOOPMtopper(String name){
        this.topperOOPM.set(name);
    }
    public void setAM3topper(String name){
        this.topperAM3.set(name);
    }
    public void setDSTtopper(String name){
        this.topperDST.set(name);
    }
    
    
    
    
    
    }   
   
    
    
        
