package Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Speciality{
	@Id
	private String  SpecialityId;
	@ManyToOne
	@JoinColumn(name = "DoctorId")
	private Doctor DoctorId;
	@Column(length = 10)
	private String Speciality;


	public Speciality() {
		super(); // TODO Auto-generated constructor stub
		} 
	
	
	public Speciality(String SpecialityId,
					 Doctor DoctorId, String Speciality
					 ) { 
			super();
					 this.SpecialityId = SpecialityId;
					 this.DoctorId = DoctorId;
					 this.Speciality = Speciality;
					 }
		public String getSpecialityId() {
					 return SpecialityId;
					 } 
		public void setSpecialityId(String SpecialityId) {
					     this.SpecialityId = SpecialityId; 
					 }
					 public Doctor getDoctorId() {
						 return DoctorId;
						 }
					 public void setDoctorId(Doctor DoctorId) {
						 this.DoctorId = DoctorId;
						 }
					 public String getSpeciality() {
						 return Speciality;
						 }
					 public void setSpeciality(String Speciality) {
						 
		                 this.Speciality = Speciality;
		                 }

	                               
	
}