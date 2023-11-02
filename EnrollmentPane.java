import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class EnrollmentPane{
	private JPanel p1;
	private JLabel sCode, sCourse, sDescription, sSchedule, sSection,secCode;
	private JTextField tF1, tF2, tF3, tF4, tF5, tF;
	private Font myFont;
	String code,descrip,sched,section,sectionCode,name;
	int units,id;
	private boolean filled = false;
	EnrollmentPane(String name,int id){
		
		myFont = new Font("Inter",Font.BOLD,15);
		p1 = new JPanel();
		p1.setLayout(new GridLayout(6,2,10,3));
		
		sCode = new JLabel("Section Code:");
		sCode.setFont(myFont);
		tF1 = new JTextField();
		tF1.setFont(myFont);
		
		secCode = new JLabel("Subject Code:");
		secCode.setFont(myFont);
		tF = new JTextField();
		tF.setFont(myFont);
		
		sCourse = new JLabel("Subject Description:");
		sCourse.setFont(myFont);
		tF2 = new JTextField();
		tF2.setFont(myFont);
		
		
		sDescription = new JLabel("Subject Units:");
		sDescription.setFont(myFont);
		tF3 = new JTextField();
		tF3.setFont(myFont);
		
		sSchedule = new JLabel("Subject Schedule:");
		sSchedule.setFont(myFont);
		tF4 = new JTextField();
		tF4.setFont(myFont);
		
		sSection = new JLabel("Section:");
		sSection.setFont(myFont);
		tF5 = new JTextField();
		tF5.setFont(myFont);
		
		
		p1.add(sCode);
		p1.add(tF);
		p1.add(secCode);
		p1.add(tF1);
		p1.add(sCourse);
		p1.add(tF2);
		p1.add(sDescription);
		p1.add(tF3);
		p1.add(sSchedule);
		p1.add(tF4);
		p1.add(sSection);
		p1.add(tF5);
	
		
		int result = JOptionPane.showConfirmDialog(null,p1, "Enroll A Student",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
		
		
		try {
		if(result == 0) {
			if(!tF.getText().equals("") && !tF1.getText().equals("") && !tF2.getText().equals("") && !tF3.getText().equals("") && !tF4.getText().equals("") && !tF5.getText().equals("")) {
				sectionCode = tF.getText();
				descrip= tF2.getText();
				sched = tF4.getText();
				section = tF5.getText();
				units = Integer.parseInt(tF3.getText());
				code = tF1.getText();
				setSubjectEnrolled(sectionCode,code,descrip,section,sched,units);
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want you enroll this student to subject?\n" +
				"Name: " + name + "\nID: " + id + "\n\nSection Code: " + 	sectionCode + "\nSubject Code: " + code + 
				"\nDescription: " + descrip + "\nSchedule: " + sched + "\nSection: " + section + "\n", "Confirm Enrollment", JOptionPane.YES_NO_OPTION);
				if(confirm == 0) {
				filled = true;
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "Please fill in all information","Warning",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please enter a correct Value","Warning",JOptionPane.WARNING_MESSAGE);
			
		}
	}
	public void setSubjectEnrolled(String sectionCode,String code,String descrip,String section,String sched,int units) {
		this.sectionCode = sectionCode;
		this.code = code;
		this.descrip = descrip;
		this.section = section;
		this.sched = sched;
		this.units = units;
	}
	public enrolledSubject getSubject() {
		return new enrolledSubject(sectionCode.toUpperCase(),
				code.toUpperCase(),descrip.toUpperCase(),
				section.toUpperCase(),sched.toUpperCase(),units);
		
	}
	public boolean filled() {
		return filled;
	}
	
}