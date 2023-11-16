package com.ilp.service;

import java.util.ArrayList;
import java.util.Scanner;
import com.ilp.entity.CurrentAccount;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.Product;
import com.ilp.entity.SavingsMaxAccount;
import com.ilp.entity.Service;

public class ProductConfiguration {

	public static Service createServices() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("The services available are:");
		System.out.println("Internet Banking");
		System.out.println("Cash Withdrawal");
		System.out.println("Cash Deposit");
		System.out.println("ATM WIthdrawal");
		System.out.println("Online Banking");
		System.out.println("What Service you want to add:");
		System.out.println("Enter Service Code:");
		String serviceCode = scanner.nextLine();
		System.out.println("Enter Service Name:");
		String serviceName = scanner.nextLine();
		System.out.println("Enter transaction rate:");
		double rate = scanner.nextDouble();
		return new Service(serviceCode, serviceName, rate);
	}

	public static Product createProducts(ArrayList<Service> serviceList) {
		// TODO Auto-generated method stub
		ArrayList<Service> chosenProductServiceList = new ArrayList<Service>();
		Product product = null;
		Scanner scanner = new Scanner(System.in);
		System.out.println("The products available are:");
		System.out.println("Savings Max Account");
		System.out.println("Current Account");
		System.out.println("Loan Account");
		System.out.println("What product you want to add:");
		System.out.print("Enter Product Code");
		String productCode = scanner.nextLine();
		System.out.println("Enter Product Name");
		String productName = scanner.nextLine();

		char continueToChoose;
		do {
			System.out.println("Enter the service codes of the services to be added to the chosen product");
			for (Service service : serviceList) {
				System.out.println(service.getServiceCode() + ":" + service.getServiceName());
			}
			scanner.nextLine();
			String choiceOfService = scanner.nextLine();
			for (Service service : serviceList) {
				if (service.getServiceCode().equals(choiceOfService)) {
					chosenProductServiceList.add(service);
					break;
				}
			}
			System.out.println("Do you want to add another service(y/n)");
			continueToChoose = scanner.next().charAt(0);
		} while (continueToChoose == 'y');

		if (productName.equalsIgnoreCase("Savings Max Account")) {

			product = new SavingsMaxAccount(productCode, productName, chosenProductServiceList);
		} else if (productName.equalsIgnoreCase("Current Account")) {

			product = new CurrentAccount(productCode, productName, chosenProductServiceList);
		} else if (productName.equalsIgnoreCase("Loan Account")) {

			product = new LoanAccount(productCode, productName, chosenProductServiceList);
		}
		return product;
	}

}
