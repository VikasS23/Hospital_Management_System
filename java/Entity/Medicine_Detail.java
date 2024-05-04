package Entity;


import java.time.LocalDate;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Medicine_Detail {
	@Id
	@Column(name = "MedicineId", length = 10)
	private String MedicineId;
	@Column(name = "MedicineName", length = 50)
	private String MedicineName;
	@Column(name = "MedicineUse", length = 25)
	private String MedicineUse;
	
	
	public String getMedicineId() {
		return MedicineId;
	}

	public void setEquipmentId(String MedicineId) {
		this.MedicineId = MedicineId;
	}

	

	
	public String getMedicineName() {
		return MedicineName;
	}

	public void setMedicineName(String MedicineName) {
		this.MedicineName = MedicineName;
	}

	public String getMedicineUse() {
		return MedicineUse;
	}

	public void setMedicineUse(String MedicineUse) {
		this.MedicineUse = MedicineUse;
	}

	
//All argument Construct 
public Medicine_Detail(String MedicineId, 
		String MedicineName,
		String MedicineUse) 
{ 
	super();
this.MedicineId = MedicineId;
this.MedicineName = MedicineName; 
this.MedicineUse = MedicineUse; 

}

@Override public String toString()
{ return 
		"Student [MedicineId=" + MedicineId  + ", MedicineName=" + MedicineName + ", MedicineUse=" +  MedicineUse+"]";
} 
}