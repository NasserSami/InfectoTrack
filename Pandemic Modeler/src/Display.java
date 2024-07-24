import javax.swing.*;
import java.awt.*;

public class Display extends JPanel {
	
	public Display() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		JLabel displayLabel = new JLabel("display label", JLabel.CENTER);
		add(displayLabel, BorderLayout.CENTER);
	}
	
	
}
