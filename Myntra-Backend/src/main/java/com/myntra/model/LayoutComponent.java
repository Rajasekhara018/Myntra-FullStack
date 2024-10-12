package com.myntra.model;

import java.util.List;

import lombok.Data;
@Data
public class LayoutComponent {
	private String type;
    private LayoutComponentProps props;
    private List<BannerComponent> children;
}
