package lk.ijse.spring.advicer;

import lk.ijse.spring.utill.StandardResponse;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppWideExceptionHandler {

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity handleException(RuntimeException ex){
        StandardResponse rs = new StandardResponse(500,"Error",ex.getMessage());
        return new ResponseEntity(rs, HttpStatus.OK);
    }

    @ExceptionHandler({StackOverflowError.class})
    public ResponseEntity handleStackOverFlowException(StackOverflowError error){
        StandardResponse rs = new StandardResponse(500,"Error",null);
        return new ResponseEntity(rs, HttpStatus.OK);
    }

    @ExceptionHandler({ConversionFailedException.class})
    public ResponseEntity handleStackOverFlowException(ConversionFailedException error){
        StandardResponse rs = new StandardResponse(500,"Error",null);
        return new ResponseEntity(rs, HttpStatus.OK);
    }
}
