package stupid.controller;

import stupid.model.ThirdStupid;
import stupid.vew.StupidDisplay;

public class StupidController
{
	private StupidDisplay popup;
	
	public StupidController()
	{
		popup = new StupidDisplay();
	}
	
	public void start()
	{
		ThirdStupid tester = new ThirdStupid("Tom", 0);
		popup.displayText(tester.toString());
		
		ifStuffTest(tester);
	}
	
	private void ifStuffTest(ThirdStupid currentTest)
	{
		int sAge = 0;
		String ageTest = popup.getResponse("What age would you like for the test?");
		while (!isValidInteger(ageTest))
		{
			ageTest = popup.getResponse("Please type an integer. What would you like the age to be?");
		}	
		sAge = Integer.parseInt(ageTest);
		
		if (sAge > 0)
		{
			popup.displayText("The test is a valid human age.");
		}
		else if (sAge < 0)
		{
			popup.displayText("The test isn't a valid human age.");
		}
	}
	
	// Helper methods
	private boolean isValidInteger(String sampleInt)
	{
		boolean valid = false;

		try
		{
			Integer.parseInt(sampleInt);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("Only integer values are valid: " + sampleInt + " is not.");
		}

		return valid;
	}

	private boolean isValidDouble(String sampleDouble)
	{
		boolean valid = false;

		// Try and catch test a primitive (this one double) is actually a double and if it's not it catches
		// it instead of crashing your program
		try
		{
			Double.parseDouble(sampleDouble);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("Only double values are valid: " + sampleDouble + " is not.");
		}

		return valid;
	}

	private boolean isValidBoolean(String sampleBoolean)
	{
		boolean valid = false;

		try
		{
			Boolean.parseBoolean(sampleBoolean);
			valid = true;
		}
		catch (NumberFormatException error)
		{
			popup.displayText("Only boolean values are valid: " + sampleBoolean + " is not.");
		}

		return valid;
	}
}
