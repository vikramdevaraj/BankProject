package bankproject;
import java.util.Scanner;
public class BankprojectDemo {
	
		public static void main(String arg[])
		{
			Scanner KB=new Scanner(System.in);
			
			//create initial accounts
			System.out.print("How Many Customer U Want to Input : ");
			int n=KB.nextInt();
			Bank  C[]=new Bank[n];
			for(int i=0;i<C.length;i++)
			{   
				C[i]=new Bank();
				C[i].openAccount();
			}
			
			//run loop until menu 5 is not pressed
			int ch;
			do
			{
				System.out.println("Main Menu 1.Display All\n 2.Search By Account\n	3.Deposit\n 4.Withdrawal\n 5.FundTransfer\n 6.Exit");
				System.out.println("Ur Choice :");
				ch=KB.nextInt();
				switch(ch)
				{ 
					case 1:
						for(int i=0;i<C.length;i++)
						{
							C[i].showAccount();
						}
						break;

					case 2:
						System.out.print("Enter Account No U Want to Search...: ");
						String acn=KB.next();
						boolean found=false;
						for(int i=0;i<C.length;i++)
						{  
							found=C[i].search(acn);
							if(found)
							{
								break;
							}
						}
						if(!found)
						{
							System.out.println("Search Failed..Account Not Exist..");
						}
						break;

					case 3:
						System.out.print("Enter Account No : ");
						acn=KB.next();
						found=false;
						for(int i=0;i<C.length;i++)
						{  
							found=C[i].search(acn);
							if(found)
							{
								C[i].deposit();
								break;
							}
						}
						if(!found)
						{
							System.out.println("Search Failed..Account Not Exist..");
						}
						break;

					case 4:
						System.out.print("Enter Account No : ");
						acn=KB.next();
						found=false;
						for(int i=0;i<C.length;i++)
						{  
							found=C[i].search(acn);
							if(found)
							{
								C[i].withdrawal();
								break;
							}
						}
						if(!found)
						{
							System.out.println("Search Failed..Account Not Exist..");
						}
						break;
				
					case 5:
						System.out.print("enter amount to send");
						long amt=KB.nextLong();
						System.out.print("sender Account No : ");
						 acn=KB.next();
						found=false;
						for(int i=0;i<C.length;i++)
						{  
							found=C[i].search(acn);
							if(found)
						{
							C[i].fundtransfer(-amt);
						}
						}
						
					System.out.print("Reciver Account No : ");
						
						 acn=KB.next();
						found=false;
						for(int j=0;j<C.length;j++)
						{  
							found=C[j].search(acn);
							if(found)
							{
							C[j].fundtransfer(amt);
					break;	}
						}
						if(!found)
						{
							System.out.println("Search Failed..Account Not Exist..");
						break;
						}
						
						case 6:
						{
							System.out.println("Good Bye..");
						}
						break;
				}
			}
			while(ch!=6);
		}
	}

