package com.ilp.service;
import java.util.Scanner;
import com.ilp.entity.Account;
import com.ilp.entity.Customer;
import com.ilp.entity.LoanAccount;
import com.ilp.entity.SavingsMaxAccount;

public class ManageAccount {

	public static void manageAccount(Customer customer) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the customer Code:");
		String customerCode = scanner.nextLine();
		System.out.println(customer.getCustomerName() + " has the following accounts:");
		for (Account account : customer.getAccountList()) {
			System.out.println((customer.getAccountList().indexOf(account) + 1) + "." + account.getProduct().getProductName());
		}
		System.out.println("Enter your choice:");
		int choiceOfAccount = scanner.nextInt();
		Account selectedAccount = customer.getAccountList().get(choiceOfAccount - 1);
		char continueToAccountManagement;
		do {
			System.out.println("Choose the Service you want to use :");
			System.out.println("1.Deposit");
			System.out.println("2.Withdraw");
			System.out.println("3.Display Balance");
			int manageAccountChoice = scanner.nextInt();
			switch (manageAccountChoice) {
			case 1:
				ManageAccount.depositMoney(selectedAccount);
				break;
			case 2:
				ManageAccount.withdrawMoney(selectedAccount);
				break;
			case 3:
				CustomerConfiguration.displayAccounts(customer);
				break;
			}

			System.out.println("Do you want to continue to Account Management(y/n)");
			continueToAccountManagement = scanner.next().charAt(0);

		} while (continueToAccountManagement == 'y');
	}

	private static void withdrawMoney(Account selectedAccount) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the amount to be Withdraw:");
		double amountWithdrawn = scanner.nextDouble();
		if (selectedAccount.getProduct() instanceof SavingsMaxAccount) {
			SavingsMaxAccount savingsMaxAccount = (SavingsMaxAccount) selectedAccount.getProduct();
			double minBalance = savingsMaxAccount.getMinimumBalance();
			if (selectedAccount.getAccountBalance() >=  amountWithdrawn + minBalance) {
				selectedAccount.setAccountBalance(selectedAccount.getAccountBalance() -  amountWithdrawn);
			} else {
				System.out.println("This amount can't be withdraw.Minimum Balance should be " + minBalance + "");
			}
		} else {
			selectedAccount.setAccountBalance(selectedAccount.getAccountBalance() -  amountWithdrawn);
		}
	}

	private static void depositMoney(Account selectedAccount) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String chqNo = "";
		double depositAmount;
		System.out.println("Enter the amount to be deposited:");
		depositAmount = scanner.nextDouble();
		if (selectedAccount.getProduct() instanceof LoanAccount) {
			System.out.println("Which way you want to deposit money? ");
			System.out.println("1.Over the counter 2.Cheque");
			int depositChoice = scanner.nextInt();
			if (depositChoice == 2) {
				LoanAccount loanAccount = (LoanAccount) selectedAccount.getProduct();
				double chequeDeposit = loanAccount.getChequeDeposit();
				depositAmount -= depositAmount * chequeDeposit;
				double updatedBalance = (selectedAccount.getAccountBalance() + depositAmount);
				selectedAccount.setAccountBalance(updatedBalance);
			}
		} else {
			double updatedBalance = (selectedAccount.getAccountBalance() + depositAmount);
			selectedAccount.setAccountBalance(updatedBalance);
		}
	}

}
