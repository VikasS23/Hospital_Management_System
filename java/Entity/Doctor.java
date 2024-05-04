package Entity;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity; 
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import Entity.Speciality;
import Entity.HibernateUtil;
import Entity.Fees;
@Entity 
public class Doctor { 
@Id @Column(name = "DoctorId", length = 10)
private String DoctorId;
@Column(name = "DoctorName", length = 50) 
private String DoctorName;
@Column(name = "Gender", length = 25)
private String gender;
@Column(name = "Email", length = 30) 
private String email;
@Column(name = "Phone", length = 25)
private String phone;
@Column(name = "Address", length = 50)
private String Address;


@OneToMany(mappedBy = "DoctorId")
private List<Speciality> Speciality;

public List<Speciality> getSpeciality1() {
	return Speciality;
	}
public void setSpeciality(List<Speciality> Speciality) {
	this.Speciality = Speciality;
	}
@OneToMany(mappedBy = "DoctorId")
private List<Fees> fees;
public List<Fees> getfees() {
	return fees;
	}
public void setfees(List<Fees> fees)
{
	this.fees = fees;
	}
//Setter And Getter



public String getGender() { return gender; }
public void setGender(String gender) { 
	this.gender = gender; }
public String getEmail() {
return email;
}
public void setEmail(String email) { 
	this.email = email; }
public String getPhone() {
	return phone; }
public void setPhone(String phone) { 
	this.phone = phone; }
public String getAddress() { 
	return Address;
	}
public void setAddress(String Address) {
	this.Address = Address; 
	}
//Default Constructor 
public Doctor() {
	super(); // TODO Auto-generated constructor stub }
}
//All argument Constructor
public Doctor(String DoctorId, String DoctorName,  String gender, String email, String phone ,String Address)
{ super();
this.DoctorId = DoctorId; this.DoctorName = DoctorName;  this.gender = gender; this.email = email; this.phone = phone;this.Address = Address; }
//ToString method 
//@Override
//public String toString() { return "Person_Detail [PersonId=" + PersonId + ", PersonName=" + PersonName  + ", gender=" + gender + ", email=" + email + ", phone=" + phone +  ", Address=" + Address +"]"; }
}