# Domain: Banking
Use case : When a customer attempts to deposit money, the list of all accounts which the customers possess should be listed so that the customer can select to which account he would like to deposit the money. Customer can have the following accounts

SavingsMaxAccount CurrentAccount LoanAccount · Customer(customerCode, customerName, List)

· Account(accountNo, accountType, balance, Product).

· Product(productCode, productName, List)

· SavingsMaxAccount is a Product(minimumBalance of Rs.1000 should be maintained in the account)

· CurrentAccount is a Product

· LoanAccount is a Product.(chequeDeposit should be chargeable ie 3%).

· Service(serviceCode, serviceName,rate)

Default services SavingsMaxAccount(CashDeposit, ATMWithdrawl, OnlineBanking)

CurrentAccount(CashDeposit, OnlineBanking, ATMWithdrawl, MobileBanking)

LoanAccount(CashDeposit, ChequeDeposit)

# Class Diagram
![ILP_15112023_Assignment_UMLClassDiagram drawio](https://github.com/ashna-saju/OOAD/assets/149554694/8bbde0c8-b2bf-4e49-858d-7dbd0af89cb4)
