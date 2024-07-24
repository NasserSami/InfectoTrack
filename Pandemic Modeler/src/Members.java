import javax.swing.*;
import java.awt.*;

public class Members extends JPanel {
	
    Font customFont = new Font("Arial", Font.PLAIN, 14);

    public Members() {
        setBackground(Color.LIGHT_GRAY);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
       
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
    }

    private JPanel createMemberPanel(String name, String email) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.LIGHT_GRAY);

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(customFont);
        JLabel emailLabel = new JLabel(email);
        emailLabel.setFont(customFont);
        emailLabel.setForeground(Color.GRAY);

        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        emailPanel.setBackground(Color.LIGHT_GRAY);
        emailPanel.add(emailLabel);

        panel.add(nameLabel, BorderLayout.WEST);
        panel.add(emailPanel, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Members");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.add(new Members());
        frame.setVisible(true);
    }
}
