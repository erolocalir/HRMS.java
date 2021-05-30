package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Users")
@AllArgsConstructor
@NoArgsConstructor
public class Users {
	
	public Users(String email2, String password2, boolean b, String string) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
    @Column(name="id")
	private int id;
	
	
	@Column(name="password")
	private String password;
	
	
	@Column(name="email")
	private String email;
	
	@Column(name="emailVerified",nullable=false)
	private boolean emailVerified;

	

}







