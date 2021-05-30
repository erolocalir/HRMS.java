package kodlama.io.hrms.entities.concretes.verification;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Verifications")
@AllArgsConstructor
@NoArgsConstructor

public class VerificationToCandidates {
	
	@Id
	@GeneratedValue
	
	@Column(name="id")
	private int id;
	

}
