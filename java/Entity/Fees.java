package Entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Fees{
	@Id
	private String  FeesId;
	@ManyToOne
	@JoinColumn(name = "DoctorId")
	private Doctor DoctorId;
	@Column(length = 10)
	private String Fees;
	@Column(length = 10)
	private String Remaining_Fees;

	public Fees(){
		super(); // TODO Auto-generated constructor stub
		}
	public Fees(String FeesId,
					 Doctor DoctorId, String Fees
					 ) { 
			super();
					 this.FeesId = FeesId;
					 this.DoctorId = DoctorId;
					 this.Fees = Fees;
					 }
		
		public String getFeesId() {
			
					 return FeesId;
					 } public void setMembershipId(String FeesId) {
					     this.FeesId = FeesId; 
					 }
					 public Doctor getDoctorId() {
						 return DoctorId;
						 }
					 public void setDoctorId(Doctor DoctorId) {
						 this.DoctorId = DoctorId;
						 }
					 public String getFees() {
						 return Fees;
						 }
					 public void setFees(String Fees) {
						 
		                 this.Fees = Fees;
		                 }

	                              
	
}