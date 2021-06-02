package kodlama.io.hrms.entities.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="Candidates")
@AllArgsConstructor
@NoArgsConstructor
public class Candidates extends Users{
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="identity_number")
	private String identityNumber;
	
	@Column(name="date_of_birth")
	private String dateOfBirth;
	
	@Column(name="university")
	private String university;
	
	@Column(name="starting_year_of_university")
	private String startingYearOfUniversity;
	
	@Column(name="graduation_year_of_university")
	private String graduationYearOfUniversity;
	
	@Column(name="job_experience")
	private String jobExperience;
	
	@Column(name="experience_starting_date")
	private String experienceStartingDate;
	
	@Column(name="experience_end_date")
	private String experienceEndDate;
	
	@Column(name="known_language")
	private String knownLanguage;
	
	@Column(name="image_name")
	private String imageName;
	
	@Column(name="github_link")
	private String githubLink;
	
	@Column(name="linkedin_link")
	private String linkedInLink;
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	@Column(name="known_technology")
	private String knownTechnology;
	
	@OneToMany(mappedBy = "candidates")
	private List<Image> images;
	
	
	@OneToOne()
	@JoinColumn(name="userid")
	private Users users;


	public String[] split(String string) {
		
		return null;
	}

}




