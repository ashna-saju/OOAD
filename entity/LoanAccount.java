package com.ilp.entity;

import java.util.ArrayList;

public class LoanAccount extends Product {
	double chequeDeposit=0.03;

	
	public double getChequeDeposit() {
		return chequeDeposit;
	}


	public void setChequeDeposit(double chequeDeposit) {
		this.chequeDeposit = chequeDeposit;
	}


	public LoanAccount(String productCode, String productName, ArrayList<Service> serviceList) {
		super(productCode, productName, serviceList);
		// TODO Auto-generated constructor stub
	}

}
