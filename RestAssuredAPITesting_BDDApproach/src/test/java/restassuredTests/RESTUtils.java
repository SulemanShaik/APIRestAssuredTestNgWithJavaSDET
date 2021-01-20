package restassuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RESTUtils
{
	
	
	public static String  getFirstName()
	{
		
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		
		
		return ("shaik"+generatedString);
		
	}
	
	public static String getLastName()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(2);
		return ("suleman"+generatedString);
	}
	
	public static String getUserName()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		return ("john"+generatedString);
	}
	
	public static String getPassword()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		return ("perry"+generatedString);
	}
	
	public static String getGmail()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return (generatedString+"gmail.com");
	}
	
	public static String empName()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		return ("john"+generatedString);
	}
	
	public static String empSal()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(5);
		return (generatedString);
	}
	
	public static String empAge()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(3);
		return (generatedString);
	}
   
}
