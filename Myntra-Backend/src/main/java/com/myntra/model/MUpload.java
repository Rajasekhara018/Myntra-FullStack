package com.myntra.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myntra.constants.enumHelper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Field;

import java.beans.Transient;
import java.io.Serializable;

@Data
public class MUpload implements Serializable {

    @JsonIgnore
    private static final long serialVersionUID = -1776250395676463050L;

    @Field("i1")
    private String name;

    @Field("i2")
    private String fileType;

    @Field("i3")
    @JsonIgnore
    private long size;

    @Field("i4")
    private String location;

    @Field("i5")
    private String title;

    @Field("i6")
    private String prefixFolder;

//    @Transient
    private String base64EncodedData;

    @Field("i8")
    private String modelKey;

    @Field("i9")
    private enumHelper.FileRetentionPolicyEnum retentionPolicy;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrefixFolder() {
        return prefixFolder;
    }

    public void setPrefixFolder(String prefixFolder) {
        this.prefixFolder = prefixFolder;
    }

    public String getBase64EncodedData() {
        return base64EncodedData;
    }

    public void setBase64EncodedData(String base64EncodedData) {
        this.base64EncodedData = base64EncodedData;
    }

    public String getModelKey() {
        return modelKey;
    }

    public void setModelKey(String modelKey) {
        this.modelKey = modelKey;
    }

    public enumHelper.FileRetentionPolicyEnum getRetentionPolicy() {
        return retentionPolicy;
    }

    public void setRetentionPolicy(enumHelper.FileRetentionPolicyEnum retentionPolicy) {
        this.retentionPolicy = retentionPolicy;
    }
}
