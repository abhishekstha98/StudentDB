package javastud;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import javastud.dao.UserDao;
import javastud.dao.UserDaoImpl;

public class PasswordChanger extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8L;
	private final JPanel contentPanel = new JPanel();
	private JPanel ChangePasswordPNL;
	private JLabel UsernameLBL;
	private JLabel OldPasswordLBL;
	private JLabel NewPasswordLBL;
	private JLabel NewPassword1LBL;
	private JTextField UsernameTXT;
	private JPasswordField NewPasswordPFLD;
	private JPasswordField NewPassword1PFLD;
	private JPasswordField OldPasswordPFLD;
	static PasswordChanger dialog = new PasswordChanger();
	private String password1="1",password2="2";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setTitle("PASSWORD CHANGER");
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PasswordChanger() {
		setBounds(100, 100, 280, 263);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getChangePasswordPNL());
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						//check user in db  
						UserDao userdao=new UserDaoImpl();
						boolean isValidUser=userdao.validateUser(UsernameTXT.getText(), new String(OldPasswordPFLD.getPassword()));//check whether the entered username and password matches with the database or not
						if(isValidUser){
							UsernameTXT.setBackground(Color.white);
							OldPasswordPFLD.setBackground(Color.white);
							password1=new String(NewPasswordPFLD.getPassword());
							password2=new String(NewPassword1PFLD.getPassword());
							if(password2.equals("")){
								NewPasswordPFLD.setBackground(Color.pink);
								NewPassword1PFLD.setBackground(Color.pink);
								return;
							}
							else{
								if(password1.equals(password2)){
									NewPasswordPFLD.setBackground(Color.white);
									NewPassword1PFLD.setBackground(Color.white);
									ChangePasswordDB();
									System.exit(0);//exit
								}
								else{
									NewPasswordPFLD.setText("");
									NewPassword1PFLD.setText("");
									NewPasswordPFLD.setBackground(Color.pink);
									NewPassword1PFLD.setBackground(Color.pink);
									return;
								}
							}
						}
						else{
							UsernameTXT.setText("");
							OldPasswordPFLD.setText("");
							UsernameTXT.setBackground(Color.pink);
							OldPasswordPFLD.setBackground(Color.pink);
							return;
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	private void ChangePasswordDB() {
		//System.out.println("reached deleteFromDB() ");
				try{
					UserDao dao = new UserDaoImpl();
					dao.ChangePassword(UsernameTXT.getText(),password2);
					JOptionPane.showMessageDialog(contentPane, "Done!");
				}catch(Exception e ){
					e.printStackTrace();
				}
			}
	private JPanel getChangePasswordPNL() {
		if (ChangePasswordPNL == null) {
			ChangePasswordPNL = new JPanel();
			ChangePasswordPNL.setBackground(Color.WHITE);
			ChangePasswordPNL.setBorder(new TitledBorder(null, "Change Password", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			ChangePasswordPNL.setBounds(6, 6, 268, 189);
			ChangePasswordPNL.setLayout(null);
			ChangePasswordPNL.add(getUsernameLBL());
			ChangePasswordPNL.add(getOldPasswordLBL());
			ChangePasswordPNL.add(getNewPasswordLBL());
			ChangePasswordPNL.add(getNewPassword1LBL());
			ChangePasswordPNL.add(getUsernameTXT());
			ChangePasswordPNL.add(getNewPasswordPFLD());
			ChangePasswordPNL.add(getNewPassword1PFLD());
			ChangePasswordPNL.add(getOldPasswordPFLD());
		}
		return ChangePasswordPNL;
	}
	private JLabel getUsernameLBL() {
		if (UsernameLBL == null) {
			UsernameLBL = new JLabel("Username");
			UsernameLBL.setBounds(6, 20, 105, 29);
		}
		return UsernameLBL;
	}
	private JLabel getOldPasswordLBL() {
		if (OldPasswordLBL == null) {
			OldPasswordLBL = new JLabel("Old Password");
			OldPasswordLBL.setBounds(6, 61, 105, 29);
		}
		return OldPasswordLBL;
	}
	private JLabel getNewPasswordLBL() {
		if (NewPasswordLBL == null) {
			NewPasswordLBL = new JLabel("New Password");
			NewPasswordLBL.setBounds(6, 102, 105, 29);
		}
		return NewPasswordLBL;
	}
	private JLabel getNewPassword1LBL() {
		if (NewPassword1LBL == null) {
			NewPassword1LBL = new JLabel("New Password");
			NewPassword1LBL.setBounds(6, 143, 105, 29);
		}
		return NewPassword1LBL;
	}
	private JTextField getUsernameTXT() {
		if (UsernameTXT == null) {
			UsernameTXT = new JTextField();
			UsernameTXT.setBounds(123, 21, 130, 26);
			UsernameTXT.setColumns(10);
		}
		return UsernameTXT;
	}
	private JPasswordField getNewPasswordPFLD() {
		if (NewPasswordPFLD == null) {
			NewPasswordPFLD = new JPasswordField();
			NewPasswordPFLD.setBounds(123, 103, 130, 26);
		}
		return NewPasswordPFLD;
	}
	private JPasswordField getNewPassword1PFLD() {
		if (NewPassword1PFLD == null) {
			NewPassword1PFLD = new JPasswordField();
			NewPassword1PFLD.setBounds(123, 144, 130, 26);
		}
		return NewPassword1PFLD;
	}
	private JPasswordField getOldPasswordPFLD() {
		if (OldPasswordPFLD == null) {
			OldPasswordPFLD = new JPasswordField();
			OldPasswordPFLD.setBounds(123, 62, 130, 26);
		}
		return OldPasswordPFLD;
	}
}
