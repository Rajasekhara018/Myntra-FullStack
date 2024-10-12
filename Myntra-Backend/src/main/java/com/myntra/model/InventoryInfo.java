package com.myntra.model;

import lombok.Data;

@Data
public class InventoryInfo {
    private int skuId;
    private String label;
    private int inventory;
    private boolean available;
    private String brandSizeLabel;
}
