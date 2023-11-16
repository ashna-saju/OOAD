package com.ilp.utility;
import java.util.ArrayList;
import java.util.Scanner;
import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.Product;
import com.ilp.entity.Service;
import com.ilp.service.CustomerConfiguration;
import com.ilp.service.ManageAccount;
import com.ilp.service.ProductConfiguration;

public class AccountUtility {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		ArrayList<Service> serviceList = new ArrayList<Service>();
		ArrayList<Product> productList = new ArrayList<Product>();
		Customer customer = null;
		char goToMainMenu = 'y';
		while (goToMainMenu == 'y') {
			System.out.println("\n*******Welcome to Bank*******");
			System.out.println("1.Create Services");
			System.out.println("2.Create Product");
			System.out.println("3.Create Accounts");
			System.out.println("4.Manage Accounts");
			System.out.println("5.Display Accounts ");
			System.out.println("6.Transaction Bill ");
			System.out.println("7.Exit ");
			System.out.print("Enter your choice : ");
			int mainMenuChoice = scanner.nextInt();
			switch (mainMenuChoice) {
			case 1:
				serviceList.add(ProductConfiguration.createServices());
				break;
			case 2:
				productList.add(ProductConfiguration.createProducts(serviceList));
				break;
			case 3:
				customer = CustomerConfiguration.createCustomer(productList);
				for (Account account : customer.getAccountList()) {
					System.out.println(account.getProduct().getProductName() + " created for "+ customer.getCustomerName() + " with the following services");
					for (Service service : account.getProduct().getServiceList()) {
						System.out.println(service.getServiceCode() + " : " + service.getServiceName());
					}
					System.out.println("\nAccount is active.!!!!!! \n");
				}
				break;
			case 4:
				ManageAccount.manageAccount(customer);
				break;
			case 5:
				CustomerConfiguration.displayAccounts(customer);
				break;
			case 6:
				CustomerConfiguration.transactionBill(customer);
				break;
			case 7:
				System.exit(0);
			}
			System.out.println("Do you want to continue to main menu(y/n):");
			goToMainMenu = scanner.next().charAt(0);
		}

	}

}
