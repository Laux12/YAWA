import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Frame extends JFrame implements ActionListener,ListSelectionListener{
	private static final long serialVersionUID = 1L;
	JTextField studentId,studentName,studentProgram,studentYear;
	JPanel panel1,panel2,panel3,panel4;
	JLabel idLabel,nameLabel,programLabel,yearLabel;
	JButton idLabel1,nameLabel1,programLabel1,yearLabel1;
	Color myColor,myColor1;
	Font myFont;
	JButton[] accessButton = new JButton[7];
	JButton addButton,updateButton,deleteButton,enrollButton,viewButton,gradeButton,corButton;
	Table table = new Table();
	ListSelectionModel selectedRow;
	int studentID = 1000,id;
	String name,year,program;
	Frame(){
		myColor = Color.decode("#D2E0FB");
		myColor1 = Color.decode("#176B87");
		myFont = new Font("Inter",Font.BOLD,15);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,600);
		this.setTitle("Student Enrollment System");
		this.setLayout(null);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
		panel1 = new JPanel();
		panel1.setBounds(0,3,785,97);
		panel1.setLayout(new GridLayout(3,4,-1,3));
		panel1.setBackground(myColor);
		panel1.setOpaque(true);
		
		
		idLabel = new JLabel("  ID");
		idLabel.setBackground(myColor);
		idLabel.setForeground(myColor1);
		idLabel.setFont(myFont);
		idLabel.setOpaque(true);
		
		nameLabel = new JLabel("  Name");
		nameLabel.setBackground(myColor);
		nameLabel.setForeground(myColor1);
		nameLabel.setFont(myFont);
		nameLabel.setOpaque(true);
		
		programLabel = new JLabel("  Program");
		programLabel.setBackground(myColor);
		programLabel.setForeground(myColor1);
		programLabel.setFont(myFont);
		programLabel.setOpaque(true);
		
		yearLabel = new JLabel("  Year");
		yearLabel.setBackground(myColor);
		yearLabel.setForeground(myColor1);
		yearLabel.setFont(myFont);
		yearLabel.setOpaque(true);
		
		studentId = new JTextField();
		studentId.setFocusable(false);
		studentId.setFont(myFont);
		
		studentName = new JTextField();
		studentName.setFont(myFont);
		studentProgram = new JTextField();
		studentProgram.setFont(myFont);
		studentYear = new JTextField();
		studentYear.setFont(myFont);
		
		idLabel1 = new JButton("ID");
		idLabel1.setBackground(myColor);
		idLabel1.setForeground(myColor1);
		idLabel1.setFont(myFont);
		idLabel1.setFocusable(false);
		
		nameLabel1 = new JButton("Name");
		nameLabel1.setBackground(myColor);
		nameLabel1.setForeground(myColor1);
		nameLabel1.setFont(myFont);
		nameLabel1.setFocusable(false);
		
		programLabel1 = new JButton("Program");
		programLabel1.setBackground(myColor);
		programLabel1.setForeground(myColor1);
		programLabel1.setFont(myFont);
		programLabel1.setFocusable(false);
		
		yearLabel1 = new JButton("Year");
		yearLabel1.setBackground(myColor);
		yearLabel1.setForeground(myColor1);
		yearLabel1.setFont(myFont);
		yearLabel1.setFocusable(false);
		
		panel1.add(idLabel);
		panel1.add(studentId);
		panel1.add(nameLabel);
		panel1.add(studentName);
		panel1.add(programLabel);
		panel1.add(studentProgram);
		panel1.add(yearLabel);
		panel1.add(studentYear);
		panel1.add(idLabel1);
		panel1.add(nameLabel1);
		panel1.add(programLabel1);
		panel1.add(yearLabel1);
		
		panel2 = new JPanel();
		panel2.setBounds(0,490, 800,80);
		panel2.setBackground(myColor);
		panel2.setLayout(null);
		panel2.setBorder(BorderFactory.createEtchedBorder());	
		
		panel3 = new JPanel();
		panel3.setBounds(43,panel2.getHeight() / 4, 700,35);
		panel3.setBackground(Color.decode("#D2E0FB"));
		panel3.setLayout(new GridLayout(1,7,15,0));
		
		for(int i =0; i < accessButton.length; i++) {
			accessButton[i] = new JButton();
			accessButton[i].setBackground(Color.decode("#78D6C6"));
			accessButton[i].setFont(new Font("Inter",Font.BOLD,12));
			accessButton[i].setForeground(myColor1);
			accessButton[i].setFocusable(false);
			accessButton[i].setBorder(BorderFactory.createEtchedBorder());
			accessButton[i].addActionListener(this);
		}
		accessButton[0].setText("ADD");
		addButton = accessButton[0];
		
		accessButton[1].setText("UPDATE");
		updateButton = accessButton[1];
		
		accessButton[2].setText("DELETE");
		deleteButton = accessButton[2];
		
		accessButton[3].setText("ENROLL");
		enrollButton = accessButton[3];
		
		accessButton[4].setText("ADD GRADE");
		gradeButton = accessButton[4];
		
		accessButton[5].setText("VIEW GRADE");
		viewButton = accessButton[5]; 
		
		accessButton[6].setText("COR");
		corButton = accessButton[6];
		
		for(int i =0; i < accessButton.length; i++) {
			panel3.add(accessButton[i]);
		}
		
		panel4 = new JPanel();
		//panel4.setBackground(Color.black);
		panel4.setBounds(0,panel1.getHeight() + 2,786,600 - panel1.getHeight() - 112);
		panel4.setLayout(new GridLayout());
		
		selectedRow = table.table.getSelectionModel();
		selectedRow.addListSelectionListener(this);
		
		panel4.add(table.table);
		panel2.add(panel3);
		this.add(panel4);
		this.add(panel2);
		this.add(panel1);
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == addButton) {
			int checker = 1;
			String studentname = studentName.getText().toUpperCase();
			if(table.studentList.size() != 0) {
				for(int i = 0;i < table.studentList.size(); i++) {
					if(table.studentList.get(i).getName().equals(studentname)) {
						JOptionPane.showMessageDialog(null, "Student name already Exist","Message",JOptionPane.ERROR_MESSAGE);
						emptyTheTextField();
						checker = 0;
					}
					
				
				}
			}
			if(checker != 0) {
				if(!studentName.getText().equals("") && !studentProgram.getText().equals("") && !studentYear.getText().equals("")) {
					int id = studentID + 1;
					studentID += 1;
					String name = studentname;
					String year = studentYear.getText().toUpperCase();
					String program = studentProgram.getText().toUpperCase();
					
					table.addStudent(new Student(id,name,year,program));
					emptyTheTextField();
					JOptionPane.showMessageDialog(null, "Student " + id + " Added Successfully","Message",JOptionPane.PLAIN_MESSAGE);
			
				}
				else {
				JOptionPane.showMessageDialog(null, "Please fill in all information","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		if(e.getSource() == updateButton) {
			if(studentName.getText().equals(name) && studentProgram.getText().equals(program) && studentYear.getText().equals(year)) {
				JOptionPane.showMessageDialog(null, "There is No Changes","Information",JOptionPane.INFORMATION_MESSAGE);
				emptyTheTextField();
			}else
			if(!studentName.getText().equals("") && !studentProgram.getText().equals("") && !studentYear.getText().equals("")) {
			int id = Integer.parseInt(studentId.getText());
			String name = studentName.getText().toUpperCase();
			String year = studentYear.getText().toUpperCase();
			String program = studentProgram.getText().toUpperCase();
			
			table.updateStudent(id,name,year,program);
			emptyTheTextField();
			JOptionPane.showMessageDialog(null, "Student " + id + " Updated Successfully","Message",JOptionPane.PLAIN_MESSAGE);
			
			
			}
			
			else if(id == 0) {
				JOptionPane.showMessageDialog(null, "Please select A Student to Update","Warning",JOptionPane.WARNING_MESSAGE);
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Please fill in all information","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource() == deleteButton) {
			if(id != 0) {
			table.deleteStudent(id);
			emptyTheTextField();
			JOptionPane.showMessageDialog(null, "Student " + id + " Deleted Successfully","Message",JOptionPane.PLAIN_MESSAGE);
			
			
			id = 0;
			}else {
				JOptionPane.showMessageDialog(null, "Please Select A Student to Delete","Warning",JOptionPane.WARNING_MESSAGE);
				
			}
		}
		if(e.getSource() == enrollButton) {
			if(id != 0) {
				EnrollmentPane enroll = new EnrollmentPane(name, id);
				
				if(enroll.filled()) {
					int i = 0;
					while(table.studentList.get(i).getID() != id) {//check ang index sa id sa student
						i++;
						
					}
					int index = 0;
					boolean exist = false;
					if(table.studentList.get(i).getSubject().size() != 0) {
						System.out.println(table.studentList.get(i).getSubject().size());
					while(index < table.studentList.get(i).getSubject().size()) {
						if(table.studentList.get(i).getSubject().get(index).getSubCode().toUpperCase().equals(enroll.getSubject().getSubCode())) {
							exist = true;
							break;
						}
						else {
							index++;
							}
					}	
					}
					if(!exist) {
						
					table.studentList.get(i).addSubject(enroll.getSubject());
					table.studentList.get(i).addGrade(0);
					table.studentList.get(i).setEnrolled(true);
					
					JOptionPane.showMessageDialog(null, "Student " + id + " Enrolled to subject Succesfully","Success",JOptionPane.PLAIN_MESSAGE);
					}else {
						JOptionPane.showMessageDialog(null, "Student Already Enrolled to this subject","Warning",JOptionPane.ERROR_MESSAGE);
						
					}
				}
			}else {
				JOptionPane.showMessageDialog(null, "Please Select A Student to Enroll","Warning",JOptionPane.WARNING_MESSAGE);
			}
		}
		if(e.getSource() == gradeButton) {
			int i = 0;
			while(table.studentList.get(i).getID() != id) {//check ang index sa id sa student
				i++;
				
			}
			if(id != 0) {
				if(table.studentList.get(i).getEnrolled()) {
					GradingPane grading = new GradingPane(id,name);
						if(grading.getFilled()) {
							int index = 0;
							boolean exist = false;
							while(index <= table.studentList.get(i).getSubject().size() - 1) {
								if(table.studentList.get(i).getSubject().get(index).getSubCode().equals(grading.getSubjectCode())) {
									exist = true;
									
									break;
								}
								else {
								index++;
								}
								
							}
							if(exist) {
							table.studentList.get(i).setGrade(index, grading.getGrade());
							JOptionPane.showMessageDialog(null, "Student " + id + "Graded Succesfully","Suc",JOptionPane.PLAIN_MESSAGE);
							}
							
							else {
								JOptionPane.showMessageDialog(null, "Subject not Found","Warning",JOptionPane.WARNING_MESSAGE);
								
							}
						}
				}else {
					JOptionPane.showMessageDialog(null, "Student not Enrolled yet","Warning",JOptionPane.WARNING_MESSAGE);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "Please Select A Student to Grade","Warning",JOptionPane.WARNING_MESSAGE);
				
			}
		}
		if(e.getSource() == viewButton) {
			
			int i = 0;
			while(table.studentList.get(i).getID() != id) {//check ang index sa id sa student
				i++;
				}
			if(id != 0) {
				if(table.studentList.get(i).getEnrolled()) {
				new GradeTable(id,name,year,program,table.studentList.get(i).getGrades(),table.studentList.get(i).getSubject());
				}else {
					JOptionPane.showMessageDialog(null, "Student not Enrolled yet","Warning",JOptionPane.WARNING_MESSAGE);
					
				}
			}else {
				JOptionPane.showMessageDialog(null, "Please Select A Student","Warning",JOptionPane.WARNING_MESSAGE);
				
			}
		}
		if(e.getSource() == corButton) {
			if(id != 0) {
			CORFrame corFrame = new CORFrame(id,name, year,program);
			int i = 0;
			while(table.studentList.get(i).getID() != id) {//check ang index sa id sa student
				i++;
				
			}
			corFrame.addSubjectList(table.studentList.get(i).getSubject());
			corFrame.displayList();
		
			}else {
				JOptionPane.showMessageDialog(null, "Please Select A Student","Warning",JOptionPane.WARNING_MESSAGE);
				
			}
		}
		
		}
	public void valueChanged(ListSelectionEvent e) {
		if(!selectedRow.isSelectionEmpty()) {
			id = (int) table.table.getValueAt(selectedRow.getMinSelectionIndex(), 0);
			name = (String) table.table.getValueAt(selectedRow.getMinSelectionIndex(), 1);
			year = (String) table.table.getValueAt(selectedRow.getMinSelectionIndex(), 2);
			program = (String) table.table.getValueAt(selectedRow.getMinSelectionIndex(), 3);
			studentId.setText(String.valueOf(id));
			studentName.setText(name);
			studentYear.setText(year);
			studentProgram.setText(program);
		}
	}
	public void emptyTheTextField() {
		studentId.setText("");
		studentName.setText("");
		studentYear.setText("");
		studentProgram.setText("");
	}
}
