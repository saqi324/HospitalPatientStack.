package HospitalPatientStack;
import javax.swing.*;
        import java.awt.*;
        import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HospitalGUI extends JFrame {
    private StackDS stack = new StackDS();
    private JTextField txtId, txtName, txtAge, txtDisease;
    private JTextArea outputArea;

    public HospitalGUI() {
        setTitle("🏥 Hospital Patient Management (Stack)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(750, 600);
        setLayout(null);

        // background
        JLabel bgLabel = new JLabel();
        bgLabel.setBounds(0, 0, 750, 600);
        ImageIcon bg = new ImageIcon("images/hospital.jpg");
        Image scaled = bg.getImage().getScaledInstance(750, 600, Image.SCALE_SMOOTH);
        bgLabel.setIcon(new ImageIcon(scaled));
        add(bgLabel);

        JPanel panel = new JPanel(null);
        panel.setOpaque(false);
        panel.setBounds(20, 20, 700, 500);
        bgLabel.add(panel);

        JLabel lblId = new JLabel("Patient ID:");
        lblId.setBounds(20, 20, 100, 30);
        panel.add(lblId);
        txtId = new JTextField();
        txtId.setBounds(130, 20, 150, 30);
        panel.add(txtId);

        JLabel lblName = new JLabel("Name:");
        lblName.setBounds(20, 70, 100, 30);
        panel.add(lblName);
        txtName = new JTextField();
        txtName.setBounds(130, 70, 150, 30);
        panel.add(txtName);

        JLabel lblAge = new JLabel("Age:");
        lblAge.setBounds(20, 120, 100, 30);
        panel.add(lblAge);
        txtAge = new JTextField();
        txtAge.setBounds(130, 120, 150, 30);
        panel.add(txtAge);

        JLabel lblDisease = new JLabel("Disease:");
        lblDisease.setBounds(20, 170, 100, 30);
        panel.add(lblDisease);
        txtDisease = new JTextField();
        txtDisease.setBounds(130, 170, 150, 30);
        panel.add(txtDisease);

        JButton btnAdd = new JButton("Add (Push)");
        btnAdd.setBounds(320, 20, 150, 30);
        panel.add(btnAdd);

        JButton btnShow = new JButton("Show All");
        btnShow.setBounds(320, 70, 150, 30);
        panel.add(btnShow);

        JButton btnUpdate = new JButton("Update Top");
        btnUpdate.setBounds(320, 120, 150, 30);
        panel.add(btnUpdate);

        JButton btnDelete = new JButton("Delete Top (Pop)");
        btnDelete.setBounds(320, 170, 150, 30);
        panel.add(btnDelete);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(20, 230, 650, 250);
        panel.add(scrollPane);

        // Action Listeners
        btnAdd.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String name = txtName.getText();
                int age = Integer.parseInt(txtAge.getText());
                String disease = txtDisease.getText();
                stack.push(new Record(id, name, age, disease));
                JOptionPane.showMessageDialog(this, "Patient added successfully!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid input.");
            }
        });

        btnShow.addActionListener(e -> outputArea.setText(stack.displayString()));

        btnUpdate.addActionListener(e -> {
            try {
                int id = Integer.parseInt(txtId.getText());
                String name = txtName.getText();
                int age = Integer.parseInt(txtAge.getText());
                String disease = txtDisease.getText();
                stack.updateTop(new Record(id, name, age, disease));
                JOptionPane.showMessageDialog(this, "Top record updated!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Please enter valid input.");
            }
        });

        btnDelete.addActionListener(e -> {
            Record removed = stack.pop();
            if (removed != null)
                JOptionPane.showMessageDialog(this, "Removed: " + removed);
            else
                JOptionPane.showMessageDialog(this, "Stack is empty!");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HospitalGUI().setVisible(true);
        });
    }
}
