package com.myntra.model;

import lombok.Data;

@Data
public class CouponData {
    private int couponDiscount;
    private String endDate;
    private String tagLink;
    private CouponDescription couponDescription;
}
