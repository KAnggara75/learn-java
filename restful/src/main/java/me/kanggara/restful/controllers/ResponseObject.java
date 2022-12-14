package me.kanggara.restful.controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class ResponseObject implements Serializable {
    private String status;
    private String message;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String[] code;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Serializable content;

    @JsonIgnore
    HttpStatus statusCode;

    public ResponseObject(HttpStatus statusCode, String status){
        this.statusCode = statusCode;
        this.status = status;
        this.message = "";
    }

    public ResponseObject(HttpStatus statusCode, String status, Serializable content){
        this.statusCode = statusCode;
        this.status = status;
        this.content = content;
        this.message = "";
    }

    public ResponseObject(HttpStatus statusCode, String status, String message){
        this.statusCode = statusCode;
        this.status = status;
        this.message = message;
    }

    public ResponseObject(HttpStatus statusCode, String status, String message, Serializable content){
        this.statusCode = statusCode;
        this.message = message;
        this.status = status;
        this.content = content;
    }

    public ResponseObject(HttpStatus statusCode, String status, String message, String[]code){
        this.statusCode = statusCode;
        this.message = message;
        this.status = status;
        this.code = code;
    }

    public ResponseObject(HttpStatus statusCode, String status, String message, String[]code, Serializable content){
        this.statusCode = statusCode;
        this.message = message;
        this.status = status;
        this.content = content;
        this.code = code;
    }

    public ResponseObject() {

    }
}