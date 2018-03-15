package com.dispenser.start.service;





import java.util.ArrayList;

import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class CashManagement {

	public  CashManagement() {
		super();
	}

	public static List<Integer> denomination = new ArrayList<>();
	public static List<Integer> notesAvailable = new ArrayList<>();

	static{
		//denomination.add(100);//add new denominations here in ascending order
		denomination.add(50);
		denomination.add(20);
		//notesAvailable.add(3);//add notes for new denominations here in ascending order
		notesAvailable.add(1);
		notesAvailable.add(3);
	}

	public String addNotes(List<Integer> notesAdded){
		String result="Failed";
		for(int i=0; i<denomination.size(); i++){
			try{
				notesAvailable.set(i, (notesAvailable.get(i)+notesAdded.get(i)));
			}catch(Exception e){
				return result;
			}
		}
		result="Added Successfully.";
		return result;
	}

	//to return total amount available in ATM
	public int totalAmount(){
		int totalSum =0;
		for(int i=0; i <denomination.size(); i++ ){
			totalSum += (denomination.get(i)*notesAvailable.get(i));
		}

		return totalSum;
	}

	//return list of currency notes required to withdraw given amount if available
	// returns a empty list if combination not possible 
	public List<Integer> withdrawal(int amount){
		List<Integer> withdrawnDenomination = new ArrayList<>();
		for(int i=0;i<denomination.size();i++){
			List<Integer> temp = new ArrayList<>();
			int amtTemp=amount;
			for(int j=0;j<denomination.size();j++){//0 if bigger denominations are not required
				if(j<i){
					temp.add(0);
				}
				
				else{
					/*check required in case remaining amount is not divisible by smallest denomination but if we remove 1 higher currency noteand add that amount to remaining
					it is possible to dispense with smaller currency notes
					eg $80 not possible with 50$ currency as remainder 30 is not divisible by 20
					hence reducing 50 $ note and dispensing additional 20$ note*/
					if(j==denomination.size()-1 && j!=0 && amount>denomination.get(j-1) && (amtTemp%denomination.get(j)!=0 && (amtTemp + denomination.get(j-1))%denomination.get(j)==0))
					{
						int noteHicur=temp.get(j-1)-1;
						noteHicur=noteHicur<0?0:noteHicur;
						temp.set(j-1,noteHicur);
						amtTemp +=denomination.get(j-1);
					}
					
					int notes =amtTemp/(denomination.get(j));
					notes=notes<=notesAvailable.get(j)?notes:notesAvailable.get(j);
					temp.add(notes);
					amtTemp-=notes*denomination.get(j);
					
				}
				
			}
			if(amtTemp==0 && updateCurrentCount(temp)){// checking if amount is completely withdrawn without any remainder
				withdrawnDenomination=temp;
				break;
			}
		}
		
		return withdrawnDenomination;


	}
	//updating current count og notes
	private boolean updateCurrentCount(List<Integer> withdrawnNotes){
		try{
			for(int i=0;i< withdrawnNotes.size();i++)
			{
				notesAvailable.set(i,notesAvailable.get(i)-withdrawnNotes.get(i));
			}
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}


}
