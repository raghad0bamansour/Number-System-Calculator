import java.util.Scanner;
public class CalculatorApp {
	
	//these for the checking methods
		static boolean valid;
		static boolean isInt;
		static Scanner in = new Scanner(System.in);
		
		public static void main (String[] args)
		{
			NumberSystem c = new NumberSystem();
			boolean checkInt;
			boolean check;
			String number;
			//this variable to check if user want to stop or complete
			int com = 1;
			
			System.out.print("**************Number System Calculator Turned On**************\n\n");
			
			while ( com != 0 ) {
			System.out.printf("Convert from:\n1. Binary (base 2)"
					+ "\n2. Octal (base 8)\n3. Decimal (base 10)"
					+ "\n4. Hexadecimal (base 16)\n>> ");
			
			int choice = in.nextInt();
	        while (choice > 4 || choice < 1) 
	        {
	            System.out.println("Wrong choice!!!");
	        	System.out.print("Enter another choice again>> ");
	        	choice = in.nextInt();
	        }
	        System.out.println("............................................\n");
	        
	        if (choice == 1)
	        {
	        	System.out.print("Enter a binary number: ");
	        	number = in.next();
	        	checkInt = isInt(number);
	        	check = isBin(number);
	        	
	        	while ( !checkInt || !check )
	    			{
	        		   if (!checkInt)  
	        		       System.out.println("Wrong!!! Not integer");
	        		   else if (!check)
	        			   System.out.println("Wrong!!! Not binary");
	        		   
	        		   System.out.printf("\nEnter a binary number: ");
	               	   number = in.next();
	               	   checkInt = isInt(number);
	                   check = isBin(number);  
	    			}
	        	
	        	System.out.println("............................................\n");
	        	
	        	// 0 is 0 in all number systems
	            if (number.contentEquals("0"))
	            {
	            	 System.out.printf("In binary: 0\n");
	     	        System.out.printf("In decimal: 0\n");
	 			    System.out.printf("In octal: 0\n");
	 			    System.out.printf("In hexadecimal: 0\n"); 
	            }
	           
	            //if the number is not 0
	            else 
	            {
	    		    System.out.printf("In binary: %s\n",number);
	    	        System.out.printf("In decimal: %d\n",c.binToDec(number));
				    System.out.printf("In octal: %s\n",c.binToOct(number));
				    System.out.printf("In hexadecimal: %s\n",c.binToHexa(number));   
	            }
	            
	            System.out.println("............................................\n");
	    			
	    	 }
	        
	        else if (choice == 2)
	        {
	        	System.out.print("Enter an octal number: ");
	        	number = in.next();
	        	checkInt = isInt(number);
	        	check = isOct(number);
	        	
	        	while ( !checkInt || !check )
	    			{
	        		   if (!checkInt)  
	        		       System.out.println("Wrong!!! Not integer");
	        		   else if (!check)
	        			   System.out.println("Wrong!!! Not octal");
	        		   
	        		   System.out.printf("\nEnter an octal number: ");
	               	   number = in.next();
	               	   checkInt = isInt(number);
	                   check = isOct(number);  
	    			}
	       
	    		System.out.println("............................................\n");
	    		
	    		
	    		if (number.contentEquals("0"))
	            {
	    			// 0 is 0 in all number systems
	            	System.out.printf("In binary: 0\n");
	     	        System.out.printf("In decimal: 0\n");
	 			    System.out.printf("In octal: 0\n");
	 			    System.out.printf("In hexadecimal: 0\n"); 
	            }
	           
	            else 
	            {
	    		    c.octToBinPush(number);
	    		    System.out.printf("In octal: %s\n",number);
			        System.out.printf("In binary: %s\n",c.octToBinPop());
			        System.out.printf("In decimal: %s\n",c.octToDec(number));
				    System.out.printf("In hexadecimal: %s\n",c.octToHexa(number));
	            }
	    		
				System.out.println("............................................\n");		
	    	 }
	        
	        
	        else if (choice == 3)
	        {
	        	System.out.print("Enter a deicmal number: ");
	        	number = in.next();
	        	checkInt = isInt(number);
	        	check = isDec(number);
	        	
	        	while ( !checkInt || !check )
	    			{
	        		   if (!checkInt)  
	        		       System.out.println("Wrong!!! Not integer");
	        		   else if (!check)
	        			   System.out.println("Wrong!!! Not deicmal");
	        		   
	        		   System.out.printf("\nEnter a deicmal number: ");
	               	   number = in.next();
	               	   checkInt = isInt(number);
	                   check = isDec(number);  
	    			}
	        	
	        	System.out.println("............................................\n");
	        	
	        	if (number.contentEquals("0"))
	            {
	        		// 0 is 0 in all number systems
	            	System.out.printf("In binary: 0\n");
	     	        System.out.printf("In decimal: 0\n");
	 			    System.out.printf("In octal: 0\n");
	 			    System.out.printf("In hexadecimal: 0\n"); 
	            }
	           
	            else 
	            {
	        	    int di = Integer.valueOf(number);
	    		    System.out.printf("In decimal: %s\n",number);
	    		    c.decToBinPush(di);
	    	        System.out.printf("In binary: %s\n",c.decToBinPop());
	    	        c.decToOctPush(di);
	    	        System.out.printf("In octal: %s\n",c.decToOctPop());
	    	        c.decToHexaPush(di);
	    		    System.out.printf("In hexadecimal: %s\n",c.decToHexaPop());
	            }
				System.out.println("............................................\n");		
	    	 }
	        
	        else if (choice == 4)
	        {
	        	System.out.print("Enter a hexadeicmal number: ");
	        	number = in.next();
	        	checkInt = isInt(number);
	        	check = isHexa(number);
	        	
	        	while ( !checkInt || !check )
	    			{
	        		   if (!checkInt)  
	        		       System.out.println("Wrong!!! Not integer");
	        		   else if (!check)
	        			   System.out.println("Wrong!!! Not hexadeicmal");
	        		   
	        		   System.out.printf("\nEnter a deicmal number: ");
	               	   number = in.next();
	               	   checkInt = isInt(number);
	                   check = isHexa(number);  
	    			}
	       
	    		System.out.println("............................................\n");
	    		
	    		if (number.contentEquals("0"))
	            {
	    			// 0 is 0 in all number systems
	            	System.out.printf("In binary: 0\n");
	     	        System.out.printf("In decimal: 0\n");
	 			    System.out.printf("In octal: 0\n");
	 			    System.out.printf("In hexadecimal: 0\n"); 
	            }
	           
	            else 
	            {
	    		    System.out.printf("In hexadeicmal: %s\n",number);
	    	        c.hexaToBinPush(number);
			        System.out.printf("In binary: %s\n",c.hexaToBinPop());
			        System.out.printf("In decimal: %s\n",c.hexaToDec(number));
		            System.out.printf("In octal: %s\n",c.hexaToOct(number)); 
	            }

		    System.out.println("............................................\n");	
		    
	    	 }
	        System.out.print("Press any number to convert again,"
	          		+ " 0 to turn the caculator off>> ");
	        com = in.nextInt();
	        System.out.println("............................................\n");
			}// while loop end
			System.out.println("......................Caculator OFF.....................\n");
	        
	    }//end main
		
				
	 ////////Methods declaration 
	    static boolean isInt(String n)
	    {
	    	//This method to check if the number is integer or not

	    	isInt = true;
	    	int i = n.length() - 1;
	    	
	    	/*in the beginning, it's integer
	    	  until the complier see a dot*/
	    	while ( isInt && i >= 0 )
	    	{
	    		int y = n.charAt(i);
	    		// The ASCII value of the (dot) is 46
	    		// ASCII value of (-) is 45
	    		if ( y == 46 || y == 45 )
	    			isInt = false; 
	    		else 
	    			isInt = true;
	    		i--;
	    	}
		return isInt;
	    }
	    
	    
	    static boolean isBin(String n)
	    {
	    	/*This method to check if the number is binary
	  	      *Binary number is 0 and 1 */
	    	
	    	valid = true;
	    	int i = n.length()-1;
	    	
	    	/*in the beginning, it's binary
	    	  until something make it wrong*/
	    	while ( valid && i >= 0 )
	    	{
	    		int y = n.charAt(i) - '0';
	    		if ( y == 1 || y == 0 )
	    			valid = true; 
	    		else 
	    			valid = false;
	    		i--;
	    	}
	    	return valid;
	    }
	    	
	    
	    static boolean isOct(String n)
	    {
	    	/*This method to check if the number is octal
	    	  octal number is from 0-7 */
	       valid = true;
	  	   int i = n.length() - 1;
	  	   
	  	 /*in the beginning, it's octal
	 	  until something make it wrong*/
	  	   while ( valid && i >= 0 )
	  	   {
	  		   int y = n.charAt(i) - '0';
	  		   if ( y >= 0 && y < 8 )
	  			 valid = true; 
	  		   else 
	  			 valid = false;
	  		i--;
	  	   }
	  	    return valid;
	    }
	    
	    
	    static boolean isDec(String n)
	    {
	    	/*This method to check if the number is octal
	    	  octal number is from 0-7 */
	       valid = true;
	  	   int i = n.length()-1;
	  	   
	  	    /*in the beginning, it's octal
	 	      until something make it wrong*/
	  	   while ( valid && i >= 0 )
	  	   {
	  		   int y = n.charAt(i)-'0';
	  		   if ( y >= 0 && y < 10 )
	  			   valid = true; 
	  		   else
	  			   valid = false;
	  		i--;
	  	   }
	  	    return valid;
	    }
	    
	     
	    static boolean isHexa(String n)
	    {
	    	/*This method to check if the number is hexadecimal
	    	  hexadecimal number is from 0-9 and from A-F */
	       valid = true;
	  	   int i = n.length()-1;
	  	   
	  	    /*in the beginning, it's octal
	 	      until something make it wrong*/
	  	   while ( valid && i >= 0 )
	  	   {
	  		   int y = n.charAt(i) - '0';
	  		   char x = n.charAt(i);
	  		   
	  		   if ( y >= 0 && y < 10 )
	  			   valid = true; 
	  		   else if ( x == 'A' || x == 'a' )
	  			   valid = true;
				else if ( x == 'B' ||  x =='b')
					valid = true;
				else if ( x == 'C' || x =='c' )
					valid = true;
				else if ( x == 'D' || x =='d' )
					valid = true;
				else if ( x == 'E' || x =='e' )
					valid = true;
				else if ( x == 'F' || x =='f' )
					valid = true;
				else 
					valid = false;
	  		i--;
	  	   }
	  	    return valid;
	    }
	       
}//end class 