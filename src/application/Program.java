package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exception.DomainException;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try{
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.next();
			String holder = sc.nextLine();
			System.out.print("Initial Balance: ");
			Double balance = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			Double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(number, holder, balance, withdrawLimit);
			
			System.out.print("\nEnter amount for withdraw: ");
			Double withdraw = sc.nextDouble();
			account.withdraw(withdraw);
			System.out.println("New Balance: " + String.format("%.2f", account.getBalance()));
		}
		catch (DomainException e) {
			System.out.println("Erro: " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Erro inesperado!");
		}

		sc.close();
	}
}
