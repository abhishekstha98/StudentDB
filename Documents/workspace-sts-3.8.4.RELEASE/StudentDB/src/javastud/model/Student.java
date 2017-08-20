package javastud.model;

public class Student {
	
	private long id;
	private String Name;
	private String Familyname;
	private String RollNo;
	private String PhoneNo;
	private String Gender;
	private String Email;
	private String Address;
	private String CollegeName;
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", Name=" + Name + ", FamilyName=" + Familyname + ", RollNo=" + RollNo + ", PhoneNo=" + PhoneNo + ", Gender="
				+ Gender + ", Email=" + Email + ", Address=" + Address + ", CollegeName=" + CollegeName + "]";
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getFamilyname() {
		return Familyname;
	}
	public void setFamilyname(String familyname) {
		Familyname = familyname;
	}
	public String getRollNo() {
		return RollNo;
	}
	public void setRollNo(String rollNo) {
		RollNo = rollNo;
	}
	public String getPhoneNo() {
		return PhoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		PhoneNo = phoneNo;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCollegeName() {
		return CollegeName;
	}
	public void setCollegeName(String collegeName) {
		CollegeName = collegeName;
	}
	
	
}
