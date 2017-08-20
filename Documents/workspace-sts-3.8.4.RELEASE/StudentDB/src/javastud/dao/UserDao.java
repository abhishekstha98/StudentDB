package javastud.dao;

public interface UserDao {
	boolean validateUser(String username, String password);
	boolean validateUser1(String RollNo);
	void ChangePassword(String Username,String Password);
}
