package com.myntra.model;

import lombok.Data;

@Data
public class CouponDescription {
    private String description;
    private String couponCode;
    private int bestPrice;
    private String bestPriceText;
    private TemplateInfo templateInfo;
}
