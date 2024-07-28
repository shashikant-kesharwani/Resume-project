import java.io.*;
import java.util.*;
import java.text.*;
 
 //   New Account Create
 
 class Create{
	 Console an=System.console();
	 Scanner in=new Scanner(System.in);
	  boolean check_pass;
	  int b;
	 int account_no[]=new int[10000];
	 String name[]=new String[10000];
	 String pass[]=new String[10000];
	 String repass[]=new String[10000];
	 void acc_create(int a,int account){
		 do{
			b=a+1; 
	 check_pass=true;
	 System.out.print("Enter the name:");
	 name[a]=an.readLine();
	 account_no[a]=account;
	 System.out.print("The Account Number is:"+account);
	 System.out.print("\nset password:");
	 char[] temp=an.readPassword();
	 pass[a]=String.valueOf(temp);
	 System.out.print("set repassword:");
	 char[] temp1=an.readPassword();
	 repass[a]=String.valueOf(temp1);
	
			if(pass[a].equals(repass[a]))
			{
				System.out.println("\n*****Successfully accout create*****");
			check_pass=false;
			}
			else{
				System.out.println("\n******Account not create successfully*********\n");
			}
		 }
	 while(check_pass);
	 }
 }
 
//     Deposite money
 
 class Deposite extends Create{
	 int money=0;
	 String acc_hold_name;
	 int acc_no;
	 int total[]=new int[10000];
	 
	 void set()
	 {
		  for(int i=0;i<10000;i++)
		  {
			  total[i]=0;
		  }
	 }
	 void deposite()
	 {
	 System.out.print("Enter the Account holder name:");
	 acc_hold_name=an.readLine();
	 System.out.print("Enter the Account number:");
	 acc_no=in.nextInt();
	 for(int i=0;i<b;i++)
	 {
	 if(acc_hold_name.equals(name[i]) && acc_no==account_no[i])
	 {
		 System.out.print("How many money Deposite:");
		 int depo_money=in.nextInt();
		 total[i]+=depo_money;
		 System.out.println("\n ******Money successfully deposite*****\n");
		 break;
		 
	 }
	 }
	 for(int i=0;i<b;i++)
	 {
	 if(acc_hold_name.equals(name[i]) && acc_no!=account_no[i])
	 {
		 System.out.println("\n**********Account not found*********\n");
		 break;
	 }
	 }
 }
 }
 //    Withdraw money
 
 class Withdraw extends Deposite{
	 void withdraw()
	 {
	 System.out.print("Enter the account holder name:");
	 acc_hold_name=an.readLine();
	 System.out.print("Enter the Account number:");
	 acc_no=in.nextInt();
	 System.out.print("Enter the password:");
	 char[] ch_p=an.readPassword();
	 String check_pass1=String.valueOf(ch_p);
	 for(int i=0;i<b;i++)
	 {
		 if(acc_hold_name.equals(name[i]) && acc_no==account_no[i] && check_pass1.equals(pass[i]))
		 {
			 System.out.print("How many money withdraw:");
			 int with_money=in.nextInt();
			 if (with_money>0)
			 {
				 total[i]-=with_money;
				 System.out.println("\n ******Money successfully withdraw*****\n");
				 break;

			 }
			 
		 }
		 
	 }
	 for(int i=0;i<b;i++)
	 {
	 if(acc_hold_name.equals(name[i]) && acc_no!=account_no[i] && !check_pass1.equals(pass[i]))
	 {
		 System.out.println("\n**********Account not found*********\n");
		 break;
	 }
	 
			 
	 }
 }
 }
	 
//    Display total amount	 
	 
	 
class T_amount extends Withdraw{
	void t_display()
	{
	 System.out.print("Enter the account holder name:");
	 acc_hold_name=an.readLine();
	 System.out.print("Enter the Account number:");
	 acc_no=in.nextInt();
	  for(int i=0;i<b;i++)
	 {
	 if(acc_hold_name.equals(name[i]) && acc_no==account_no[i])
	 {
		 System.out.println("Total amount:"+total[i]);
		 break;
	 }
}
for(int i=0;i<b;i++)
	 {
	 if(acc_hold_name.equals(name[i]) && acc_no!=account_no[i])
	 {
		 System.out.println("\n**********Account not found*********\n");
		 break;
	 }

	}
}
}
	
	// Transfer money class
	
	class Transfer extends T_amount{
		void transfer()
		{
		System.out.print("Enter the sender name:");
		String sender_name=an.readLine();
		System.out.print("Enter the sender account number:");
		int send_acc_no=in.nextInt();
		for(int i=0;i<b;i++)
		{
			if(sender_name.equals(name[i]) && send_acc_no==account_no[i])
			{
				System.out.print("Enter the reciever name:");
				String reciever_name=an.readLine();
				System.out.print("Enter the reciever account number:");
				int rec_acc_no=in.nextInt();
					for(int j=0;j<b;j++)
					{
						if(reciever_name.equals(name[j]) && rec_acc_no==account_no[j])
						{
							System.out.print("How many money send:");
							int send_money=in.nextInt();
							if(total[i]>send_money)
							{
								total[j]=total[j]+send_money;
								total[i]=total[i]-send_money;
								System.out.print("\n*********Money successfully send**********\n");
							}
							else{
								System.out.print("\n********Balance is not sufficient*******\n");
							}
							break;
						}
						
					}
					for(int j=0;j<b;j++)
					{
						if(reciever_name.equals(name[j]) && rec_acc_no!=account_no[j])
						{
						 System.out.print("\n**** reciever account not found*******\n");
						 break;
						}
					}
					break;
			}
		}
		for(int i=0;i<b;i++)
		{
			if(sender_name.equals(name[i]) && send_acc_no!=account_no[i])
			{
						System.out.print("\n**** sender account not found*******\n");
						 break;
			}
		}

				
		}
	}
	
	
	// Display Information
	
	class Display_info extends Transfer {
		void acc_display()
		{
		System.out.print("Enter the account holder name:");
		String ac_name=an.readLine();
		System.out.print("Enter the account number:");
		int ac_no=in.nextInt();
		for(int i=0;i<b;i++)
		{
			if(ac_name.equals(name[i]) && ac_no==account_no[i])
			{
				System.out.println("\n****** Account Information*******");
				System.out.println("\nAccount holder Name:"+name[i]);
				System.out.println("Account number:"+account_no[i]);
				System.out.println("password:"+pass[i]);
				System.out.println("Total amount:"+total[i]);
				break;
			}
		}
		for(int i=0;i<b;i++)
		{
			if(ac_name.equals(name[i]) && ac_no!=account_no[i])
			{
				System.out.println("\n***********Account not found************\n");
				break;
			}
		}
	}
	}
				
		
	// main class

	
class Bank{
	 public static void main(String args[])
	 {
		 String day="Sun";
		 Date dNow=new Date();
SimpleDateFormat ft=new SimpleDateFormat("E");
SimpleDateFormat date=new SimpleDateFormat("dd.MM.yyyy");
SimpleDateFormat time=new SimpleDateFormat("hh:mm:ss");
if(day.equals(ft.format(dNow)))
{
	System.out.print("\n*******Today Sunday, so Bank closed today.*******\n");
	System.exit(0);
} else { 
	Scanner in=new Scanner(System.in);
	boolean quit=true;
	int count=0;
	int account_number=729301;
	Display_info display=new Display_info();
	display.set();
	
	int ch;
		do{
			System.out.println("\n******Welcome to the Bank of  SICS*******");
			System.out.println("\n\t\t\t\tDate:"+date.format(dNow));	// return date
			System.out.println("\t\t\t\tTime:"+time.format(dNow));	    // return time
			System.out.println("\t\t\t\tDay:"+ft.format(dNow));		// return day
			System.out.println("1->Create a new account");
			System.out.println("2->Deposite");
			System.out.println("3->Withdraw");
			System.out.println("4->Total Amount");
			System.out.println("5->Send money");
			System.out.println("6->Display Information");
			System.out.println("7->Quit");
			System.out.print("What you want:");
			ch=in.nextInt();
			switch(ch)
			{
				case 1:
				display.acc_create(count,account_number);
				count++;
				account_number++;
				break;
				case 2:
				display.deposite();
				break;
				case 3:
				display.withdraw();
				break;
				case 4:
				display.t_display();
				break;
				case 5:
				display.transfer();
				break;
				case 6:
				display.acc_display();
				break;
				case 7:
				System.exit(0);
				default:
				System.out.println("Wrong input!!!");
			}
		}
		while(quit);		 
		}
	}
}