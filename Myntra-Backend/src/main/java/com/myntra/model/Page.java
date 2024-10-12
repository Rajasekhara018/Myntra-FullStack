package com.myntra.model;

import lombok.Data;

@Data
public class Page {

	private Integer pagesize;
	private Integer totalElements;
	private Integer totalPages;
	private Integer pageNo;
}
