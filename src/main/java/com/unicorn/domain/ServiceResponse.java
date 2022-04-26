package com.unicorn.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ServiceResponse<T> {

    public ServiceResponse(){

    }

    public ServiceResponse(T body){
        this.body = body;
    }

    public ServiceResponse(String status,T body){
        this.status = status;
        this.body = body;
    }

    public ServiceResponse(String error){
        this.error = error;
    }

    private T body;

    private String status;

    private String error;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }
}
