package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
	
	
	JobPosition getPositionName(String positionName);

	JobPosition findByPositonName(String positionName);
	
	JobPosition findById(int id);

}


