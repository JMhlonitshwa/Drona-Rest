//============================================================
//Copyright 2015, Drona, Inc. All rights reserved.
//============================================================
package com.settleUp.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author Vinayak Mumbai <vinayak.s.mumbai@gmail.com> Created on Dec 1, 2015
 */
@Entity
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;

	@ManyToOne	
	@JoinColumn(name = "payedBy_id")
	private User payedBy;

	private Long amount;

	@ManyToOne
	@JoinColumn(name = "groupId")
	private Group group;

	@OneToMany(mappedBy = "paymentId", cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	private List<PaymentUser> payedForUser = new ArrayList<PaymentUser>();
	
	private String note;

	public List<PaymentUser> getPayedForUser() {
		return payedForUser;
	}

	public void setPayedForUser(List<PaymentUser> payedForUser) {
		this.payedForUser = payedForUser;
	}

	public Payment() {
		super();
	}

	public Payment(Long paymentId, User payedBy, Long amount, Group groupId) {
		super();
		this.paymentId = paymentId;
		this.payedBy = payedBy;
		this.amount = amount;
		this.group = groupId;
	}

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public User getPayedBy() {
		return payedBy;
	}

	public void setPayedBy(User payedBy) {
		this.payedBy = payedBy;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group groupId) {
		this.group = groupId;
	}

}
