//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.drona.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.drona.entity.organisation.OrganisationImpl;

@Entity
@Table(name = "USERS")
public class UserImpl {

	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;

	@Column(name = "USER_NAME", length = 50, nullable = false)
	private String username;

	@Column(name = "PASSWORD", length = 50, nullable = false)
	private String password;

	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	private String firstname;

	@Column(name = "MIDDLE_NAME", length = 50)
	private String middlename;

	@Column(name = "LAST_NAME", length = 50)
	private String lastname;

	@Column(name = "GENDER", length = 1)
	private String gender;

	@Column(name = "EMAIL_ID", length = 50, nullable = false)
	private String emailId;

	@Column(name = "PHONE_NO", length = 15, nullable = false)
	private String phoneno;

	@Column(name = "SECURITY_QUESTION", length = 2)
	private Integer securityQuetion;

	@Column(name = "ANSWER", length = 50)
	private String answer;

	@Column(name = "USER_LOCALE", length = 1, nullable = false)
	private Integer userLocale;

	@Column(name = "STATUS", length = 1, nullable = false)
	private int status;

	@Embedded
	private AuditData auditData;

	public UserImpl() {
	}

	public UserImpl(Long userId, String username, String password,
			String firstname, String middlename, String lastname,
			String gender, String emailId, String phoneno,
			Integer securityQuetion, String answer, Integer userLocale,
			int status, AuditData auditData) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.gender = gender;
		this.emailId = emailId;
		this.phoneno = phoneno;
		this.securityQuetion = securityQuetion;
		this.answer = answer;
		this.userLocale = userLocale;
		this.status = status;
		this.auditData = auditData;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public Integer getSecurityQuetion() {
		return securityQuetion;
	}

	public void setSecurityQuetion(Integer securityQuetion) {
		this.securityQuetion = securityQuetion;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Integer getUserLocale() {
		return userLocale;
	}

	public void setUserLocale(Integer userLocale) {
		this.userLocale = userLocale;
	}

	public AuditData getAuditData() {
		return auditData;
	}

	public void setAuditData(AuditData auditData) {
		this.auditData = auditData;
	}

}
