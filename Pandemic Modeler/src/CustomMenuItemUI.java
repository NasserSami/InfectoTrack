import java.awt.Color;
import java.awt.Font;

import javax.swing.JMenuItem;

public class CustomMenuItemUI extends JMenuItem {
    public CustomMenuItemUI(String text) {
        super(text);
        setOpaque(true);
        setBackground(new Color(0x666666)); // Darker background for menu items
        setForeground(Color.WHITE); // White text color
        setFont(new Font("Arial", Font.PLAIN, 14));
    }
}