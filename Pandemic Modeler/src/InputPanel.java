/**
 * Program Name: InputPanel.java
 * Purpose: 
 * Coder: Sam Nasser 1139908 Sec 04
 * Date: Jul 24, 2024
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InputPanel extends JPanel
{
    private JSpinner populationField, unvaccinatedField ,  oneShotField ,   twoShotField ,  recoveredField;

    public InputPanel()
    {

	    super();
	
	    this.setLayout(new GridLayout(8, 2) );
	    
	
	    populationField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
	    unvaccinatedField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
	    oneShotField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
	    twoShotField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
	    recoveredField = new JSpinner(new SpinnerNumberModel(0, 0, 100, 1));
	    
	    //populationField.setEditor(new JSpinner()).getTextField().setEditable(false);
	
	
	     //Buttons
	    JButton pause = new JButton("Pause");
	    JButton resume = new JButton("Resume");
	
	    // add to the panel
	    this.add(new JLabel("Population Size:"));
	    this.add(populationField);
	    this.add(new JLabel("Unvaccinated (%):"));
	    this.add(unvaccinatedField);
	
	    this.add(new JLabel("One Shot (%):"));
	    this.add(oneShotField);
	
	    this.add(new JLabel("Two Shots (%):"));
	    this.add(twoShotField);
	
	    this.add(new JLabel("Recovered (%):"));
	    this.add(recoveredField);
	    
	    this.add(pause);
	    this.add(resume);





    }



}
//end class

