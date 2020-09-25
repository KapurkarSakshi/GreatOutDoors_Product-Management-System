package com.capgemini.go.pms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product_master_table")
public class ProductMaster {


	@Id
	@Column(name="user_id")
	private String userId;
	@Column(name="password" , nullable=false)
	private String password;
	@Column(name="re_enter_password" , nullable=false)
	private String reEnterPassword;
	@Column(name="email" , nullable=false)
	private String email;
	@Column(name="phone_number" , nullable=false)
	private Long phoneNumber;
	
	
	
	public ProductMaster() {
		super();
	
	}


	public ProductMaster(String userId, String password, String reEnterPassword, String email, Long phoneNumber) {
		super();
		this.userId = userId;
		this.password = password;
		this.reEnterPassword = reEnterPassword;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getReEnterPassword() {
		return reEnterPassword;
	}


	public void setReEnterPassword(String reEnterPassword) {
		this.reEnterPassword = reEnterPassword;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime * result + ((reEnterPassword == null) ? 0 : reEnterPassword.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductMaster other = (ProductMaster) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (reEnterPassword == null) {
			if (other.reEnterPassword != null)
				return false;
		} else if (!reEnterPassword.equals(other.reEnterPassword))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "ProductMaster [userId=" + userId + ", password=" + password + ", reEnterPassword=" + reEnterPassword
				+ ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
	}
	
	

}
