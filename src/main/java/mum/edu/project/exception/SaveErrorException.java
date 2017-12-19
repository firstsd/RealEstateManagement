/*
 * Created on Nov 7, 2017
 */
package mum.edu.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason="error saving")
public class SaveErrorException extends RuntimeException{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String message;
    
    
    public String getMessage() {
        return message;
    }

    
    public void setMessage(String message) {
        this.message = message;
    }

    public SaveErrorException(String message) {
        this.message = message;
    }
    
}
