package com.myntra.model;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

//import com.fasterxml.jackson.annotation.JsonFormat;
//@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
@Data
public class UserSearchCriteria implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7537280530603171306L;
	
	private String firstName;
	private String lastName;
    private String userName;
    private String email;
    private String dob;
    private String gender;
	private Integer noOfPages;
//	private Integer reqPageNo;
//	private Integer reqRecordsPerPage;
	private Integer pageNo;
	private Integer pageSize;
}
