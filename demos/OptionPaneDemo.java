import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class OptionPaneDemo {

    public static void main(String[] args) {
        JFrame frame = new JFrame("My opinion");
        frame.setSize(580, 480); // Chinh kich co cua frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Chinh dung project khi tat frame
        frame.setLocationRelativeTo(null); // Hien giua man hinh
        
        JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER); // Them panel vao frame
        panel.setBorder(new TitledBorder("Opinion")); // Chinh duong vien
        panel.setLayout(new GridLayout(4, 1));
        
        ButtonGroup opinionGroup = new ButtonGroup(); // Tao nhom Button
        
        JRadioButton opinion1 = new JRadioButton("Hoc lap trinh rat de");
        panel.add(opinion1);
        opinionGroup.add(opinion1); // Them button vao nhom
        
        JRadioButton opinion2 = new JRadioButton("Nghi he rat vui");
        panel.add(opinion2);
        opinionGroup.add(opinion2); // Them button vao nhom
        
        JRadioButton opinion3 = new JRadioButton("Toi thich Netbeans");
        panel.add(opinion3);
        opinionGroup.add(opinion3); // Them button vao nhom
        
        JRadioButton opinion4 = new JRadioButton("Toi thich co nguoi yeu", true);
        panel.add(opinion4);
        opinionGroup.add(opinion4); // Them button vao nhom
        
        JButton confirmButton = new JButton("Confirm");
        frame.add(confirmButton, BorderLayout.PAGE_END);
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (opinion1.isSelected()) { // Kiem tra check box co chon hay chua
                    JOptionPane.showMessageDialog(
                            null, 
                            opinion1.getText()
                    );
                }
                
                if (opinion4.isSelected()) {
                    while (true) {
                        int choice = JOptionPane.showConfirmDialog(
                                null, 
                                "Chac chua?"
                        );

                        if (choice == JOptionPane.YES_OPTION) {
                            JOptionPane.showMessageDialog(
                                    null, 
                                    "Chuc mung"
                            );
                            break;
                        } else if (choice == JOptionPane.NO_OPTION) {
                            JOptionPane.showMessageDialog(
                                    null,
                                    "Vay ban chon lam gi?"
                            );
                            break;
                        }
                    }
                }
                
                if (opinion2.isSelected()) {
                    String input = JOptionPane.showInputDialog("Ban lam gi trong ki nghi");
                    
                    if (input != null && !input.isEmpty()) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Ki nghi cua ban: " + input
                        );
                    }
                }
                
                if (opinion3.isSelected()) {
                    String[] languages = {
                        "Java",
                        "C#",
                        "PHP",
                        "HTML"
                    };
                    int index = JOptionPane.showOptionDialog(
                            null, 
                            "Ngon ngu lap trinh", 
                            "Ngon ngu", 
                            JOptionPane.DEFAULT_OPTION, 
                            JOptionPane.QUESTION_MESSAGE, 
                            null, 
                            languages, 
                            languages[1]
                    );
                    JOptionPane.showMessageDialog(
                            null, 
                            "Ngon ngu da chon: " + languages[index]
                    );
                }
            }
        });
        
        frame.pack(); // Thu gon kich co vua voi cac thanh phan phia trong
        frame.setVisible(true);
    }
}
