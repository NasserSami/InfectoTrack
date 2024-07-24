import javax.swing.*;
import java.awt.*;

public class About extends JPanel {

	public About() {
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		JLabel aboutLabel = new JLabel("About page", JLabel.CENTER);
		add(aboutLabel, BorderLayout.CENTER);
	}

}
