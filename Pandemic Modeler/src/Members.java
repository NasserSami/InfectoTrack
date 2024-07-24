import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;

public class Members extends JPanel {

    Font customFont = new Font("Arial", Font.PLAIN, 14);

    public Members() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(300, 200)); // Set preferred size

        // Sample data
        String[][] members = {
            {"Nikolas Peesker", "n_peesker@fanshaweonline.ca"},
            {"Sam Nasser", "s_nasser186980@fanshaweonline.ca"},
            {"Saima Yousaf", "s_yousaf@fanshaweonline.ca"},
            {"CJ Okoye", "c_okoye140155@fanshaweonline.ca"},
            {"Brendan Goddard", "b_goddard198580@fanshaweonline.ca"}
        };

        for (String[] member : members) {
            add(createMemberPanel(member[0], member[1]));
        }
        
        // Add a panel at the bottom
        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(300, 50)); // Space for the bottom panel
        bottomPanel.setBackground(Color.GRAY);
        add(bottomPanel);
    }

    private JPanel createMemberPanel(String name, String email) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(new EmptyBorder(5, 5, 5, 5)); // Padding around the panel

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(customFont);
        nameLabel.setBorder(new EmptyBorder(0, 0, 0, 10)); // Padding to the right

        JLabel emailLabel = new JLabel(email);
        emailLabel.setFont(customFont);
        emailLabel.setForeground(Color.GRAY);
        emailLabel.setBorder(new EmptyBorder(0, 0, 0, 10)); // Padding to the right

        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        emailPanel.setBackground(Color.LIGHT_GRAY);
        emailPanel.add(emailLabel);

        panel.add(nameLabel, BorderLayout.EAST);
        panel.add(emailPanel, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Members");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300); // Size of the frame
        frame.setLayout(new BorderLayout());

        Members membersPanel = new Members();
        frame.add(membersPanel, BorderLayout.CENTER);


        frame.setVisible(true);
    }
}
