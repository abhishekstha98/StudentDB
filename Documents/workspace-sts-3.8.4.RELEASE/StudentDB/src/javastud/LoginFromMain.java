package javastud;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import javastud.dao.UserDao;
import javastud.dao.UserDaoImpl;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class LoginFromMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel imagePNL;
	private JLabel companyName;
	private JLabel userNameLBL;
	private JTextField usernameTXT;
	private JLabel passwordLBL;
	private JPasswordField passwordTXT;
	private JButton loginBTN;
	private JButton cancelBTN;
	private static LoginFromMain frame;
	private JMenuBar menuBar;
	private JMenu FileMN;
	private JMenuItem ChangePasswordMNTM;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new LoginFromMain();
					frame.setTitle("LOGIN");
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
	public LoginFromMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 443, 256);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getImagePNL());
		contentPane.add(getCompanyName());
		contentPane.add(getUserNameLBL());
		contentPane.add(getUsernameTXT());
		contentPane.add(getPasswordLBL());
		contentPane.add(getPasswordTXT());
		contentPane.add(getLoginBTN());
		contentPane.add(getCancelBTN());
	}
	private JPanel getImagePNL() {
		if (imagePNL == null) {
			imagePNL = new LogoPanel();
			imagePNL.setBounds(169, 5, 189, 89);
		}
		return imagePNL;
	}
	private JLabel getCompanyName() {
		if (companyName == null) {
			companyName = new JLabel("Student Corp.");
			companyName.setBounds(15, 26, 165, 43);
			companyName.setFont(new Font("Tahoma", Font.BOLD, 15));
			companyName.setForeground(UIManager.getColor("ComboBox.selectionBackground"));
		}
		return companyName;
	}
	private JLabel getUserNameLBL() {
		if (userNameLBL == null) {
			userNameLBL = new JLabel("User Name:");
			userNameLBL.setBounds(30, 109, 132, 20);
			userNameLBL.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return userNameLBL;
	}
	private JTextField getUsernameTXT() {
		if (usernameTXT == null) {
			usernameTXT = new JTextField();
			usernameTXT.setBounds(168, 109, 192, 25);
			usernameTXT.setColumns(10);
		}
		return usernameTXT;
	}
	private JLabel getPasswordLBL() {
		if (passwordLBL == null) {
			passwordLBL = new JLabel("Password:");
			passwordLBL.setBounds(30, 140, 132, 41);
			passwordLBL.setFont(new Font("Tahoma", Font.BOLD, 13));
		}
		return passwordLBL;
	}
	private JPasswordField getPasswordTXT() {
		if (passwordTXT == null) {
			passwordTXT = new JPasswordField();
			passwordTXT.setBounds(168, 140, 192, 25);
			passwordTXT.setColumns(10);
		}
		return passwordTXT;
	}
	private JButton getLoginBTN() {
		if (loginBTN == null) {
			loginBTN = new JButton("Login");
			loginBTN.setBounds(165, 181, 94, 29);
			loginBTN.setFont(new Font("Tahoma", Font.BOLD, 13));
			loginBTN.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
					//check user in db  
					UserDao userdao=new UserDaoImpl();
					boolean isValidUser=userdao.validateUser(usernameTXT.getText(), new String(passwordTXT.getPassword()));//check whether the entered username and password matches with the database or not
					if(isValidUser){
							StudentForm studform = new StudentForm();
							studform.setVisible(true);//make the studentform visible
							frame.dispose();//dispose the current frame
					}
					else{
						JOptionPane.showMessageDialog(contentPane, "Please enter the required field");//if empty set the empty field red and notify
						usernameTXT.setBackground(Color.pink);
						passwordTXT.setBackground(Color.pink);
						return;
					}
				}
			});
			}
		return loginBTN;
	}
	private JButton getCancelBTN() {
		if (cancelBTN == null) {
			cancelBTN = new JButton("Cancel");
			cancelBTN.setBounds(270, 181, 89, 25);
			cancelBTN.setFont(new Font("Tahoma", Font.BOLD, 13));
			cancelBTN.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {//to do the required task after the cancel button is clicked
					System.exit(0);
				}
			});
		}
		return cancelBTN;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getFileMN());
		}
		return menuBar;
	}
	private JMenu getFileMN() {
		if (FileMN == null) {
			FileMN = new JMenu("File");
			FileMN.add(getChangePasswordMNTM());
		}
		return FileMN;
	}
	private JMenuItem getChangePasswordMNTM() {
		if (ChangePasswordMNTM == null) {
			ChangePasswordMNTM = new JMenuItem("Change Password");
			ChangePasswordMNTM.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
						PasswordChanger pchange=new PasswordChanger();
						pchange.setVisible(true);
						frame.dispose();
				}
			});
		}
		return ChangePasswordMNTM;
	}
}
