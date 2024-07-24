import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMainMenu extends JMenuItem implements MenuElement, Accessible {

    Font customFont = new Font("Arial", Font.PLAIN, 14);
    Color menuBarBackgroundColor = new Color(0x333333); // Dark gray background
    Color menuTextColor = Color.WHITE; // White text color

    JMenu mainMenu, fileMenu;
    JMenuItem item1, item2, item3, item4, item5;
    JPanel currentPanel = null; // Track the currently visible panel
    JFrame frame;
    JPanel mainDisplayPanel; // Panel for the main display

    public JMainMenu() {
        frame = new JFrame("Menu Frame example");
        frame.setFont(customFont);
        frame.setSize(500, 500);
        frame.setLayout(new BorderLayout());

        // Initialize and show the main display panel
        mainDisplayPanel = Main.createMainDisplay();
        Main.showDisplay(frame, mainDisplayPanel); // Initially show the main display

        JMenuBar mb = new JMenuBar();
        mb.setBackground(menuBarBackgroundColor); // Set background color

        fileMenu = new CustomMenuUI("File");
        fileMenu.setBackground(menuBarBackgroundColor); // Set background color
        fileMenu.setForeground(menuTextColor); // Set text color

        mainMenu = new CustomMenuUI("Main Menu");
        mainMenu.setBackground(menuBarBackgroundColor); // Set background color
        mainMenu.setForeground(menuTextColor); // Set text color

        item5 = new CustomMenuItemUI("Export as");
        item5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.exportFile();
            }
        });

        item1 = new CustomMenuItemUI("Start / Stop");
        item1.setIcon(new ImageIcon("startbutton.png"));
        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.startStop();
            }
        });

        item2 = new CustomMenuItemUI("About");
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanel(new About(), BorderLayout.CENTER, new Dimension(200, 200));
            }
        });

        item3 = new CustomMenuItemUI("Members");
        item3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanel(new Members(), BorderLayout.CENTER, new Dimension(400, 200));
            }
        });

        item4 = new CustomMenuItemUI("Main Screen");
        item4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                switchPanel(mainDisplayPanel, BorderLayout.CENTER, new Dimension(500, 500));
            }
        });

        fileMenu.add(item5);
        mainMenu.add(item1);
        mainMenu.add(item2);
        mainMenu.add(item3);
        mainMenu.add(item4);

        mb.add(fileMenu);
        mb.add(mainMenu);

        mb.setPreferredSize(new Dimension(300, 40));
        frame.setJMenuBar(mb);
        frame.setVisible(true);
    }

    private void switchPanel(JPanel panel, String position, Dimension size) {
        if (currentPanel != null) {
            frame.remove(currentPanel);
        }
        currentPanel = panel;
        panel.setPreferredSize(size);
        frame.add(panel, position);
        frame.revalidate();
        frame.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new JMainMenu());
    }
}
