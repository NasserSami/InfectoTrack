import java.awt.Color;

public class Person
{
	private int xCoord;
	private int yCoord;
	private int diameter;
	private Color color;
	private int xIncrement;
	private int yIncrement;
	private boolean isAlive;
	private boolean isInfected

	public Person(int diam, Color color, int widthValue, int heightValue, bool isInfected)
	{
		this.diameter = diam;
		this.color = color;
		int randomX, randomY;
		boolean loopflag = true;
		isAlive = true;
		this.isInfected = isInfected;
		
		while(loopflag)
		{
			//generate a random value using widthValue
			randomX = (int)(Math.random() * widthValue);
			if(randomX >= 0 && randomX <= widthValue - this.diameter)
			{
				//we have a valid x value, assign it to xCoord
				this.xCoord = randomX;
				//System.out.println("STUB:Valid random xCoord value of " + randomX);
				loopflag = false;
			}
		}//end while
		
		loopflag = true;
		while(loopflag)
		{
			//repeat for yCoord
			randomY = (int)(Math.random() * heightValue);
			if(randomY >= 0 && randomY <= heightValue - this.diameter)
			{
				//we have a valid y value, assign it to yCoord
				this.yCoord = randomY;
				//System.out.println("STUB:Valid random yCoord value of " + randomY);
			  loopflag = false;
			}
		}//end while
		
		loopflag = true;
		while(loopflag)
		{
			this.xIncrement = (int)(Math.random()*11 - 5);
			this.yIncrement = (int)(Math.random()*11 - 5);		
			if(this.xIncrement ==0 && this.xIncrement ==0)
			{
			  //run it again
				this.xIncrement = (int)(Math.random()*11 - 5);
				this.yIncrement = (int)(Math.random()*11 - 5);
			}
			else
			{
				loopflag = false;
			}
		}//end loop
	}//end constructor
	
	public Color getColor()
	{
		return color;
	}

	public void setColor(Color color)
	{
		this.color = color;
	}

	//getters and setters
	public int getxCoord()
	{
		return xCoord;
	}
	public int getyCoord()
	{
		return yCoord;
	}
	public int getDiameter()
	{
		return diameter;
	}
	
	public void setxCoord(int xCoord)
	{
		this.xCoord = xCoord;
	}

	public void setyCoord(int yCoord)
	{
		this.yCoord = yCoord;
	}
  
	public int getxIncrement()
	{
		return xIncrement;
	}

	public void setxIncrement(int xIncrement)
	{
		this.xIncrement = xIncrement;
	}

	public int getyIncrement()
	{
		return yIncrement;
	}

	public void setyIncrement(int yIncrement)
	{
		this.yIncrement = yIncrement;
	}
}//end Person class
