/*
 * Created on Nov 17, 2017
 */
package mum.edu.project.model.dto;

import java.io.Serializable;

public class SearchPropertyDto implements Serializable  {
     
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String textSearch;
    private String purpose;
    private String type;
    
    public String getTextSearch() {
        return textSearch;
    }
    
    public void setTextSearch(String textSearch) {
        this.textSearch = textSearch;
    }
    
    public String getPurpose() {
        return purpose;
    }
    
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
    
    public String getType() {
        return type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
}
