package com.settleUp.requestResponse;

public class PaymentDTO {
	private Long paymentId;
	private String note;
	private Long amount;
	private UsersDTO payedBy;

	public Long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public UsersDTO getPayedBy() {
		return payedBy;
	}

	public void setPayedBy(UsersDTO payedBy) {
		this.payedBy = payedBy;
	}

}
