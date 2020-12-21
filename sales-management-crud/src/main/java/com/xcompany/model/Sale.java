package com.xcompany.model;

import java.util.Date;

public class Sale {

	private int saleId, productId, leadId;
	private Date saleDate, saleDeliveryDate, saleCancelDate;
	private String saleDeliveryAddress, saleObs, saleStatus, saleCancelReason;

	public Sale() {}

	public Sale(int saleId, int productId, int leadId, Date saleDate, Date saleDeliveryDate, Date saleCancelDate,
			String saleDeliveryAdress, String saleObs, String saleStatus, String saleCancelReason) {
		this.saleId = saleId;
		this.productId = productId;
		this.leadId = leadId;
		this.saleDate = saleDate;
		this.saleDeliveryDate = saleDeliveryDate;
		this.saleCancelDate = saleCancelDate;
		this.saleDeliveryAddress = saleDeliveryAdress;
		this.saleObs = saleObs;
		this.saleStatus = saleStatus;
		this.saleCancelReason = saleCancelReason;
	}

	public int getSaleId() {
		return saleId;
	}

	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public int getLeadId() {
		return leadId;
	}

	public void setLeadId(int leadId) {
		this.leadId = leadId;
	}

	public Date getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}

	public Date getSaleDeliveryDate() {
		return saleDeliveryDate;
	}

	public void setSaleDeliveryDate(Date saleDeliveryDate) {
		this.saleDeliveryDate = saleDeliveryDate;
	}

	public Date getSaleCancelDate() {
		return saleCancelDate;
	}

	public void setSaleCancelDate(Date saleCancelDate) {
		this.saleCancelDate = saleCancelDate;
	}

	public String getSaleDeliveryAddress() {
		return saleDeliveryAddress;
	}

	public void setSaleDeliveryAddress(String saleDeliveryAdress) {
		this.saleDeliveryAddress = saleDeliveryAdress;
	}

	public String getSaleObs() {
		return saleObs;
	}

	public void setSaleObs(String saleObs) {
		this.saleObs = saleObs;
	}

	public String getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(String saleStatus) {
		this.saleStatus = saleStatus;
	}

	public String getSaleCancelReason() {
		return saleCancelReason;
	}

	public void setSaleCancelReason(String saleCancelReason) {
		this.saleCancelReason = saleCancelReason;
	}

	public String toString() {
		return "Sale [saleId=" + saleId + ", productId=" + productId + ", leadId=" + leadId + ", saleDate=" + saleDate
				+ ", saleDeliveryDate=" + saleDeliveryDate + ", saleCancelDate=" + saleCancelDate
				+ ", saleDeliveryAdress=" + saleDeliveryAddress + ", saleObs=" + saleObs + ", saleStatus=" + saleStatus
				+ ", saleCancelReason=" + saleCancelReason + "]";
	}
}
