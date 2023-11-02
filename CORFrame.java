import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CORFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	JButton[] corHeaders = new JButton[6];
	JPanel corPanel2,corTable;
	ArrayList<enrolledSubject> subjectList = new ArrayList<>();
	CORTable subjectTable;
	CORFrame(int id,String name,String year,String program){
		
		this.setSize(750,500);	
		this.setLayout(null);
		this.setBackground(Color.decode("#D2E0FB"));
		this.setResizable(false);
		this.setLocationRelativeTo(null);
			JLabel cor_name = new JLabel();
			cor_name.setText("Name: " + name);
			cor_name.setFont(new Font("Inter",Font.BOLD,15));
			JLabel cor_id = new JLabel();
			cor_id.setText("ID No: " + id);
			cor_id.setFont(new Font("Inter",Font.BOLD,15));
			JLabel cor_course = new JLabel();
			cor_course.setText("Course/Year: " + year);	
			cor_course.setFont(new Font("Inter",Font.BOLD,15));
			JLabel cor_period = new JLabel();
			cor_period.setText("Period: " + program);
			cor_period.setFont(new Font("Inter",Font.BOLD,15));
			
			JPanel cor_panel_1 = new JPanel();
			cor_panel_1.setBounds(0,1,750,60);
			cor_panel_1.setBackground(Color.decode("#D2E0FB"));
			cor_panel_1.setLayout(new GridLayout(2,2));
			cor_panel_1.setFont(new Font("Inter",Font.BOLD,13));
			cor_panel_1.add(cor_name);

			cor_panel_1.add(cor_course);
			cor_panel_1.add(cor_id);
			cor_panel_1.add(cor_period);

			corPanel2 = new JPanel();
			corPanel2.setBounds(0,61,745,30);
			corPanel2.setBackground(Color.decode("#78D6C6"));
			corPanel2.setFont(new Font("Inter",Font.BOLD,12));
			corPanel2.setLayout(new GridLayout(1,6,-1,0));
			
			for(int i = 0; i < corHeaders.length;i++) {
				corHeaders[i] = new JButton();
				corHeaders[i].setBackground(Color.decode("#78D6C6"));
				corHeaders[i].setFont(new Font("Inter",Font.BOLD,10));
				corPanel2.add(corHeaders[i]);
				corHeaders[i].setFocusable(false);
			}
			
			corHeaders[0].setText("SECTION CODE");
			corHeaders[1].setText("SUBJECT CODE");	
			corHeaders[2].setText("DESCRIPTION");	
			corHeaders[3].setText("UNITS");
			corHeaders[4].setText("SCHEDULE");
			corHeaders[5].setText("SECTION");

			corTable = new JPanel();
			
			corTable.setBounds(1,cor_panel_1.getHeight() + corPanel2.getHeight() + 2,745,500 - (cor_panel_1.getHeight() + corPanel2.getHeight()) - 30);
			
			corTable.setLayout(new GridLayout(1,1));
			
			subjectTable = new CORTable();
			
			
			
			corTable.add(subjectTable.table);
			
			
			this.add(cor_panel_1);
			this.add(corPanel2);
			this.add(corTable);
			this.setVisible(true);

		}
	public void addSubjectList(ArrayList<enrolledSubject> subjectList) {
		this.subjectList = subjectList;
	}
	
	public void displayList() {
		for(int i = 0;i < subjectList.size(); i++) {
			subjectTable.addRow(subjectList.get(i));
			
		}
		
		
		
		
	}
	}

