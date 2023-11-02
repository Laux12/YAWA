import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

public class Table implements ListSelectionListener{
	int id;
	String name,year,program;
	JTable table;
	DefaultTableModel model;
	ListSelectionModel selectedRow;
	ArrayList<Student> studentList = new ArrayList<>();
	Table(){
		String[] tblHeader = {"ID", "Name","Year","Program"};
		model = new DefaultTableModel(tblHeader,0);
		table = new JTable(model);
		table.setRowHeight(30);
		table.setFont(new Font("Inter",Font.PLAIN,15));
		selectedRow = table.getSelectionModel();
		selectedRow.addListSelectionListener(this);
		}
	
	public void addStudent(Student student) {
		studentList.add(student);
		Object[] studentInfo = {
				student.getID(),student.getName(),student.getYear(),student.getProgram()
		};
		model.addRow(studentInfo);
		
		
	}
	public void updateStudent(int id, String name,String year,String program) {
		int index = 0;
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getID() == id) {
				index = i;
			}
		}
		model.setValueAt(name, index, 1);
		model.setValueAt(year, index, 2);
		model.setValueAt(program, index, 3);
		studentList.get(index).setNewInfo(name, year, program);
		
		
	}
	public void deleteStudent(int id) {
		int index = 0;
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getID()== id) {
				index = i;
			}
		}
		model.removeRow(index);
		studentList.remove(index);
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(!selectedRow.isSelectionEmpty()) {
			id = (int) table.getValueAt(selectedRow.getMinSelectionIndex(), 0);
			name = (String) table.getValueAt(selectedRow.getMinSelectionIndex(), 1);
			year = (String) table.getValueAt(selectedRow.getMinSelectionIndex(), 2);
			program = (String) table.getValueAt(selectedRow.getMinSelectionIndex(), 3);
			
		}
		
	}

}
