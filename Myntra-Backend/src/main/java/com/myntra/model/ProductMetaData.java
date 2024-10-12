package com.myntra.model;

import lombok.Data;

@Data
public class ProductMetaData {
    private boolean plaSlot;
    private String plaReason;
    private int plaRank;
    private String adSource;
    private Object adsMeta;
    private String lmsMetadata;
}
