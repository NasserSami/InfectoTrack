import java.awt.*;
import javax.accessibility.Accessible;
import javax.swing.*;
import java.awt.event.*;

public class JMainMenu extends JMenuItem implements MenuElement, Accessible {

    Font customFont = new Font("Arial", Font.PLAIN, 14);

    JMenu mainMenu, subMenu, fileMenu;
    JMenuItem item1, item2, item3, item4, item5;
    JPanel currentPanel = null; // Track the currently visible panel

    public JMainMenu() {
        JFrame f = new JFrame("Menu Frame example");
        f.setFont(customFont);
        JMenuBar mb = new JMenuBar();
        fileMenu = new JMenu("File");
        fileMenu.setFont(customFont);
        mainMenu = new JMenu("Main Menu");
        mainMenu.setFont(customFont);
        subMenu = new JMenu("Sub Menu");
        subMenu.setFont(customFont);

        item5 = new JMenuItem("Export as");
        item5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.exportFile();
            }
        });

        item1 = new JMenuItem("Start / Stop");
        item1.setIcon(new ImageIcon("startbutton.png"));
        item1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Main.startStop();
            }
        });

        item2 = new JMenuItem("About");
        item2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPanel(f, new About(), BorderLayout.WEST, new Dimension(200, 200));
            }
        });

        item3 = new JMenuItem("Members");
        item3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showPanel(f, new Members(), BorderLayout.EAST, new Dimension(400, 200));
            }
        });

        item4 = new JMenuItem("Main Screen");

        fileMenu.add(item5);
        mainMenu.add(item1);
        mainMenu.add(item2);
        mainMenu.add(item3);
        mainMenu.add(item4);

        //mainMenu.add(subMenu);
        mb.add(fileMenu);
        
        mb.add(mainMenu);
        
        item1.setFont(customFont);
        item2.setFont(customFont);
        item3.setFont(customFont);
        item4.setFont(customFont);
        item5.setFont(customFont);
        //item6.setFont(customFont);

        f.setJMenuBar(mb);
        f.setSize(500, 500);
        f.setLayout(new BorderLayout());
        f.setVisible(true);
    }

    private void showPanel(JFrame frame, JPanel panel, String position, Dimension size) {
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
        new JMainMenu();
    }
}
