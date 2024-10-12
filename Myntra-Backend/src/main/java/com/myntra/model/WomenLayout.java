package com.myntra.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(value="Myntra-women")
@Data
public class WomenLayout {
	@Id
	private String id;
    private String type;
    private LayoutProps props;
    private List<LayoutComponent> children;
}
