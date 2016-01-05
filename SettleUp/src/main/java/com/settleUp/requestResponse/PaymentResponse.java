package com.settleUp.requestResponse;

import java.util.ArrayList;
import java.util.List;

public class PaymentResponse extends JsonResponse {
	private List<PaymentDTO> payments;

	public PaymentResponse(int size) {
		payments = new ArrayList<PaymentDTO>(size);
	}

	public List<PaymentDTO> getPayments() {
		return payments;
	}

	public void setPayments(List<PaymentDTO> payments) {
		this.payments = payments;
	}

}
