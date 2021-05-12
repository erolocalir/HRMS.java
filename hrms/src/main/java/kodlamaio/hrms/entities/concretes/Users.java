package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="Users")
public class Users {
	
	
	@Id
	@GeneratedValue
	
	
    @Column(name="id")
	private int id;
	
	
	@Column(name="password")
	private String password;

}

