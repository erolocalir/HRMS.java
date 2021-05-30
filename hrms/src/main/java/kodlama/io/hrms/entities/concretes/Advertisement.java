package kodlama.io.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Cities")
@NoArgsConstructor
@AllArgsConstructor

public class Advertisement {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="maxSalary")
	private int maxSalary;
	
	@Column(name="minSalary")
	private int minSalary;
	
	@Column(name="isActive")
	private boolean isActive;
	
	@Column(name="Publication_Date")
	private Date publicationDate;
	
	@Column(name="Last_applicaiton_Date")
	private Date lastApplicaitonData;
	
	@Column(name="Open_positions")
	private int openPositions;
	
	
	
	@ManyToOne()
	@JoinColumn(name="id")
	private City city;
	
	
	@ManyToOne()
	@JoinColumn(name="jobpositionid")
	private JobPosition jobPosition;
	
	
	@ManyToOne()
	@JoinColumn(name="employerid")
	private Employer employer;
	
	
}
























