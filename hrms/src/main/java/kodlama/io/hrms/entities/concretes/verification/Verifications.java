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

public class Verifications {
	
	@Id
	@GeneratedValue
	@Column(name="activation_code")
	private int activationCode;
	
	@Column(name="id")
	private int id;
	
	@Column(name="is_verified")
	private boolean isVerified;
	

}
