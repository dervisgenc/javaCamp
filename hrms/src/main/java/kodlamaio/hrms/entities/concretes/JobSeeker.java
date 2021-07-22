package kodlamaio.hrms.entities.concretes;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import kodlamaio.hrms.core.entities.concretes.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@Entity
@Table(name="job_seekers")
@NoArgsConstructor


@EqualsAndHashCode(callSuper = false)

public class JobSeeker extends User{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="national_id")
	private String nationalId;
	
	@Column(name="birth_year")
	private int birthYear;

	public JobSeeker(int id, String email, String password, int id2, String firstName, String lastName,
			String nationalId, int birthYear) {
		super(id, email, password);
		id = id2;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalId = nationalId;
		this.birthYear = birthYear;
	}
	
	

	
	

	
}
