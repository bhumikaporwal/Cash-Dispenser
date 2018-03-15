package com.dispenser.start.junit;

import static org.junit.Assert.*;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.dispenser.start.service.CashManagement;
@RunWith(SpringRunner.class)
public class CashDispenserTest  {

	CashManagement cashManagement = new CashManagement();

	//Test case to check withdraw Functionality
	@Test
	public void withdraw_test_20() throws Exception{
		List<Integer> list1 = Arrays.asList( 2, 4);

		try{

			assertEquals(list1, cashManagement.withdrawal(180));
			System.out.println("Test case for 20 withdrawal: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 20 withdrawal Failed");
		}

	}

	//Test case to check deposit functionality 	
	@Test
	public void deposit_test_20() throws Exception{
		List<Integer> list = new ArrayList<>();
		list.add(40);
		list.add(30);

		String res ="Added Successfully.";
		try{
			assertEquals(res, cashManagement.addNotes(list));
			System.out.println("Test case for 20 deposit: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 20 deposit Failed");
		}
	}

	//Test case to check withdraw Functionality
	@Test
	public void withdraw_test_40() throws Exception{
		List<Integer> list1 = Arrays.asList( 2, 4);

		try{

			assertEquals(list1, cashManagement.withdrawal(180));
			System.out.println("Test case for 40 withdrawal: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 40 withdrawal Failed");
		}

	}

	@Test
	public void deposit_test_40() throws Exception{
		List<Integer> list = new ArrayList<>();
		list.add(40);
		list.add(30);

		String res ="Added Successfully.";
		try{
			assertEquals(res, cashManagement.addNotes(list));
			System.out.println("Test case for 40 deposit: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 40 deposit Failed");
		}
	}

	@Test
	public void withdraw_test_50() throws Exception{
		List<Integer> list1 = Arrays.asList(1,1);

		try{

			assertEquals(list1, cashManagement.withdrawal(70));
			System.out.println("Test case for 50 withdrawal1: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 50 withdrawal1 Failed");
		}



	}
	@Test
	public void deposit_test_50() throws Exception{
		List<Integer> list = new ArrayList<>();
		list.add(40);
		list.add(30);

		String res ="Added Successfully.";
		try{
			assertEquals(res, cashManagement.addNotes(list));
			System.out.println("Test case for 50 deposit: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 50 deposit Failed");
		}
	}

	@Test
	public void withdraw_test_70() throws Exception{
		List<Integer> list1 = new ArrayList<>();
		try{

			assertEquals(list1, cashManagement.withdrawal(30));
			System.out.println("Test case for 70 withdrawal: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 70 withdrawal Failed");
		}



	}

	@Test
	public void deposit_test_70() throws Exception{
		List<Integer> list = new ArrayList<>();
		list.add(40);
		list.add(30);

		String res ="Added Successfully.";
		try{
			assertEquals(res, cashManagement.addNotes(list));
			System.out.println("Test case for 70 deposit: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 70 deposit Failed");
		}
	}

	@Test
	public void withdraw_test_80() throws Exception{
		List<Integer> list1 = new ArrayList<>();
		try{

			assertEquals(list1, cashManagement.withdrawal(30));
			System.out.println("Test case for 80 withdrawal: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 80 withdrawal Failed");
		}



	}

	@Test
	public void deposit_test_80() throws Exception{
		List<Integer> list = new ArrayList<>();
		list.add(40);
		list.add(30);

		String res ="Added Successfully.";
		try{
			assertEquals(res, cashManagement.addNotes(list));
			System.out.println("Test case for 80 deposit: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 80 deposit Failed");
		}
	}
	@Test
	public void withdraw_test_100() throws Exception{
		List<Integer> list1 = new ArrayList<>();
		try{

			assertEquals(list1, cashManagement.withdrawal(30));
			System.out.println("Test case for 100 withdrawal: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 100 withdrawal Failed");
		}



	}

	@Test
	public void deposit_test_100() throws Exception{
		List<Integer> list = new ArrayList<>();
		list.add(40);
		list.add(30);

		String res ="Added Successfully.";
		try{
			assertEquals(res, cashManagement.addNotes(list));
			System.out.println("Test case for 100 deposit: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 100 deposit Failed");
		}
	}
	@Test
	public void withdraw_test_150() throws Exception{
		List<Integer> list1 = new ArrayList<>();
		try{

			assertEquals(list1, cashManagement.withdrawal(30));
			System.out.println("Test case for 150 withdrawal: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 150 withdrawal Failed");
		}



	}

	@Test
	public void deposit_test_150() throws Exception{
		List<Integer> list = new ArrayList<>();
		list.add(40);
		list.add(30);

		String res ="Added Successfully.";
		try{
			assertEquals(res, cashManagement.addNotes(list));
			System.out.println("Test case for 150 deposit: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 150 deposit Failed");
		}
	}
	@Test
	public void withdraw_test_60() throws Exception{
		List<Integer> list1 = new ArrayList<>();
		try{

			assertEquals(list1, cashManagement.withdrawal(30));
			System.out.println("Test case for 60 withdrawal: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 60 withdrawal Failed");
		}



	}

	@Test
	public void deposit_test_60() throws Exception{
		List<Integer> list = new ArrayList<>();
		list.add(40);
		list.add(30);

		String res ="Added Successfully.";
		try{
			assertEquals(res, cashManagement.addNotes(list));
			System.out.println("Test case for 60 deposit: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 60 deposit Failed");
		}
	}
	@Test
	public void withdraw_test_110() throws Exception{
		List<Integer> list1 = new ArrayList<>();
		try{

			assertEquals(list1, cashManagement.withdrawal(30));
			System.out.println("Test case for 110 withdrawal: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 110 withdrawal Failed");
		}



	}

	@Test
	public void deposit_test_110() throws Exception{
		List<Integer> list = new ArrayList<>();
		list.add(40);
		list.add(30);

		String res ="Added Successfully.";
		try{
			assertEquals(res, cashManagement.addNotes(list));
			System.out.println("Test case for 110 deposit: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 110 deposit Failed");
		}
	}
	@Test
	public void withdraw_test_200() throws Exception{
		List<Integer> list1 = new ArrayList<>();
		try{

			assertEquals(list1, cashManagement.withdrawal(30));
			System.out.println("Test case for 200 withdrawal: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 200 withdrawal Failed");
		}



	}

	@Test
	public void deposit_test_200() throws Exception{
		List<Integer> list = new ArrayList<>();
		list.add(40);
		list.add(30);

		String res ="Added Successfully.";
		try{
			assertEquals(res, cashManagement.addNotes(list));
			System.out.println("Test case for 200 deposit: Success");
		}
		catch(Exception e){
			System.out.println("Test case for 200 deposit Failed");
		}
	}
}
