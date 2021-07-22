package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activation_by_staff")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivationByPersonnel {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
	
	
	@Column(name = "employer_id")
	private int employerId;
	
	@Column(name = "personnel_id")
	private int personnelId;
    

    @Column(name = "is_verified")
    private boolean isVerified;
	
}
