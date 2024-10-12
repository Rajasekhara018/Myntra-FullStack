package com.myntra.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value="Myntra-men-jackets")
@Data
public class MenJackets {
	@Id
	private String id;
    private String landingPageUrl;
    private boolean loyaltyPointsEnabled;
    private String adId;
    private boolean isPLA;
    private long productId;
    private String product;
    private String productName;
    private double rating;
    private int ratingCount;
//    private boolean isFastFashion;
//    private int futureDiscountedPrice;
//    private String futureDiscountStartDate;
    private int discount;
    private String brand;
    private String searchImage;
//    private double effectiveDiscountPercentageAfterTax;
//    private int effectiveDiscountAmountAfterTax;
//    private int buyButtonWinnerSkuId;
//    private int buyButtonWinnerSellerPartnerId;
//    private int relatedStylesCount;
//    private String relatedStylesType;
    private List<ProductVideo> productVideos;
    private List<InventoryInfo> inventoryInfo;
    private String sizes;
    private List<ProductImages> images;
    private String gender;
    private String primaryColour;
    private String discountLabel;
    private String discountDisplayLabel;
    private String additionalInfo;
    private String category;
    private int mrp;
    private int price;
//    private String advanceOrderTag;
//    private boolean colorVariantAvailable;
//    private String productimagetag;
//    private int listViews;
    private String discountType;
//    private String tdBxGyText;
//    private String catalogDate;
    private String season;
    private String year;
//    private boolean isPersonalised;
//    private String eorsPicksTag;
    private String personalizedCoupon;
    private int personalizedCouponValue;
    private String productMeta;
//    private String preferredDeliveryTag;
//    private String deliveryPromise;
    private CouponData couponData;
    private ProductMetaData productMetaData;
//    private MyntraArticleType articleType;
//    private MyntraSubCategory subCategory;
//    private MyntraMasterCategory masterCategory;
//    private boolean hasMultipleSizes;
//    private int relatedColoursCount;
    private String brandLogo;
}
