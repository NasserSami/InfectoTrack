import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        new JMainMenu();
    }

    public static void exportFile() {
        JFrame frame = new JFrame("Export Wizard");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // File Name Field
        JPanel fileNamePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        fileNamePanel.add(new JLabel("File Name:"));
        JTextField fileNameField = new JTextField(20);
        fileNamePanel.add(fileNameField);
        panel.add(fileNamePanel);

        // Folder Save Path
        JPanel pathPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pathPanel.add(new JLabel("Save Path:"));
        JTextField pathField = new JTextField(20);
        JButton browseButton = new JButton("Browse");
        pathPanel.add(pathField);
        pathPanel.add(browseButton);
        panel.add(pathPanel);

        // Add check buttons for including data
        JCheckBox[] checkBoxes = new JCheckBox[7];
        for (int i = 0; i < checkBoxes.length; i++) {
            checkBoxes[i] = new JCheckBox("Include data " + (i + 1));
            panel.add(checkBoxes[i]);
        }

        // Browse button action listener
        browseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int option = fileChooser.showOpenDialog(frame);
                if (option == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    pathField.setText(selectedFile.getAbsolutePath());
                }
            }
        });

        // Export Button
        JButton exportButton = new JButton("Export");
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String fileName = fileNameField.getText();
                String path = pathField.getText();
                if (fileName.isEmpty() || path.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please enter a file name and select a save path.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                File file = new File(path, fileName + ".txt");
                try (FileWriter writer = new FileWriter(file)) {
                    for (JCheckBox checkBox : checkBoxes) {
                        if (checkBox.isSelected()) {
                            writer.write(checkBox.getText() + "\n");
                        }
                    }
                    JOptionPane.showMessageDialog(frame, "File saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error saving file: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        panel.add(exportButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void startStop() {
        System.out.println("START CLICKED");
    }
}
