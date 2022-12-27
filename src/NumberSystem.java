import java.util.Stack;
public class NumberSystem {
	
	public Stack<Integer> si = new Stack<Integer>();
	public Stack<String> ss = new Stack<String>();
	
///////////////////////convert decimal to any number system/////////////////////////////
	
	/*divide by the base of that system 
	 * and keep track to the reminder. 
	 * Thus, we will save the value in a stack until it become 0
	 * we will pop the values until the stack become empty to have the answer */
	
	public void decToBinPush(int n)
	{
		// this variable to keep the reminder values 
		int rem;
			while (n>0)
		    {
			   rem = n % 2;
			   si.push(rem);
			   n /= 2;
		    }
	}
	
	
	public String decToBinPop()
	{
		String result="";
		
		while(!si.isEmpty())
			result += si.pop();
		return result;
	}
	
	
	public void decToOctPush(int n)
	{
		int rem;
			while (n>0)
		    {
			   rem = n % 8;
			   si.push(rem);
			   n /= 8;
		    }
	}
	
	
	public String decToOctPop()
	{
		String result="";
		
		while(!si.isEmpty())
			result += si.pop();
		return result;
	}
	
	
	public void decToHexaPush(int n)
	{
		int rem;
			while (n>0)
		    {
			   rem = n % 16;
			   si.push(rem);
			   n /= 16;
		    }
	}
	
	
	public String decToHexaPop()
	{
		String result="";
		
		while( !si.isEmpty() )
		{
			int poped = si.pop();
			
			 /*to represent 10 - 15 in hexadecimal,
			   we have to represent it by letter*/
			
		    if (poped == 10)
			   result += "A";
		    else if (poped == 11)
		    	result += "B";
		    else if (poped == 12)
		    	result += "C";
		    else if (poped == 13)
		    	result += "D";
		    else if (poped == 14)
		    	result += "E";
		    else if (poped == 15)
		    	result += "F";
		    else
			   result += poped;	
		}
		return result;
	}
	
///////////////////////convert from any system to decimal/////////////////////////////
	
	/*multiply each digit by the base of the system to the power n.
	 * n is the "weight" of the bit
	 * The weight is the position of the digit 
	 * starting from 0 on the right 
	 * add the results */
	
	public int binToDec(String n)
	{
		//the variable pos is the weight(position) of each bit
		int pos = n.length() - 1; 
		int i = 0;
		//the variable result to contain the final conversion.
		int result = 0;
		
		while ( i < n.length() )
		{
			//converting from string to integer to take one digit at a time.
			int y = n.charAt(i) - '0';
			if (y == 1)
				result += (int)( Math.pow(2,pos) );	
            pos--;
            i++;
		}
		return result;
	}
	
	
	public int octToDec(String n)
	{
		int pos = n.length()-1; 
		int i = 0;
		int result = 0;
		
		while ( i<n.length()  )
		{
			int y = n.charAt(i)-'0';
             result += (int) ( Math.pow(8,pos) * y );
			
            pos--;
            i++;
		}
		return result;
	}
		
	
	public int hexaToDec(String n)
	{
		int pos = n.length()-1; 
		int result = 0;
		
		for (int i=0; i < n.length(); i++)
		{
			int y;
			char ch = n.charAt(i);
			
			  //we have to know the value of the letters in hexa
			if ( ch == 'A' || ch == 'a')
				y= 10;
			else if ( ch == 'B' || ch == 'b' )
				y= 11;
			else if ( ch == 'C' || ch == 'c' )
				y= 12;
			else if ( ch == 'D' || ch == 'd')
				y= 13;
			else if ( ch == 'E' || ch == 'e' )
				y= 14;
			else if ( ch == 'F' || ch == 'f' )
				y= 15;
			else 
				y = ch - '0';
			
            result += (int)( Math.pow(16,pos) * y );
            pos--;
		}
		return result;
	}
	
///////////////////////octal to binary and hexadecimal/////////////////////////////
	
	/*To convert form octal to binary
	 * convert each octal digit to 3-bit
	 * equivalent binary representation
	 * and push it into the stack
	 * then pop the values to see the result */
	
	public void octToBinPush(String n)
	{
        int i = n.length()-1;
		while ( i >= 0 )
		{
			char y = n.charAt(i);
			if (y == '0')
				ss.push("000");
			else if (y == '1')
				ss.push("001");
			else if (y == '2')
				ss.push("010");
			else if (y == '3')
				ss.push("011");
			else if (y == '4')
				ss.push("100");
			else if (y == '5')
				ss.push("101");
			else if (y == '6')
				ss.push("110");
			else if (y == '7')
				ss.push("111");
			i--;		
		}	
	}
	
	
	public String octToBinPop()

	{
		String result;
		
		/*not to print the first left zero's
		 * just if the number is 1 - 3*/
		String first = ss.pop();
		
		if (first.equals("000"))
			result = "";
		
		else if (first.equals("001"))
			result = "1";
		
		else if (first.equals("010"))
			result = "10";
		
		else if (first.equals("011"))
			result = "11";
	    else
			result = first;
		
		//now pop the rest
		while (!ss.isEmpty())
		    result += ss.pop();
		
		return result;
	}

	
	
	/*To convert from octal to hexadecimal
	 * first we will convert it to binary
	 * then convert the binary number to hexadecimal*/
	
	public String octToHexa(String n)
	{
		octToBinPush(n);
		String bin =  octToBinPop();
		String result = binToHexa(bin);
		return result; 
	}
	
///////////////////////binary to octal and hexadecimal/////////////////////////////
	
	/*To convert from binary to octal
	 * first we will convert it to decimal
	 * then convert the decimal number to octal*/
	
    public String binToOct(String n)
    {
		int dec = binToDec(n);
		decToOctPush(dec);
	    String oct = decToOctPop();  	
		return oct;
	}
    
    /*To convert from binary to hexadecimal
	 * first we will convert it to decimal
	 * then convert the decimal number to hexadecimal*/
    
    public String binToHexa(String n)
    {
		int dec = binToDec(n);
		decToHexaPush(dec);
		String hexa = decToHexaPop(); 	
		return hexa;
	}
    
///////////////////////Hexadecimal to binary and octal/////////////////////////////
    
    /*To convert form hexadecimal to binary
	 * convert each octal digit to 4-bit
	 * equivalent binary representation
	 * and push it into the stack
	 * then pop the values to see the result */
    
    public void hexaToBinPush(String n)
	{
		for (int i = n.length()-1; i>=0; i--)
		{
			char y = n.charAt(i);
			
			if (y == '0')
				ss.push("0000");
			else if (y == '1')
				ss.push("0001");
			else if (y == '2')
				ss.push("0010");
			else if (y == '3')
				ss.push("0011");
			else if (y == '4')
				ss.push("0100");
			else if (y == '5')
				ss.push("0101");
			else if (y == '6')
				ss.push("0110");
			else if (y == '7')
				ss.push("0111");
			else if (y == '8')
				ss.push("1000");
			else if (y == '9')
				ss.push("1001");
			else if (y == 'A' || y=='a')
				ss.push("1010");
			else if (y == 'B' || y=='b')
				ss.push("1011");
			else if (y == 'C' || y=='c')
				ss.push("1100");
			else if (y == 'D' || y=='d')
				ss.push("1101");
			else if (y == 'E' || y=='e')
				ss.push("1110");
			else if (y == 'F' || y=='f')
				ss.push("1111");		
		}
	}
	
    
	public String hexaToBinPop()
	{
		String result;
		
		//print the top without zero's on the left
		String first = ss.pop();
		
		 if (first.equals("0000"))
				result = "";
		
		 else if (first.equals("0001"))
			result = "1";
		
		 else if (first.equals("0010"))
			 result = "10";
		
		 else if (first.equals("0011"))
			 result = "11";
		   
		 else if (first.equals("0100"))
			 result = "100";
		   
		 else if (first.equals("0101"))
			 result = "101";
		   
		 else if (first.equals("0110"))
			 result = "110";
		   
		 else if (first.equals("0111"))
			 result = "111";
		 
		 else
			 result = first;
			
		   // pop the rest and save them
		   while (!ss.isEmpty())
			   result += ss.pop();
		   return result;
	}
	
	/*To convert from octal to hexadecimal
	 * first we will convert it to binary
	 * then convert the binary number to hexadecimal*/
	
	public String hexaToOct(String n)
	{
		hexaToBinPush(n);
		String bin = hexaToBinPop();
		String oct = binToOct(bin);
		return oct;
	}
	
////////////
}//end class