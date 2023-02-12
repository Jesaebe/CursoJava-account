package application;

import java.util.Locale;
import java.util.Scanner;

import javax.security.auth.login.AccountException;

import model.entities.Account;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double withdrawLimit = sc.nextDouble();
			
			System.out.println("--------------------------------");
			
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			System.out.printf("New balance: %.2f", account.getBalance());
			
		} catch (AccountException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
