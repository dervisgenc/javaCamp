package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.concretes.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employers")
@PrimaryKeyJoinColumn(name="user_id",referencedColumnName = "id")
@Data
@NoArgsConstructor

@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisements"})


public class Employer extends User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int id;
	
	
	@Column(name="website")
	private String website;
	
	@Column(name="company_name")
	private String companyName;
	
	@Column(name="phone_number")
	private String telNumber;
	
	@Column(name = "is_actived")
    private boolean isActive;
	
	@OneToMany(mappedBy= "employer")
	private List<JobAdvertisement> jobAdvertisements; 

	public Employer(int id, String email, String password, int id2, String website, String companyName,
			String telNumber, boolean isActive) {
		super(id, email, password);
		id = id2;
		this.website = website;
		this.companyName = companyName;
		this.telNumber = telNumber;
		this.isActive = isActive;
	}
}
