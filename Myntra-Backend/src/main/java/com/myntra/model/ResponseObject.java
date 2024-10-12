package com.myntra.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myntra.constants.enumHelper;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class ResponseObject implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = -4002496096878583919L;

    private String token;
    private Boolean success;
    private List<String> errors;
//    private ArrayList<ErrorData> detailErrors;
//    private List<MessageCodeEnum> messages;
    private Object object;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

}
