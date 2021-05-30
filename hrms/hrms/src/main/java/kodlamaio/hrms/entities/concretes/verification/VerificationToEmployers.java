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
@Table(name="Verification_to_Employers")
@AllArgsConstructor
@NoArgsConstructor

public class VerificationToEmployers {


	@Id
	@GeneratedValue
	
	@Column(name="id")
	private int id;
	
	@Column(name="verification_to_email")
	private String verificationToEmail;
	
}
