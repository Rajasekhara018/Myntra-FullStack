package com.myntra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestObject  implements Serializable {
    @JsonIgnore
    private static final long serialVersionUID = -4002496096878583919L;

    private String messageID;
    private String version;
    private String requestType;
    private Integer pageNo;
    private Integer pageSize;
    private String userData;
    private String token;
//    private SearchQuery searchQuery;
//    private TSortCard sort;
    private Object object;
    private Boolean downloadCSV;
    // This will be public key
    private String inqEncryptionKey;
    private boolean doesInputHaveEncryptedData;
    private String updEncryptionIndex;
    private String updEncryptionPubVal;
//    private ReportFileEnum fileEnum;


    public String getMessageID() {
        return messageID;
    }

    public String getVersion() {
        return version;
    }

    public String getRequestType() {
        return requestType;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public String getUserData() {
        return userData;
    }

    public String getToken() {
        return token;
    }

    public Object getObject() {
        return object;
    }

    public Boolean getDownloadCSV() {
        return downloadCSV;
    }

    public String getInqEncryptionKey() {
        return inqEncryptionKey;
    }

    public boolean isDoesInputHaveEncryptedData() {
        return doesInputHaveEncryptedData;
    }

    public String getUpdEncryptionIndex() {
        return updEncryptionIndex;
    }

    public String getUpdEncryptionPubVal() {
        return updEncryptionPubVal;
    }
}
