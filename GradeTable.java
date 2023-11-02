import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class GradeTable extends JFrame{

	private static final long serialVersionUID = 1L;
	JTable table;
	DefaultTableModel model;
	GradeTable(int id,String name,String year,String program,ArrayList<Float> grades,ArrayList<enrolledSubject> arrayList){
		this.setSize(550,400);	
		this.setLayout(null);
		this.setBackground(Color.decode("#D2E0FB"));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
			JLabel grade_name = new JLabel();
			grade_name.setText("Name: " + name);
			grade_name.setFont(new Font("Inter",Font.BOLD,15));
			JLabel grade_id = new JLabel();
			grade_id.setText("ID No: " + id);
			grade_id.setFont(new Font("Inter",Font.BOLD,15));
			JLabel grade_course = new JLabel();
			grade_course.setText("Course/Year: " + year);	
			grade_course.setFont(new Font("Inter",Font.BOLD,15));
			JLabel grade_period = new JLabel();
			grade_period.setText("Program: " + program);
			grade_period.setFont(new Font("Inter",Font.BOLD,15));
			
			JPanel grade_panel_1 = new JPanel();
			grade_panel_1.setBounds(0,1,550,60);
			grade_panel_1.setBackground(Color.decode("#D2E0FB"));
			grade_panel_1.setLayout(new GridLayout(2,2));
			grade_panel_1.setFont(new Font("Inter",Font.BOLD,13));
			grade_panel_1.add(grade_name);

			grade_panel_1.add(grade_course);
			grade_panel_1.add(grade_id);
			grade_panel_1.add(grade_period);
			
			JPanel gradePanel = new JPanel();
			gradePanel = new JPanel();
			gradePanel.setBounds(0,61,545,30);
			gradePanel.setBackground(Color.decode("#78D6C6"));
			gradePanel.setFont(new Font("Inter",Font.BOLD,12));
			gradePanel.setLayout(new GridLayout(1,2,-1,0));
			
			JButton subjectLabel = new JButton("Subject Code");
			JButton gradeLabel = new JButton("Final Grade");
			
			
			subjectLabel.setBackground(Color.decode("#78D6C6"));
			subjectLabel.setFont(new Font("Inter",Font.BOLD,13));
			subjectLabel.setFocusable(false);
			
			gradeLabel.setBackground(Color.decode("#78D6C6"));
			gradeLabel.setFont(new Font("Inter",Font.BOLD,13));
			gradeLabel.setFocusable(false);
			
			gradePanel.add(subjectLabel);
			gradePanel.add(gradeLabel);
			
			
			
			String[] tblHeader = {"Section Code", "Final Grade"};
			model = new DefaultTableModel(tblHeader,0);
			table = new JTable(model);
			table.setRowHeight(30);
			table.setFont(new Font("Inter",Font.PLAIN,14));
			
			JPanel tableContainer = new JPanel();
			tableContainer.setBounds(1,grade_panel_1.getHeight() + gradePanel.getHeight() + 2,545,400 - (grade_panel_1.getHeight() + gradePanel.getHeight()) - 30);
			tableContainer.setBackground(Color.black);
			tableContainer.setLayout(new GridLayout(1,1));
			
			for(int i = 0;i < grades.size();i++) {
				addRow(grades.get(i),arrayList.get(i).getSubCode());
			}
			
			tableContainer.add(table);
			this.add(gradePanel);
			this.add(grade_panel_1);
			this.add(tableContainer);
			this.setVisible(true);
	}
	public void addRow(float grade,String subjectCode) {
		Object[] studentGrade = {
				subjectCode,grade
		};
		model.addRow(studentGrade);
	}
	
	
}
