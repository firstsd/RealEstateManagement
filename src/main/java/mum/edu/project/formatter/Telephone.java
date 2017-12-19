package mum.edu.project.formatter;

import java.io.Serializable;

public class Telephone implements Serializable {
    private static final long serialVersionUID = 145364L;

    private String areaCode;  //first 3
    private String frontNumber; // middle3
    private String lastNumber; //last 4
  
    
    public String getAreaCode() {
        return areaCode;
    }

    
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    
    public String getFrontNumber() {
        return frontNumber;
    }

    
    public void setFrontNumber(String frontNumber) {
        this.frontNumber = frontNumber;
    }

    
    public String getLastNumber() {
        return lastNumber;
    }

    
    public void setLastNumber(String lastNumber) {
        this.lastNumber = lastNumber;
    }

    public Telephone(String areaCode, String frontNumber,String lastNumber) {
        this.areaCode = areaCode;
        this.frontNumber = frontNumber;
        this.lastNumber = lastNumber;
    }
 
    public Telephone () {
     
    }
      
   
    
    @Override
    public String toString() {
    	return getAreaCode() + "-" + getFrontNumber() +"-"+getLastNumber()
    	;
    }

 
}
