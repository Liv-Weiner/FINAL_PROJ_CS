
public class Wheel 
{

	public int consonantAward(int timesInWord) 
	{
		int wheelValue = 100*((int)(Math.random()*10)+1);
		wheelValue = wheelValue * timesInWord;
		return wheelValue;
				
	}
	
}
