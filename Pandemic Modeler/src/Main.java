import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 * Program Name: Main.java
 * Purpose: 
 * Coders: 
 * Date: Jul 19, 2024
 */

public class Main extends JPanel
{
	
	private final int WIDTH = 800, HEIGHT = 700;//size of JPanel
	private final int LAG_TIME = 50; // 250 time in milliseconds between re-paints of screen
	private Timer time;//Timer class object that will fire events every LAG_TIME interval
	private final int IMG_DIM =10; //size of ball to be drawn

	private final int ARRAY_SIZE = 500;//default to 500
	private Person [] personArray = new Person[ARRAY_SIZE];
	
	public Main()
	{
		//create the timer
		this.time = new Timer(LAG_TIME, new BounceListener() );

		//the first person is infected
		personArray[0] = new Person(IMG_DIM, Color.RED,WIDTH, HEIGHT);

		Color color = Color.BLUE;//color to pass in to Person constructor	

		for(int i = 1; i < personArray.length; i++)
		{
				personArray[i] = new Person(IMG_DIM, color, WIDTH, HEIGHT);
		}//end for

		this.setPreferredSize(new Dimension(WIDTH, HEIGHT) );
		this.setBackground(Color.WHITE);

		//start the timer
		this.time.start();	

	}//end Main constructor
	
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);

		for(int i = 0; i < personArray.length; i++)
		{
			//get the color
			g.setColor(personArray[i].getColor());
			g.fillOval(personArray[i].getxCoord(), personArray[i].getyCoord(),  personArray[i].getDiameter(), personArray[i].getDiameter());
		}
	}//end paintComponent over-ride
	
	//inner class to handle bounces
	private class BounceListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{
			for(int i = 0; i < personArray.length; i++)
			{
				calcPosition(personArray[i]);
			}
			
			int deltaX;//difference in pixels of the x coordinates of the two balls being compared.
			int deltaY;//difference in pixels of the y coordinates of the two balls being compared.
	
			int firstPersonX,  firstPersonY, secondPersonX, secondPersonY;
	
			
			for(int i = 0; i < personArray.length -1; i++)//LCC to length-1 to avoid out of bounds
			{
				//get the x and y co-ords of  first ball of the pair
				firstPersonX = personArray[i].getxCoord();
				firstPersonY = personArray[i].getyCoord();
				
				//Inner loop gets the second ball of the pair
				//start inner loop counter at i+1 so we don't compare the first ball to itself.
				for(int j = i+1; j < personArray.length; j++)
				{
					secondPersonX = personArray[j].getxCoord();
					secondPersonY = personArray[j].getyCoord();
					
					//now calculate deltaX and deltaY for the pair of balls
					deltaX = firstPersonX - secondPersonX;
					deltaY = firstPersonY - secondPersonY;
					//square them to get rid of negative values, then add them and take square root of total
					// and compare it to ball diameter held in IMG_DIM
					if(Math.sqrt(deltaX *deltaX + deltaY * deltaY) <= IMG_DIM)//if true, they have touched
					{					
						//ALSO, to get a bit of directional change generate a new set of random values for the xIncrement
						//  and yIncrement of each ball involved in the collision and assign them.
						int firstPersonnewxIncrement = (int)(Math.random()*11 - 5);
						int firstPersonnewyIncrement = (int)(Math.random()*11 - 5);
						int secondPersonnewxIncrement = (int)(Math.random()*11 - 5);
						int secondPersonnewyIncrement = (int)(Math.random()*11 - 5);
						
						//this will prevent balls from "getting stuck" on the borders.
						personArray[i].setxIncrement(firstPersonnewxIncrement);
						personArray[i].setyIncrement(firstPersonnewyIncrement);
						personArray[j].setxIncrement(secondPersonnewxIncrement);
						personArray[j].setyIncrement(secondPersonnewyIncrement);
						
						
						//IN VERSION FIVE change the color of a blue ball to red.
						if(personArray[i].getColor().equals(Color.RED) && personArray[j].getColor().equals(Color.BLUE))
						{
							//change second ball to color of first ball
							personArray[j].setColor(personArray[i].getColor());
						}
						if(personArray[j].getColor().equals(Color.RED) && personArray[i].getColor().equals(Color.BLUE))
						{
							//second ball is red, so change first ball to color of second ball 
							personArray[i].setColor(personArray[j].getColor());;
						}
					}//end if
				}//end inner for				
			}//end outer loop
			repaint();
		}//end method
	}//end inner class
	
	public void calcPosition(Person person)
	{
		
		if(person.getxCoord() >= WIDTH - person.getDiameter() )
		{
			person.setxIncrement(person.getxIncrement() * -1);
		}
		if(person.getxCoord() <= 0)
		{
			person.setxIncrement(person.getxIncrement() * -1);;
		}
		if(person.getyCoord() >= HEIGHT - person.getDiameter() )
		{
			person.setyIncrement(person.getyIncrement() * -1);
		}
		if(person.getyCoord() <= 0)
		{
			person.setyIncrement(person.getyIncrement() * -1);;
		}
		person.setxCoord(person.getxCoord() + person.getxIncrement());
		person.setyCoord(person.getyCoord() + person.getyIncrement());
	}//end calcPosition
	
	public static void main(String[] args)
	{
		// create a JFrame to hold the JPanel
		JFrame frame = new JFrame("InfectoTrack Project");
		
		//boilerplate
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout() );//ANONYMOUS object
		frame.setSize(1200,1000);
		frame.setLocationRelativeTo(null);
		
		//set background color of contentPane
		frame.getContentPane().setBackground(Color.BLUE);
		
		//create an ANONYMOUS object of the class and add the JPanel to the JFrame
		frame.add(new Main() );
		
		frame.pack();//shrinks the JFrame to the smallest size possible to conserve
		             //screen real estate. Comment it out to see its effect
		frame.setVisible(true);		
	}
	//end main
}
//end class
