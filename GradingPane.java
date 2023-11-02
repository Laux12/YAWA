import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradingPane{
	 JTextField sCode;
	JTextField sGrade;
	private Font myFont;
	private boolean filled = false;
	private float grade;
	private String subCode;
	 GradingPane(int id, String name){
		 	myFont = new Font("Inter",Font.BOLD,14);
		    sCode = new JTextField();
		    sCode.setFont(myFont);
	        sGrade = new JTextField();
	        sGrade.setFont(myFont);
	        JLabel sCodeLabel = new JLabel("Subject Code: ");
	        sCodeLabel.setFont(myFont);
	        
	        
	        JLabel sGradeLabel = new JLabel("Grade: ");
	        sGradeLabel.setFont(myFont);
	        
	        JPanel panel = new JPanel(new GridLayout(2,2,5,5));
	        panel.add(sCodeLabel);
	        panel.add(sCode);
	        panel.add(sGradeLabel);
	        panel.add(sGrade);

	        int result = JOptionPane.showConfirmDialog(
	           null,
	           panel,
	           "Enroll Student in Subject",
	           JOptionPane.OK_CANCEL_OPTION,
	           JOptionPane.PLAIN_MESSAGE
	        );
	        
	        if (result == 0) {
	          
	        	try {
	        		if(!sCode.getText().equals("")) {
	        		subCode = sCode.getText();
	        		grade = Float.parseFloat(sGrade.getText());
	        		int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to grade this student?\n" + 
	        		"Name: " + name + "\nID: " + id);
	        		if(confirm == 0) {
	        			filled = true;
	        		}
	        		}
	        	}
	        	catch(NumberFormatException e) {
	        		JOptionPane.showMessageDialog(null, "Please enter the correct Value","Error",JOptionPane.ERROR_MESSAGE);
	        	}
	        	
	        	
	        	
	        }
	    }
	 public String getSubjectCode() {
		 return subCode;
	 }
	 public float getGrade() {
		 return grade;
	 }
	 public boolean getFilled() {
		 return filled;
	 }
}