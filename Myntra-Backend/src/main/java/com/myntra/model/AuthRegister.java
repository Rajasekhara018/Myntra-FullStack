package com.myntra.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value = "Register")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRegister implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2069819749508760843L;
	
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String userName;
	private String email;
	private long phoneNo;
	private String gender;
	private String password;
	private LocalDate dob;
	private List<AuthRegister> searcheusers;

	public void setId(String id) {
		this.id = id;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public void setSearcheusers(List<AuthRegister> searcheusers) {
		this.searcheusers = searcheusers;
	}

	public String getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getUserName() {
		return userName;
	}

	public String getEmail() {
		return email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public String getGender() {
		return gender;
	}

	public String getPassword() {
		return password;
	}

	public LocalDate getDob() {
		return dob;
	}

	public List<AuthRegister> getSearcheusers() {
		return searcheusers;
	}
}
