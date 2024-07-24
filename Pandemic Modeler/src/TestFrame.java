/**
 * Program Name: TestFrame.java
 * Purpose: 
 * Coder: Sam Nasser 1139908 Sec 04
 * Date: Jul 24, 2024
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TestFrame extends JFrame
{
	public TestFrame()
	{
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(500,300);
		this.setLocationRelativeTo(null);
		this.setLayout(new BorderLayout() );
		
		this.add(new InputPanel());
		
		this.setVisible(true);
		
		
		
		
	}

	public static void main(String[] args)
	{
		new TestFrame();

	}
	//end main
}
//end class
