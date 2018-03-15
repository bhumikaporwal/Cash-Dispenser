package com.dispenser.start;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dispenser.start.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import static java.lang.System.exit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication(scanBasePackages={
		"com.dispenser.start.service", "com.dispenser.start.junit"})
public class CashDispenser implements CommandLineRunner {

	@Autowired
	private CashManagement cashService;
	private Scanner sc =new Scanner(System.in);
	public static void main(String[] args){

		SpringApplication app = new SpringApplication(CashDispenser.class);
		app.run(args);

		System.out.println("Atm Operations Starts");

	}
	// Application start point
	@Override
	public void run(String... args) throws Exception {
		do{
			int selection = getUserInput();// to get user input
			switch(selection){

			case 1:
				System.out.println(depositMoney());
				break;

			case 2:

				List<Integer> result =withdraw();
				if(result.isEmpty()){
					System.out.println("Withdraw UnSuccessfull. Denominations not available for the given amount.");
				}
				else{
					System.out.println("Withdraw Successfull");
					for (int i=0;i<CashManagement.denomination.size();i++){
						System.out.println(CashManagement.denomination.get(i)+ "$ notes: " + result.get(i));
					}
				}

				break;

			case 3:
				System.out.println(" Total Amount available is "+cashService.totalAmount());
				for (int i=0;i<CashManagement.denomination.size();i++){
					System.out.println(CashManagement.denomination.get(i)+ "$ notes: " + CashManagement.notesAvailable.get(i));
				}

				break;
			case 4:
				System.out.println("Session Ended Successfully...  Thank You..!!!");
				exit(0);
				break;

			}
			exitConfimation();
		}while(true);

	}

	private void exitConfimation(){
		System.out.println("Do you wish to Continue? Y/N: ");

		if(sc.nextLine().toLowerCase().equals("n")){
			System.out.println("Session Ended Successfully...  Thank You..!!!");
			exit(0);
		}
	}
	//method to get User Input 
	private int getUserInput() {
		String selected="";
		int selectedOption=0;
		System.out.println("========================\n"
				+"ATM Menu: \n \n"
				+ "1. Deposit Money \n"
				+ "2. Withdraw Money \n"
				+ "3. Total Available Amount\n"
				+ "4. End Session\n"
				+ "========================\n"
				+ "\nEnter selection: ");
		while(selectedOption==0){
			selected=sc.nextLine(); 
			try{
				selectedOption=Integer.parseInt(selected);//to check if selected option is a int
				if(selectedOption<=0 || selectedOption>4){//to check if selected option is a within range
					selectedOption=0;
					System.out.println("Kindly Enter a correct option");
				}
				else
					return selectedOption;	
			}
			catch(NumberFormatException e){
				selectedOption=0;
				System.out.println("Please Enter a no.");
			}

		}

		return selectedOption;
	}

	private String depositMoney(){

		List<Integer> notesAdded =  new ArrayList<>();

		for(int i : CashManagement.denomination){
			System.out.println("Enter "+ i+"$ notes");
			String temp = "";
			int notes = -1;

			while(notes<0 ){
				temp=sc.nextLine(); 
				try{

					notes=Integer.parseInt(temp);
					if(notes<0 ){
						System.out.println("Kindly Enter a positive no.");

					}
				}
				catch(NumberFormatException e){
					System.out.println("Please Enter a no.");
				}

			}
			notesAdded.add(notes);
		}		

		return cashService.addNotes(notesAdded);
	}

	private List<Integer> withdraw(){
		System.out.print("Enter Amount to be withdrawn: ");

		String temp = "";
		int amount = 0;
		boolean warned =false;
		while(amount==0){
			temp=sc.nextLine();
			try{				
				amount=Integer.parseInt(temp);
				if(amount<0 ){
					amount=0;
					System.out.println("Amount cannot be less than zero. Please make correct entry");
				}
				if(warned && amount>cashService.totalAmount()){
					System.out.println("Looks Like Funds are not Suffiecient. \n"
							+ "Ending Session....");
					exit(0);//exiting application if user enter value more than total amount twice
				}
				else if (amount>cashService.totalAmount()){
					amount=0;
					System.out.println("Insufficient Fund. Kindly enter value lesser than $" +cashService.totalAmount());
					System.out.println("Enter new Amount to be withdrawn: ");
					warned=true;
				}
				

			}
			catch(NumberFormatException e){
				System.out.println("Please Enter a no.");
			}

		}
		return cashService.withdrawal(amount);
	}		




}
