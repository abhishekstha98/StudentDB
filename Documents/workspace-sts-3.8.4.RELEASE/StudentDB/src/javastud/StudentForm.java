package javastud;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import javastud.dao.StudentDao;
import javastud.dao.StudentDaoImpl;
import javastud.model.Student;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JProgressBar;

public class StudentForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3L;
	private JPanel contentPane;
	private JPanel studentPnl;
	private JLabel nameLbl;
	private JTextField nameTxt;
	private JLabel rollNoLbl;
	private JTextField rollNoTxt;
	private JLabel phoneNoLbl;
	private JTextField phoneNoTxt;
	private JPanel genderPnl;
	private JRadioButton maleRdo;
	private JRadioButton femaleRdo;
	private JLabel emailLbl;
	private JTextField emailTxt;
	private JLabel collegeNameLbl;
	private JTextField collegeNameTxt;
	private JLabel addressLbl;
	private JTextField addressTxt;
	private JButton btnSave;
	private JTable studentTbl;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem fileMenuExit;	
	private ButtonGroup group;
	private JScrollPane scrollPane_1;
	private JScrollPane scrollPane;
	private static StudentForm frame = new StudentForm();
	private JTextField familynameTXT;
	private JLabel FamilyNameLBL;
	private JPanel DeletingPNL;
	private JButton btnReset;
	private JPanel panel_1;
	private JLabel RollnoLBL;
	private JTextField RollNoTXT;
	private JPanel panel_2;
	private JTextPane WarningPane;
	private JRadioButton AgreeRdBTN;
	private JButton DeleteBTN;
	private JProgressBar progressBar;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setTitle("STUDENT FORM");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public StudentForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 22, 1279, 777);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getStudentPnl());
		contentPane.add(getScrollPane_1());
		contentPane.add(getMenuBar_1());
		contentPane.add(getDeletingPNL());
		contentPane.add(getProgressBar());
		showAllStudents();//this is to show the contents of the data from the beginning 
	}
	
	private JPanel getStudentPnl() {
		if (studentPnl == null) {
			studentPnl = new JPanel();
			studentPnl.setBorder(
					new TitledBorder(null, "Student Form", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			studentPnl.setBounds(10, 23, 617, 174);
			studentPnl.setLayout(null);
			studentPnl.add(getNameLbl());
			studentPnl.add(getNameTxt());
			studentPnl.add(getRollNoLbl());
			studentPnl.add(getRollNoTxt());
			studentPnl.add(getPhoneNoLbl());
			studentPnl.add(getPhoneNoTxt());
			studentPnl.add(getGenderPnl());
			studentPnl.add(getEmailLbl());
			studentPnl.add(getEmailTxt());
			studentPnl.add(getCollegeNameLbl());
			studentPnl.add(getCollegeNameTxt());
			studentPnl.add(getAddressLbl());
			studentPnl.add(getAddressTxt());
			studentPnl.add(getBtnSave());
			studentPnl.add(getFamilynameTXT());
			studentPnl.add(getFamilyNameLBL());
		}
		return studentPnl;
	}

	private JLabel getNameLbl() {
		if (nameLbl == null) {
			nameLbl = new JLabel("Name*");
			nameLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
			nameLbl.setForeground(Color.RED);
			nameLbl.setBounds(10, 17, 46, 16);
		}
		return nameLbl;
	}

	private JTextField getNameTxt() {
		if (nameTxt == null) {
			nameTxt = new JTextField();
			nameTxt.setBounds(58, 17, 130, 21);
			nameTxt.setColumns(10);
		}
		return nameTxt;
	}

	private JLabel getRollNoLbl() {
		if (rollNoLbl == null) {
			rollNoLbl = new JLabel("Roll No*");
			rollNoLbl.setForeground(Color.RED);
			rollNoLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
			rollNoLbl.setBounds(422, 17, 55, 16);
		}
		return rollNoLbl;
	}

	private JTextField getRollNoTxt() {
		if (rollNoTxt == null) {
			rollNoTxt = new JTextField();
			rollNoTxt.setColumns(10);
			rollNoTxt.setBounds(479, 17, 130, 21);
		}
		return rollNoTxt;
	}

	private JLabel getPhoneNoLbl() {
		if (phoneNoLbl == null) {
			phoneNoLbl = new JLabel("Phone No:");
			phoneNoLbl.setForeground(Color.BLACK);
			phoneNoLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
			phoneNoLbl.setBounds(183, 64, 72, 21);
		}
		return phoneNoLbl;
	}

	private JTextField getPhoneNoTxt() {
		if (phoneNoTxt == null) {
			phoneNoTxt = new JTextField();
			phoneNoTxt.setColumns(10);
			phoneNoTxt.setBounds(267, 63, 130, 21);
		}
		return phoneNoTxt;
	}

	private JPanel getGenderPnl() {
		if (genderPnl == null) {
			genderPnl = new JPanel();
			genderPnl.setBorder(new TitledBorder(null, "Gender", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			genderPnl.setBounds(8, 88, 159, 75);
			genderPnl.setLayout(null);
			genderPnl.add(getMaleRdo());
			genderPnl.add(getFemaleRdo());
			group = new ButtonGroup();//this is compulsorily done to prevent accidental or intentional selection of both the rdo buttons
			group.add(maleRdo);
			group.add(femaleRdo);
		}
		return genderPnl;
	}

	private JRadioButton getMaleRdo() {
		if (maleRdo == null) {
			maleRdo = new JRadioButton("Male");
			maleRdo.setFont(new Font("Tahoma", Font.BOLD, 13));
			maleRdo.setBounds(6, 23, 65, 23);
		}
		return maleRdo;
	}

	private JRadioButton getFemaleRdo() {
		if (femaleRdo == null) {
			femaleRdo = new JRadioButton("Female");
			femaleRdo.setFont(new Font("Tahoma", Font.BOLD, 13));
			femaleRdo.setBounds(73, 23, 74, 23);
		}
		return femaleRdo;
	}

	private JLabel getEmailLbl() {
		if (emailLbl == null) {
			emailLbl = new JLabel("Email:");
			emailLbl.setForeground(Color.BLACK);
			emailLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
			emailLbl.setBounds(8, 64, 41, 16);
		}
		return emailLbl;
	}

	private JTextField getEmailTxt() {
		if (emailTxt == null) {
			emailTxt = new JTextField();
			emailTxt.setColumns(10);
			emailTxt.setBounds(48, 64, 130, 21);
		}
		return emailTxt;
	}

	private JLabel getCollegeNameLbl() {
		if (collegeNameLbl == null) {
			collegeNameLbl = new JLabel("College Name:");
			collegeNameLbl.setForeground(Color.BLACK);
			collegeNameLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
			collegeNameLbl.setBounds(183, 107, 98, 21);
		}
		return collegeNameLbl;
	}

	private JTextField getCollegeNameTxt() {
		if (collegeNameTxt == null) {
			collegeNameTxt = new JTextField();
			collegeNameTxt.setColumns(10);
			collegeNameTxt.setBounds(285, 106, 130, 21);
		}
		return collegeNameTxt;
	}

	private JLabel getAddressLbl() {
		if (addressLbl == null) {
			addressLbl = new JLabel("Address:");
			addressLbl.setForeground(Color.BLACK);
			addressLbl.setFont(new Font("Tahoma", Font.BOLD, 13));
			addressLbl.setBounds(409, 66, 58, 16);
		}
		return addressLbl;
	}

	private JTextField getAddressTxt() {
		if (addressTxt == null) {
			addressTxt = new JTextField();
			addressTxt.setColumns(10);
			addressTxt.setBounds(479, 63, 130, 21);
		}
		return addressTxt;
	}

	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Save");
			btnSave.setForeground(Color.BLUE);
			btnSave.setFont(new Font("Tahoma", Font.BOLD, 13));
			btnSave.setBounds(427, 106, 136, 57);
			btnSave.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					// 1. check Validation
					if(nameTxt.getText().trim().isEmpty()){
						nameTxt.setBackground(Color.pink);
						JOptionPane.showMessageDialog(contentPane, "please enter name");
						return;//this return stops from execution of the code even when error persists 
					}else{
						nameTxt.setBackground(Color.white);
					}
					if(rollNoTxt.getText().trim().isEmpty()){
						rollNoTxt.setBackground(Color.pink);
						JOptionPane.showMessageDialog(contentPane, "please enter roll no");
						return;//this return stops from execution of the code even when error persists 
					}else{
						rollNoTxt.setBackground(Color.white);
					}
					//save to db
					saveDataToDB();
					//show db
					showAllStudents();
					//clear fields
					clearFields();
				}
			});
		}
		return btnSave;
	}

	private void saveDataToDB() {//set the entered values into the database
		Student stud= new Student();
		stud.setName(nameTxt.getText().trim());
		stud.setRollNo(rollNoTxt.getText().trim());
		stud.setPhoneNo(phoneNoTxt.getText().trim());
		stud.setFamilyname(familynameTXT.getText().trim());
		if(maleRdo.isSelected()){
			stud.setGender("Male");
		}
		else if(femaleRdo.isSelected()){
			stud.setGender("Female");
		}
		stud.setEmail(emailTxt.getText().trim());
		stud.setAddress(addressTxt.getText().trim());
		stud.setCollegeName(collegeNameTxt.getText().trim());
		try{
			StudentDao dao = new StudentDaoImpl();
			dao.saveStudent(stud);//call the method to implement the desired insertion of contents to the database
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
	
	private JButton getDeleteBTN() {
		if (DeleteBTN == null) {
			DeleteBTN = new JButton("Delete");
			DeleteBTN.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(AgreeRdBTN.isSelected()){
						if(RollNoTXT.getText().trim().isEmpty()){
							RollNoTXT.setBackground(Color.pink);
							JOptionPane.showMessageDialog(contentPane, "please enter roll no");
							return;//this return stops from execution of the code even when error persists 
						}else{
							RollNoTXT.setBackground(Color.white);
						}
						//delete from db
						deleteFromDB();
						//show db
						showAllStudents();
						//clear fields
						clearFields();
					}
					else{
						AgreeRdBTN.setBackground(Color.pink);
						JOptionPane.showMessageDialog(contentPane, "please agree");//this shows an error when the agree button is not selected
						return;
					}
				}
			});
			DeleteBTN.setBounds(96, 109, 90, 29);
		}
		return DeleteBTN;
	}
	
	private void deleteFromDB() {
		Student stud= new Student();
		stud.setRollNo(RollNoTXT.getText().trim());
		try{
			StudentDao dao = new StudentDaoImpl();
			dao.deleteStudent(stud);//this is to send the required rolno to the method where the data is deleted from the database according to the database
		}catch(Exception e ){
			e.printStackTrace();
		}
	}
	
	public void showAllStudents() {
		// clear table
		DefaultTableModel model = (DefaultTableModel) studentTbl.getModel();
		model.setRowCount(0);
		try {
			StudentDao dao = new StudentDaoImpl();
			List<Student> studlist=dao.getAllStudents();
			
			for(Student stud : studlist){
				Object[] row =new Object[]{stud.getId(),stud.getName(),stud.getFamilyname(),stud.getRollNo(),stud.getPhoneNo(),stud.getGender(),stud.getCollegeName(),stud.getAddress(),stud.getEmail()
				};//get the contents from the database and them to the object array "row"
			model.addRow(row);//add the content to the table 
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void ResetDB() {
		//System.out.println("reached deleteFromDB() ");
				Student stud= new Student();
				stud.setRollNo(RollNoTXT.getText().trim());
				try{
					StudentDao dao = new StudentDaoImpl();
					dao.resetStudent();
				}catch(Exception e ){
					e.printStackTrace();
				}
			}
	
	private JButton getBtnReset() {
		if (btnReset == null) {
			btnReset = new JButton("RESET");
			btnReset.setBounds(196, 109, 90, 29);
			btnReset.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(AgreeRdBTN.isSelected()){
						//reset the db
						ResetDB();   
						//show db
						showAllStudents();
						//clear fields
						clearFields();
					}
					else{
						AgreeRdBTN.setBackground(Color.pink);
						JOptionPane.showMessageDialog(contentPane, "please agree");//this shows an error when the agree button is not selected
						return;
					}
				}
			});
		}
		return btnReset;
	}
	
	public void clearFields(){//clear the text field for next addition or deletion
		nameTxt.setText("");
		rollNoTxt.setText("");
		RollNoTXT.setText("");;
		phoneNoTxt.setText("");
		emailTxt.setText("");
		familynameTXT.setText("");
		addressTxt.setText("");
		collegeNameTxt.setText("");
		group.clearSelection();
	}
	
	private JTable getStudentTbl() {//making of table
		if (studentTbl == null) {
			studentTbl = new JTable();
			studentTbl.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null, null, null }, 
				{ null, null, null, null,null, null, null, null, null }, 
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null },
				{ null, null, null, null, null, null, null, null, null }, },
				new String[] { "ID", "Name", "Family Name", "Roll No", "Phone No", "Gender", "College", "Address", "Email" }));
		}
		return studentTbl;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setBounds(10, 0, 97, 21);
			menuBar.add(getMnFile());
		}
		return menuBar;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getFileMenuExit());
		}
		return mnFile;
	}

	private JMenuItem getFileMenuExit() {
		if (fileMenuExit == null) {
			fileMenuExit = new JMenuItem("Exit");
			fileMenuExit.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
						System.exit(0);//exit when exit is clicked
				}
			});
		}
		return fileMenuExit;
	}	
	
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getStudentTbl());
		}
		return scrollPane;
	}
	
	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setBounds(10, 209, 1261, 520);
			scrollPane_1.setViewportView(getScrollPane());
		}
		return scrollPane_1;
	}
	
	private JTextField getFamilynameTXT() {
		if (familynameTXT == null) {
			familynameTXT = new JTextField();
			familynameTXT.setColumns(10);
			familynameTXT.setBounds(290, 17, 130, 21);
		}
		return familynameTXT;
	}
	
	private JLabel getFamilyNameLBL() {
		if (FamilyNameLBL == null) {
			FamilyNameLBL = new JLabel("Family Name");
			FamilyNameLBL.setForeground(Color.BLACK);
			FamilyNameLBL.setFont(new Font("Tahoma", Font.BOLD, 13));
			FamilyNameLBL.setBounds(190, 17, 98, 16);
		}
		return FamilyNameLBL;
	}
	
	private JPanel getDeletingPNL() {
		if (DeletingPNL == null) {
			DeletingPNL = new JPanel();
			DeletingPNL.setLayout(null);
			DeletingPNL.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Deleting", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
			DeletingPNL.setBounds(654, 23, 617, 174);
			DeletingPNL.add(getPanel_1());
			DeletingPNL.add(getPanel_2());
		}
		return DeletingPNL;
	}
	
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setLayout(null);
			panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(6, 22, 292, 146);
			panel_1.add(getRollnoLBL());
			panel_1.add(getTextField_1());
		}
		return panel_1;
	}
	
	private JLabel getRollnoLBL() {
		if (RollnoLBL == null) {
			RollnoLBL = new JLabel("Enter the RollNo that is to be removed");
			RollnoLBL.setBounds(6, 6, 280, 74);
		}
		return RollnoLBL;
	}
	
	private JTextField getTextField_1() {
		if (RollNoTXT == null) {
			RollNoTXT = new JTextField();
			RollNoTXT.setColumns(10);
			RollNoTXT.setBounds(6, 92, 280, 36);
		}
		return RollNoTXT;
	}
	
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setLayout(null);
			panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_2.setBounds(319, 22, 292, 146);
			panel_2.add(getWarningPane());
			panel_2.add(getAgreeRdBTN());
			panel_2.add(getDeleteBTN());
			panel_2.add(getBtnReset());
		}
		return panel_2;
	}
	
	private JTextPane getWarningPane() {
		if (WarningPane == null) {
			WarningPane = new JTextPane();
			WarningPane.setEditable(false);
			WarningPane.setText("Warning! Please ensure that the RollNo that is entered is the desired RollNo that is to be deleted from the Database, if the relevant information is ensured plz check the following box below.");
			WarningPane.setBackground(SystemColor.window);
			WarningPane.setBounds(6, 6, 280, 87);
		}
		return WarningPane;
	}
	
	private JRadioButton getAgreeRdBTN() {
		if (AgreeRdBTN == null) {
			AgreeRdBTN = new JRadioButton("I agree!");
			AgreeRdBTN.setBounds(6, 105, 78, 34);
		}
		return AgreeRdBTN;
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setBounds(10, 729, 146, 20);
		}
		return progressBar;
	}
}
