import javax.swing.*;
import java.awt.*;

public class CustomMenuUI extends JMenu {
    public CustomMenuUI(String text) {
        super(text);
        setOpaque(true);
        setBackground(new Color(0x444444)); // Darker background for menu
        setForeground(Color.WHITE); // White text color
        setFont(new Font("Arial", Font.PLAIN, 14));
    }
}


