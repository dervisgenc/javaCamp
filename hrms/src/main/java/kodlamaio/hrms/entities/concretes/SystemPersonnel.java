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
@Table(name="system_personnel")
@NoArgsConstructor

@EqualsAndHashCode(callSuper = false)
public class SystemPersonnel extends User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name= "user_id")
	private int id;
	
	@Column(name="first_name")
	private String name;
	
	@Column(name="last_name")
	private String surname;
	
	@Column(name = "department_id")
	private int departmentId;

	public SystemPersonnel(int id, String email, String password, int id2, String name, String surname,
			int departmentId) {
		super(id, email, password);
		id = id2;
		this.name = name;
		this.surname = surname;
		this.departmentId = departmentId;
	}

}
