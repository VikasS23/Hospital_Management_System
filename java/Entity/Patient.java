package Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {
     @Id
	private  int patientid;
     @Column
	private String patientname;
     @Column
	private String phoneno ;
     
	public int getPatientid() {
		return patientid;
	}
	public void setPatientid(int patientid) {
		this.patientid = patientid;
	}
	public String getPatientname() {
		return patientname;
	}
	public void setPatientname(String patientname) {
		this.patientname = patientname;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	
		public Patient(int patientid, String patientname, String phoneno) {
		super();
		this.patientid = patientid;
		this.patientname = patientname;
		this.phoneno = phoneno;
	}
	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Patient [patientid=" + patientid + ", patientname=" + patientname + ", phoneno=" + phoneno + "]";
	}

	
}