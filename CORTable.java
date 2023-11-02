import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CORTable {
	JTable table;
	DefaultTableModel model;
	CORTable(){
		String[] tblHeader = {"Section Code", "Subject Code","Description","Units","Schedule","Section"};
		model = new DefaultTableModel(tblHeader,0);
		table = new JTable(model);
		table.setRowHeight(30);
		table.setFont(new Font("Inter",Font.PLAIN,14));
	}
	public void addRow(enrolledSubject subject) {
		Object[] subjectInfo = {
				subject.getSecCode(),subject.getSubCode(),subject.getSubDescrip(),subject.getUnits(),subject.getSubSched(),subject.getSubSection()
		};
		model.addRow(subjectInfo);
	}
}
